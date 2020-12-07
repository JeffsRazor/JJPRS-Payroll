package Employee;
import java.sql.Connection;

import DatabaseCode.UserAccountDAO;
public class EmployeePlan {
	
	private int premium, deductible,outOfPocket,retirementDeduction;
	private String planType,healthInsurance;
	private Boolean hasSickLeave, hasDentalInsurance, hasLifeInsurance, hasChildCare, hasPaidVacation, hasPersonalLeave,isRetired;
	
	private UserAccountDAO dao;
	
	public EmployeePlan(Connection db,int id) {
		this.dao = new UserAccountDAO(db);
		this.setHealthInsurance(dao.getHealthInsurance(id));
		this.setPlanType(dao.getPosition(id));
		this.setIsRetired(dao.getRetirement(id));
	}
	
	public void setBenefits(EmployeePlan emp) {
		if (emp.getPlanType().contentEquals("Part-Time")) {
			emp.setHasSickLeave(true);
			emp.setHasDentalInsurance(true);
			emp.setHasLifeInsurance(true);
			emp.setHasChildCare(false);
			emp.setHasPaidVacation(false);
			emp.setHasPersonalLeave(false);
		}
		else if(emp.getPlanType().contentEquals("Full-Time")) {
			emp.setHasSickLeave(true);
			emp.setHasDentalInsurance(true);
			emp.setHasLifeInsurance(true);
			emp.setHasChildCare(true);
			emp.setHasPaidVacation(true);
			emp.setHasPersonalLeave(true);
		}
	}
	
	public void setHealthPlan(EmployeePlan emp) {
		if (emp.getHealthInsurance().contentEquals("Gold")) {
			emp.setPremium(400);
			emp.setDeductible(1000);
			emp.setOutOfPocket(6000);			
		}
		else if (emp.getHealthInsurance().contentEquals("Silver")) {
			emp.setPremium(250);
			emp.setDeductible(3500);
			emp.setOutOfPocket(6500);		
		}
		else if(emp.getHealthInsurance().contentEquals("Bronze")) {
			emp.setPremium(100);
			emp.setDeductible(5500);
			emp.setOutOfPocket(7500);
						
		}
	}
	
	public void setRetirementPayment(EmployeePlan emp) {
		if (emp.getIsRetired()==true) {
			emp.setRetirementDeduction(200);
		}
		else{
			emp.setRetirementDeduction(0);
		}
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getDeductible() {
		return deductible;
	}

	public void setDeductible(int deductible) {
		this.deductible = deductible;
	}

	public int getOutOfPocket() {
		return outOfPocket;
	}

	public void setOutOfPocket(int outOfPocket) {
		this.outOfPocket = outOfPocket;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
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
