package com.wq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPool {
	public static void main(String[] args) {
		
		//缓存线程池 每次调用的是同一个线程(重复利用同一个线程 ,超出处理需要可灵活回收)
		ExecutorService cacheThread = Executors.newCachedThreadPool();
		MyRunnable t1 = new MyRunnable();
		for(int i=0;i<7;i++){
			cacheThread.execute(t1);
		}
		//定长线程池，控制最大并发数(重复利用同一个线程)
//		ExecutorService fixedThread = Executors.newFixedThreadPool(3);
//		MyRunnable t1 = new MyRunnable();
//		for(int i=0;i<7;i++){
//			fixedThread.execute(t1);
//		}
		//定长线程池，支持定时及周期性任务执行(schedule方法)
//		ScheduledExecutorService scheduleThread = Executors.newScheduledThreadPool(3);
//		for(int i=0;i<2;i++){
////			scheduleThread.schedule(t1, 3,TimeUnit.SECONDS);
//			scheduleThread.scheduleAtFixedRate(new MyRunnable(), 1, 3, TimeUnit.SECONDS);
//		}
		//单个线程(一个线程执行，保证输出顺序)
//		ExecutorService singleThread = Executors.newSingleThreadExecutor();
//		for(int i=0;i<4;i++){
//			singleThread.execute(new MyRunnable());
//		}
	}
}
