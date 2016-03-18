package com.wq.produce.controller;

public class testmain {
	public static void main(String[] args) throws InterruptedException {
		testmain test = new testmain();
		test.count(10);
	}
	
	public void count(final Integer count) throws InterruptedException{
		long star = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			int a = 0;
			@Override
			public void run() {
				for(int i=0;i<=count;i++){
					a += 5;
				}
				System.out.println(a);
			}
		});
		thread.start();
		System.out.println(System.currentTimeMillis()-star);
		
		long c = System.currentTimeMillis();
		int b = 0;
		for(int i=0;i<=count;i++){
			b += 5;
		}
		long time = System.currentTimeMillis() -c;
		thread.join();
		System.out.println("currentTime:"+time +"sd"+b);
	}
}
