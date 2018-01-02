package jh.test.socket;

import java.net.InetAddress;

/**
 *InetAddress 是互联网中的一个ip地址
 *
 * @author JiangHan
 */
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getLocalHost();
		String hostname = inetAddress.getHostName();
		inetAddress.getHostAddress();
		
		System.out.println(hostname);
	}
}
