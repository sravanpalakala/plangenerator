package com.lendico.task.calculators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.lendico.task.model.Constants;

public class SimpleInterestCalculator implements InterestCalculator {

	public BigDecimal getMonthlyInterest(double nominalRate, double principal) {
		double numerator = (nominalRate * Constants.DAYSINMONTH.getValue() * principal);
		double denominator = (Constants.DAYSINYEAR.getValue() * 100);
		double result = numerator/denominator;
		
		BigDecimal simpleInterest = new BigDecimal(result).setScale(Constants.SCALE.getValue(), RoundingMode.HALF_UP);
		return simpleInterest;
	}

}
