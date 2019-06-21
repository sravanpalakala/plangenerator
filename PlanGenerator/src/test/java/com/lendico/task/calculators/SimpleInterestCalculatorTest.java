package com.lendico.task.calculators;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.lendico.task.model.Constants;

public class SimpleInterestCalculatorTest {
	
	@Test
	public void getMonthlyInterestTest() {
		SimpleInterestCalculator calculator = new SimpleInterestCalculator();
		BigDecimal expectedValue = new BigDecimal(20.83).setScale(Constants.SCALE.getValue(), RoundingMode.HALF_UP);
		BigDecimal actualValue = calculator.getMonthlyInterest(5.0, 5000);
		
		assertEquals(expectedValue, actualValue);
	}
	
}
