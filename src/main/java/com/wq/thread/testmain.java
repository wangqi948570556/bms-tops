package com.wq.thread;

import junit.framework.Assert;

public class testmain {
	public static void main(String[] args) throws InterruptedException {
		//Thread类实现多线程
//		MyThread t1 = new MyThread();
//		MyThread t2 = new MyThread();
//		t2.start();
////		t2.join();
//		t1.start();
		//Runnable接口实现多线程
//		MyRunnable t = new MyRunnable();  
//		Thread a1 = new Thread(t,"一号");  
//		Thread a2 = new Thread(t,"二号");  
//		Thread a3 = new Thread(t,"三号");  
//		a1.start();
//		a2.start();
//		a2.join();
//		a3.start();
//	    System.out.println(change("1018"));
	}
	
	public static String change(String s){
	    String[] s1 = { "", "拾", "佰", "仟" };
	    String[] s2 = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	    String[] s3 = { "元整", "万", "亿" };
	    String[] s4 = { "万", "亿" };
	    s = s.substring(1);
	    String result = "";
	    for (int i = 0; i < s.length(); i++) {
	     int numIndex = (int) s.charAt(i) - 48;
	     int index = s.length() - 1 - i;
	     int unitIndex = index % 4;
	     if (numIndex != 0 || unitIndex != 3) {
	      result += s2[numIndex];
	     }
	     if (numIndex != 0) {
	      result += s1[unitIndex];
	     }
	     if (unitIndex == 0) {
	      if (index >= 12) {
	       result += s4[(index - 1) / 4 % 2];
	      } else {
	       result += s3[index / 4 % 3];
	      }
	     }
	    }
	    return result;
	   }
}
