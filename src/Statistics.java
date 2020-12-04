
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
	public static void GenderPercentages(){ 
		double pmale = countmale / countinfected * 100;
		double pfemale = countfemale / countinfected * 100;
		System.out.println(pmale + " % of the confirmed cases are male" );
		System.out.println(pfemale + " % of the confirmed cases are female") ;
	}
	public static void AgeofPatients(int age) { /*Υπολογισμός ποσοστών ανα ηλικία*/

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
	public static double[] infratepermonth() {
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
	public static void SeasonPercentages(){
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
	
}
	
		
						
			
	
	
	
	
    
	
	
	
	
	
	

