package com.lendico.task.calculators;

import java.math.BigDecimal;

public interface InterestCalculator {
	
	BigDecimal getMonthlyInterest(double nominalRate, double principal);
	
}
