package merge_sh_yk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FriendsListPanel extends JPanel{
	JPanel p_search; //검색 패널
	JPanel p_list; //p_search부분 제외한 아랫부분 전체 패널-그리드
	JPanel p_myProfile;
	JTextField t_search;
	JLabel la_myProfile, la_friends;
	JScrollPane scroll;
	int friends_count=0; //친구 수
	PersonPanel person=new PersonPanel("/jeju2.jpg", "차유경", "여름!!!");
	
	PersonPanel[] people=new PersonPanel[7];
	
	
	
	public FriendsListPanel(){
		setLayout(new BorderLayout());
		
		p_search=new JPanel();
		t_search=new JTextField("이름검색", 30);
		p_list=new JPanel();
		p_myProfile=new JPanel();
		la_myProfile=new JLabel("    내 프로필 ");
		
		scroll=new JScrollPane(p_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		p_list.setLayout(new GridLayout(15,1));
		p_list.setBackground(Color.WHITE);

		t_search.setPreferredSize(new Dimension(350, 30));
		p_search.setPreferredSize(new Dimension(360, 43));
		//p_search.setBackground(Color.BLUE);
		
		p_search.add(t_search);	
		
		friends_count=people.length;
		la_friends=new JLabel("    친구   "+friends_count);
		
		p_list.add(la_myProfile);
		p_list.add(person);
		p_list.add(la_friends);
		
		for(int i=0; i<people.length; i++){
			people[i]=new PersonPanel("/jeju2.jpg", "차유경", "여름!!!");
			p_list.add(people[i]);
		}

		add(p_search, BorderLayout.NORTH);
		add(scroll);
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(360, 497));
		//setPreferredSize(new Dimension(370, 497));
		
	}
}
