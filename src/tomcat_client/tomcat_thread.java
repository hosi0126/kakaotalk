package tomcat_client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

//서버 메세지를 실시간청취하기 위해서는 와일문으로 리드라인을 실행해야한다 따라서 메인쓰레드도 이 작업을 시도하면 메인쓰레드가 와일문에서 빠져나오지 못하므로 모든 유아이가 멈춰있게된다
public class tomcat_thread extends Thread{
	Socket socket;
	BufferedWriter buffw;
	boolean flag=true;
	File file;
	FileInputStream fis;
	ObjectOutputStream oos;
	
	public tomcat_thread(Socket socket, File file) {
		this.socket=socket;
		this.file=file;
		try {
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	        oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send(){
		try {
			fis=new FileInputStream(file);
			oos.writeUTF(file.getName());
			oos.flush();
			
			byte[] data=new byte[1024];
			while(true){
				int d=fis.read(data);
				if(d==-1) break;
				oos.write(data,0,d);
				oos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void run() {
		send();
	}
}
