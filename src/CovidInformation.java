import java.util.Scanner;
public class CovidInformation {
	public static void menu() { 
	System.out.println("********Menu********");
	System.out.println("1.Printing the symptoms of Covid19");
	System.out.println("2.Printing the instruction for protecting from Covid19");
	System.out.println("3.Printing todays people infected by Covid19");
	System.out.println("4.Printing total people infected by Covid19");
	System.out.println("5.Printing totays deaths from Covid19");
	System.out.println("6.Printing total deaths from Covid19");
	System.out.println("7.Printing the percentage of mortality");
	System.out.println("8.Printing the number of people infected by Covid19 that are into Meths");
	System.out.println("9.Printing available Meths in every city");
	System.out.println("10.");
	System.out.println("11.");
	System.out.println("12");
	System.out.println("13.");
	System.out.println("14.");
	System.out.println("15.");
	System.out.println("Choose from 1 to 15");
	}
	
    public static void covidSymptoms() {
		System.out.println("Covid19 infects different people in different ways:"
				+ "Most infected people have mild to moderate symptoms and recover without treatment."
				+ "-Often symptoms:"
				+ "1)fever, 2)dry cough, 3)tiredness"
				+ "-Rare symptoms:"
				+ "1)pains, 2)sore throat, 3)diarrhea, 4)conjunctivitis, 5)headache, 6)loss of taste or smell"
				+ "-Serious symptoms:"
				+ "1)difficulty breathing or shortness of breath, 2)chest pains, 3)loss of speech or movement");
	}
	
	public static void covidGuide() {
		System.out.println("To protect yourself from the covid19 virus you must:"
				+ "1.Να κάνετε χρήση της μάσκας σε πολυσύχναστους και κλειστούς χώρους, στα ΜΜΜ"
				+ "  και στους χώρους παροχής υπηρεσιών υγείας."
				+ "2.Για να γίνεται σωστή χρήση της μάσκας να μην αγγίζετε το μπροστινό μέρος,να την εφαρμόζετε "
				+ "  καλά στο πρόσωπό σας καλύπτοντας την μύτη και το στόμα και να την αφαιρείτε μόνο από τα "
				+ "  ειδικά κορδόνια."
				+ "3.Να πλένετε συχνά και σχολαστικά τα χέρια σας με σαπούνι και νερό ή αλκοολούχο διάλυμα."
				+ "4.Να τηρείτε απόσταση 1,5-2 μέτρα από όλους."
				+ "5.Να μην αγγίζετε το πρόσωπό σας(μάτια,μύτη,στόμα)."
				+ "6.Να αποφεύγετε επαφές με άτομα που ανήκουν σε ευπαθείς ομάδες και νοσηλευόμενους ασθενείς."
				+ "7.Να αποφεύγετε τις άσκοπες μετακινήσεις και τους χώρους συγχρωτισμού."
				+ "8.Όταν βήχετε ή φτερνιζόσαστε να καλύπτετε το στόμα και την μύτη σας με τον αγκώνα ή ένα χαρτομάντιλο."
				+ "9.Αν παρουσιάζετε συμπτώματα βήχα,πυρετού ή δυσκολίας στην αναπνοή αναζητήστε άμεσα ιατρική βοήθεια "
				+"  και ενημερώστε άμεσα το ιατρικό προσωπικό για το ιστορικό των μετακινήσεών σας.");
	}
	
	public static void todayInfected(int day, int month , int year) {
		System.out.println("Θέλετε να δείτε τα σημερινά κρούσματα σε όλη την Ελλάδα ή σε συγκεκριμένη περιοχή;Εισάγετε [Σε όλη την Ελλάδα] ή [Σε συγκεκριμένη περιοχή] αντίστοιχα");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		int countTodayInfected = 0;
		if (answer == "Σε όλη την Ελλάδα") {
			for (int j= 0 ; j<=Person.personlist.size() ; j++) {
				if (Person.personlist.get(0).isInfected() == true && Person.personlist.get(0).getTestday() == day && Person.personlist.get(0).getTestmonth() == month &&  Person.personlist.get(0).getTestyear() == year) {
					countTodayInfected++;
				}
			}
			System.out.println("Τα σημερινά κρούσματα Covid19 είναι:" + countTodayInfected);
		}else {
			System.out.println("Εισάγετε την περιοχή όπου επιθυμείτε να δείτε των αριθμό των σημερινών κρουσμάτων Covid19");
			String region = sc.next();
			for (int j= 0 ; j<=Person.personlist.size() ; j++) {
				if (Person.personlist.get(0).isInfected() == true && Person.personlist.get(0).getRegion() == region && Person.personlist.get(0).getTestday() == day && Person.personlist.get(0).getTestmonth() == month &&  Person.personlist.get(0).getTestyear() == year) {
					countTodayInfected++;
				}
			}
			System.out.println("Τα σημερινά κρούσματα Covid19 είναι:" + countTodayInfected);
		}
	}
}
