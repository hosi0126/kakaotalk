package tomcat_client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

//���� �޼����� �ǽð�û���ϱ� ���ؼ��� ���Ϲ����� ��������� �����ؾ��Ѵ� ���� ���ξ����嵵 �� �۾��� �õ��ϸ� ���ξ����尡 ���Ϲ����� ���������� ���ϹǷ� ��� �����̰� �����ְԵȴ�
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
