package tomcat_server;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;


public class User implements Runnable{
	Thread thread;
	Socket socket;
	BufferedReader buffr;
	boolean flag=true;
	ObjectInputStream ois;
	
	public User(Socket socket) {
		this.socket=socket;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        ois= new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread=new Thread(this);
		thread.start();
		
	}
	
	public void listen(){
		FileOutputStream fos=null;
		try {
				String fileName=ois.readUTF();
				String path="C:/myserver/data/"+fileName;
				fos=new FileOutputStream(path);
					
				byte[] data=new byte[1024];
					
				while(true){
					int d=ois.read(data);
					if(d==-1) break;
					fos.write(data,0,d);
					fos.flush();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
