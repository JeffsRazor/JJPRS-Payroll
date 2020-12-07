package Employee;

public class EmployeePlan {
	
	private int premium, deductible,outOfPocket,retirementDeduction;
	private String planType,healthInsurance;
	private Boolean hasSickLeave, hasDentalInsurance, hasLifeInsurance, hasChildCare, hasPaidVacation, hasPersonalLeave,isRetired;
	
	
	
	public EmployeePlan(Employee emp) {
		setBenefits(emp);
		setHealthPlan(emp);
		setRetirementPayment(emp);
	}
	
	public void setBenefits(Employee emp) {
		if (emp.getPosition().equals("Part-Time")) {
			hasSickLeave = true;
			hasDentalInsurance = true;
			hasLifeInsurance = true;
			hasChildCare = false;
			hasPaidVacation = false;
			hasPersonalLeave = false;
		}
		else if(emp.getPosition().equals("Full-Time")) {
			hasSickLeave = true;
			hasDentalInsurance = true;
			hasLifeInsurance = true;
			hasChildCare = true;
			hasPaidVacation = true;
			hasPersonalLeave = true;
		}
	}
	
	public void setHealthPlan(Employee emp) {
		if (emp.getHealthInsurance().equals("Gold")) {
			this.premium = 400;
			this.deductible = 1000;
			this.outOfPocket = 6000;			
		}
		else if (emp.getHealthInsurance().equals("Silver")) {
			this.premium = 250;
			this.deductible = 3500;
			this.outOfPocket = 6500;		
		}
		else if(emp.getHealthInsurance().equals("Bronze")) {
			this.premium = 100;
			this.deductible = 5500;
			this.outOfPocket = 7500;
						
		}
	}
	
	public void setRetirementPayment(Employee emp) {
		if (emp.isRetirement()) {
			this.retirementDeduction = 200;
		}
		else{
			this.retirementDeduction = 0;
		}
	}

	public int getPremium() {
		return premium;
	}

	public int getDeductible() {
		return deductible;
	}

	public int getOutOfPocket() {
		return outOfPocket;
	}


	public String getPlanType() {
		return planType;
	}


	public Boolean getHasSickLeave() {
		return hasSickLeave;
	}

	public void setHasSickLeave(Boolean hasSickLeave) {
		this.hasSickLeave = hasSickLeave;
	}

	public Boolean getHasDentalInsurance() {
		return hasDentalInsurance;
	}

	public void setHasDentalInsurance(Boolean hasDentalInsurance) {
		this.hasDentalInsurance = hasDentalInsurance;
	}

	public Boolean getHasLifeInsurance() {
		return hasLifeInsurance;
	}

	public void setHasLifeInsurance(Boolean hasLifeInsurance) {
		this.hasLifeInsurance = hasLifeInsurance;
	}

	public Boolean getHasChildCare() {
		return hasChildCare;
	}

	public void setHasChildCare(Boolean hasChildCare) {
		this.hasChildCare = hasChildCare;
	}

	public Boolean getHasPaidVacation() {
		return hasPaidVacation;
	}

	public void setHasPaidVacation(Boolean hasPaidVacation) {
		this.hasPaidVacation = hasPaidVacation;
	}

	public Boolean getHasPersonalLeave() {
		return hasPersonalLeave;
	}

	public void setHasPersonalLeave(Boolean hasPersonalLeave) {
		this.hasPersonalLeave = hasPersonalLeave;
	}


	public String getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(String healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public int getRetirementDeduction() {
		return retirementDeduction;
	}

	public void setRetirementDeduction(int retirementDeduction) {
		this.retirementDeduction = retirementDeduction;
	}

	public Boolean getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(Boolean isRetired) {
		this.isRetired = isRetired;
	}

	
}
