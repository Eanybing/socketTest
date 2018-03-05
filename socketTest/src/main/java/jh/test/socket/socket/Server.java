package jh.test.socket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket server
 *
 * @author JiangHan
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//绑定本地端口
		ServerSocket serverSocket = new ServerSocket(12345);
		while (true) {
			Socket socket = serverSocket.accept();//监听开始,程序到此时,等待
			// 读取客户端数据
			DataInputStream input = new DataInputStream(socket.getInputStream());
			
			String clientInputStr = input.readUTF();// 这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
			// 处理客户端数据
			System.out.println("客户端发过来的内容:" + clientInputStr);

			// -------------------------------------------------------------------------------------------
			// 向客户端回复信息
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			// 发送键盘输入的一行
			String s = "11223344";
			out.writeUTF(s);
			out.close();
			input.close();
			socket.close();
		}

	}
}
