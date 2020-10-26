package Payroll;
import java.sql.Connection;

import javax.swing.text.Position;

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
		this.isMarried = dao.getStatus(id);
	

		this.hrsWorkedPerWeek = dao.getHours(id);

		this.income= calculateGrossIncome(salary, pos, hrsWorkedPerWeek);

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
	
	public double calculateLocalTax(String location,int income,Boolean isMarried, String pos) {
		//TODO: Do taxes for part-time
		if(pos.equals("Full-Time")){
		if (location.equals("New York")) {
			if(!isMarried) {
				if(income<8500) {
					//4%
					 localIncomeTax=.04 * income;
					
				}
				else if (income>8500 && income<11700) {
					//4.5%
					 localIncomeTax=.045 * income;
				}
				else if (income>11700 && income<13900) {
					//5.25%
					 localIncomeTax=.0525 * income;
				}
				else if(income>13900 && income<21400) {
					//5.9%
					 localIncomeTax=.059 * income;
				}
				else if(income>21400 && income<80650) {
					//6.21%
					 localIncomeTax=.0621 * income;
				}
				else if(income>80650 && income<215400) {
					//6.49
					 localIncomeTax=.0649 * income;
				}
				else if (income>215400 && income<1077550) {
					//6.85
					 localIncomeTax=.0685*income;
				}
				else if(income<1077550) {
					//8.82
					localIncomeTax=.0882*income;
				}
				else {
					//Invalid number
					System.out.println("Invalid Number");
				}
			}
			else {
				if(income<17500) {
					//4%
					 localIncomeTax=.04 * income;
				}
				else if (income>17500 && income<23600) {
					//4.5%
					 localIncomeTax=.045 * income;
				}
				else if (income>23600 && income<27900) {
					//5.25%
					 localIncomeTax=.0525 * income;
				}
				else if(income>27900 && income<43000) {
					//5.9%
					 localIncomeTax=.059 * income;
				}
				else if(income>43000 && income<161550) {
					//6.09%
					 localIncomeTax=.0609 * income;
				}
				else if(income>161550 && income<323200) {
					//6.41
					 localIncomeTax=.0641 * income;
				}
				else if (income>323200 && income<2155350) {
					//6.85
					 localIncomeTax=.0685*income;
				}
				else if(income<2155350) {
					//8.82
					localIncomeTax=.0882*income;
				}
				else {
					//Invalid number
					System.out.println("Invalid Number");
				}
			
			}
		}
	}
		return localIncomeTax;
	}
	public double calculateFederalTax(Boolean isMarried, int income, String pos){
			if(pos.equals("Full-Time")) {

			
		
			if(!isMarried) {
				if(income<9700) {
					//10%
					federalIncomeTax=.1 * income;
					
				}
				else if (income>9700 && income<39475) {
					//12
					federalIncomeTax=.12 * income;
				}
				else if (income>39475 && income<84200) {
					//22%
					federalIncomeTax=.22 * income;
				}
				else if(income>84200 && income<160725) {
					//24%
					federalIncomeTax=.24 * income;
				}
				else if(income>160275 && income<204100) {
					//32%
					federalIncomeTax=.32 * income;
				}
				else if(income>204100 && income<510300) {
					//35
					federalIncomeTax=.35 * income;
				}
				else if(income>510300) {
					//37
					federalIncomeTax=.37*income;
				}

				else {
					//Invalid number
					System.out.println("Invalid Number");
				}
			}
			else {
				if(income<19400) {
					//10%
					federalIncomeTax=.1 * income;
				}
				else if (income>19400 && income<78950) {
					//12
					federalIncomeTax=.12 * income;
				}
				else if (income>78950 && income<168400) {
					//22%
					federalIncomeTax=.22 * income;
				}
				else if(income>168400 && income<321450) {
					//24%
					federalIncomeTax=.24 * income;
				}
				else if(income>321450 && income<408200) {
					//32%
					federalIncomeTax=.32 * income;
				}
				else if(income>408200 && income<612350) {
					//35
					federalIncomeTax=.35 * income;
				}
				else if (income>612350) {
					//37
					federalIncomeTax=.37*income;
				}
				else {
					//Invalid number
					System.out.println("Invalid Number");
				}
			}
		}
			/* TODO: Calculate part time tax
			else if(pos.equals("Part-time")){
				if(!isMarried) {
					if(income < 160){
						federalIncomeTax = (0 * income) + 4;

					}
					else if(income >=160 && income <210) {
						federalIncomeTax = (0 * income) + 9;
					}
					else if(income >=210 && income <260) {
						federalIncomeTax = (0 *income) + 14; 
					}
					else if(income >=260 && income <310) {
						federalIncomeTax = (0 * income) + 20;
					}
					else if(income >= 310 && income <)
				}		
			}
			*/
		return federalIncomeTax;
	}
	
	public double calculateDeductions(double totalTax, int income) {
		
		netPay=income-totalTax;
		return netPay;
	}
	//TODO: How are we doing this one? Hourly pay?
	public int calculateGrossIncome(int salary, String pos, int hrsWorkedPerWeek) {
		int a = 0;
		if (pos.equals("Part-Time")) {
		    a = salary*hrsWorkedPerWeek;
		}
		else if (pos.equals("Full-Time"))
		{
			a = salary;
		}
		return a;
	}
	public double calculateTotalTax(double localIncomeTax, double federalIncomeTax) {
			return localIncomeTax + federalIncomeTax;
	}
	
}
