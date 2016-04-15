package com.wq.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable {
	private CountDownLatch begin;
	private CountDownLatch end;
	private int a;
	public CountDownLatchThread(int a,CountDownLatch begin, CountDownLatch end) {
		this.a = a;
		this.begin =begin;
		this.end = end;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			begin.await();
			System.out.println("开始");
			System.out.println("玩家"+a+"进入第一关");
			end.countDown();
			System.out.println("玩家"+a+"继续进入第二关");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
