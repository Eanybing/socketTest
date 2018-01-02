package jh.test.mina1.base;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;

/**
 * 使用mina客户端
 *
 * @author JiangHan
 */
public class MinaClient3 {

	public static void main(String[] args) throws Exception {
		// 创建客户端连接器.
		SocketConnector connector = new SocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		// 设置连接超时检查时间
		// 建立连接
		String msg = new String("hello3");
		IoSession session;
		ConnectFuture cf = connector.connect(new InetSocketAddress("localhost", 18089), new ClientIoHandler3(msg));
		Thread.sleep(10*1000);
	
	}
}
