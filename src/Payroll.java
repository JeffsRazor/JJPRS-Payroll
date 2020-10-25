
public class Payroll {
	
	public void calculateBenefits(String insurance) {
		
	}
	
	public double calculateLocalTax(String location,int income,Boolean isMarried) {
		double localIncomeTax=0.0;
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
		return localIncomeTax;
	}
	public double calculateFederalTax(Boolean isMarried, int income){
		double federalIncomeTax=0.0;
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
			return federalIncomeTax;
	}
	
	public double calculateDeductions(int income,Boolean isMarried,String location) {
		double netPay=0.0;
		double totalTax=0.0;
		
		totalTax=calculateFederalTax(isMarried,income)+calculateLocalTax(location,income,isMarried);
		netPay=income-totalTax;
		return netPay;
	}
	
	public int calculateGrossIncome(int salary, String pos,int hourlyPay, int hrsWorkedPerWeek) {
		int a=0;
		if (pos.equals("Part-Time")) {
		    a = hourlyPay*hrsWorkedPerWeek*52;
		}
		else if (pos.equals("Full-Time"))
		{
			a = salary;
		}
		return a;
	}

	
}
