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
		bt_test=new JButton("����");
		
		add(bt_test);
		bt_test.addActionListener(this);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//���⼱ �����ϸ� �ٷ� ä��â�� ����־����� ä�ø��-> ä�ù� �����ϸ� �Ʒ� ä�ù��� ����ִ°ɷ� �����ϱ�
		main.chat.setLocation(main.getLocation().x+360,main.getLocation().y);
		main.chat.setVisible(true);//ȭ�� ��ü
	}
}
