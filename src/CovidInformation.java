import java.util.Scanner;
public class CovidInformation {
	public static void menu() { 
	System.out.println("********Menu********");
	System.out.println("1.Printing the symptoms of Covid19");
	System.out.println("2.Εκτύπωση των οδηγιών για προστασία των πολιτών απο τον Covid19");
	System.out.println("3.Εκτύπωση σημερινών κρουσμάτων Covid19");
	System.out.println("4.Εκτύπωση συνολικών κρουσμάτων Covid19");
	System.out.println("5.Εκτύπωση σημερινών θανάτων από Covid19");
	System.out.println("6.Εκτύπωση συνολικών θανάτων από Covid19");
	System.out.println("7.Εκτύπωση των κρουσμάτων Covid19 που βρίσκονται σε ΜΕΘ");
	System.out.println("8.Εκτύπωση διαθέσιμων κλίνων ΜΕΘ σε κάθε πόλη");
	System.out.println("9.");
	System.out.println("10.");
	System.out.println("11.");
	System.out.println("12");
	System.out.println("13.");
	System.out.println("14.");
	System.out.println("15.");
	System.out.println("Choose from 1 to 15");
	}
	
    public static void covidSymptoms() {
		System.out.println("Ο Covid19 προσβάλλει διαφορετικά άτομα με διαφορετικούς τρόπους."
				+ "Τα περισσότερα μολυσμένα άτομα εμφανίζουν ήπια έως μέτρια συμπτώματα και αναρρώνουν χωρίς να χρειάζεται να νοσηλευτούν."
				+ "-Πιο συχνά συμπτώματα:"
				+ "1)πυρετός, 2)ξηρός βήχας, 3)κούραση"
				+ "-Πιο σπάνια συμπτώματα:"
				+ "1)πόνοι, 2)πονόλαιμος, 3)διάρροια, 4)επιπεφυκίτιδα, 5)πονοκέφαλος, 6)απώλεια γεύσης ή όσφρησης"
				+ "-Σοβαρά συμπτώματα:"
				+ "1)δυσκολία στην αναπνοή ή δύσπνοια, 2)πόνος ή πίεση στο στήθος, 3)απώλεια ομιλίας ή κίνησης");
	}
	
	public static void covidGuide() {
		System.out.println("Για να προστατευθείτε από τον ιό covid19 πρέπει:"
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
