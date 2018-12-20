package sc.lab2_3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sc.lab2_3.controller.Lab2_3Controller;

public class Lab2_3 {
	static final Logger LOGGER = LogManager.getLogger(Lab2_3.class);
	
	public static void main(String[] args) {
		LOGGER.info("Starting");
		LOGGER.debug("Creating controller");
		Lab2_3Controller controller = new Lab2_3Controller();
		LOGGER.debug("Controller created");
		controller.run();
		LOGGER.info("Exit");
	}
}