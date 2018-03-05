package jh.test.socket.socketChennel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class ByteBufferTest {
	public static void main(String[] args) throws IOException {
		
		String str = "213425fgdgsd";
		// string to byteBuffer
		ByteBuffer bb = ByteBuffer.wrap(str.getBytes());
		// byteBuffer to string
		CharBuffer charBuffer = Charset.forName("utf-8").newDecoder().decode(bb.asReadOnlyBuffer());
		String cc = charBuffer.toString();
		System.out.println("------------------");
		System.out.println(cc);
		System.out.println("------------------");
	}
}
