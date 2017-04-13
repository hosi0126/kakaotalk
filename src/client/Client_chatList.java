package client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Client_chatList extends JPanel implements ActionListener{
	MainClient main;
	JButton bt_test;
	
	public Client_chatList(MainClient main) {
		// TODO Auto-generated constructor stub
		this.main=main;
		bt_test=new JButton("입장");
		
		add(bt_test);
		bt_test.addActionListener(this);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//여기선 연결하면 바로 채팅창을 띄워주었지만 채팅목록-> 채팅방 선택하면 아래 채팅방을 띄워주는걸로 변경하기
		main.chat.setLocation(main.getLocation().x+360,main.getLocation().y);
		main.chat.setVisible(true);//화면 교체
	}
}
