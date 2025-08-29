package com.letskodeit.testclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {
	
	private static final Logger log = LogManager.getLogger(LoggerDemo.class.getName());
	
	public static void main(String agrs[]) {
		log.trace("Trace Message Printed");
		log.debug("Debug Message Printed");
		log.info("Info Message Printed");
		log.error("Error Message Printed");
		log.fatal("Fatal Message Printed");
	}
}
