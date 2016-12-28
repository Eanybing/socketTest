package jh.test.socketTest.chart;

import java.net.InetAddress;

import org.junit.Test;

public class ChartTest {

	@Test
	public void test() {
		InetAddress toIp;
		try {
			toIp = InetAddress.getByName("127.0.0.1");
			ChartSend chartSend = new ChartSend(toIp);
			chartSend.run();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
