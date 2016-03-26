package com.wq.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public abstract class socketService implements Runnable{
	protected Socket socket;
	protected InetAddress addr;
	protected DataInputStream in;
	protected DataOutputStream out;
	private boolean runFlag;
	public socketService(Socket socket){
		this.socket = socket;
		this.addr = socket.getInetAddress();
	}
	//获取连接到的Socket地址
	public InetAddress getInetAddress() {
		return addr;
	}
	
	public void start(){
		runFlag = true;
		new Thread(this).start();
	}
	//断开连接
	public void stop(){
		runFlag = false;
		try {
			socket.shutdownInput();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//发送字符串
	public boolean send(String s){
		if(out != null){
			try {
				out.writeUTF(s);
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public void run() {
		try {
			in = new DataInputStream(this.socket.getInputStream());
			out = new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			runFlag = false;
		}
		while(runFlag){
			try {
				final String s = in.readUTF();
				this.onReceive(addr,s);
			} catch (Exception e) {
				runFlag = false;
			}
			try {
				in.close();
				out.close();
				socket.close();
				in = null;
				out = null;
				socket = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.onDisconnect(addr);
		}
	}
	
	public abstract void onReceive(InetAddress addr, String s);
	

	public abstract void onDisconnect(InetAddress addr);
}
