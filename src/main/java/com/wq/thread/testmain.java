package com.wq.thread;

public class testmain {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new deadLock(false));
		Thread t2 = new Thread(new deadLock(true));
		t2.start();
		t2.join();
		t1.start();
	}
}
