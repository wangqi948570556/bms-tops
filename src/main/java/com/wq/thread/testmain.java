package com.wq.thread;

public class testmain {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new deadLock(true));
		Thread t2 = new Thread(new deadLock(false));
		t1.start();
		t2.start();
	}
}
