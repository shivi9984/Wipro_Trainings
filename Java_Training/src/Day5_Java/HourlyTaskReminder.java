package Day5_Java;

import java.util.Timer;
import java.util.TimerTask;

public class HourlyTaskReminder {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // Reminder 1: Every 30 minutes
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("[Reminder] Drink some water!");
            }
        }, 0, 30 * 60 * 1000); // 30 minutes

        // Reminder 2: Every 1 hour
        
        timer.scheduleAtFixedRate(new TimerTask() {
        	
            @Override
            public void run() {
                System.out.println("[Reminder] Time to stretch your body!");
            }
        }, 0, 60 * 60 * 1000); // 1 hour

        // Reminder 3: Every 2 hours
        
        timer.scheduleAtFixedRate(new TimerTask() {
        	
            @Override
            public void run() {
                System.out.println("[Reminder] Take an eye break!");
            }
        }, 0, 2 * 60 * 60 * 1000); // 2 hours

        System.out.println("Hourly reminders started!!!");
    }
}
