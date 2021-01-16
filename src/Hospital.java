import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
	
	Scanner scanner = new Scanner(System.in);
	
	// A list with all the people the needed icu
	static ArrayList<Person>  entrancedPerson = new ArrayList<Person>();
	private static ArrayList<String> belongingHospital = new ArrayList<String>();
	// Variables with the name of the hospital and the location of it
	private String hospitalName, location;
	
	// The number of the icu's the hospital has
	private int icu;
	
	// The number of available icus out of the current hospital
	private  int freeIcu;

	private static Hospital[] hospitals = new Hospital[21];
	private static int count = 0;
	
	// Number of people that come out of the Icus alive and dead
	private static int numberAlive = 0, numberDead = 0;

	private static double totalIcuCases = 0;
	
	// constructor for hospitals and their attributes
	public Hospital(String hospitalName, int icu, String location) {
		hospitals[count] = this;
		count++;
		this.hospitalName = hospitalName;
		this.icu = icu;
		this.location = location;
		this.freeIcu = icu;	
	}

	// Prints the available icus of every hospital
	public static void showAvailability() {
		for(int i = 0 ; i < hospitals.length ; i++) {
			System.out.println("The remaining Icus of the " +  hospitals[i].hospitalName + 
					 " are " + hospitals[i].icu);
		}
	}
	
	/*  Priortise the Hospitals with the most capacity in Icu's at the specific location
	  	so the next Covid-19 case that needs the Icu can go there */
	public static int mostFreeIcus(String location) {
		for(int i = 0 ; i < hospitals.length ; i++) {
			if(hospitals[i].icu > 0 && location.equals(hospitals[i].location)) {
				return i;
			}
		}
		return 0;
	}
	
	// The entrance of a new person who need icu
	public static void icuUpdate(Person person, boolean managerDecision) {
		if(person.infected && managerDecision ) {
			hospitals[mostFreeIcus(person.getRegion())].freeIcu--;
			entrancedPerson.add(person);
			belongingHospital.add(hospitals[mostFreeIcus(person.getRegion())].hospitalName);
			totalIcuCases++;
		}
	}
	
	public static int findHospital(Person person) {
		int place = 0;
		for (int i = 0; i <= belongingHospital.size(); i++) {
			for(int j=0; j <= hospitals.length; j++) {
				if(belongingHospital.get(i).equals((hospitals[j].hospitalName))) {
					place = i;
				}
			}
		}
		return place;
	}
	
	// When a person is exiting the Icu 
	public static void icuExtraction(Person person, String currentSituation) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give the date(DD/MM/YYY) that the person left the icu : ");
		String departureDate = scanner.nextLine();
		if(currentSituation.equals("Alive")) {
			numberAlive++;
			for( Person findPerson : Person.personlist) {
				if(findPerson == person) {
					person.setDepartmentDate(departureDate);
					break;
				}
			}
		}else {
			numberDead++;
			for( Person findPerson : Person.personlist) {
				if(findPerson == person) {
					person.setDepartmentDate(departureDate);
					break;
				}
			}
		}
		hospitals[findHospital(person)].freeIcu--;
		System.out.println("The hospital has now one more available Icu!");
		}
	
	
	// give date to the method to count the number of deaths in that day
	public static int deadInADay(String date) {
		int count = 0;
		for(Person person : entrancedPerson) {
			if(date.equals(person.getDepartmentDate())) {
				count++;
			}
		}
		return count;
	}

	
	public int totalFreeIcus() {
		int sum = 0;
		for(int i =0 ; i < hospitals.length; i++) {
			sum += hospitals[i].freeIcu;
		}
		return sum;
	}
		
	public static void showIcuPerson() {
		for(int i = 0; i < entrancedPerson.size() ; i++) {
			System.out.println(entrancedPerson.get(i));
		}
	}
	
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getIcu() {
		return icu;
	}

	public void setIcu(int icu) {
		this.icu = icu;
	}

	public static int getNumberAlive() {
		return numberAlive;
	}

	public static void setNumberAlive(int numberAlive) {
		Hospital.numberAlive = numberAlive;
	}

	public static int getNumberDead() {
		return numberDead;
	}

	public static void setNumberDead(int numberDead) {
		Hospital.numberDead = numberDead;
	}

	public static double getTotalIcuCases() {
		return totalIcuCases;
	}

	public static void setTotalIcuCases(int totalIcuCases) {
		Hospital.totalIcuCases = totalIcuCases;
	}

	public static void hospitalMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give Password = ");
		int password = sc.nextInt();
		if(password == 104) {
			System.out.println("Correct Pasword...");
			System.out.println("Insert AMKA to find the person you want : ");
			int AMKA = sc.nextInt();
			boolean flag = true;
			for(int i=0; i < Person.personlist.size(); i++) {
				if (Person.personlist.get(i).getAMKA() == AMKA ) {
					flag = false;
					System.out.println("Press 1 through 4 to choose the following or anything "
							+ "else to stop the procedure...  ");
					System.out.println("1) Insert person in icu");
					System.out.println("2) Update patient status");
					System.out.println("3) Show the availabilty of the Icus of all the hospitals.");
					System.out.println("4) To show the list of the person that have been entranced in Icu");
					System.out.println("5)Go to main menu");
					int choice = sc.nextInt();
					switch (choice) {
						// add of a covid-19 case to the icu
						case 1 :
							System.out.println("Does the patience need icu(true/false)?");
							boolean managerDecision = sc.nextBoolean();
							if(managerDecision==true){
								Hospital.icuUpdate(Person.personlist.get(i), managerDecision);
								System.out.println("The addition has been successful!!");
							} else if(managerDecision==false){
								System.out.println("The patient doesnt need Icu at the moment");
							}
							break;
							// end of the addition
							// deleting-extracting a case from the icu - new icu-space	
						case 2 :
							System.out.println("What is the current situation of the case: alive or dead;");
							String status = sc.next();
							Hospital.icuExtraction(Person.personlist.get(i), status);
							System.out.println("The extraction has been successful!!");
							break;
							// end of extraction	
						case 3 :
							Hospital.showAvailability();
							break;
							// end of showing availity		
						case 4:
							Hospital.showIcuPerson();
						case 5:
							break;
						}
					break;
				}
			}
			if (flag == true) {
				System.out.println("There's no patient with COVID-19 with that AMKA!!");
			}
		}

	}
}

