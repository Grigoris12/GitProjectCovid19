import java.util.Scanner;
public class CovidInformation {
	/*Printing a list of options for users*/
	public static void menu() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("********Menu********");   
		System.out.println("1)Printing the symptoms of Covid19");
		System.out.println("2)Printing the instructions for protecting from Covid19");
		System.out.println("3)Printing the instructions if you have symptoms of Covid19");
		System.out.println("4)Printing today's people infected by Covid19");
		System.out.println("5)Printing total people infected by Covid19");
		System.out.println("6)Printing today's deaths from Covid19");
		System.out.println("7)Printing total deaths from Covid19");
		System.out.println("8)Printing the percentage of mortality");
		System.out.println("9)Printing the number of people infected by Covid19 that are into icus");
		System.out.println("10)Printing the percentage of people infected by Covid19 that have exit icus");
		System.out.println("11)Printing the available icus in every city");
		System.out.println("12)Printing the percentage of felame and male infected by Covid19");
		System.out.println("13)Printing the percentage of infections in every city right now");/*++να εμφανίζει την πόλη με τα περισσότερα κρούσματα */
		System.out.println("14)Printing the percentage of infections per month");
		System.out.println("15)Printing the percentage of infections per season");/*++να εμφανίζει την εποχή με τα περισσότερα κρούσματα*/
		System.out.println("16)Printing the percentage of infections in age category");
		System.out.println("17)Printing the Covid-map");/* πόλεις σε πράσινο,κίτρινο,πορτοκαλί και κόκκινο */
		System.out.println("Choose from 1 to 17");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: covidSymptoms();
		case 2: covidGuide();
		case 3: 
			Scanner s = new Scanner(System.in);
			System.out.println("Insert the day,month and year that you want to know the number of infections");
			int d = s.nextInt();
			int m = s.nextInt();
			int y = s.nextInt();
			todayInfected(d, m, y);
		case 4: totalInfected();
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:				
		case 10:
		case 11:				
		case 12: Statistics.GenderPercentages();		
		case 13:
		case 14:
		case 15: Statistics.SeasonPercentages();		
		case 16: Statistics.AgePercentages();
		default: System.out.println("Wrong input, try again!");
		}	
	}
	
	/* Printing the symptoms of Covid19*/
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
    
	/*Printing the instructions for protection from Covid19*/
	public static void covidGuide() {
		System.out.println("To protect yourself from the covid19 virus you must:"
				+ "1)Cover your mouth and nose with a mask when around others."
				+ "2)Clean your hands before you put your mask on and make sure it covers both your nose, mouth and chin."
				+ "3)Wash your hands often with soap and water for at least 20 seconds especially after you have been in a public place."
				+ "4)Keep a distance of 1.5-2 meters from everyone."
				+ "5)Do not touch your face (eyes, nose, mouth)."
				+ "6)Avoid contact with people belonging to vulnerable groups and hositalized patients."
				+ "7)Avoid unnecessary transportation."
				+ "8)Always cover your mouth and nose with a tissue when you cough or sneeze use the inside of your elbow."
				+ "9)If you have symptoms of cough, fever or it is difficult to breath, you must contact with your doctor.");

	}
	
	/*Printing instructions for people infected by Covid19*/
	public static void instructionsForInfected() {
		
	}
	
	/*Printing the number of today's infections*/
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
	
	/*Printing the number of total infections*/
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
}