import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * Creates a list of CollectionSites from data read from a file
 */
public class CollectionSiteReader {
	
	/*
	 * Reads each line from a file, creates a CollectionSite object, and saves
	 * the objects to a CollectionSiteList, and returns the list
	 */
	public CollectionSiteList readDataFromCSV(String fileName){
		CollectionSiteList data = new CollectionSiteList();
		Path pathToFile = Paths.get(fileName);
		
		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
			br.readLine();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] attributes = line.split(",");
				CollectionSite d = createData(attributes);
				data.add(d);
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return data;
	}
	
	/*
	 * Creates a CollectionSite object from an array of necessary data
	 */
	private static CollectionSite createData(String[] metadata) {
		int siteNumber = Integer.parseInt(metadata[0]);
		double longitude = Double.parseDouble(metadata[1]);
		double latitude = Double.parseDouble(metadata[2]);
		String location = metadata[3];
		String name = metadata[4];
		
		return new CollectionSite(siteNumber, name, location, latitude, longitude);
	}
}