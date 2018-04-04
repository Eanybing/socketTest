package jh.io.socket.socketChennel;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SelectTestClient {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws IOException {
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 12346));

		// 打开并注册选择器到信道
        //Selector selector = Selector.open();
        //sc.register(selector, SelectionKey.OP_WRITE);

		// write data
		String newData = "New String to write to file...";
		ByteBuffer buf2 = ByteBuffer.allocate(48);
		buf2.clear();
		buf2.put(newData.getBytes());
		buf2.flip();
		while (buf2.hasRemaining()) {
			sc.write(buf2);
		}
	}

}
