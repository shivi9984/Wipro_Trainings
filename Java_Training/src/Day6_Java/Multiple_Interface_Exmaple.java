package Day6_Java;


interface Printable {
 void print();
}

interface Scannable {
 void scan();
}


class MultiFunctionMachine implements Printable, Scannable {
 public void print() {
     System.out.println("Printing document...");
 }

 public void scan() {
     System.out.println("Scanning document...");
 }
}

public class Multiple_Interface_Exmaple {
 public static void main(String[] args) {
     MultiFunctionMachine m = new MultiFunctionMachine();
     m.print();   
     m.scan();    
 }
}

