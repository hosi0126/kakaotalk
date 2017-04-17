package merge_sh_yk;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
	KakaoMain kakaoMain;
	JPanel p_north, p_center, p_south, p_id_pw;
	JTextField t_id;
	JPasswordField t_password;
	JButton bt_login, bt_find_pw;
	Checkbox auto_login;
	JLabel info, link, temp;
	
	Canvas logo;
	BufferedImage image=null;
	URL url=this.getClass().getResource("/icon.png");
	
	Join join;
	//Login login; 
	
	Thread thread;
	
	public LoginPanel(KakaoMain kakaoMain) {
		this.kakaoMain=kakaoMain;
		
		setLayout(new BorderLayout());
		
		//패널
		p_north=new JPanel();
		p_center=new JPanel();
		p_south=new JPanel();
		p_id_pw=new JPanel();
		
		p_north.setPreferredSize(new Dimension(360, 250));
		p_center.setPreferredSize(new Dimension(360, 170));
		p_south.setPreferredSize(new Dimension(360, 170));
		
		p_north.setBackground(new Color(255, 235, 051));
		p_center.setBackground(new Color(255, 235, 051));
		p_south.setBackground(new Color(255, 235, 051));
		
		p_north.setLayout(new BorderLayout());
		p_center.setLayout(new FlowLayout());
		p_south.setLayout(new FlowLayout());
		p_id_pw.setLayout(new GridLayout(2,1));
		
		//캔버스
		try {
			image=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logo=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(image, 125, 75, 110, 110, this);
			}
		};
		logo.setPreferredSize(new Dimension(150, 150));
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입!!");
				join=new Join();
			}
		});
		
		t_id=new JTextField("카카오계정(이메일)");
		t_password=new JPasswordField("비밀번호");
		bt_login=new JButton("로그인");
		auto_login=new Checkbox("잠금모드로 자동로그인");
		
		
		t_id.setPreferredSize(new Dimension(250, 35));
		t_password.setPreferredSize(new Dimension(250, 35));
		bt_login.setPreferredSize(new Dimension(250, 35));
		bt_login.setBackground(new Color(113	, 92, 94));
		bt_login.addActionListener(this);
		
		info=new JLabel("모바일에서 카카오계정을 확인할 수 있습니다.");
		link= new JLabel("<HTML><U>카카오계정안내</U></HTML>");
		link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		link.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    JOptionPane.showMessageDialog(kakaoMain, "카카오계정이란 모바일 카카오톡에서 등록한 이메일 주소입니다."+"\n" +"모바일 카카오톡의 '더보기>설정>개인/보안>카카오계정을 확인해주세요"); 
			}
		});
		
		temp=new JLabel();
		temp.setPreferredSize(new Dimension(300, 35));
		
		bt_find_pw=new JButton("비밀번호를 잊어버리셨나요?");
		bt_find_pw.setBackground(new Color(255, 235, 051));
		bt_find_pw.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(kakaoMain, "모바일 카카오톡에서 '더보기>설정>개인/보안>카카오계정'을 선택한 후"+"\n" +"계정 비밀번호 변경을 실행해주세요."); 
			}
		});
		
		p_north.add(logo);
		p_id_pw.add(t_id);
		p_id_pw.add(t_password);
		p_center.add(p_id_pw);
		p_center.add(bt_login);
		p_center.add(auto_login);
		
		p_south.add(info);
		p_south.add(link);
		p_south.add(temp);
		p_south.add(bt_find_pw);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
	
		kakaoMain.dragMouse(p_north);
		//pack();
		//setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		kakaoMain.panel[0].setVisible(false);
		kakaoMain.panel[1].setVisible(true);
		
		System.out.println("버튼");
	}
}
