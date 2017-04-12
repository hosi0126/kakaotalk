package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainClient extends JFrame{
	JPanel p_center;
	JPanel[] page=new JPanel[2];
	
	public MainClient(){
		p_center=new JPanel();
		page[0]=new Client_login(this);
		page[1]=new Client_chat(this);
		
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