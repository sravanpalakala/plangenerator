package com.lendico.task.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MonthlyPlan {
	
	private LocalDateTime date;
	
	private BigDecimal borrowerPaymentAmount;
	
	private BigDecimal principal;
	
	private BigDecimal interest;
	
	private BigDecimal initialOutstandingPrincipal;
	
	private BigDecimal remainingOutstandingPrincipal;

	public MonthlyPlan(BigDecimal borrowerPaymentAmount, LocalDateTime date, BigDecimal initialOutstandingPrincipal,
			BigDecimal interest, BigDecimal principal, BigDecimal remainingOutstandingPrincipal) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
		this.date = date;
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
		this.interest = interest;
		this.principal = principal;
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	public BigDecimal getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrowerPaymentAmount == null) ? 0 : borrowerPaymentAmount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((initialOutstandingPrincipal == null) ? 0 : initialOutstandingPrincipal.hashCode());
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((principal == null) ? 0 : principal.hashCode());
		result = prime * result
				+ ((remainingOutstandingPrincipal == null) ? 0 : remainingOutstandingPrincipal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		MonthlyPlan other = (MonthlyPlan) obj;
		if ((borrowerPaymentAmount == null && other.borrowerPaymentAmount != null) || !borrowerPaymentAmount.equals(other.borrowerPaymentAmount)) {
				return false;
		}
		if ((date == null && other.date != null) || !date.equals(other.date)) {
				return false;
		} 
		if ((initialOutstandingPrincipal == null && other.initialOutstandingPrincipal != null) || !initialOutstandingPrincipal.equals(other.initialOutstandingPrincipal)) {
				return false;
		} 
		if ((interest == null && other.interest != null) || !interest.equals(other.interest)) {
				return false;
		} 
		if ((principal == null && other.principal != null) || !principal.equals(other.principal)) {
				return false;
		}
		if ((remainingOutstandingPrincipal == null && other.remainingOutstandingPrincipal != null) || !remainingOutstandingPrincipal.equals(other.remainingOutstandingPrincipal)) {
				return false;
		}
		
		return true;
	}
	
}
