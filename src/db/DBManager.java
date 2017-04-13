package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���� �Ѱ��� �α�. ������ ���̽� ���� ������ �ߺ��ؼ� �������� �ʱ� ����
//�ν��Ͻ��� ������ �Ѱ���. ���ø����̼� ���� �� �����Ǵ� Ŀ�ؼ� ��ü�� �ϳ��� ����
public class DBManager {
	static private DBManager instance;
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user="bread";
	private String pass="bread";
	
	private Connection con;
	
	private DBManager(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public DBManager getInstance(){
		if(instance==null){
			instance=new DBManager();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void disConnect(Connection con){

		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}