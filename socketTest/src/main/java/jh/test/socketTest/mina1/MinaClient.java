package jh.test.socketTest.mina1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MinaClient {
	
	public static void main(String[] args) throws Exception {
		System.out.println("-------------------- mina client start ------------------");
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("192.168.53.99", 18088));
		//sc.connect(new InetSocketAddress("127.0.0.1", 18088));
		ByteBuffer bf = ByteBuffer.allocate(1024);
		bf.putInt(1025);
		//如果末尾不设置十六进制的换行符,mina server方面不执行自定义的io handler 下的messageReceived方法
		//猜想: 可能是mina认为客户端还没有输入完,默认等待客户端输入完
		bf.putInt(0x0D0A);
//		bf.put(new String("hhww").getBytes());
		bf.flip();
		while(0 != bf.remaining()){
			sc.write(bf);
		}
		System.out.println("-------------------- mina client back ------------------");
		sc.close();
		Thread.sleep(900000);
	}

}
