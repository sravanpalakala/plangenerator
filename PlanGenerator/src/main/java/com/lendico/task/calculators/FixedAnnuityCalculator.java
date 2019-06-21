package com.lendico.task.calculators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.lendico.task.model.Constants;

public class FixedAnnuityCalculator implements AnnuityCalculator {
	
	public BigDecimal getAnnuityAmount(int duration, double nominalRate, double loanAmount) {
		double rateForAnnuity = (nominalRate/(Constants.MONTHS.getValue() * 100));
		double numerator = rateForAnnuity * loanAmount;
		double denominator = (1 - Math.pow((1 + rateForAnnuity), duration * (-1)));
		double result = numerator/denominator;
		
		BigDecimal annuityAmount = new BigDecimal(result).setScale(Constants.SCALE.getValue(), RoundingMode.HALF_UP);
 		return annuityAmount;
	}

}
