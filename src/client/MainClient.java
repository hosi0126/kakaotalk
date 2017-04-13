package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainClient extends JFrame{
	JPanel p_center;
	JPanel[] page=new JPanel[2];//페이지 추가
	Client_chat chat;//채널 새창*채팅목록에서 새로열기 가능하게 바꾸기
	
	public MainClient(){
		chat=new Client_chat(this);
		p_center=new JPanel();
		page[0]=new Client_login(this);
		page[1]=new Client_chatList(this);
		
		p_center.add(page[0]);
		p_center.add(page[1]);
		add(p_center);
		
		setSize(360,590);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MainClient();
	}
}