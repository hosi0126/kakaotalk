package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

//DB가 가져야할 정보 num/users/내용
public class Server_chat extends Thread{
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	Vector<ThreadManager> userThread=new Vector<ThreadManager>();
	public Server_chat(Socket socket,Vector<ThreadManager> userThread) {
		this.socket=socket;
		this.userThread=userThread;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listen(){
		//클라에서 받는 것
		String msg=null;
		
		try {
			msg=buffr.readLine();
			//여기서 판단하기
			
			send(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String msg){
		//서버가 보내주는 것
		try {
			//판단해서 보내주기
			for(int i=0;i<userThread.size();i++){
				userThread.get(i).chat.buffw.write(msg+"\n");
				userThread.get(i).chat.buffw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			listen();
		}
	}
}