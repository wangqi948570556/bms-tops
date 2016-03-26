package com.wq.socket;

public class testSocket {
	public static void main(String[] args) {
		int port = 1234;
		tcpSocketService server = new tcpSocketService(port) {
			
			@Override
			public void onServerStop() {
				System.out.println("停止连接");
			}
			
			@Override
			public void onReceive(socketService client, String s) {
				System.out.println("建立连接");
			}
			
			@Override
			public void onDisconnect(socketService client) {
				System.out.println("断开连接");
			}
			
			@Override
			public void onConnectFailed() {
				System.out.println("客户端连接失败");
			}
			
			@Override
			public void onConnect(socketService client) {
				printInfo(client,"Connect");
			}
		};
		System.out.println("启动服务");
		server.start();
	}
	static void printInfo(socketService st, String msg) {
		System.out.println("Client " + st.getInetAddress().getHostAddress());
		System.out.println("  " + msg);
	}
}
