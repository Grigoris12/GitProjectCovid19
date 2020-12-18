import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLauncher {

	public static void main(String[] args) {
    	creationOfHospitals();

		Scanner sc= new Scanner(System.in);
		boolean bol = false;
		int x;
		//main menu //
		do {
			//Deserialize list//
			try
	        {
	            FileInputStream fis = new FileInputStream("persondata");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            Person.personlist = (ArrayList) ois.readObject();
	 
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
			
			System.out.println("********MainMenu********"); 
			System.out.println("1. Sign-Up ");
			System.out.println("2. Covid Information");
			System.out.println("3. Log in  (Hospital Manager only)");
			System.out.print("Give [1-3] = ");
			try {
				x =  sc.nextInt();
				switch(x) {
				case 1:
					Person.addPerson();
					break;

				case 2:
					CovidInformation.menu();
					break;
				case 3:
					System.out.println("Give Password = ");
					int p = sc.nextInt();
					if(p==104) {
						System.out.println("Correct Pasword...");
						System.out.println("Insert AMKA to find the person you want : ");
						int AMKA = sc.nextInt();
						System.out.print("Press a through c to choose the following or anything "
								+ "else to stop the procedure... \n ");
						String choice = sc.nextLine();
						System.out.println("a) Is there a new case that needs icu?");
						System.out.println("b) Is there a new Icu open?");
						System.out.println("c) Show the availabilty of the Icus of all the hospitals.");
						switch (choice) {
						// add of a covid-19 case to the icu
						case "a" :
							for (Person person : Person.personlist) {
								if (person.getAMKA() == AMKA ) {
									Hospital.icuUpdate(person);
									break;	
								}
							}
							System.out.println("The addition has been successful!!");
							break;
						// end of the addition
						// deleting-extracting a case from the icu - new icu-space	
						case "b" :
							for (Person person : Person.personlist) {
								if (person.getAMKA() == AMKA ) {
									System.out.println("What is the current situation of the case: alive or dead;");
									String status = sc.nextLine();
									Hospital.icuExtraction(person, status);
									break;
								}
								System.out.println("The extraction has been successful!!");
							}
							break;
						// end of extraction	
						case "c" :
							Hospital.showAvailability();
							break;
						// end of showing availity		
						}	
						break;
					}
				case 4:
					
					for(int i=0;i<Person.personlist.size();i++)
						System.out.print(Person.personlist.get(i));
				      break; 
				
				}

			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error,Try Again "); 

			}

		}while(bol==false);
		sc.close();



	}
  	public static void creationOfHospitals() {
		Hospital hosp1 = new Hospital("Σωτηρία", 122, "Αθήνα");
		Hospital hosp2 = new Hospital("Γ.Γεννηματά", 57, "Αθήνα");
		Hospital hosp3 = new Hospital("Αττικόν", 47, "Αθήνα");
		Hospital hosp4 = new Hospital("Βουγιουκλάκειο", 36, "Αθήνα");
		Hospital hosp5 = new Hospital("ΚΑΤ", 60, "Αθήνα");
		Hospital hosp6 = new Hospital("Ευαγγελισμός", 32, "Αθήνα");
		Hospital hosp7 = new Hospital("Ιπποκράτειο", 97, "Θεσσαλονίκη");
		Hospital hosp8 = new Hospital("ΑΧΕΠΑ", 66, "Θεσσαλονίκη");
		Hospital hosp9 = new Hospital("Άγιος Δημήτριος", 22, "Θεσσαλονίκη");
		Hospital hosp10 = new Hospital("Γ.Γεννηματά Θεσσαλονίκης", 46, "Θεσσαλονίκη");
		Hospital hosp11 = new Hospital("Άγιος Λουκάς", 21, "Θεσσαλονίκη");
		Hospital hosp12 = new Hospital("Άγιος Γεώργιος", 33, "Χανιά");
		Hospital hosp13 = new Hospital("Γενικό Νοσοκομείο Λάρισας", 17, "Λάρισα");
		Hospital hosp14 = new Hospital("ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο", 27, "Λάρισα");
		Hospital hosp15 = new Hospital("Άγιος Ανδρέας", 33, "Πάτρα");
		Hospital hosp16 = new Hospital("Πανεπιστημιακό Γενικό Νοσοκομείο", 28, "Πάτρα");
		Hospital hosp17 = new Hospital("ΧΑΤΖΗΚΩΣΤΑ", 43, "Ιωάννινα");
		Hospital hosp18 = new Hospital("Πανεπιστημιακό Νοσοκομείο Ιωαννίνων", 12, "Ιωάννινα");
		Hospital hosp19 = new Hospital("ΕΚΑΒ", 11,"Καλαμάτα");
		Hospital hosp20 = new Hospital("Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης", 9, "Αλεξανδρούπολη");
		Hospital hosp21 = new Hospital("Σισμανόγλειο", 16, "Κομοτηνή");
	}


}




