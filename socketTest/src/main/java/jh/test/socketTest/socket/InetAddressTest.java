package jh.test.socketTest.socket;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getLocalHost();
		String hostname = inetAddress.getHostName();
		inetAddress.getHostAddress();
		
		System.out.println(hostname);
	}
}
