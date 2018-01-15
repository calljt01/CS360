import java.util.Date;

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
	
	public String toString(){
		return String.format("%d, %s, %s, (%.0f,%.0f)", siteNumber, name, location, latitude, longitude);
	}

	
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
	
	
	
	
	
}
