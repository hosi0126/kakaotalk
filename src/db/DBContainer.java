package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class DBContainer {
	DBManager manager=DBManager.getInstance();
	Map<Integer, Vector>m_chat=new HashMap<Integer,Vector>();//맵을 너무 쓰고싶었다...☆
	Connection con;
	
	public DBContainer() {
		// TODO Auto-generated constructor stub
		con=manager.getConnection();
		getMap();
	}
	public void getMap(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from test_chatlist";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(m_chat.containsKey(rs.getInt("chat_key"))){
					m_chat.get(rs.getInt("chat_key")).add(rs.getInt("member_key"));//중복되는 키값은 멤버로 넣는다
				}
				else{
					Vector<Integer> vec=new Vector<Integer>();
					vec.add(rs.getInt("member_key"));
					
					m_chat.put(rs.getInt("chat_key"),vec);//새로 만들경우
				}
			}
			
			Iterator<Integer> iter=m_chat.keySet().iterator();
			while(iter.hasNext()){
				int n=iter.next();
				if(m_chat.containsKey(n)){
					Vector vec=m_chat.get(n);
					for(int i=0;i<vec.size();i++){
						System.out.println(vec.get(i));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
