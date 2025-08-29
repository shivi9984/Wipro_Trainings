package Day_31_Loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger_Demo {
	
	public static void main(String[] args) {
		Logger log = LogManager.getLogger(Logger_Demo.class);
		
		System.out.println("This is Logger Demo.");
		log.info("for info only");
		log.debug("for debug only");
		log.error("for error message");
		log.warn("for warning");
	}
	
}
