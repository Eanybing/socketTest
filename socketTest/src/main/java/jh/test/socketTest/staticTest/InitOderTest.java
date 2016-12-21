package jh.test.socketTest.staticTest;

/**
 *  在实现继承的类被new的过程中，初始化执行顺序如下：
实现父类的公共静态属性和静态块级代码。
实现自身的静态属性和静态块级代码。
实现父类的非静态属性和非静态代码块。
执行父类的构造函数。
实现自身的非静态属性和非静态代码块。
执行自身的构造函数。
 *
 *  静态代码块和非静态代码块的异同点如下：
相同点：都是JVM加载类时且在构造函数执行之前执行，在类中都可以定义多个，一般在代码块中对一些static变量进行赋值。
不同点：静态代码块在非静态代码块之前执行（静态代码块 > 非静态代码块）。静态代码块只在第一次new时执行一次，之后不再执行。而非静态代码块每new一次就执行一次。
 *
 *
 * @author JiangHan
 */
public class InitOderTest {
	public static String STATIC_FIELD = "静态属性";

	// 静态块
	static {
		System.out.println(STATIC_FIELD);
		System.out.println("静态代码块");
	}

	public String field = "非静态属性";

	// 非静态块
	{
		System.out.println(field);
		System.out.println("非静态代码块");
	}

	public InitOderTest() {
		System.out.println("无参构造函数");
	}

	public static void main(String[] args) {
		InitOderTest test = new InitOderTest();
		// 静态属性
		// 静态代码块
		// 非静态属性
		// 非静态代码块
		// 无参构造函数
	}
}
