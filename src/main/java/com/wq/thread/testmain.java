package com.wq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		//缓存线程池 每次调用的是同一个线程(重复利用同一个线程 ,超出处理需要可灵活回收)
//		ExecutorService cacheThread = Executors.newCachedThreadPool();
//		for(int i=0;i<2;i++){
//			cacheThread.execute(new MyRunnable());
//		}
		//定长线程池，控制最大并发数(重复利用同一个线程)
//		ExecutorService fixedThread = Executors.newFixedThreadPool(3);
//		for(int i=0;i<4;i++){
//			fixedThread.execute(new MyRunnable());
//		}
		//定长线程池，支持定时及周期性任务执行(schedule方法)
//		ScheduledExecutorService scheduleThread = Executors.newScheduledThreadPool(3);
//		for(int i=0;i<2;i++){
////			scheduleThread.schedule(new MyRunnable(), 3,TimeUnit.SECONDS);
//			scheduleThread.scheduleAtFixedRate(new MyRunnable(), 1, 3, TimeUnit.SECONDS);
//		}
		//单个线程(一个线程执行，保证输出顺序)
		ExecutorService singleThread = Executors.newSingleThreadExecutor();
		for(int i=0;i<4;i++){
			singleThread.execute(new MyRunnable());
		}
	}
}
