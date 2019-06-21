package com.lendico.task.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lendico.task.model.MonthlyPlan;

public class CSVPrinter {
	
	private String delimiter;
	
	private static final Logger LOGGER = Logger.getLogger(CSVPrinter.class.getName());
	
	public CSVPrinter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public void printInCSVFile(String fileName, Class<MonthlyPlan> schemaClassObject, List<MonthlyPlan> monthlyPlans) {
		
		try {
				BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true));
			LOGGER.log(Level.INFO, "Printing the contents in the csv file");
			
			List<String> propertyNames = getBeanSchema(schemaClassObject);
			for(String property : propertyNames) {
				br.write(property + "" + delimiter);
			}
			
			br.write("\r\n");
			
			for(MonthlyPlan monthlyPlan : monthlyPlans) {
				br.write(monthlyPlan.getDate().toLocalDate().toString() + "" + delimiter);
				br.write(monthlyPlan.getBorrowerPaymentAmount() + "" + delimiter);
				br.write(monthlyPlan.getPrincipal() + "" + delimiter);
				br.write(monthlyPlan.getInterest() + "" + delimiter);
				br.write(monthlyPlan.getInitialOutstandingPrincipal() + "" + delimiter);
				br.write(monthlyPlan.getRemainingOutstandingPrincipal() + "" + delimiter);
				br.write("\r\n");
			}
			
			LOGGER.log(Level.INFO, "Successfully printed the contents in the csv file");
			
		} catch(IOException ex) {
			
			LOGGER.log(Level.SEVERE, "IOExcepton occured while printing the csv file");
		}
		
	}
	
	private static List<String> getBeanSchema(Class<?> schemaClassObject) {
		List<String> fieldNames = new ArrayList<String>();
		Field[] declaredFields = schemaClassObject.getDeclaredFields();
		Arrays.stream(declaredFields).map(f -> f.getName()).forEach(fieldNames::add);
		return fieldNames;
	}
	
}
