import java.util.Scanner;

public class MenuLauncher {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		//System.out.println(Person.personlist);
		//System.out.println(Person.personlist.get(0).getGender());
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
				if((x>=1)&&(x<=3)) {
					if(x==1) {

						Person.addPerson();

					} else if(x==2) {


					}
					else if(x==3) {
						System.out.println("Give Password = ");
						int p = sc.nextInt();
						if(p==1044932) {
							System.out.println("Correct Pasword");
						}
					}
				} else if((x<1)||(x>3)) {
					System.out.println("Try again");
				}
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error,Try Again"); 

			}

		}while(bol==false);
		sc.close();
		
		
            
	}


}

