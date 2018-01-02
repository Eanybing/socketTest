package jh.test.byteTest;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ByteTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
		//fail("Not yet implemented");
		//1
		//00000000
		//00000000 00000000 00000000 00001000
		byte b = (byte)1000;
		int i = 1;
		String hh = "12";
	//	b = Byte.valueOf(hh);
		System.out.println(b);
		System.out.println();
	}
	
	@Test
	public void testChar(){
		char a = 'q';
		char b = '我';
		char c = '1';
		System.out.println("----");
		System.out.println(Character.charCount(a));
		System.out.println(Character.charCount(b));
		System.out.println(Character.charCount(c));
	}

}
