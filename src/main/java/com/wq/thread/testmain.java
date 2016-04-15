package com.wq.thread;

public class testmain {
	public static void main(String[] args) throws InterruptedException {
		//Thread类实现多线程
//		MyThread t1 = new MyThread();
//		MyThread t2 = new MyThread();
//		t2.start();
////		t2.join();
//		t1.start();
		//Runnable接口实现多线程
		MyRunnable t = new MyRunnable();  
		Thread a1 = new Thread(t,"一号");  
		Thread a2 = new Thread(t,"二号");  
		Thread a3 = new Thread(t,"三号");  
		a1.start();
		a2.start();
		a2.join();
		a3.start();
	}
}
