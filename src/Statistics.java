
public class Statistics {
	private static double countmale = 0;
	private static double totalcount = 0; 
	private static double countfemale = 0;
	private static double countkids = 0; 
	private static double countadults = 0;
	private static double countelders = 0;
	public static void Gendercount(boolean infected,String gender){
		if (infected) {
			totalcount++;
			if (gender == "male") {
			countmale++; 
			}else {
			countfemale++;
		}
	}
	}
	public static void GenderPercentages(){
		System.out.println(countmale/totalcount *100 + " % of the confirmed cases are male" );
		System.out.println(countfemale/totalcount *100 + " % of the confirmed cases are female") ;
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
		System.out.println(countkids/totalcount *100 + "% of the confirmed cases are kids");
		System.out.println(countadults/totalcount *100 + "% of the confirmed cases are adults");
		System.out.println(countelders/totalcount *100 + "% of the confirmed cases are elders"); 
	}
}
