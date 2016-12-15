package jh.test.socketTest.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Ignore;
import org.junit.Test;

public class BigDecimalTest {
	@Test
	@Ignore
	public void t1() {
		String str = "86.64466666";
		BigDecimal bd = new BigDecimal(Double.parseDouble(str));
		System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println("=================");
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(Double.parseDouble(str)));
		System.out.println("=================");
		System.out.println(String.format("%.2f", Double.parseDouble(str)));
		System.out.println("=================");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(Double.parseDouble(str)));
	}

	@Test(timeout=110)
//	@Ignore
	public void t2() {
		System.out.println(0.06 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(303.1 / 1000);
	}
	
	//@Test
	public void t3(){
		System.out.println(0.01/1);
	}
}
