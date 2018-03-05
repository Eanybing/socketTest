package jh.mina1.baseToObject;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * mina 1 test
 *
 * @author JiangHan
 */
public class MinaServer {
	private static final String LOG4J_CONFIG = "log4j.properties";
	private static Logger log = LoggerFactory.getLogger(MinaServer.class);
	
	public static void main(String[] args) throws Exception {
		System.out.println("------------mina server start -------------------------");
		IoAcceptor acceptor =  new SocketAcceptor();
		Log4jConfig.load(LOG4J_CONFIG);
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		acceptor.bind(new InetSocketAddress("192.168.53.55", 18088), new ServerIoHandler());
		System.out.println("------------mina server end -------------------------");
	}
}
