package Day8_Multithreading;

class Mul1 extends Thread{
	public void run() {
		for(int i=0; i<=50; i++) {
			System.out.println("Hello Everyone...");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Mul2 extends Thread{
	public void run() {
		for(int i=0; i<=50; i++) {
			System.out.println("Starting New Concept Today.");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Multithreading_Example {
	public static void main(String[] args) {
		Mul1 m1 = new Mul1();
		Mul2 m2 = new Mul2();
		
//		System.out.println(m2.getPriority());
		
//		m2.setPriority(Thread.MAX_PRIORITY);
		
		m1.start();
		try {
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		m2.start();
		
	}
}
