package com.wq.thread;

public class deadLock implements Runnable {
	public boolean flag;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	public deadLock(boolean f){this.flag = f;};//构造方法复值
	@Override
	public void run() {
		while(flag){
			if(flag){
				synchronized (lock1) {
					System.out.println("锁住lock1");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("锁住lock2");
					}
				}
			}else{
				synchronized (lock2) {
					System.out.println("锁住lock2");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("锁住lock1");
					}
				}
			}
		}
	}
}
