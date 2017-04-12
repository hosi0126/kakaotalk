package client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client_login extends JPanel implements ActionListener{
	String ip;
	JButton bt;
	JTextField t_server;
	Socket socket;
	MainClient main;
	ClientThread ct;
	
	int port=7777;
	public Client_login(MainClient main) {
		// TODO Auto-generated constructor stub
		bt=new JButton("connect");
		t_server=new JTextField(20);
		t_server.setText("211.238.142.121");
		this.main=main;
		
		setLayout(new FlowLayout());
		add(t_server);
		add(bt);
		bt.addActionListener(this);
		setVisible(true);
		loadIp();
	}
	public void loadIp(){
		ip=t_server.getText();//서버 아이피 주소 입력
		System.out.println(ip);
	}

	public void connect(){
		try {
			socket=new Socket(ip, port);
			
			ct=new ClientThread(socket,(Client_chat)main.page[1]);
			ct.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void actionPerformed(ActionEvent e) {
		connect();
		setVisible(false);
		main.page[1].setVisible(true);
	}
}
