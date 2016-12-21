package jh.test.socketTest.mina1.base;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

/**
 * mina hander
 * 
 * @ClassName: MinaHander
 * @author jh
 * @date 2016-9-2 下午3:47:03
 * 
 */
public class JhMinaHander extends IoHandlerAdapter {
	public JhMinaHander() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------------create jh hander-----------------------");
		System.out.println(session.toString());
		System.out.println("client ip: " + session.getRemoteAddress().toString());
		super.sessionCreated(session);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("--------------------open jh hander-----------------------");
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
	}

	/**
	 * session 负责写入消息,和保存客户端与服务器的连接状态
	 * message 负责接收消息,这通过ProtocolCodecFilter从byte转换到Objet
	 * 
	 * */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//读取数据
		String msg = message.toString();
		//String msg2 =	(String)message;
		System.out.println("---------------------------------msg--------------------------------------");
		System.out.println(msg);
		
		//写入数据到客户端
		session.write("12345");
		super.messageReceived(session, message);

	}

	/* (non-Javadoc)
	 * @see org.apache.mina.common.IoHandlerAdapter#messageSent(org.apache.mina.common.IoSession, java.lang.Object)
	 * 
	 * 我得个天,这个方法会一直给客户端发数据,我服
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		//session.write("hhh");
		super.messageSent(session, message);
	}
}
