import java.util.ArrayList;
import java.util.Scanner;
public class Person {
	public static ArrayList<Person> personlist = new ArrayList<Person>();
	private String name;
	private String surname;
	private String age;
	private String gender;
	private String region;
	private int testday;
	private int testmonth;
	private int testyear;
	private int AMKA;
	boolean infected;

	public Person(String name, String surname, String age, String gender, String region, int testday,
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
	public static void addPerson() {
		Scanner sca = new Scanner(System.in);
		System.out.print("Give name = ");
		String n = sca.next();
		System.out.print("Give surname = ");
		String s = sca.next();
		System.out.print("Give age = ");
		String b = sca.next();
		System.out.print("Give gender = "); 
		String g = sca.next();
		System.out.print("Give region = ");
		String r = sca.next();
		System.out.print("Give test day = ");
		int d = sca.nextInt();
		System.out.print("Give test month = ");
		int m = sca.nextInt();
		System.out.print("Give test year = ");
		int y = sca.nextInt();
		System.out.print("Give AMKA = ");
		int a = sca.nextInt();
		System.out.print("You tested Posice or Negatice for covid-19(true/false) = ");
		boolean i = sca.nextBoolean();

		personlist.add(new Person(n , s, b, g, r, d, m, y, a, i));
		
	}
 
	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", region=" + region + ", testday=" + testday + ", testmonth=" + testmonth + ", testyear=" + testyear
				+ ", AMKA=" + AMKA + ", infected=" + infected +"\n";	
		
		
	}
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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
}
