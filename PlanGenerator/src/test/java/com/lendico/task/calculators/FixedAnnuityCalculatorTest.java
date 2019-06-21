package com.lendico.task.calculators;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.lendico.task.model.Constants;

public class FixedAnnuityCalculatorTest {
	
	@Test
	public void getAnnuityAmountTest() {
		FixedAnnuityCalculator calculator = new FixedAnnuityCalculator();
		BigDecimal expectedValue = new BigDecimal(219.36).setScale(Constants.SCALE.getValue(), RoundingMode.HALF_UP);
		BigDecimal actualValue = calculator.getAnnuityAmount(24, 5.0, 5000);
		
		assertEquals(expectedValue, actualValue);
	}
}
