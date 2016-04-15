package com.wq.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable {
	
	private CyclicBarrier cyclicBarrier;
	private int a ;
	public CyclicBarrierThread(int a ,CyclicBarrier cyclicBarrier){
		this.a = a;
		this.cyclicBarrier = cyclicBarrier;
	}
	@Override
	public void run() {
		try {
			System.out.println("玩家"+a+"进入第一关");
			cyclicBarrier.await();
			System.out.println("玩家"+a+"进入第二关");

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
