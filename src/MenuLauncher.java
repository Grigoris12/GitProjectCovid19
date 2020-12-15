import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLauncher {

	public static void main(String[] args) {

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
					if(p==14) {
						System.out.println("Correct Pasword");
						break;
					}
				case 4:
					
					for(int i=0;i<Person.personlist.size();i++)
						System.out.print(Person.personlist.get(i));
				      break; 
				case 5:
					System.out.println("hi");
					
				}

			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error,Try Again "); 

			}

		}while(bol==false);
		sc.close();



	}


}



