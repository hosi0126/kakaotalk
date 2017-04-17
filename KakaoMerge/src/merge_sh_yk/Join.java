package merge_sh_yk;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Join extends JDialog{
	JPanel panel;
	JTextField t_id, t_pw, t_nick;
	
	public Join() {
			
		panel=new JPanel();
		t_id = new JTextField("아이디를 입력하세요"); 
		t_pw= new JTextField("비밀번호를 입력하세요"); 
	
		panel.setPreferredSize(new Dimension(360, 590));
		panel.setBackground(new Color(255, 235, 051));
		
		panel.add(t_id);
		panel.add(t_pw);
		add(panel);
		
		this.setModal(true);
		this.setSize(380, 650);
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

}
