package com.wq.thread;

import java.lang.reflect.Method;

import javax.swing.JOptionPane;

public class SortMain {
	public static void main(String[] args) {
		int[] a = {1,6,3,8,4,5,9};
//		selectSort(a);
//		insertSort(a);
		bubbleSort(a);
		for(int k=0;k<a.length;k++){
			System.out.println(a[k]);
		}
//		fanse();
	}
	//反射
	public static void fanse(){
		String s = JOptionPane.showInputDialog("com.wq.produce.model.User", "com.wq.produce.model.User");
		try {
			Class<?> cla = Class.forName(s);
			Method[] ms = cla.getDeclaredMethods();
			for(Method m:ms){
				System.out.println("方法有："+m.toString());
				System.out.println(cla.getPackage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//冒泡排序
	public static void bubbleSort(int[] a){
		int temp;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	//插入排序
	public static void insertSort(int[] a){
		for(int i=0;i<a.length;i++){
			int temp = a[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(a[j]<temp){
					a[j+1]=a[j];
				}else{
					break;
				}
			}
			a[j+1]=temp;
		}
	}
	
	//选择排序
	public static void selectSort(int[] a){
		int temp;
	    for(int i=0;i<a.length;i++){
	    	for(int j=0;j<a.length;j++){
	    		if(a[i]>a[j]){
	    			temp=a[j];
	    			a[j]=a[i];
	    			a[i]=temp;
	    		}
	    	}
		}
	}
}
