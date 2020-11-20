
public class Statistics {
	private static int countmale = 0;
	private static int countfemale = 0;
	private static int countkids = 0; 
	private static int countadults = 0;
	private static int countelders = 0;
	public static void Gendercount(boolean infected,String gender){
		if (infected && gender == "male") {
			countmale++; 
		}else if (infected && gender == "female") {
			countfemale++;
		}
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
}
