package jh.test.socketTest.thread;

public class RunnableTest {

	
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.run();
		//new Thread(mt).start();
	}
}

class MyThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("my thread do ...");
	}
	
}
