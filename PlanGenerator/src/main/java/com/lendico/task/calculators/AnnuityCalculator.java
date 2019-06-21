package com.lendico.task.calculators;

import java.math.BigDecimal;

public interface AnnuityCalculator {
	
	BigDecimal getAnnuityAmount(int duration, double nominalRate, double loanAmount);
	
}
