package jh.io.socket.socketChennel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import org.junit.BeforeClass;
import org.junit.Test;

public class SelectTestServer {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(12346));
		while (true) {
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);//异步
			//selector
			Selector selector = Selector.open();
			SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
			
			//从selector中获取selection key s,从selectionKey中获取channel,selector
			 for(SelectionKey sk : selector.selectedKeys()){
				
				 if(sk.isReadable()){//选择一个注册的信道,即读取信道
					SocketChannel sc = (SocketChannel) sk.channel();
					sk.selector();
					//
					ByteBuffer buf = ByteBuffer.allocate(48);
					sc.read(buf);//read into buffer.
					buf.flip(); //make buffer ready for read

					String cc = Charset.forName("utf-8").newDecoder().decode(buf.asReadOnlyBuffer()).toString();
					System.out.println("-----------------------");
					System.out.println(cc);
					System.out.println("-----------------------");
					
				}
			 }
			
			
			
			ByteBuffer buf = ByteBuffer.allocate(48);
			socketChannel.read(buf);//read into buffer.
			buf.flip(); //make buffer ready for read

			String cc = Charset.forName("utf-8").newDecoder().decode(buf.asReadOnlyBuffer()).toString();
			System.out.println("-----------------------");
			System.out.println(cc);
			System.out.println("-----------------------");
			// do something with socketChannel...
		}
	}

}
