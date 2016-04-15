package com.wq.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(4);
		for(int i=1;i<5;i++){
			new Thread(new CountDownLatchThread(i,begin,end)).start();
		}
		try {
			begin.countDown();
			end.await();
			System.out.println("完了");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
