package client;

import java.awt.Dimension;
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
			
			ct=new ClientThread(socket,main.chat);//chat 리스트를 넣어서 각 채팅방의 번호에 따라 대화를 넘겨주기
			//채팅방 리스트는 각 계정이 미리 알고 있어야하므로 db를 넣는다. 채팅방이 생성된 순서에따라 db에 넣어주고 그 순서대로 chat 리스트 생성후 저장
			//각 방의 리스트는 db(서버)에서 관리하며 각 프라이머리키를 갖고 있다. 서버에서 클라로 해당하는 사용자가 있을 경우 접속시 방의 정보를 넘겨준다.
			//넘겨준 정보를 바탕으로 접속전에 chat 리스트를 생성한다.
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
		main.page[1].setVisible(true);
		setVisible(false);
	}
}
