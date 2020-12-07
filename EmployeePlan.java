package Employee;

public class EmployeePlan {
	
	private int premium, deductible,outOfPocket;
	private String planType,position;
	private Boolean hasSickLeave, hasDentalInsurance, hasLifeInsurance, hasChildCare, hasPaidVacation, hasPersonalLeave;
	
	public EmployeePlan() {

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
