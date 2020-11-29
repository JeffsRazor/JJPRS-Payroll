package Payroll;

import java.sql.Connection;

import DatabaseCode.UserAccountDAO;

public class Payroll {
	private String location, insurance, pos;
	private Boolean isMarried;
	private double localIncomeTax, federalIncomeTax, totalTax, netPay;
	private int salary, income, hrsWorkedPerWeek;
	private UserAccountDAO dao;

	public Payroll(Connection db, int id) {
		this.dao = new UserAccountDAO(db);
		this.salary = dao.getSalary(id);
		this.location = dao.getLocation(id);
		this.insurance = dao.getHealthInsurance(id);
		this.pos = dao.getPosition(id);
		this.isMarried = dao.getMaritalStatus(id);
		//this.hrsWorkedPerWeek = dao.getHours(id);
		this.income = calculateGrossIncome(salary, pos);
		this.localIncomeTax = calculateLocalTax(location, income, isMarried, pos);
		this.federalIncomeTax = calculateFederalTax(isMarried, income, pos);
		this.totalTax = calculateTotalTax(localIncomeTax, federalIncomeTax);
		this.netPay = calculateDeductions(totalTax, income);
	}

	public String getLocation() {
		return this.location;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public String getPos() {
		return this.pos;
	}

	public Boolean getIsMarried() {
		return this.isMarried;
	}

	public Boolean isIsMarried() {
		return this.isMarried;
	}

	public double getLocalIncomeTax() {
		return this.localIncomeTax;
	}

	public double getFederalIncomeTax() {
		return this.federalIncomeTax;
	}

	public double getTotalTax() {
		return this.totalTax;
	}

	public double getNetPay() {
		return this.netPay;
	}

	public int getSalary() {
		return this.salary;
	}

	public int getIncome() {
		return this.income;
	}

	public int getHrsWorkedPerWeek() {
		return this.hrsWorkedPerWeek;
	}

	public UserAccountDAO getDao() {
		return this.dao;
	}

	public void calculateBenefits(String insurance) {

	}

	
	//Calculate Local Tax by Location, martial status, and Full/Part time
	public double calculateLocalTax(String location, int income, Boolean isMarried, String pos) {

		if (location.equals("New York")) {
			if (pos.equals("Full-Time")) {
				if (!isMarried) { // Single
					if (income >= 0 && income <= 8500) {
						// 4%
						localIncomeTax = .04 * income;
					} else if (income > 8500 && income <= 11700) {
						// 4.5%
						localIncomeTax = .045 * income;
					} else if (income > 11700 && income <= 13900) {
						// 5.25%
						localIncomeTax = .0525 * income;
					} else if (income > 13900 && income <= 21400) {
						// 5.9%
						localIncomeTax = .059 * income;
					} else if (income > 21400 && income <= 80650) {
						// 6.33%
						localIncomeTax = .0633 * income;
					} else if (income > 80650 && income <= 215400) {
						// 6.57
						localIncomeTax = .0657 * income;
					} else if (income > 215400 && income <= 1077550) {
						// 6.85
						localIncomeTax = .0685 * income;
					} else if (income > 1077550) {
						// 8.82
						localIncomeTax = .0882 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & full time NY tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 17150) {
						// 4%
						localIncomeTax = .04 * income;
					} else if (income > 17150 && income <= 23600) {
						// 4.5%
						localIncomeTax = .045 * income;
					} else if (income > 23600 && income <= 27900) {
						// 5.25%
						localIncomeTax = .0525 * income;
					} else if (income > 27900 && income <= 43000) {
						// 5.9%
						localIncomeTax = .059 * income;
					} else if (income > 43000 && income <= 161550) {
						// 6.33%
						localIncomeTax = .0633 * income;
					} else if (income > 161550 && income <= 323200) {
						// 6.57
						localIncomeTax = .0657 * income;
					} else if (income > 323200 && income <= 2155350) {
						// 6.85
						localIncomeTax = .0685 * income;
					} else if (income > 2155350) {
						// 8.82
						localIncomeTax = .0882 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & full time NY tax calculation.");
					}
				}
			} else if (pos.equals("Part-Time")) { // Part Time
				if (!isMarried) { // Single
					if (income >= 0 && income <= 8500) {
						// 4%
						localIncomeTax = .04 * income;
					} else if (income > 8500 && income <= 11700) {
						// 4.5%
						localIncomeTax = .045 * income;
					} else if (income > 11700 && income <= 13900) {
						// 5.25%
						localIncomeTax = .0525 * income;
					} else if (income > 13900 && income <= 21400) {
						// 5.9%
						localIncomeTax = .059 * income;
					} else if (income > 21400 && income <= 80650) {
						// 6.33%
						localIncomeTax = .0633 * income;
					} else if (income > 80650 && income <= 215400) {
						// 6.57
						localIncomeTax = .0657 * income;
					} else if (income > 215400 && income <= 1077550) {
						// 6.85
						localIncomeTax = .0685 * income;
					} else if (income > 1077550) {
						// 8.82
						localIncomeTax = .0882 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & part time NY tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 17150) {
						// 4%
						localIncomeTax = .04 * income;
					} else if (income > 17150 && income <= 23600) {
						// 4.5%
						localIncomeTax = .045 * income;
					} else if (income > 23600 && income <= 27900) {
						// 5.25%
						localIncomeTax = .0525 * income;
					} else if (income > 27900 && income <= 43000) {
						// 5.9%
						localIncomeTax = .059 * income;
					} else if (income > 43000 && income <= 161550) {
						// 6.33%
						localIncomeTax = .0633 * income;
					} else if (income > 161550 && income <= 323200) {
						// 6.57
						localIncomeTax = .0657 * income;
					} else if (income > 323200 && income <= 2155350) {
						// 6.85
						localIncomeTax = .0685 * income;
					} else if (income > 2155350) {
						// 8.82
						localIncomeTax = .0882 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & part time NY tax calculation.");
					}
				}
			}
		}

		else if (location.equals("Connecticut")) {
			if (pos.equals("Full-Time")) {
				if (!isMarried) { // Single
					if (income >= 0 && income <= 10000) {
						// 3%
						localIncomeTax = .03 * income;
					} else if (income > 10000 && income <= 50000) {
						// 5%
						localIncomeTax = .05 * income;
					} else if (income > 50000 && income <= 100000) {
						// 5.5%
						localIncomeTax = .055 * income;
					} else if (income > 100000 && income <= 200000) {
						// 6%
						localIncomeTax = .06 * income;
					} else if (income > 200000 && income <= 250000) {
						// 6.5%
						localIncomeTax = .065 * income;
					} else if (income > 250000 && income <= 500000) {
						// 6.9
						localIncomeTax = .069 * income;
					} else if (income > 500000) {
						// 6.99
						localIncomeTax = .0699 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & full time CT tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 20000) {
						// 3%
						localIncomeTax = .03 * income;
					} else if (income > 20000 && income <= 100000) {
						// 5%
						localIncomeTax = .05 * income;
					} else if (income > 100000 && income <= 200000) {
						// 5.5%
						localIncomeTax = .055 * income;
					} else if (income > 200000 && income <= 400000) {
						// 6%
						localIncomeTax = .06 * income;
					} else if (income > 400000 && income <= 500000) {
						// 6.5%
						localIncomeTax = .065 * income;
					} else if (income > 500000 && income <= 1000000) {
						// 6.9
						localIncomeTax = .069 * income;
					} else if (income > 1000000) {
						// 6.99
						localIncomeTax = .0699 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & full time CT tax calculation.");
					}
				}
			} else if (pos.equals("Part-Time")) { // Part Time
				if (!isMarried) { // Single
					if (income >= 0 && income <= 10000) {
						// 3%
						localIncomeTax = .03 * income;
					} else if (income > 10000 && income <= 50000) {
						// 5%
						localIncomeTax = .05 * income;
					} else if (income > 50000 && income <= 100000) {
						// 5.5%
						localIncomeTax = .055 * income;
					} else if (income > 100000 && income <= 200000) {
						// 6%
						localIncomeTax = .06 * income;
					} else if (income > 200000 && income <= 250000) {
						// 6.5%
						localIncomeTax = .065 * income;
					} else if (income > 250000 && income <= 500000) {
						// 6.9
						localIncomeTax = .069 * income;
					} else if (income > 500000) {
						// 6.99
						localIncomeTax = .0699 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & part time CT tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 20000) {
						// 3%
						localIncomeTax = .03 * income;
					} else if (income > 20000 && income <= 100000) {
						// 5%
						localIncomeTax = .05 * income;
					} else if (income > 100000 && income <= 200000) {
						// 5.5%
						localIncomeTax = .055 * income;
					} else if (income > 200000 && income <= 400000) {
						// 6%
						localIncomeTax = .06 * income;
					} else if (income > 400000 && income <= 500000) {
						// 6.5%
						localIncomeTax = .065 * income;
					} else if (income > 500000 && income <= 1000000) {
						// 6.9
						localIncomeTax = .069 * income;
					} else if (income > 1000000) {
						// 6.99
						localIncomeTax = .0699 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & part time CT tax calculation.");
					}
				}
			}
		}

		else if (location.equals("New Jersey")) {
			if (pos.equals("Full-Time")) {
				if (!isMarried) { // Single
					if (income >= 0 && income <= 20000) {
						// 1.4%
						localIncomeTax = .014 * income;
					} else if (income > 20000 && income <= 35000) {
						// 1.75%
						localIncomeTax = .0175 * income;
					} else if (income > 35000 && income <= 40000) {
						// 3.5%
						localIncomeTax = .035 * income;
					} else if (income > 40000 && income <= 75000) {
						// 5.525%
						localIncomeTax = .05525 * income;
					} else if (income > 75000 && income <= 500000) {
						// 6.37%
						localIncomeTax = .0637 * income;
					} else if (income > 500000 && income <= 5000000) {
						// 8.97
						localIncomeTax = .0897 * income;
					} else if (income > 5000000) {
						// 10.75
						localIncomeTax = .01075 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & full time NJ tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 20000) {
						// 1.4%
						localIncomeTax = .014 * income;
					} else if (income > 20000 && income <= 50000) {
						// 1.75%
						localIncomeTax = .0175 * income;
					} else if (income > 50000 && income <= 70000) {
						// 2.45%
						localIncomeTax = .0245 * income;
					} else if (income > 70000 && income <= 80000) {
						// 3.5%
						localIncomeTax = .035 * income;
					} else if (income > 80000 && income <= 150000) {
						// 5.525%
						localIncomeTax = .05525 * income;
					} else if (income > 150000 && income <= 500000) {
						// 6.37
						localIncomeTax = .0637 * income;
					} else if (income > 500000 && income <= 5000000) {
						// 8.97
						localIncomeTax = .0897 * income;
					} else if (income > 5000000) {
						// 10.75
						localIncomeTax = .01075 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & full time NJ tax calculation.");
					}
				}
			} else if (pos.equals("Part-Time")) { // Part Time
				if (!isMarried) { // Single
					if (income >= 0 && income <= 20000) {
						// 1.4%
						localIncomeTax = .014 * income;
					} else if (income > 20000 && income <= 35000) {
						// 1.75%
						localIncomeTax = .0175 * income;
					} else if (income > 35000 && income <= 40000) {
						// 3.5%
						localIncomeTax = .035 * income;
					} else if (income > 40000 && income <= 75000) {
						// 5.525%
						localIncomeTax = .05525 * income;
					} else if (income > 75000 && income <= 500000) {
						// 6.37%
						localIncomeTax = .0637 * income;
					} else if (income > 500000 && income <= 5000000) {
						// 8.97
						localIncomeTax = .0897 * income;
					} else if (income > 5000000) {
						// 10.75
						localIncomeTax = .01075 * income;
					} else {
						// Invalid number
						System.out.println("Invalid single & part time NJ tax calculation.");
					}
				} else { // Married
					if (income >= 0 && income <= 20000) {
						// 1.4%
						localIncomeTax = .014 * income;
					} else if (income > 20000 && income <= 50000) {
						// 1.75%
						localIncomeTax = .0175 * income;
					} else if (income > 50000 && income <= 70000) {
						// 2.45%
						localIncomeTax = .0245 * income;
					} else if (income > 70000 && income <= 80000) {
						// 3.5%
						localIncomeTax = .035 * income;
					} else if (income > 80000 && income <= 150000) {
						// 5.525%
						localIncomeTax = .05525 * income;
					} else if (income > 150000 && income <= 500000) {
						// 6.37
						localIncomeTax = .0637 * income;
					} else if (income > 500000 && income <= 5000000) {
						// 8.97
						localIncomeTax = .0897 * income;
					} else if (income > 5000000) {
						// 10.75
						localIncomeTax = .01075 * income;
					} else {
						// Invalid number
						System.out.println("Invalid married & part time NJ tax calculation.");
					}
				}
			}
		}
		return localIncomeTax;
	}
	
	//Federal tax is for everyone in the country. Both Full Time and Part Time are the same but changes if they are married or not married.
	public double calculateFederalTax(Boolean isMarried, int income, String pos){
			if(pos.equals("Full-Time") || pos.equals("Part-Time")) {
			if(!isMarried) {//Single
				if(income>=0 && income<=9875) { 
					//10%
					federalIncomeTax=.1 * income;
				}
				else if (income>9875 && income<=40125) { 
					//12%
					federalIncomeTax=.12 * income;
				}
				else if (income>40125 && income<=85525) {
					//22%
					federalIncomeTax=.22 * income;
				}
				else if(income>85525 && income<=163300) {
					//24%
					federalIncomeTax=.24 * income;
				}
				else if(income>163300 && income<=207350) {
					//32%
					federalIncomeTax=.32 * income;
				}
				else if(income>207350 && income<=518400) {
					//35
					federalIncomeTax=.35 * income;
				}
				else if(income>518400) {
					//37
					federalIncomeTax=.37*income;
				}

				else {
					System.out.println("Invald single fedaral tax calculation.");
				}
			}
			else { //Married
				if(income>=0 && income<=19750) { 
					//10%
					federalIncomeTax=.1 * income;
				}
				else if (income>19750 && income<=80250) { 
					//12%
					federalIncomeTax=.12 * income;
				}
				else if (income>80250 && income<=171050) {
					//22%
					federalIncomeTax=.22 * income;
				}
				else if(income>171050 && income<=326600) {
					//24%
					federalIncomeTax=.24 * income;
				}
				else if(income>326600 && income<=414700) {
					//32%
					federalIncomeTax=.32 * income;
				}
				else if(income>414700 && income<=622050) {
					//35
					federalIncomeTax=.35 * income;
				}
				else if(income>622050) {
					//37
					federalIncomeTax=.37*income;
				}

				else {
					System.out.println("Invald married fedaral tax calculation.");
				}
			}
		}
		return federalIncomeTax;
	}
		
	//Calculates Net Pay which is pay after tax deductions are applied. Also used for retirement plan calculations
	public double calculateDeductions(double totalTax, int income) {
		
		netPay=income-totalTax;
		return netPay;
	}
	
	//Gross Income is their salary and with no tax deductions
	public int calculateGrossIncome(int salary, String pos) {
		int a = 0;
		if (pos.equals("Part-Time")) {
		    a = salary*26;
		}
		else if (pos.equals("Full-Time"))
		{
			a = salary;
		}
		return a;
	}

	//Calculates the total tax to deduct from the salary
	public double calculateTotalTax(double localIncomeTax, double federalIncomeTax) {
			return localIncomeTax + federalIncomeTax;
	}
	
}
