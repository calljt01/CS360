
	/*
	 * A simple date object that creates a string format of a date
	 */
public class Date {

	private String date;
	
	public Date(String month, String day, String year){
		date = month + "/" + day + "/" + year;
	}
	
	public String getDate(){
		return date;
	}
}
