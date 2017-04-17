package merge_sh_yk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KakaoMain extends JFrame {
	Point mouseDownCompCoords = null;
	JPanel[] panel;
	JPanel menuPanel, friendsListPanel, chattingListPanel, settingPanel, p_center;
	
	public KakaoMain(){

		panel=new JPanel[2];
		p_center=new JPanel();
		
		menuPanel=new MenuPanel(this);
		friendsListPanel=new FriendsListPanel();
		chattingListPanel=new ChattingListPanel();
		settingPanel=new SettingPanel();
		
		panel[0]=new LoginPanel(this);
		panel[1]=new JPanel();	
		panel[1].setLayout(new BorderLayout()); //panel[1]의 북쪽에 메뉴바, 센터에 패널3개
	
		panel[1].add(menuPanel, BorderLayout.NORTH);
		p_center.add(friendsListPanel);
		p_center.add(chattingListPanel);
		p_center.add(settingPanel);
		panel[1].add(p_center);
		
		add(panel[0]);
		add(panel[1]);

		panel[0].setBackground(new Color(255, 235, 051));
		panel[0].setSize(360,590);
		
		panel[0].setVisible(true);
		panel[1].setVisible(false);

		dragMouse(panel[0]);
		
		setUndecorated(true); //타이틀바 제거
		setBounds(100,100,360,590);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//윈도우안에 어떤 패널이 올지를 결정해주는 메서드 정의
	public void setPage(int index){
		for(int i=0; i<panel.length; i++){
			if(i==index){
				panel[i].setVisible(true);
			}else{
				panel[i].setVisible(false);
			}
			//pack(); //내용물의 크기만큼 윈도우의 크기 설정
			//setLocationRelativeTo(null); //화면 중앙
		}
	}
	
	public void dragMouse(JPanel panel){
		panel.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseDownCompCoords = null;
				System.out.println("mouseReleased1");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
				System.out.println("mousePressed1");
			}
		});

		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
		        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
				System.out.println("mouseDragged2");
			}
		});
	}
	
	public static void main(String[] args) {
		new KakaoMain();
	}
}
