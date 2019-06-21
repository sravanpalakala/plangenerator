package com.lendico.task.plan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lendico.task.calculators.AnnuityCalculator;
import com.lendico.task.calculators.InterestCalculator;
import com.lendico.task.model.Constants;
import com.lendico.task.model.MonthlyPlan;
import com.lendico.task.model.PlanGeneratorRequest;

public class PlanGenerator {
	
	private AnnuityCalculator annuityCalc;
	
	private InterestCalculator interestCalc;

	public PlanGenerator(AnnuityCalculator annuityCalc, InterestCalculator interestCalc) {
		this.annuityCalc = annuityCalc;
		this.interestCalc = interestCalc;
	}
	
	public List<MonthlyPlan> getPlan(PlanGeneratorRequest planRequest) {
		List<MonthlyPlan> repaymentPlan = new ArrayList<MonthlyPlan>();
		BigDecimal annuityAmount = annuityCalc.getAnnuityAmount(planRequest.getDuration(), planRequest.getNominalRate(), planRequest.getLoanAmount());
		BigDecimal initialOutstandingPrincipal = new BigDecimal(planRequest.getLoanAmount()).setScale(Constants.SCALE.getValue(), RoundingMode.HALF_UP);
		BigDecimal monthlyInterest = null, principal = null, remOutstandingPrincipal = null;
		LocalDateTime date = planRequest.getStartDate();
		
		for(int i = 0; i < planRequest.getDuration(); i++) {
			monthlyInterest = interestCalc.getMonthlyInterest(planRequest.getNominalRate(), initialOutstandingPrincipal.doubleValue());
			if(initialOutstandingPrincipal.compareTo(annuityAmount) >= 0) {
				principal = annuityAmount.subtract(monthlyInterest);
			} else {
				principal = initialOutstandingPrincipal;
				annuityAmount = principal.add(monthlyInterest);
			}
			remOutstandingPrincipal = initialOutstandingPrincipal.subtract(principal);
			repaymentPlan.add(new MonthlyPlan(annuityAmount, date, initialOutstandingPrincipal, monthlyInterest, principal, remOutstandingPrincipal));
			initialOutstandingPrincipal = remOutstandingPrincipal;
			date = date.plusMonths(1);
		}
		
		return repaymentPlan;
	}
}
