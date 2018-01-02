package jh.test.inner;

public class innerTest {
	public static void main(String[] args) {

		System.out.println("456");

		B b = new B() {
			public void ss() {
				// TODO Auto-generated method stub
				System.out.println("bbccccss");
			}

			{
				System.out.println("bbbbbb");
			}
		};
		b.ss();
	}
	
	public innerTest() {
		// TODO Auto-generated constructor stub
		System.out.println("innser");
	}

	{
		System.out.println("123");
	}

}

interface B {
	public void ss();
}
