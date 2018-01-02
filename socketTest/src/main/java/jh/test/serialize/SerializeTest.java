package jh.test.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 序列化学习
 * 
 * transient
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，
 *	   本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 *
 * @author JiangHan
 */
public class SerializeTest implements Serializable {
	public int age;
	public String name;
	public transient int SSN;//短暂的

//	public static void main(String[] args) {
//		SerializeTest s = new SerializeTest();
//		s.age = 12;
//		s.name = "我的";
//		FileOutputStream fileOut;
//		try {
//			fileOut = new FileOutputStream("d:/SerializeTest.ser");
//			ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			out.writeObject(s);
//			out.close();
//			fileOut.close();
//			System.out.printf("Serialized data is saved in d:/SerializeTest.ser");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * readObject() 方法中的 try/catch代码块尝试捕获 ClassNotFoundException 异常。
	 * 对于 JVM 可以反序列化对象，它必须是能够找到字节码的类。
	 * 如果JVM在反序列化对象的过程中找不到该类，则抛出一个 ClassNotFoundException 异常。
	 *
	 * @Author JiangHan
	 * @param args
	 */
	public static void main(String[] args) {
		SerializeTest s = null;
		try {
			FileInputStream fileIn = new FileInputStream("d:/SerializeTest.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s = (SerializeTest) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + s.name);
		System.out.println("age: " + s.age);
	}
}
