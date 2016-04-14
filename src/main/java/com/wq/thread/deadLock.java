package com.wq.thread;

public class deadLock implements Runnable {
	public int flag = 1;  
    //静态对象是类的所有对象共享的  
    private static Object o1 = new Object(), o2 = new Object();
    public deadLock(int flag){
    	this.flag = flag;
    }
    @Override  
    public void run() {  
        System.out.println("我进来了" + flag);  
        if (flag == 1) {  
            synchronized (o1) {  
                try {  
                    Thread.sleep(500);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                synchronized (o2) {  
                    System.out.println("我是一");  
                }  
            }  
        }  
        if (flag == 0) {  
            synchronized (o2) {  
                try {  
                    Thread.sleep(500);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                synchronized (o1) {  
                    System.out.println("我是二");  
                }  
            }  
        }
    }
	public static void main(String[] args) {
		deadLock td1 = new deadLock(1);  
		deadLock td2 = new deadLock(0);  
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。  
        //td2的run()可能在td1的run()之前运行  
        new Thread(td1).start();  
        new Thread(td2).start(); 
	}
}
