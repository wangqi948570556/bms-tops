package com.wq.thread;

public class MyRunnable implements Runnable {
	private volatile int ticket =20;
    
    public void run(){
		while(true){
	        if(this.ticket>0){
		        System.out.println(Thread.currentThread().getName()+"    卖票---->"+(this.ticket--));  
	        }
	    }
    }
}
