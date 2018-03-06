package jh.io.socket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException, IOException {
		 Socket socket = new Socket("localhost", 12345);  
		 //读取服务器端数据    
         DataInputStream input = new DataInputStream(socket.getInputStream());    
         //向服务器端发送数据    
         DataOutputStream out = new DataOutputStream(socket.getOutputStream());  
         String str = "client ---- 1234";    
         out.writeUTF(str);    
         String ret = input.readUTF();     
         System.out.println("服务器端返回过来的是: " + ret);    
	}
}
