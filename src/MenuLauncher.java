import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLauncher {

	public static void main(String args[]) {
		// creation of Hospital objects for all the Hospitals that have Icus in Greece
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
				Hospital hosp19 = new Hospital("Γενικό Νοσοκομείο Καλαμάτας", 11,"Καλαμάτα");
				Hospital hosp20 = new Hospital("Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης", 9, "Αλεξανδρούπολη");
				Hospital hosp21 = new Hospital("Σισμανόγλειο", 16, "Κομοτηνή");
				// end of creation
		
		Gui.graph();
		Scanner sc= new Scanner(System.in);
		boolean bol = false;
		int x;
			
			System.out.print("Give [1] = ");
			
				x =  sc.nextInt();
				switch(x) {
				case 1 :
					
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
					for(int i=0;i<Person.personlist.size();i++) {
						System.out.print(Person.personlist.get(i));
					}
				      break;  
				case 2: Person.addPers();
				case 3:
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
					for(int i=0;i<Hospital.entrancedPerson.size();i++) {
						System.out.print(Hospital.entrancedPerson.get(i));
					}
				      break;
				   
				case 4:
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
			            return;
			        } 
			        catch (ClassNotFoundException c) 
			        {
			            System.out.println("Class not found");
			            c.printStackTrace();
			            return;
			        }
					for(int i=0;i<Hospital.deadPerson.size();i++) {
						System.out.print(Hospital.deadPerson.get(i));
					}
				      break;
					
				case 5:
					try
			        {
			            FileInputStream fis = new FileInputStream("alivePerson");
			            ObjectInputStream ois = new ObjectInputStream(fis);
			 
			            Hospital.alivePerson = (ArrayList) ois.readObject();
			 
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
					for(int i=0;i<Hospital.alivePerson.size();i++) {
						System.out.print(Hospital.alivePerson.get(i));
					}
				      break;
					
				   
	
	
	}
	}}
			

 	




