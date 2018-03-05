package jh.test.socket.socketChennel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ChannelServer {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(12346));
		while (true) {
			SocketChannel socketChannel = serverSocketChannel.accept();
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
