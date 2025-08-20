package Day8_Multithreading;

class Mul3 implements Runnable{
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Hello Everyone...");
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Mul4 implements Runnable{
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Starting New Concept Today.");
//			try {
//				Thread.sleep(10);
//			}
//			catch(InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

public class Multithreading_Runnable {
	public static void main(String[] args) {
		Runnable m3 = new Mul3();
		Thread t1 = new Thread(m3);
		
		Runnable m4 = new Mul4();
		Thread t2 = new Thread(m4);
		
//		t1.setPriority(1);
//		t2.setPriority(10);
		

		t1.start();
		t2.start();
		
	}
}

