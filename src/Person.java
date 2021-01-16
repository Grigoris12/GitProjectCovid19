import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Person implements Serializable {
	//declarations//
	public static ArrayList<Person> personlist = new ArrayList<Person>();
	private String name;
	private String surname;
	private String gender;
	private String region;
	private int age;
	private int testday;
	private int testmonth;
	private int testyear;
	private int AMKA;
	private String departmentDate = null;
	boolean infected;
	//Constructor for person//
	public Person(String name, String surname, int age, String gender, String region, int testday,
			int testmonth, int testyear, int aMKA, boolean infected) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.region = region;
		this.testday = testday;
		this.testmonth = testmonth;
		this.testyear = testyear;
		AMKA = aMKA;
		this.infected = infected;
	}
	//method for adding person//
	public static void addPerson() {
		Scanner sca = new Scanner(System.in);
		String n=null;
		String s=null;
		boolean per = true;
		
		File f = new File("persondata");
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//name input//
		do {
			per=true;
			try{
				System.out.print("Give name = ");
				n = sca.next();
				if(!n.matches("^[a-zA-Z]+$")){
					throw new Exception();
				}

			}catch(Exception e){
				System.out.println("Wrong input ");
				per=false;
			}
		}while(per == false);

		//surname input//
		do {
			per=true;
			try{
				System.out.print("Give surname = ");
				s = sca.next();
				if(!s.matches("^[a-zA-Z]+$")){
					throw new Exception();
				}

			}catch(Exception e){
				System.out.println("Wrong input");
				per=false;
			}
		}while(per == false);

		//age input//
		int b=0;
		do {
			per=true;
			try {
				System.out.print("Give age = ");
				b = sca.nextInt();
			}catch (InputMismatchException exception) 
			{ 
				System.out.println("Integers only, please."); 
				per=false;
				sca.nextLine();
			} 
		}while(per == false);

		//gender input//
		String g=null;
		do {
			per=true;
			try {
				System.out.print("Give gender male/female= "); 
				g = sca.next();
				if(!g.matches("male|female")) {

					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println("Wrong input,put male/female");
				per=false;
				sca.nextLine();
			}
		}while(per == false);

		//region input//
		String r = null;
		do {
			per=true;
			try {
				System.out.print("Give region(Athens,Thessaloniki,Larisa,Xania,Patra,Komotini,Alexandroupoli,Kalamata,Giannena) = ");
				r = sca.next();
				if((!r.matches("Athens|Thessaloniki|Larisa|Xania|Patra|Komotini|Alexandroupoli|Kalamata|Giannena"))){
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println("Wrong input,not valid region");
				per=false;
				sca.nextLine();
			}
		}while(per == false);

		//test day input//
		int d=0;
		do {
			per=true;
			try {
				System.out.print("Give test day = ");
				d = sca.nextInt();
			}catch (InputMismatchException exception) 
			{ 
				System.out.println("Integers only, please."); 
				per=false;
				sca.nextLine();
			} 
		}while(per == false);

		//test month input//
		int m=0;
		do {
			per=true;
			try {
				System.out.print("Give test month = ");
				m = sca.nextInt();
			}catch (InputMismatchException exception) 
			{ 
				System.out.println("Integers only, please."); 
				per=false;
				sca.nextLine();
			} 
		}while(per == false);

		//test year input//
		int y=0;
		do {
			per=true;
			try {
				System.out.print("Give test year = ");
				y = sca.nextInt();
			}catch (InputMismatchException exception) 
			{ 
				System.out.println("Integers only, please."); 
				per=false;
				sca.nextLine();
			} 
		}while(per == false);


		//AMKA input//
		int a=0;
		do {
			per=true;
			try {
				System.out.print("Give AMKA = ");
				a = sca.nextInt();
			}catch (InputMismatchException exception) 
			{ 
				System.out.println("Integers only, please."); 
				per=false;
				sca.nextLine();
			} 
		}while(per == false);

        //covid test input//
		boolean i=true;
		do {
			per=true;
			try {
				System.out.print("You tested Positive  or Negatice for covid-19(true/false) = ");
				i = sca.nextBoolean();
			}catch(Exception e) {
				System.out.println("only put true/false");  
				per=false;
				sca.nextLine();
			}
		}while(per == false);


		personlist.add(new Person(n , s, b, g, r, d, m, y, a, i));
		Statistics.countinfpermonth();
		Statistics.infratepermonth();
		Statistics.infrateperseason();
	
		
		//Serialize arraylist//
				try
		        {
					FileOutputStream fos = new FileOutputStream(f,false);
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		            oos.writeObject(personlist);
		            oos.close();
		            fos.close();
		            
		        } 
		        catch (IOException ioe) 
		        {
		            ioe.printStackTrace();
		        }
	}
				

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", region=" + region + ", testday=" + testday + ", testmonth=" + testmonth + ", testyear=" + testyear
				+ ", AMKA=" + AMKA + ", infected=" + infected +"\n";	
	}
	//getters and setters//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;

	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getTestday() {
		return testday;
	}
	public void setTestday(int testday) {
		this.testday = testday;
	}
	public int getTestmonth() {
		return testmonth;
	}
	public void setTestmonth(int testmonth) {
		this.testmonth = testmonth;
	}
	public int getTestyear() {
		return testyear;
	}
	public void setTestyear(int testyear) {
		this.testyear = testyear;
	}
	public int getAMKA() {
		return AMKA;
	}
	public void setAMKA(int aMKA) {
		AMKA = aMKA;
	}
	public boolean isInfected() {
		return infected;
	}
	public void setInfected(boolean infected) {
		this.infected = infected;
	}
	
	public void setDepartmentDate(String date) {
		departmentDate = date;
	}
	
	public String getDepartmentDate() {
		return departmentDate;
	}
}

