import java.util.Scanner;
import java.text.DecimalFormat;

public class Statistics {
	private static double countmale = 0;
	private static double countfemale = 0;
	private static double countinfected = 0;
	private static double countkids = 0; 
	private static double countadults = 0;
	private static double countelders = 0; 
	private static double[] infpermonth = new double [12];
	private static double[] monthinfrate = new double [12];
	private static int maxmonth;
	private static String maxseason;
	private static double[] seasoninfrate = new double [4];
	private static String[] regions = new String[9];
	private static double[] infperregion = new double[9];
	private static String maxregion;
	private static double[] regioninfrate = new double[9];

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public static void gendercount(boolean infected,String gender){ // calculates the percentage of male and female infected by covid 
		if(infected) {
			countinfected++;
			if (gender.equals("male")) {
				countmale++;
			}else {
				countfemale++;
			}
		}
	} 
	public static void genderPercentages(){ 
		double pmale = countmale / countinfected * 100;
		double pfemale = countfemale / countinfected * 100;
		System.out.println(df2.format(pmale) + " % of the confirmed cases are male" );
		System.out.println(df2.format(pfemale) + " % of the confirmed cases are female") ;
	}
	public static void ageofPatients(int age,boolean infected) { // calculates the percentage of cases in age category 
		if (infected) { 
			if (age <= 17) {
			countkids++;
			} else if (age <= 64) {
			countadults++;
			} else  {
			countelders++;
			}
		}
	}
	public static void agePercentages() { 
		double pkids = countkids / countinfected * 100;
		double padults = countadults / countinfected * 100;
		double pelders = countelders / countinfected * 100;
		System.out.println(df2.format(pkids) + "% of the confirmed cases are kids");
		System.out.println(df2.format(padults) + "% of the confirmed cases are adults");
		System.out.println(df2.format(pelders) + "% of the confirmed cases are elders"); 
	}
	//table initialization with total infections per month//
	public static void initialisation() {
		for (int i = 0; i < 12; i++) {
			infpermonth[i] = 0;
		}
	}
	//counting total infections per month//
	public static void countinfpermonth(boolean infected, int testmonth) {
		for (int i = 0; i < 12; i++) {
			if (infected && testmonth == i + 1) {
				infpermonth[i]++;
			}
		}
	}
    //filling table with infection rates per month//
	public static double[] infratepermonth() {

		for (int i = 0; i < 12; i++) {
			monthinfrate[i] = infpermonth[i]/countinfected * 100;
		}
		return monthinfrate;
	}
	//finding month with the highest infection rate//
	public static int mostinfmonth() {
		double maxinf = 0;
		for (int i = 0; i < 12; i++) {
			if ( i == 0) {
				maxinf = infpermonth[i];
				maxmonth = i + 1;
			} else {
				if (infpermonth[i] > maxinf) {
					maxinf = infpermonth[i];
					maxmonth = i + 1;
				}
			}
		}
		return maxmonth;
	}
    //filling table with infection rates per season//
	public static double[] infrateperseason() { 
		seasoninfrate[0] = monthinfrate[0] + monthinfrate[1] + monthinfrate[11];
		seasoninfrate[1] = monthinfrate[2] + monthinfrate[3] + monthinfrate[4];
		seasoninfrate[2] = monthinfrate[5] + monthinfrate[6] + monthinfrate[7];
		seasoninfrate[3] = monthinfrate[8] + monthinfrate[9] + monthinfrate[10];
		return seasoninfrate;
	}
	//printing infection rates per season//
	public static void seasonPercentages(){
		double pwinter = seasoninfrate[0]; 
		double pspring = seasoninfrate[1]; 
		double psummer = seasoninfrate[2];
		double pautumn = seasoninfrate[3];
		System.out.println(df2.format(pwinter) + "% of the confirmed cases appeared in winter");
		System.out.println(df2.format(pspring) + "% of the confirmed cases appeared in spring");
		System.out.println(df2.format(psummer) + "% of the confirmed cases appeared in summer");
		System.out.println(df2.format(pautumn) + "% of the confirmed cases appeared in autumn");
	}
	//finding season with highest infection rate//
	public static String mostinfseason() {
		String[] season = {"Winter", "Spring", "Summer", "Autumn"};
		double maxinfrate = 0;
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				maxinfrate = seasoninfrate[i];
				maxseason = season[i];
			} else {
				if (seasoninfrate[i] > maxinfrate) {
					maxinfrate = seasoninfrate[i];
					maxseason = season[i];
				}
			}
		}
		return maxseason;
	}
	public static void todayInfected(int day, int month , int year) { // calculates the number of cases on a given day 
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		do {
			System.out.print("You want to know today's infected in Greece or in certain city?Insert [Greece] or [city] ");
			String answer = sc.next();
			int countTodayInfected = 0;
			if (answer.equals("Greece")) {
				for (int j = 0 ; j < Person.personlist.size() ; j++) {
					if (Person.personlist.get(j).isInfected() == true && Person.personlist.get(j).getTestday() == day && Person.personlist.get(j).getTestmonth() == month &&  Person.personlist.get(j).getTestyear() == year) {
						countTodayInfected++;
					}
				}
				System.out.println("Today's people infected by Covid19 in Greece are " + countTodayInfected);
				a = true;
			} else if (answer.equals("city")) {
				do {
					try {
						System.out.print("Insert the city you want to know the total number of people that are infected by Covid19 "
								+ "(Athens,Thessaloniki,Larissa,Xania,Patra,Komotini,Alexandroupoli,Kalamata,Gianena)");
						String region = sc.next();
						if((!region.matches("Athens|Thessaloniki|Larissa|Xania|Patra|Komotini|Alexandroupoli|Kalamata|Gianena"))){
							throw new Exception();
						}
						for (int j = 0 ; j < Person.personlist.size() ; j++) {
							if (Person.personlist.get(j).isInfected() == true && Person.personlist.get(j).getRegion().equals(region)  && Person.personlist.get(j).getTestday() == day && Person.personlist.get(j).getTestmonth() == month &&  Person.personlist.get(j).getTestyear() == year) {
								countTodayInfected++;
							}
						}
						System.out.println("Today's people infected by Covid19 in " + region + " are " + countTodayInfected);
						a = true;
					} catch (Exception e) {
						System.out.println("Wrong input,not valid region");
						a = false;
						sc.nextLine();
					}
				} while (a == false);
			} else {
				System.out.println("Wrong input, insert [Greece] or [city]");
				a = false;
			}
		} while (a == false);
	}


	public static void totalInfected() { // calculates the total number of cases 
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		do {
			System.out.print("You want to know total infected in Greece or in certain city?Insert [Greece] or [city] ");
			String answer = sc.next();
		    int countTotalInfected = 0;
			if (answer.equals("Greece")) {
				for (int i = 0 ; i < Person.personlist.size() ; i++) {
					if(Person.personlist.get(i).isInfected() == true) {
						countTotalInfected++;
					}
				}
				System.out.println("Total people infected by Covid19 in Greece are : " + countTotalInfected);
				b = true;
			} else if (answer.equals("city")) {
					do {
						try {
							System.out.print("Insert the city you want to know the total number of people that are infected by Covid19 "
									+ "(Athens,Thessaloniki,Larissa,Xania,Patra,Komotini,Alexandroupoli,Kalamata,Gianena)");
							String region = sc.next();
							if((!region.matches("Athens|Thessaloniki|Larissa|Xania|Patra|Komotini|Alexandroupoli|Kalamata|Gianena"))){
								throw new Exception();
							}
							for (int i = 0 ; i < Person.personlist.size(); i++) {
								if (Person.personlist.get(i).isInfected() == true && Person.personlist.get(i).getRegion().equals(region)) {
									countTotalInfected++;
								}
							}
							System.out.println("Total people infected by Covid19 in " + region + " are " + countTotalInfected);
							b = true;
						} catch(Exception e) {
							System.out.println("Wrong input,not valid region");
							b = false;
							sc.nextLine();
						} 
					} while (b == false);
			} else {
				System.out.println("Wrong input, insert [Greece] or [city]");
				b = false;
				}
		} while (b == false);
	}
	public static void mortalityrate() {  
		double pdeath = Hospital.getNumberDead()/ countinfected * 100; 
		System.out.println("The mortality rate of Covid19 is " + df2.format(pdeath) + "%");
	}
	
	public static void icurate() { // percentage of people that entered icu 
		double pentrance = Hospital.getTotalIcuCases() / countinfected * 100; 
		System.out.println(df2.format(pentrance) + " % of the confirmed cases needed icu");
	}
	
	public static void icuexitrate() { // percentage of people that exit icu 
		double pexit = Hospital.getNumberAlive()/Hospital.getTotalIcuCases() * 100; 
		System.out.println(df2.format(pexit) + " % of people infected by Covid 19 have exit icus ");
	}
	//filling table with the regions investigated for possible infections//
	public static void regionnames() {
		for (int i = 0; i < 9; i++) {
			switch(i) {
			  case 0:
				  regions[i] ="Athens";
			  case 1:
				  regions[i] ="Thessaloniki";
			  case 2:
				  regions[i] = "Larissa";
			  case 3:
				  regions[i] = "Xania";
			  case 4:
				  regions[i] = "Patra";
			  case 5:
				  regions[i] = "Komotini";
			  case 6:
				  regions[i] = "Alexandroupoli";
			  case 7:
				  regions[i] = "Kalamata";
			  case 8:
				  regions[i] = "Gianena";
				  break;
			}
		}
	}
	//finding total infections per region//
	public static void countinfperregion(String region, boolean infected) {
		if (infected) {
			for (int i = 0; i < 9; i++) {
				if (region == regions[i]) {
					infperregion[i]++;
				}
			}
		}
	}
	//finding region with the highest infection rate//
	public static String mostinfregion() {
		double maxinf = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				maxinf = infperregion[i];
				maxregion = regions[i];
			} else {
				if (infperregion[i] > maxinf) {
					maxinf = infperregion[i];
					maxregion = regions[i];
				}
			}
		}
		return maxregion;
	}
	//filling table with infection rates per region//
	public static double[] infrateperregion() {
		for (int i = 0; i < 9; i++) {
			regioninfrate[i] = infperregion[i] / countinfected * 100;
		}
		return regioninfrate;
	}
}  
 

		
				
						
	
	

    
	
	
	
	
	
	

