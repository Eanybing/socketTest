package jh.test.socketTest.mina1;

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

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub

		String msg = message.toString();
		System.out.println("--------------------------msg--------------------------------------");
		System.out.println(msg);

		super.messageReceived(session, message);

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}
}
