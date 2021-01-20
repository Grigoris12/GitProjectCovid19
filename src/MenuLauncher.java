import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLauncher {

	public static void main(String args[]) {
		
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
				   
	
	
	}
	}}
			

 	




