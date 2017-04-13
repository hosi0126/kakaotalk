package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client_chat extends JDialog {
	JTextField t_input;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	MainClient main;
	
	public Client_chat(MainClient main) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		t_input=new JTextField(30);
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		this.main=main;
		
		p_south.add(t_input);
		add(scroll);
		add(p_south,BorderLayout.SOUTH);
		
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int key=e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					String msg=t_input.getText();
					Client_login log=(Client_login)main.page[0];
					log.ct.send(msg);
					t_input.setText("");
				}
			}
		});
		setVisible(false);
		setSize(360,590);
	}
}