import java.util.Scanner;

public class MenuLauncher {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		boolean bol = false;
		int x;
		//main menu //
		do {
			System.out.println("1. Sign-Up ");
			System.out.println("2. Covid Information");
			System.out.println("3. Log in (Hospital Manager only)");
			System.out.print("Give [1-3] ");
			try {
				x = sc.nextInt();
				switch(x) {
				case 1:
					Person.addPerson();
					break;

				case 2:
					for(int i=0;i<Person.personlist.size();i++)
						System.out.print(Person.personlist.get(i));
					break;

				case 3:
					System.out.println("Give Password = ");
					int p = sc.nextInt();
					if(p==104) {
						System.out.println("Correct Pasword");
					}
				}

			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error,Try Again"); 

			}

		}while(bol==false);
		sc.close();



	}


}



