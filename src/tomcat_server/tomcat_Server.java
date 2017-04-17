package tomcat_server;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tomcat_Server extends JFrame implements Runnable{
	JPanel p_center;
	ServerSocket server;
	Thread thread;
	int port=7878;
	
	public tomcat_Server() {
		p_center=new JPanel();
		try {
			server=new ServerSocket(port);
			System.out.println("辑滚 积己");
			
			thread=new Thread(this);
			thread.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p_center.setBackground(Color.WHITE);
		add(p_center);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new tomcat_Server();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Socket socket=server.accept();
				System.out.println("立加");
				User user=new User(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
