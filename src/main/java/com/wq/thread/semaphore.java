package com.wq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class semaphore {
    public static void main(String[] args) {
        //信号量(Semaphore)，有时被称为信号灯，是在多线程环境下使用的一种设施, 它负责协调各个线程, 以保证它们能够正确、合理的使用公共资源。
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);
        for(int index =0;index<8;index++){
            final int No = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
                        System.out.println("accese:"+No);
                        Thread.sleep((long) (Math.random() * 10000));
                        semp.release();
                      //availablePermits()指的是当前信号灯库中有多少个可以被使用
                        System.out.println("-----------------  " + semp.availablePermits());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
