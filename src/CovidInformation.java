import java.util.Scanner;

public class CovidInformation {
	/*Printing a list of options for users*/
	public static void menu() {
		boolean b;
		do {
		    b = true;
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("********Menu********");
				System.out.println("1)Printing the symptoms of Covid19");
				System.out.println("2)Printing the instructions for protecting from Covid19");
				System.out.println("3)Printing the instructions if you have symptoms of Covid19");
				System.out.println("4)Printing the number of people infected by Covid19 a "
						+ "specific day");
				System.out.println("5)Printing total people infected by Covid19");
				System.out.println("6)Printing the deaths from Covid19 on a specific day");
				System.out.println("7)Printing total deaths from Covid19");
				System.out.println("8)Printing the percentage of mortality");
				System.out.println("9)Printing the number of people infected by Covid19 "
						+ "that are into icus");
				System.out.println("10)Printing the percentage of people infected by Covid19 that "
						+ "have enter icus"); 
				System.out.println("11)Printing the percentage of people infected by Covid19 that"
						+ "have exit icus");
				System.out.println("12)Printing the available icus of every hospital");
				System.out.println("13)Printing the percentage of female and male infected by Covid19");
				System.out.println("14)Printing the percentage of infections in every city right now");
				System.out.println("15)Printing the month with the most infections");
				System.out.println("16)Printing the percentage of infections per season");
				System.out.println("17)Printing the percentage of infections in age category");
				System.out.println("18)Go to main menu");
				System.out.print("Give [1-18] ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:covidSymptoms();
				break;

				case 2:covidGuide();
				break;

				case 3:instructionsForInfected();
				break;

				case 4:
					boolean a = true;
					do {
						try {
						Scanner s = new Scanner(System.in);
							System.out.print("Insert the day that you want to know the number of infections: ");
							int d = s.nextInt();
							System.out.print("Insert the month that you want to know the number of infections: ");
							int m = s.nextInt();
							System.out.print("Insert the year that you want to know the number of infections: ");
							int y = s.nextInt();
							Statistics.todayInfected(d, m, y);
							a = true;
						} catch (Exception e) {
							sc.nextLine();
							System.out.println("Error,integers only!");
							a = false;
						}
					} while (a == false);
					break;
					
				case 5:Statistics.totalInfected();
				break;
				
				case 6:
					Scanner sca = new Scanner(System.in);
					System.out.print("Insert the date that you want to know the number of deaths: ");
					String d=sca.next();
					System.out.println("Total deaths in Greece on " + d + " are " + Hospital.deadInADay(d) );
				break;

				case 7:System.out.println("Total deaths in Greece are " + Hospital.getNumberDead());
				break;

				case 8:Statistics.mortalityrate();
				break;

				case 9:System.out.println("The number of people infected by Covid19 that are into icus is " 
				    + (Hospital.getTotalIcuCases() - Hospital.getNumberAlive() - Hospital.getNumberDead()));
				break;

				case 10:Statistics.icurate();
				break;
				
				case 11:Statistics.icuexitrate();
				break;
		 
				case 12:Hospital.showAvailability();
				break;
		 
				case 13: 
					Statistics.gendercount();
					break;

				case 14: 
					Statistics.regionnames();
		            Statistics.countinfperregion();
		            Statistics.infrateperregion();
		         System.out.println("The region with the most infections is " +  Statistics.mostinfregion());
				 break;
				
				
					
				case 15: 
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.mostinfmonth();
					System.out.println("The month with the most infections is " + Statistics.mostinfmonth());
					break;

				case 16:
					Statistics.initialisation();
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.infrateperseason();
					Statistics.seasonPercentages();
					System.out.println("The season with the most infections is " + Statistics.mostinfseason());
				break;
				
				case 17:Statistics.ageofPatients();
				break;
				
				case 18:
				break;

				default:System.out.println("Wrong input, try again!");
				break;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Error,integers only!"); 
			}
		}while (b == false);
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
	
	/*Printing the instructions for people infected by Covid19*/
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