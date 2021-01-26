import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
	
	
	Scanner scanner = new Scanner(System.in);
	
	// A list with all the people the needed icu

	static ArrayList<Person>  entrancedPerson = new ArrayList<Person>();
	static ArrayList<Person>  deadPerson = new ArrayList<Person>();
	static ArrayList<Person>  alivePerson = new ArrayList<Person>();
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
	public static String showAvailability() {
		String showHospitals = "";
		for(int i = 0 ; i < hospitals.length ; i++) {
			showHospitals += "The remaining Icus of the " +  hospitals[i].hospitalName + 
					 " are " + hospitals[i].icu +"\r\n";
		}
		return showHospitals;
	}
	public static String showEntranced(){
		try
        {

            FileInputStream fis = new FileInputStream("hospital_icus");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Hospital.entrancedPerson = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            
        }
		
		String showentranced = "";
		for(Person entrancedperson : Hospital.entrancedPerson) {
			showentranced += entrancedperson.toString() + "\r\n";
		}
		return showentranced;
	}
	
	/*  Priortise the Hospitals with the most capacity in Icu's at the specific location
	  	so the next Covid-19 case that needs the Icu can go there */
	public static int mostFreeIcus(String location) {
		for(int i = 0 ; i <  hospitals.length ; i++) {
			if(hospitals[i].icu > 0 && location.equals(hospitals[i].location)) {
				return i;
			}
		}
		return 0;
	}
	
	// The entrance of a new person who need icu
	public static void icuUpdate(Person person, boolean managerDecision) {
		File f2 = new File("hospital_icus");
		try {
			f2.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
        {
            FileInputStream fis = new FileInputStream("hospital_icus");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Hospital.entrancedPerson = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
		if(person.infected && managerDecision ) {
			hospitals[mostFreeIcus(person.getRegion())].freeIcu--;
			entrancedPerson.add(person);
			person.setBelongingHospital(hospitals[mostFreeIcus(person.getRegion())].hospitalName);
			
			
			try
	        {
				FileOutputStream fos = new FileOutputStream(f2,false);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(Hospital.entrancedPerson);
	            oos.close();
	            fos.close();
	            
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	        }
		}
	}
	
	public static int findHospital(Person person) {
		int place = 0;

		for (int i = 0; i < belongingHospital.size(); i++) {
			for(int j=0; j < hospitals.length; j++) {
				if(belongingHospital.get(i).equals((hospitals[j].hospitalName))) {
					place = i;
				}

			}
		}
		return place;
	}
	
	// When a person is exiting the Icu 

	public static void icuExtraction(Person person, String currentSituation,String departureDate) {
		File f3 = new File("deadPerson");
		try {
			f3.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File f4 = new File("alivePerson");
		try {
			f4.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(currentSituation.equals("alive")) {
			for( Person findPerson : Person.personlist) {
				if(findPerson == person) {
					Hospital.alivePerson.add(findPerson);
					person.setDepartmentDate(departureDate);
					try
			        {
						FileOutputStream fos = new FileOutputStream(f4,false);
			            ObjectOutputStream oos = new ObjectOutputStream(fos);
			            oos.writeObject(Hospital.alivePerson);
			            oos.close();
			            fos.close();
			            
			        } 
			        catch (IOException ioe) 
			        {
			            ioe.printStackTrace();
			        }
					
					break;
				}
			}
		}else if(currentSituation.equals("dead")) {
			for( Person findPerson : Person.personlist) {
				if(findPerson == person) {
					Hospital.deadPerson.add(findPerson);
					person.setDepartmentDate(departureDate);
					try
			        {
						FileOutputStream fos = new FileOutputStream(f3,false);
			            ObjectOutputStream oos = new ObjectOutputStream(fos);
			            oos.writeObject(Hospital.deadPerson);
			            oos.close();
			            fos.close();
			            
			        } 
			        catch (IOException ioe) 
			        {
			            ioe.printStackTrace();
			        }
					
					
					
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
		try
        {
            FileInputStream fis = new FileInputStream("deadPerson");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Hospital.deadPerson = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
           
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            
        }
		for(Person person : deadPerson) {
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
		return numberAlive=Hospital.alivePerson.size();
	}

	public static void setNumberAlive(int numberAlive) {
		Hospital.numberAlive = numberAlive;
	}

	public static int getNumberDead() {
		return numberDead=Hospital.deadPerson.size();
	}

	public static void setNumberDead(int numberDead) {
		Hospital.numberDead = numberDead;
	}

	public static double getTotalIcuCases() {
		return totalIcuCases=Hospital.entrancedPerson.size();
	}

	public static void setTotalIcuCases(int totalIcuCases) {
		Hospital.totalIcuCases = totalIcuCases;
	}


}

