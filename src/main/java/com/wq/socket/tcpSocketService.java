package com.wq.socket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public abstract class tcpSocketService implements Runnable {
	private int port;
	private boolean runFlag;
	private List<socketService> clients = new ArrayList<socketService>();

	//监听端口
	public tcpSocketService(int port) {
		this.port = port;
	}

	//启动服务
	public void start() {
		runFlag = true;
		new Thread(this).start();
	}

	//停止服务
	public void stop() {
		runFlag = false;
	}
	@Override
	public void run() {
		try {
			System.out.println(port+""+runFlag);
			ServerSocket server = new ServerSocket(port);
			while(runFlag){
				try {
					Socket socket = server.accept();
					System.out.println(socket);
					startClient(socket);//启动客户端收发
				} catch (Exception e) {
					e.printStackTrace();
					this.onConnectFailed();
				}
			}
			try {//停止服务断开与每个客户端的连接
				for(socketService client:clients){
					client.stop();
				}
				clients.clear();
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.onServerStop();
	}
	//启动客户端收发
	public void startClient(final Socket socket){
		System.out.println("startClient");
		socketService client = new socketService(socket){
			@Override
			public void onReceive(InetAddress addr, String s) {
				tcpSocketService.this.onReceive(this, s);
			}

			@Override
			public void onDisconnect(InetAddress addr) {
				clients.remove(this);
				tcpSocketService.this.onDisconnect(this);
			}
		};
		client.start();
		clients.add(client);
		this.onConnect(client);//启动连接
	}
	//客户端建立连接
	public abstract void onConnect(socketService client);
	//连接建立失败
	public abstract void onConnectFailed();
	//客户端收到字符串
	public abstract void onReceive(socketService client,String s);
	//连接断开
	public abstract void onDisconnect(socketService client);
	//服务停止
	public abstract void onServerStop();
}
