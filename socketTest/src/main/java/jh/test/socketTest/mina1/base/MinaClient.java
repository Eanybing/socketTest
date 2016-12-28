package jh.test.socketTest.mina1.base;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 通过原始的socket channel来发送数据
 * 这个的关键点就是byte to 基本类型,byte to 对象的相互转换,剩下的都是都比了
 * 
 * 原理上来讲,mina底层是用socket channel实现的,这个就可以知道mina绑定的一个端口对应一个socket握手,
 * 这样的话,一个客户端与mina服务器建立联系的时候只会有一个iosession
 *
 * @author JiangHan
 */
public class MinaClient {
	
	public static void main(String[] args) throws Exception {
		System.out.println("-------------------- mina client start ------------------");
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("192.168.53.55", 18088));
		//sc.connect(new InetSocketAddress("127.0.0.1", 18088));
		ByteBuffer bf = ByteBuffer.allocate(1024);
//		bf.putInt(1025);
		bf.put(new String("hhww").getBytes());
		//如果末尾不设置十六进制的换行符,mina server方面不执行自定义的io handler 下的messageReceived方法
		//猜想: 可能是mina认为客户端还没有输入完,默认等待客户端输入完
		bf.putInt(0x0D0A);
		bf.flip();
		while(0 != bf.remaining()){
			sc.write(bf);
		}
		System.out.println("-------------------- mina client back ------------------");
		ByteBuffer dst = ByteBuffer.allocate(1024);
		while(sc.read(dst) != -1){
			dst.flip();
			//byte to string
			CharBuffer charBuffer = Charset.forName("utf-8").newDecoder().decode(dst.asReadOnlyBuffer());
			String cc = charBuffer.toString();
			
			System.out.println(cc);
		}
		sc.close();
	}

}
