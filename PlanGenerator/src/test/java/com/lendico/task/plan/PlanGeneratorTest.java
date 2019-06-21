package com.lendico.task.plan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.lendico.task.calculators.AnnuityCalculator;
import com.lendico.task.calculators.InterestCalculator;
import com.lendico.task.model.MonthlyPlan;
import com.lendico.task.model.PlanGeneratorRequest;

import static org.hamcrest.CoreMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class PlanGeneratorTest {
	
	@Mock
	private AnnuityCalculator annuityCalc;
	
	@Mock
	private InterestCalculator interestCalc;
	
	@InjectMocks
	private PlanGenerator planGenerator;

	@Test
	public void getPlanTest() {
		List<MonthlyPlan> expectedList = getTestDataList();
		
		when(annuityCalc.getAnnuityAmount(anyInt(), anyDouble(), anyDouble())).thenReturn(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP));
		when(interestCalc.getMonthlyInterest(anyDouble(), anyDouble())).thenReturn(new BigDecimal(20.83).setScale(2, RoundingMode.HALF_UP), new BigDecimal(19.14).setScale(2, RoundingMode.HALF_UP), new BigDecimal(17.43).setScale(2, RoundingMode.HALF_UP),
																				   new BigDecimal(15.72).setScale(2, RoundingMode.HALF_UP), new BigDecimal(14.00).setScale(2, RoundingMode.HALF_UP), new BigDecimal(12.28).setScale(2, RoundingMode.HALF_UP),
																				   new BigDecimal(10.55).setScale(2, RoundingMode.HALF_UP), new BigDecimal(8.81).setScale(2, RoundingMode.HALF_UP), new BigDecimal(7.06).setScale(2, RoundingMode.HALF_UP),
																				   new BigDecimal(5.31).setScale(2, RoundingMode.HALF_UP), new BigDecimal(3.54).setScale(2, RoundingMode.HALF_UP), new BigDecimal(1.78).setScale(2, RoundingMode.HALF_UP));
		
		List<MonthlyPlan> actualList = planGenerator.getPlan(new PlanGeneratorRequest(5000.0, 5.0f, 12, LocalDateTime.parse("2018-01-01T00:00:01")));
		
		verify(interestCalc, times(12)).getMonthlyInterest(anyDouble(), anyDouble());
		assertEquals(expectedList.size(), actualList.size());
		assertThat(expectedList, is(actualList));
	}
	
	private List<MonthlyPlan> getTestDataList() {
		List<MonthlyPlan> testList = new ArrayList<>();
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-01-01T00:00:01"), new BigDecimal(5000.00).setScale(2, RoundingMode.HALF_UP), 
									 new BigDecimal(20.83).setScale(2, RoundingMode.HALF_UP), new BigDecimal(407.21).setScale(2, RoundingMode.HALF_UP), new BigDecimal(4592.79).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-02-01T00:00:01"), new BigDecimal(4592.79).setScale(2, RoundingMode.HALF_UP), 
				 	 				 new BigDecimal(19.14).setScale(2, RoundingMode.HALF_UP), new BigDecimal(408.90).setScale(2, RoundingMode.HALF_UP), new BigDecimal(4183.89).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-03-01T00:00:01"), new BigDecimal(4183.89).setScale(2, RoundingMode.HALF_UP), 
 				 					 new BigDecimal(17.43).setScale(2, RoundingMode.HALF_UP), new BigDecimal(410.61).setScale(2, RoundingMode.HALF_UP), new BigDecimal(3773.28).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-04-01T00:00:01"), new BigDecimal(3773.28).setScale(2, RoundingMode.HALF_UP), 
					 				 new BigDecimal(15.72).setScale(2, RoundingMode.HALF_UP), new BigDecimal(412.32).setScale(2, RoundingMode.HALF_UP), new BigDecimal(3360.96).setScale(2, RoundingMode.HALF_UP)));

		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-05-01T00:00:01"), new BigDecimal(3360.96).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(14.00).setScale(2, RoundingMode.HALF_UP), new BigDecimal(414.04).setScale(2, RoundingMode.HALF_UP), new BigDecimal(2946.92).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-06-01T00:00:01"), new BigDecimal(2946.92).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(12.28).setScale(2, RoundingMode.HALF_UP), new BigDecimal(415.76).setScale(2, RoundingMode.HALF_UP), new BigDecimal(2531.16).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-07-01T00:00:01"), new BigDecimal(2531.16).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(10.55).setScale(2, RoundingMode.HALF_UP), new BigDecimal(417.49).setScale(2, RoundingMode.HALF_UP), new BigDecimal(2113.67).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-08-01T00:00:01"), new BigDecimal(2113.67).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(8.81).setScale(2, RoundingMode.HALF_UP), new BigDecimal(419.23).setScale(2, RoundingMode.HALF_UP), new BigDecimal(1694.44).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-09-01T00:00:01"), new BigDecimal(1694.44).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(7.06).setScale(2, RoundingMode.HALF_UP), new BigDecimal(420.98).setScale(2, RoundingMode.HALF_UP), new BigDecimal(1273.46).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-10-01T00:00:01"), new BigDecimal(1273.46).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(5.31).setScale(2, RoundingMode.HALF_UP), new BigDecimal(422.73).setScale(2, RoundingMode.HALF_UP), new BigDecimal(850.73).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.04).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-11-01T00:00:01"), new BigDecimal(850.73).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(3.54).setScale(2, RoundingMode.HALF_UP), new BigDecimal(424.50).setScale(2, RoundingMode.HALF_UP), new BigDecimal(426.23).setScale(2, RoundingMode.HALF_UP)));
		
		testList.add(new MonthlyPlan(new BigDecimal(428.01).setScale(2, RoundingMode.HALF_UP), LocalDateTime.parse("2018-12-01T00:00:01"), new BigDecimal(426.23).setScale(2, RoundingMode.HALF_UP), 
				 					 new BigDecimal(1.78).setScale(2, RoundingMode.HALF_UP), new BigDecimal(426.23).setScale(2, RoundingMode.HALF_UP), new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP)));
		
		return testList;
	}
	
}
