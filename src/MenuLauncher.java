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
		
		//Hospital.hospitalMenu();

		Gui.graph();
		Scanner sc= new Scanner(System.in);
		boolean bol = false;
		int x;
		do {

			System.out.println("********MainMenu********"); 
			System.out.println("1. Sign-Up ");
			System.out.println("2. Covid Information");
			System.out.println("3. Log in  (Hospital Manager only)");
			System.out.println("4. Information about the hospitals");
			System.out.println("default ");
			System.out.print("Give [1-4] = ");
			try {
				x =  sc.nextInt();
				switch(x) {
				case 1:
				
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
					Person.addPerson();
                     break;
				case 2:
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
					CovidInformation.menu();
					break; 
				case 3:
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
				//	Hospital.hospitalMenu();
					
				break; 
				case 4:
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
					Hospital.showAvailability();
					System.out.println("For more information about the hospitals that have Icus in Greece");
					System.out.println("please type the name of the hospital that your are looking for else type end to exit:");
					String n = sc.nextLine();
					n = sc.nextLine();

						if (n.equals(hosp1.getHospitalName())) {
							System.out.println("The website of Hospital Σωτηρία is http://www.sotiria.gr/");

						}else if  (n.equals(hosp2.getHospitalName())) {
							System.out.println("The website of Hospital Γ.Γεννηματά is http://www.gna-gennimatas.gr/");

						}else if  (n.equals(hosp3.getHospitalName())) {
							System.out.println("The website of Hospital Αττικόν is http://www.attikonhospital.gr/ ");

						}else if  (n.equals(hosp4.getHospitalName())) {
							System.out.println("The website of Hospital Βουγιουκλάκειο  is https://vougiouklakio.gr/web/");
						}else if  (n.equals(hosp5.getHospitalName())) {
							System.out.println("The website of Hospital ΚΑΤ  is https://www.kat-hosp.gr/");
						}else if  (n.equals(hosp6.getHospitalName())) {
							System.out.println("The website of Hospital Ευαγγελισμός is https://www.evaggelismos-hosp.gr/ ");
						}else if  (n.equals(hosp7.getHospitalName())) {
							System.out.println("The website of Hospital Ιπποκράτειο is http://www.ippokratio.gr/ ");

						}else if  (n.equals(hosp8.getHospitalName())) {
							System.out.println("The website of Hospital ΑΧΕΠΑ  is http://www.ahepahosp.gr/ ");

						}else if  (n.equals(hosp9.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Δημήτριος is http://www.oagiosdimitrios.gr/");

						}else if  (n.equals(hosp10.getHospitalName())) {
							System.out.println("The website of Hospital Γ.Γεννηματά Θεσσαλονίκης is http://www.gennimatas-thess.gr/ ");

						}else if  (n.equals(hosp11.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Λουκάς is http://www.klinikiagiosloukas.gr/ ");

						}else if  (n.equals(hosp12.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Γεώργιος is http://www.chaniahospital.gr/ ");

						}else if  (n.equals(hosp13.getHospitalName())) {
							System.out.println("The website of Hospital Γενικό Νοσοκομείο Λάρισας  is http://www.uhl.gr/ ");

						}else if  (n.equals(hosp14.getHospitalName())) {
							System.out.println("The website of Hospital ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο is http://www.ghl.gr/gnl.php ");

						}else if  (n.equals(hosp15.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Ανδρέας is http://www.agandreashosp.gr/");

						}else if  (n.equals(hosp16.getHospitalName())) {
							System.out.println("The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο  is https://www.pgnp.gr/");

						}else if  (n.equals(hosp17.getHospitalName())) {
							System.out.println("The website of Hospital ΧΑΤΖΗΚΩΣΤΑ  is https://www.gni-hatzikosta.gr/");

						}else if  (n.equals(hosp18.getHospitalName())) {

						}else if  (n.equals(hosp19.getHospitalName())) {
							System.out.println("The website of Hospital ΕΚΑΒis https://www.nosokomeiokalamatas.gr/");

						}else if  (n.equals(hosp20.getHospitalName())) {
							System.out.println("The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης is https://pgna.gr/ ");

						}else if  (n.equals(hosp21.getHospitalName())) {
							System.out.println("The website of Hospital Σισμανόγλειο is http://www.komotini-hospital.gr/ ");

						} else if (n.equals("end")) {
							System.out.println("Thank you for your coperation!");
						}

					break; 
				case 5 :
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
					for(int i=0;i<Person.personlist.size();i++) {
						System.out.print(Person.personlist.get(i));
					}
				      break; 
				   
				case 6 :
					bol = true;
				
				}

			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error,Try Again "); 
			}

		}while(bol==false);

		System.out.println("Thank you");
		sc.close();
	
	}
}

 	




