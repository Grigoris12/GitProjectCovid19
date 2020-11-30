
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
	public static void gendercount(boolean infected,String gender){
		if(infected) {
			countinfected++;
			if (gender == "male") {
				countmale++;
			}else {
				countfemale++;
			}
		}
	}
	public static void GenderPercentages(){
		double pmale = countmale / countinfected * 100;
		double pfemale = countfemale / countinfected * 100;
		System.out.println(pmale + " % of the confirmed cases are male" );
		System.out.println(pfemale + " % of the confirmed cases are female") ;
	}
	public static void AgeofPatients(int age) {

		if (age <= 17) {
			countkids++;
		} else if (age <= 64) {
			countadults++;
		} else {
			countelders++;
		}
	}
	public static void AgePercentages() {
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
	public static double[] infratepermonth(double[] infpermonth, double countmale, double countfemale) {
		for (int i = 0; i < 12; i++) {
			monthinfrate[i] = infpermonth[i]/(countmale + countfemale) * 100;
		}
		return monthinfrate;
	}
	public static int mostinfmonth(double[] infpermonth) {
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
	public static double[] infrateperseason(double[] monthinfrate) {
		int countseason = 0;
		for (int i = 0; i < 12; i++) {
			if ( i == 0) {
				seasoninfrate[countseason] = monthinfrate[i];
			} else if (i == 1) {
				seasoninfrate[countseason] = monthinfrate[i - 1] + monthinfrate[i];
			} else if (i == 2) {
				countseason++;
				seasoninfrate[countseason] = monthinfrate[i];
			} else if (i <= 4) {
				seasoninfrate[countseason] = monthinfrate[i - 1] + monthinfrate[i];
			} else if (i == 5) {
				countseason++;
				seasoninfrate[countseason] = monthinfrate[i];
			} else if (i <= 7) {
				seasoninfrate[countseason] = monthinfrate[i - 1] + monthinfrate[i];
			} else if (i == 8) {
				countseason++;
				seasoninfrate[countseason] = monthinfrate[i];
			} else if (i <= 10) {
				seasoninfrate[countseason] = monthinfrate[i - 1] + monthinfrate[i];
			} else {
				countseason = 0;
				seasoninfrate[countseason] = seasoninfrate[countseason] + monthinfrate[i];
			}
		}
		return seasoninfrate;
	}
	public static String mostinfseason(double[] seasoninfrate) {
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
	
}
	
	
					
			
				
				
	
				
						
			
	
	
	
	
    
	
	
	
	
	
	

