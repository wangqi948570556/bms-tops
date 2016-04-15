package com.wq.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("都进来了");
			}
		});
				
		for(int i=0;i<4;i++){
			new Thread(new CyclicBarrierThread(i, cyclicBarrier)).start();
		}
	}
}
