package com.wq.thread;

public class deadLock implements Runnable {
	public boolean flag;
	public deadLock(boolean f){this.flag = f;};//构造方法复值
	@Override
	public void run() {
			if(flag){
				synchronized (Lock.lock1) {
					System.out.println("锁住lock1");
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (Lock.lock2) {
						System.out.println("锁住lock2");
					}
				}
			}else{
				synchronized (Lock.lock2) {
					System.out.println("锁住lock2");
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (Lock.lock1) {
						System.out.println("锁住lock1");
					}
				}
			}
	}
}
