package jh.test.socketTest.mina1;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;

public class MinaClient2 {

	public static void main(String[] args) throws Exception {
		// 创建客户端连接器.
		SocketConnector connector = new SocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		// 设置连接超时检查时间
		// connector.setHandler(new TimeClientHandler());

		// 建立连接
		ConnectFuture cf = connector.connect(new InetSocketAddress("192.168.53.99", 18088), new IoHandlerAdapter());
		// 等待连接创建完成
		// cf.awaitUninterruptibly();

		cf.getSession().write("Hi Server!");
		cf.getSession().write("quit");

		// 等待连接断开
		// cf.getSession().getCloseFuture().awaitUninterruptibly();
		// 释放连接
		// connector.dispose();
		connector.wait(1000000);
		Thread.sleep(1000000);
	}

}
