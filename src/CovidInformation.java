import java.util.Scanner;

//import sun.applet.Main;
public class CovidInformation {
	/*Printing a list of options for users*/
	public static void menu() { 
		boolean b = true;
		do {
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
			System.out.println("10)Printing the percentage of people infected by Covid19 that have enter icus"); 
			System.out.println("11)Printing the available icus of every hospital");
			System.out.println("12)Printing the percentage of female and male infected by Covid19");
			System.out.println("13)Printing the percentage of infections in every city right now");
			System.out.println("14)Printing the percentage of infections per month");
			System.out.println("15)Printing the percentage of infections per season");
			System.out.println("16)Printing the percentage of infections in age category");
			System.out.println("17)Printing the Covid-map");
			System.out.println("18)Go to home page");
			System.out.printf("Give [1-18] ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: covidSymptoms();
					MenuLauncher.main(null);
					
			case 2: instructionsForInfected();
					MenuLauncher.main(null);
					
			case 3: covidGuide();
					MenuLauncher.main(null);
					
			case 4:
				Scanner s = new Scanner(System.in);
				System.out.println("Insert the day,month and year that you want to know the number of infections");
				int d = s.nextInt();
				int m = s.nextInt();
				int y = s.nextInt();
				Statistics.todayInfected(d, m, y);
				MenuLauncher.main(null);
				
			case 5: Statistics.totalInfected();
					MenuLauncher.main(null);
					
			case 6:
					MenuLauncher.main(null);
					
			case 7:   
					MenuLauncher.main(null);
					
			case 8: Statistics.mortalityrate();
					MenuLauncher.main(null);
					
			case 9:				
					MenuLauncher.main(null);
			case 10: Statistics.icurate();
					 MenuLauncher.main(null);
					 
			case 11: 
					 MenuLauncher.main(null);
					 
			case 12: Statistics.genderPercentages();
					 MenuLauncher.main(null);
					 
			case 13:
					 MenuLauncher.main(null);
					 
			case 14: 
					 System.out.println("The month with the more infections is:" + Statistics.mostinfmonth());
					 MenuLauncher.main(null);
					 
			case 15: Statistics.seasonPercentages();
					 System.out.println("The season with the more infections is:" + Statistics.mostinfseason());
					 MenuLauncher.main(null);
					 
			case 16: Statistics.agePercentages();
					 MenuLauncher.main(null);
					 
			case 17:
					 MenuLauncher.main(null);
					 
			case 18:
				    MenuLauncher.main(null);
				    
			default: System.out.println("Wrong input, try again!");
					 break;
			}
		}while (b == true);
	}
	
	
	/* Printing the symptoms of Covid19*/
    public static void covidSymptoms() {
    	System.out.println("Covid19 infects different people in different ways:");
		System.out.println("Most infected people have mild to moderate symptoms and recover without treatment.");
		System.out.println("-Often symptoms:");
		System.out.println("1)fever, 2)dry cough, 3)tiredness");
		System.out.println("-Rare symptoms:");
		System.out.println("1)pains, 2)sore throat, 3)diarrhea, 4)conjunctivitis, 5)headache, 6)loss of taste or smell");
		System.out.println("-Serious symptoms:");
		System.out.println("1)difficulty breathing or shortness of breath, 2)chest pains, 3)loss of speech or movement");
	}
    
	/*Printing the instructions for protection from Covid19*/
	public static void covidGuide() {
		System.out.println("To protect yourself from the covid19 virus you must:");
		System.out.println("1)Cover your mouth and nose with a mask when around others.");
		System.out.println("2)Clean your hands before you put your mask on and make sure it covers "
				+ "both your nose, mouth and chin.");
		System.out.println("3)Wash your hands often with soap and water for at least 20 seconds "
				+ "especially after you have been in a public place.");
		System.out.println("4)Keep a distance of 1.5-2 meters from everyone.");
		System.out.println("5)Do not touch your face (eyes, nose, mouth).");
		System.out.println("6)Avoid contact with people belonging to vulnerable groups "
				+ "and hospitalized patients.");
		System.out.println("7)Avoid unnecessary transportation.");
		System.out.println("8)Always cover your mouth and nose with a tissue when you cough or sneeze"
				+ " use the inside of your elbow.");
		System.out.println("9)If you have symptoms of cough, fever or it is difficult to breath, you"
				+ " must contact with your doctor.");
	}
	
	/*Printing instructions for people infected by Covid19*/
	public static void instructionsForInfected() {
		System.out.println("1)Stay home and self-isolate even if you have minor symptoms such as cough, "
				+ "headache, mild fever, until you recover.");
		System.out.println("2)Call your health care provider or hotline for advice.");
		System.out.println("Have someone bring you supplies.");
		System.out.println("4)If you need to leave your house or have someone near you, "
				+ "wear a medical mask to avoid infecting others");
		System.out.println("5)If you have a fever, cough and difficulty breathing, seek medical attention immediately."
				+ " Call by telephone first if you can and follow the directions of your local health authority");
		System.out.println("6)Keep up to date on the latest information from trusted sources. Local and national "
				+ "authorities and public health unit are the best placed to advise on what people in "
				+ "your area should be doing to protect themselves.");

	}
}