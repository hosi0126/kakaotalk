package merge_sh_yk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel implements ActionListener{
	KakaoMain kakaoMain;
	
	Color color=new Color(82, 55, 56);
	//Point mouseDownCompCoords = null;
	
	JPanel[] page = new JPanel[3];
	JButton[] bt_menu=new JButton[3];
	URL[] url = new URL[3];
	String[] path={"/person2.png", "/talk2.png", "/etc3.png"};
	JPanel p_north, p_center;
	JPanel p_buttons ;
	JButton bt_close;
	URL url_close;
	URL url_kakaotalk=this.getClass().getResource("/kakaotalk2.png");
	ImageIcon kakaoIcon = new ImageIcon(url_kakaotalk);
	JLabel la_kakaotalk;

	JTextField t_name, t_status;
	JButton bt_reg;
	
	public MenuPanel(KakaoMain kakaoMain){
		this.kakaoMain=kakaoMain;
		kakaoMain.dragMouse(this);
		
		setLayout(new BorderLayout());

		p_north=new JPanel();
		p_center=new JPanel();
		p_buttons=new JPanel();
		la_kakaotalk=new JLabel(kakaoIcon);
		url_close=this.getClass().getResource("/close3.png");
		bt_close=new JButton(new ImageIcon(url_close));
		
		t_name=new JTextField(10);
		t_status=new JTextField(10);
		bt_reg=new JButton("등록");
		
		bt_close.setPreferredSize(new Dimension(25, 25));	
		la_kakaotalk.setPreferredSize(new Dimension(80, 25));
		//la_kakaotalk.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		//bt_close.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		p_center.setLayout(new BorderLayout());
		p_north.setLayout(new BorderLayout());
		
		p_center.setBackground(color);
		p_north.setBackground(color);
		p_buttons.setBackground(color);
		
		for(int i=0; i<path.length; i++){
			url[i]=this.getClass().getResource(path[i]);

			bt_menu[i]=new JButton(new ImageIcon(url[i]));
			bt_menu[i].setPreferredSize(new Dimension(40, 40));
			p_buttons.add(bt_menu[i]);
			
			bt_menu[i].setBorderPainted(false); //버튼 경계선 없애기
			bt_menu[i].setContentAreaFilled(false); //색 채우기(파란색) 없애기
			bt_menu[i].setFocusPainted(false); //포커스에 의한 경계 없애기
			bt_menu[i].setOpaque(false); //투명도-투명해야되니까 false(불투명-true)
			
			//메뉴 리스너 연결
			bt_menu[i].addActionListener(this);
			bt_close.addActionListener(this);
		}
		
		bt_close.setBorderPainted(false);
		bt_close.setContentAreaFilled(false);
		bt_close.setFocusPainted(false);
		bt_close.setOpaque(false);
		
		p_north.add(la_kakaotalk, BorderLayout.WEST);
		p_north.add(bt_close, BorderLayout.EAST);
		p_center.add(p_buttons, BorderLayout.WEST);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setBackground(color);
		setPreferredSize(new Dimension(360, 93));
	}
	public void setPage(int index){
		kakaoMain.panel[0].setVisible(false);
		kakaoMain.panel[1].setVisible(true);

		boolean[] flag={false, false, false};
		for(int i=0; i<flag.length; i++){
			if(i==index){
				flag[index]=true;
				kakaoMain.friendsListPanel.setVisible(flag[0]);
				kakaoMain.chattingListPanel.setVisible(flag[1]);
				kakaoMain.settingPanel.setVisible(flag[2]);
			}
			flag[index]=false;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==bt_menu[0]){
			setPage(0);
		}else if(obj==bt_menu[1]){
			setPage(1);
		}else if(obj==bt_menu[2]){
			setPage(2);
		}else if(obj==bt_close){
			System.exit(0);
		}
	}
}


