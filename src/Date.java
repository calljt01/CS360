
public class Date {
	private String month;
	private String day;
	private String year;
	private String date;
	
	public Date(String month, String day, String year){
		this.month = month;
		this.day = day;
		this.year = year;
		date = month + "/" + day + "/" + year;
	}
	
	public String getDate(){
		return date;
	}
}
