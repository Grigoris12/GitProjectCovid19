import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
	
	Scanner scanner = new Scanner(System.in);
	
	// A list with all the people the needed icu
	private static ArrayList<Person> entrancedPerson = new ArrayList<Person>();
	
	// Variables with the name of the hospital and the location of it
	private String hospitalName, location;
	
	// The number of the icu's the hospital has
	private int icu;
	
	// The number of available icus out of all hospitals
	private static int freeIcu = 0;

		private static Hospital[] hospitals = new Hospital[6];
	private static int count = 0;
	
	// Number of people that come out of the Icus alive and dead
	private static int numberAlive = 0, numberDead = 0;

	// constructor for hospitals and their attributes
	public Hospital(String hospitalName, int icu, String location) {
		hospitals[count] = this;
		count++;
		this.hospitalName = hospitalName;
		this.icu = icu;
		this.location = location;
		freeIcu += icu;	
	}

	// Prints the available icus of every hospital
	public void showAvailability() {
		for(int i = 0 ; i < hospitals.length ; i++) {
			System.out.println("The remaining Icus of the " +  hospitals[i].hospitalName + 
					 " are " + hospitals[i].icu);
		}
	}
	
	/*  Priortise the Hospitals with the most capacity in Icu's 
	  	so the next Covid-19 case that needs the Icu can go there */
	public int mostFreeIcus() {
		int mostFreeIcus = hospitals[0].icu;
		int mostEmptyHospital = 0;
		for(int i = 1 ; i < hospitals.length ; i++) {
			if(hospitals[i].icu > mostFreeIcus) {
				mostFreeIcus = hospitals[i].icu;
				mostEmptyHospital = i;
			}
		}
		return mostEmptyHospital;
	}
	
	// The 
	public void icuUpdate(Person person) {
		if(person.infected ) {
			entrancedPerson.add(person);
			hospitals[mostFreeIcus()].icu--;
		}		
	}
	// 
	public void icuExtraction() {
		System.out.println("What is the current situation of the case: alive or dead;");
		boolean alive = scanner.hasNext();
		if(alive) {
			numberAlive++;
		}else {
			numberDead++;
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
}


