package com.lendico.task.validation;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
	
	private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());

	public void uncaughtException(Thread t, Throwable e) {
		LOGGER.log(Level.SEVERE, e.getMessage(), e);
	}

}
