package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//정보 한곳에 두기. 데이터 베이스 계정 정보를 중복해서 기재하지 않기 위해
//인스턴스의 갯수를 한개만. 어플리케이션 가동 중 생성되는 커넥션 객체를 하나로 통일
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