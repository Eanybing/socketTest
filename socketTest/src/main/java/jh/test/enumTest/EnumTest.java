package jh.test.enumTest;

import org.junit.Test;

public class EnumTest {
	public enum TT{
		/**sdf */
		JPG,/**sdf */
		PNG,/**sdf */
		JPNG
	}
	
	public enum HH{
		ww12sdf,s14sdf,s15fdas
	}
	
	@Test
	public void test(){
		System.out.println(TT.JPG);
		boolean a = TT.JPG.equals("JPG");
		System.out.println(a);
	}
}
