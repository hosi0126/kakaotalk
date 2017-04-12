package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;

public class MainServer extends JFrame implements Runnable{
	int port=7777;
	ServerSocket server;
	Thread thread;//accept ������
	Socket socket;
	Vector<ThreadManager> userThread=new Vector<ThreadManager>();//�� ������ ������Ŵ����� ���´�.
	
	public MainServer() {
		thread=new Thread(this);//accept
		thread.start();
		
		setSize(360,590);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void accept(){
		try {
			server=new ServerSocket(port);
			System.out.println("server ����");
			
			while(true){
				socket=server.accept();
				String ip=socket.getInetAddress().getHostAddress();
				System.out.println(ip+" ����\n");
				
				ThreadManager tm=new ThreadManager(socket,userThread);
				tm.start();
				
				userThread.add(tm);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run() {
		accept();
	}
	public static void main(String[] args) {
		new MainServer();
	}


}
