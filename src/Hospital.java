import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
	
	Scanner scanner = new Scanner(System.in);
	
	// A list with all the people the needed icu
	private static ArrayList<Person>  entrancedPerson = new ArrayList<Person>();
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

	private static int totalIcuCases = 0;
	
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
		int maxFreeIcus = Integer.MIN_VALUE;
		int mostEmptyHospital = -1;
		int j;
		for(j = 0; j < hospitals.length ; j++ ) {
			if (location.equals(hospitals[j].location)) {
				maxFreeIcus = hospitals[j].freeIcu;
				mostEmptyHospital = j;
				break;
			}
		}
		for(int i = j+1 ; i < hospitals.length ; i++) {
			if(hospitals[i].icu > maxFreeIcus && location.equals(hospitals[i].location)) {
				maxFreeIcus = hospitals[i].freeIcu;
				mostEmptyHospital = i;
			}
		}
		return mostEmptyHospital;
	}
	
	// The entrance of a new person who need icu
	public static void icuUpdate(Person person, String managerDecision) {
		if(person.infected && managerDecision.equals("Yes") ) {
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

	public static int getTotalIcuCases() {
		return totalIcuCases;
	}

	public static void setTotalIcuCases(int totalIcuCases) {
		Hospital.totalIcuCases = totalIcuCases;
	}


}

