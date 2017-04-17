package tomcat_client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tomcat_Client extends JFrame implements ActionListener{
	JPanel p_center,p_south;
	JButton bt,load;
	String[] path={"mario.png",
			"base.png",
			"baskeat.png",
			"block1.png",
			"enemy.png",
			"enemy2.png",
			"enemy3.png",
			"enemy4.png"};
	Socket socket;
	int port=7878;
	String ip="localhost";
	tomcat_thread ct;
	JFileChooser chooser;
	
	
	public tomcat_Client() {
		p_center=new JPanel();
		p_south=new JPanel();
		bt=new JButton("Connect");
		load=new JButton("Load");
		chooser=new JFileChooser();

		p_south.add(bt);
		p_south.add(load);
		
		add(p_center);
		add(p_south,BorderLayout.SOUTH);
		
		
		bt.addActionListener(this);
		load.addActionListener(this);
		
		
		setSize(300,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void connect(){
		try {
			socket=new Socket(ip, port);			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt){
			connect();
		}
		else if(obj==load){
			LoadData();
		}
	}
	
	public void LoadData(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			ct=new tomcat_thread(socket,file);
			ct.start();
		}
	}//데이터를 읽어서 넘겨줄것
	
	public static void main(String[] args) {
		new tomcat_Client();
	}
}
