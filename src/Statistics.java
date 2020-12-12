import java.util.Scanner;

public class Statistics {
	private static double countmale = 0;
	private static double countfemale = 0;
	private static double countinfected = 0;
	private static double countkids = 0; 
	private static double countadults = 0;
	private static double countelders = 0; 
	private static double[] infpermonth = new double [12];
	protected static double[] monthinfrate = new double [12];
	protected static int maxmonth;
	protected static String maxseason;
	protected static double[] seasoninfrate = new double [4];
	public static void gendercount(boolean infected,String gender){ /* Υπολογισμός ποσοστών ανα φύλο*/
		if(infected) {
			countinfected++;
			if (gender == "male") {
				countmale++;
			}else {
				countfemale++;
			}
		}
	} 
	public static void genderPercentages(){ 
		double pmale = countmale / countinfected * 100;
		double pfemale = countfemale / countinfected * 100;
		System.out.println(pmale + " % of the confirmed cases are male" );
		System.out.println(pfemale + " % of the confirmed cases are female") ;
	}
	public static void ageofPatients(int age) { /*Υπολογισμός ποσοστών ανα ηλικία*/

		if (age <= 17) {
			countkids++;
		} else if (age <= 64) {
			countadults++;
		} else {
			countelders++;
		}
	}
	
	public static void agePercentages() {
		double pkids = countkids / countinfected * 100;
		double padults = countadults / countinfected * 100;
		double pelders = countelders / countinfected * 100;
		System.out.println(pkids + "% of the confirmed cases are kids");
		System.out.println(padults + "% of the confirmed cases are adults");
		System.out.println(pelders + "% of the confirmed cases are elders"); 
	}
	
	public static void initialisation() {
		for (int i = 0; i < 12; i++) {
			infpermonth[i] = 0;
		}
	}
	public static void countinfpermonth(boolean infected, int testmonth) {
		for (int i = 0; i < 12; i++) {
			if (infected && testmonth == i + 1) {
				infpermonth[i]++;
			}
		}
	}

	public static double[] infratepermonth(double[] infpermonth) {

		for (int i = 0; i < 12; i++) {
			monthinfrate[i] = infpermonth[i]/countinfected * 100;
		}
		return monthinfrate;
	}
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

	public static double[] infrateperseason() { /* Υπολογισμός ποσοστών ανα εποχή*/
		seasoninfrate[0] = monthinfrate[0] + monthinfrate[1] + monthinfrate[11];
		seasoninfrate[1] = monthinfrate[2] + monthinfrate[3] + monthinfrate[4];
		seasoninfrate[2] = monthinfrate[5] + monthinfrate[6] + monthinfrate[7];
		seasoninfrate[3] = monthinfrate[8] + monthinfrate[9] + monthinfrate[10];
		return seasoninfrate;
	}
	public static void seasonPercentages(){
		double pwinter = seasoninfrate[0] / countinfected * 100; 
		double pspring = seasoninfrate[1] / countinfected * 100;
		double psummer = seasoninfrate[2] / countinfected * 100;
		double pautumn = seasoninfrate[3] / countinfected * 100;
		System.out.println(pwinter + "% of the confirmed cases appeared in winter");
		System.out.println(pspring + "% of the confirmed cases appeared in spring");
		System.out.println(psummer + "% of the confirmed cases appeared in summer");
		System.out.println(pautumn + "% of the confirmed cases appeared in autumn");
	}
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
	public static void todayInfected(int day, int month , int year) {
		System.out.println("You want to know todays infected in Greece or in certain city?Insert [Greece] or [city].");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		int countTodayInfected = 0;
		if (answer == "Greece") {
			for (int j= 0 ; j<=Person.personlist.size() ; j++) {
				if (Person.personlist.get(0).isInfected() == true && Person.personlist.get(0).getTestday() == day && Person.personlist.get(0).getTestmonth() == month &&  Person.personlist.get(0).getTestyear() == year) {
					countTodayInfected++;
				}
			}
			System.out.println("Today's people infected by Covid19 in Greece are:" + countTodayInfected);
		}else {
			System.out.println("Insert the city you want to know the number of people that are infected by Covid19 today");
			String region = sc.next();
			for (int j= 0 ; j<=Person.personlist.size() ; j++) {
				if (Person.personlist.get(0).isInfected() == true && Person.personlist.get(0).getRegion() == region && Person.personlist.get(0).getTestday() == day && Person.personlist.get(0).getTestmonth() == month &&  Person.personlist.get(0).getTestyear() == year) {
					countTodayInfected++;
				}
			}
			System.out.println("Today's people infected by Covid19 in" + region + "are:" + countTodayInfected);
		}
	}
	
	public static void totalInfected() {
		System.out.println("You want to know total infected in Greece or in certain city?Insert [Greece] or [city]");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		int countTotalInfected = 0;
		if (answer == "Grecce") {
			for (int i = 0 ; i <= Person.personlist.size() ; i++) {
				if(Person.personlist.get(0).isInfected() == true) {
					countTotalInfected++;
				}
			}
			System.out.println("Total people infected by Covid19 in Greece are:" + countTotalInfected);
		}else {
			System.out.println("Insert the city you want to know the total number of people that are infected by Covid19");
			String region = sc.next();
			for (int i = 0 ; i <= Person.personlist.size(); i++) {
				if (Person.personlist.get(0).isInfected() == true && Person.personlist.get(0).getRegion() == region);{
					countTotalInfected++;
				}
			}
			System.out.println("Total people infected by Covid19 in" + region + "are:" + countTotalInfected);
		}
	}
	public static void mortalityrate() { // ποσοστό θνησιμότητας 
		double pdeath = Hospital.getNumberDead()/ countinfected * 100; 
		System.out.println("The mortality rate of Covid19 is" + pdeath);
	}
	
	public static void icurate() { // ποσοστό ατόμων που μπήκαν σε ΜΕΘ 
		double pentrance = Hospital.getTotalIcuCases() / countinfected * 100; 
		System.out.println(pentrance + " % of the confirmed cases needed icu");
	}
	
	public static void icuexitrate() {
		double pexit = Hospital.getNumberAlive()/Hospital.getTotalIcuCases() * 100; 
		System.out.println(pexit + " % of people infected by Covid 19 have exit icus ");
	}
        
	public static void regionnames() {
		for (int i = 0; i < 9; i++) {
			switch(i) {
			  case 0:
				  regions[i] = "Athens";
			  case 1:
				  regions[i] = "Thessaloniki";
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
	
	public static void countinfperregion(String region, boolean infected) {
		if (infected) {
			for (int i = 0; i < 9; i++) {
				if (region == regions[i]) {
					infperregion[i]++;
				}
			}
		}
	}
	
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
	
	public static double[] infrateperregion() {
		for (int i = 0; i < 9; i++) {
			regioninfrate[i] = infperregion[i] / countinfected * 100;
		}
		return regioninfrate;
	}
}
		
				
						
	
	

    
	
	
	
	
	
	

