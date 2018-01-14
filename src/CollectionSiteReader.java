import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CollectionSiteReader {
	
	public static void main(String[] args){
		List<CollectionSiteData> data = readDataFromCSV("sample-sites.csv");
		
		for(CollectionSiteData d : data) {
			System.out.println(d);
		}
	}
	
	private static List readDataFromCSV(String fileName){
		List<CollectionSiteData> data = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
			br.readLine();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] attributes = line.split(",");
				CollectionSiteData d = createData(attributes);
				data.add(d);
				line = br.readLine();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return data;
	}
	private static CollectionSiteData createData(String[] metadata) {		
		int siteNumber = Integer.parseInt(metadata[0]);
		double longitude = Double.parseDouble(metadata[1]);
		double latitude = Double.parseDouble(metadata[2]);
		String location = metadata[3];
		String name = metadata[4];
		
		return new CollectionSiteData(siteNumber, longitude, latitude, location, name);
	}
}
class CollectionSiteData {
	private int siteNumber;
	private String name, location;
	private double latitude, longitude;
	
	public CollectionSiteData(int siteNumber, double longitude, double latitude, String location, String name) {
		this.siteNumber = siteNumber;
		this.name = name;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String toString() {
		return "Data [siteNumber=" + siteNumber + ", Name=" + name + ", Location=" + location + ", Latitude=" + latitude + ", Longitude=" + longitude + "]";
	}
}
