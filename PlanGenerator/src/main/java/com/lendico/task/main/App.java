package com.lendico.task.main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lendico.task.calculators.AnnuityCalculator;
import com.lendico.task.calculators.FixedAnnuityCalculator;
import com.lendico.task.calculators.InterestCalculator;
import com.lendico.task.calculators.SimpleInterestCalculator;
import com.lendico.task.model.MonthlyPlan;
import com.lendico.task.model.PlanGeneratorRequest;
import com.lendico.task.plan.PlanGenerator;
import com.lendico.task.util.CSVPrinter;
import com.lendico.task.validation.GlobalExceptionHandler;

public class App 
{
    public static void main(String[] args ) {
    	
    	GlobalExceptionHandler handler = new GlobalExceptionHandler();
    	Thread.setDefaultUncaughtExceptionHandler(handler);
    	
    	int duration = Integer.parseInt(args[0]);
    	double loanAmount = Double.parseDouble(args[1]);
    	float nominalRate = Float.parseFloat(args[2]);
    	
        Instant dateInstant = Instant.from(DateTimeFormatter.ISO_INSTANT.parse(args[3]));
        LocalDateTime date = LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneOffset.UTC.getId()));
    	
        AnnuityCalculator annuityCalc = new FixedAnnuityCalculator();
        InterestCalculator interestCalc = new SimpleInterestCalculator();
        PlanGenerator planGen = new PlanGenerator(annuityCalc, interestCalc);
        List<MonthlyPlan> monthlyPlans = planGen.getPlan(new PlanGeneratorRequest(loanAmount, nominalRate, duration, date));
        
        CSVPrinter csvPrinter = new CSVPrinter(",");
        csvPrinter.printInCSVFile("output.csv", MonthlyPlan.class, monthlyPlans);
       
    }
}
