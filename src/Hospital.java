public class Hospital {
	
	private String hospitalName, location;
	private int icu;
	private static int totalIcu = 0;
	private static Hospital[] hospitals = new Hospital[6];
	private static int count = 0;
	
	public Hospital(String hospitalName, int icu, String location) {
		hospitals[count] = this;
		count++;
		this.hospitalName = hospitalName;
		this.icu = icu;
		this.location = location;
		totalIcu += icu;	
	}

	public void showAvailability() {
		for(int i = 0 ; i < hospitals.length ; i++) {
			System.out.println("THe remaining Icus of the " +  hospitals[i].hospitalName + 
					 " are " + hospitals[i].icu);
		}
	}
}
	
