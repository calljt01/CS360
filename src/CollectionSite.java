import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 *Manages the creation of 'Collection Site' objects
 */
public class CollectionSite implements Comparable<CollectionSite>{
	/*
	 * Necessary information
	 */
	private int siteNumber;
	private String name, location, lastAccessed;
	private double latitude, longitude;
	SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	
	
	/*
	 * Two constructors. One with last accessed date and one without
	 * since the date is not necessary.
	 */
	public CollectionSite(int siteNumber, String name, String location, double latitude, double longitude) {
		this.siteNumber = siteNumber;
		this.name = name;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public CollectionSite(int siteNumber, String name, String location, double latitude, double longitude,
			String lastAccessed) {
		this.siteNumber = siteNumber;
		this.name = name;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.lastAccessed = lastAccessed;
	}

	/*
	 * Getters and setters
	 */
	public int getSiteNumber() {
		return siteNumber;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getLastAccessed() {
		return lastAccessed;
	}
	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setLastAccessed(String lastAccessed) {
		this.lastAccessed = lastAccessed;
	}
	
	/*
	 * Returns String value of collection site data
	 */
	public String toString(){
		return String.format("%d, %s, %s, (%.0f,%.0f)", siteNumber, name, location, latitude, longitude);
	}
	
	/*
	 * Compares two collection sites by comparing the site number
	 * returns 0 if the two objects are equal, or 1, -1 if the site
	 * number is less than or greater than
	 */
	@Override
	public int compareTo(CollectionSite o) {
		if (this.siteNumber < o.getSiteNumber()){
			return -1;
		} else if (this.siteNumber == o.getSiteNumber()){
			return 0;
		} else {
			return 1;
		}
	}
	
	public boolean hadRecentCheck(){
		Date today = Calendar.getInstance().getTime();
		if (lastAccessed.equals(null)){
			return false;
		}
		try {
		    Date date = myFormat.parse(lastAccessed);
		    long diff = today.getTime() - date.getTime();
		    if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) <= 30){
		    	return true;
		    } else {
		    	return false;
		    }
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return false;
	}
}
