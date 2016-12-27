package jh.test.socketTest.thread;

public class ThreadTest extends Thread{

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("thread is ... ");
	}
	
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.start();
		System.out.println("main is end ...");
	}
}
