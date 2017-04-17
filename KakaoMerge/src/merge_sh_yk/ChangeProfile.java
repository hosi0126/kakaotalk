package merge_sh_yk;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class ChangeProfile extends JDialog{
	JTextField t_photo, t_status;
	JButton bt_change;
	
	public ChangeProfile(){
		setLayout(new FlowLayout());
		t_photo=new JTextField(10);
		t_status=new JTextField(10);
		bt_change=new JButton("º¯°æ");
		
		add(t_photo);
		add(t_status);
		add(bt_change);
		
		 this.setSize(200,100);
         this.setModal(true);
         this.setVisible(true);
	}
}
