import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLauncher {

	public static void main(String[] args) {
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
		
		
		Scanner sc= new Scanner(System.in);
		boolean bol = false;
		int x;
		
		do {
			
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
					System.out.println("Give Password = ");
					int p = sc.nextInt();
					Scanner scanner = new Scanner(System.in);
					if(p==104) {
						System.out.println("Correct Pasword...");
						System.out.println("Insert AMKA to find the person you want : ");
						int AMKA = sc.nextInt();
						for (Person person : Person.personlist) {
							if (person.getAMKA() == AMKA ) {
								System.out.println("Press 1 through 3 to choose the following or anything "
										+ "else to stop the procedure...  ");
								System.out.println("1) Is there a new case that needs icu?");
								System.out.println("2) Is there a new Icu open?");
								System.out.println("3) Show the availabilty of the Icus of all the hospitals.");
								int choice = scanner.nextInt();
								switch (choice) {
									// add of a covid-19 case to the icu
									case 1 :
										System.out.println("Does the patience need icu?");
										boolean managerDecision = sc.hasNext();
										Hospital.icuUpdate(person, managerDecision);
										System.out.println("The addition has been successful!!");
										break;
									// end of the addition
									// deleting-extracting a case from the icu - new icu-space	
									case 2 :
											System.out.println("What is the current situation of the case: alive or dead;");
											String status = sc.nextLine();
											Hospital.icuExtraction(person, status);
											System.out.println("The extraction has been successful!!");
										break;
										// end of extraction	
									case 3 :
										Hospital.showAvailability();
										break;
										// end of showing availity			
								}
								break;
							}
						}
					}
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
					boolean flag = false ; 
					while ( flag = false) {
						if (n.equals(hosp1.getHospitalName())) {
							System.out.println("The website of Hospital Σωτηρία is http://www.sotiria.gr/");
							flag = true;
						}else if  (n.equals(hosp2.getHospitalName())) {
							System.out.println("The website of Hospital Γ.Γεννηματά is http://www.gna-gennimatas.gr/");
							flag = true;
						}else if  (n.equals(hosp3.getHospitalName())) {
							System.out.println("The website of Hospital Αττικόν is http://www.attikonhospital.gr/ ");
							flag = true;
						}else if  (n.equals(hosp4.getHospitalName())) {
							System.out.println("The website of Hospital Βουγιουκλάκειο  is https://vougiouklakio.gr/web/");
							flag = true;
						}else if  (n.equals(hosp5.getHospitalName())) {
							System.out.println("The website of Hospital ΚΑΤ  is https://www.kat-hosp.gr/");
							flag = true;
						}else if  (n.equals(hosp6.getHospitalName())) {
							System.out.println("The website of Hospital Ευαγγελισμός is https://www.evaggelismos-hosp.gr/ ");
							flag = true;
						}else if  (n.equals(hosp7.getHospitalName())) {
							System.out.println("The website of Hospital Ιπποκράτειο is http://www.ippokratio.gr/ ");
							flag = true;
						}else if  (n.equals(hosp8.getHospitalName())) {
							System.out.println("The website of Hospital ΑΧΕΠΑ  is http://www.ahepahosp.gr/ ");
							flag = true;
						}else if  (n.equals(hosp9.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Δημήτριος is http://www.oagiosdimitrios.gr/");
							flag = true;
						}else if  (n.equals(hosp10.getHospitalName())) {
							System.out.println("The website of Hospital Γ.Γεννηματά Θεσσαλονίκης is http://www.gennimatas-thess.gr/ ");
							flag = true;
						}else if  (n.equals(hosp11.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Λουκάς is http://www.klinikiagiosloukas.gr/ ");
							flag = true;
						}else if  (n.equals(hosp12.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Γεώργιος is http://www.chaniahospital.gr/ ");
							flag = true;
						}else if  (n.equals(hosp13.getHospitalName())) {
							System.out.println("The website of Hospital Γενικό Νοσοκομείο Λάρισας  is http://www.uhl.gr/ ");
							flag = true;
						}else if  (n.equals(hosp14.getHospitalName())) {
							System.out.println("The website of Hospital ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο is http://www.ghl.gr/gnl.php ");
							flag = true;
						}else if  (n.equals(hosp15.getHospitalName())) {
							System.out.println("The website of Hospital Άγιος Ανδρέας is http://www.agandreashosp.gr/");
							flag = true;
						}else if  (n.equals(hosp16.getHospitalName())) {
							System.out.println("The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο  is https://www.pgnp.gr/");
							flag = true;
						}else if  (n.equals(hosp17.getHospitalName())) {
							System.out.println("The website of Hospital ΧΑΤΖΗΚΩΣΤΑ  is https://www.gni-hatzikosta.gr/");
							flag = true;
						}else if  (n.equals(hosp18.getHospitalName())) {
							System.out.println("The website of Hospital Πανεπιστημιακό Νοσοκομείο Ιωαννίνων  is https://www.uhi.gr/ ");
							flag = true;
						}else if  (n.equals(hosp19.getHospitalName())) {
							System.out.println("The website of Hospital ΕΚΑΒis https://www.nosokomeiokalamatas.gr/");
							flag = true;
						}else if  (n.equals(hosp20.getHospitalName())) {
							System.out.println("The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης is https://pgna.gr/ ");
							flag = true;
						}else if  (n.equals(hosp21.getHospitalName())) {
							System.out.println("The website of Hospital Σισμανόγλειο is http://www.komotini-hospital.gr/ ");
							flag = true;
						} else if (n.equals("end")) {
							flag = true;
						}else {
							System.out.println("Please type the name of the hospital again");
							n = sc.nextLine();
						}
					}
					System.out.println("Thank you for your coperation!");
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
} 	




