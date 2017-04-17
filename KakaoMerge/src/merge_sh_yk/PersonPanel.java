package merge_sh_yk;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonPanel extends JPanel{
	Canvas can=null;
	BufferedImage image=null; //������ ����
	BufferedImage bgimage=null; //������ ���� ����ó�� ���� �̹���
	URL url=null;
	URL bgurl=null;

	JPanel p_info; //�̸�, ��� ���� �׸��� �г�
	//JPanel p_name, p_statusMsg; 
	JLabel la_name, la_statusMsg;
	
	String photoPath;
	String name;
	String statusMsg;
	
	ChangeProfile pop; //�� ������ ������ ���� �ӽ�â. 
	
	public PersonPanel(String photoPath, String name, String statusMsg){
		this.photoPath=photoPath;
		this.name=name;
		this.statusMsg=statusMsg;

		p_info=new JPanel();
		//p_name=new JPanel();
		//p_statusMsg=new JPanel();
		la_name=new JLabel(name);
		la_statusMsg=new JLabel(statusMsg);
		
		setLayout(new BorderLayout());
		
		p_info.setLayout(new GridLayout(2, 1));
		p_info.setBackground(Color.WHITE);
		url=this.getClass().getResource(photoPath); //"/jeju2.jpg"
		bgurl=this.getClass().getResource("/emptyCircle.png");
		
		try {
			image=ImageIO.read(url);
			bgimage=ImageIO.read(bgurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 50,50, this);
				g.drawImage(bgimage, 0, 0, 50,50, this);
			}
		};
		
		can.setPreferredSize(new Dimension(50,50));
		
		//p_name.add(la_name);
		//p_statusMsg.add(la_statusMsg);
		
		p_info.add(la_name);
		p_info.add(la_statusMsg);
		
		add(can, BorderLayout.WEST);
		add(p_info);
		
		
		//������ ���콺 ������ ����
		can.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("����Ŭ��");
				pop=new ChangeProfile();
			}
		});
		
		setPreferredSize(new Dimension(360, 60));
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		setBackground(Color.WHITE);
	}
}
