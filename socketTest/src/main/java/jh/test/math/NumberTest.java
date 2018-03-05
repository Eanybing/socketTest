package jh.test.math;

import java.math.BigDecimal;

public class NumberTest {
	public static void main(String[] args) {
		String s = "收银台2017-06-08112222121212121212121212121";
		System.out.println("s-------------" + s.length());
		double d = Double.valueOf(s);
		System.out.println("d-------------" + d);
		System.out.println("d2---------" + Double.parseDouble(s));
		System.out.println("d3---------" + BigDecimal.valueOf(d/100));
		System.out.println("f---------" + Float.valueOf(s));
		
		
		
		
		//int i = Integer.valueOf(s);
		//System.out.println("i-------------" + i);
	}
}
