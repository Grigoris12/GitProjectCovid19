import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
	private String belongingHospital = null;
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
		personlist.add(this);
	}

	public static void addPers() {

		File f = new File("persondata");
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	public void setBelongingHospital(String hospital) {
		belongingHospital = hospital;
	}

	public String getBelongingHospital() {
		return belongingHospital;
	}
}
