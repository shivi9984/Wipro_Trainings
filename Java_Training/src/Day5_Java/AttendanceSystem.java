package Day5_Java;

import java.util.Scanner;

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] students = new String[n];
        String[] attendance = new String[n];

        // Taking student names
        
        System.out.println("\nEnter student names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            students[i] = sc.nextLine();
        }

        // Marking attendance
        
        System.out.println("\nMark attendance (P for Present, A for Absent):");
        for (int i = 0; i < n; i++) {
            System.out.print(students[i] + " (P/A): ");
            String status = sc.nextLine().trim().toUpperCase();
            attendance[i] = (status.equals("P")) ? "Present" : "Absent";
        }

        // Displaying attendance
        
        System.out.println("\nAttendance Report:");
        System.out.println("Name\t\tAttendance");
        System.out.println("---------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println(students[i] + "\t\t" + attendance[i]);
        }
        System.out.println("---------------------------");

        sc.close();
    }
}

