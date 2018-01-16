import java.util.ArrayList;

/*
 * Manages a list of collection sites
 */
public class CollectionSiteList {
	
	private ArrayList<CollectionSite> CSL;
	
	
	public CollectionSiteList(){
		CSL = new ArrayList<CollectionSite>();
	}
	
	/*
	 * Will check to see if the site already exists, if it doesn't
	 * it will add the new site to the list
	 */
	public void add(CollectionSite CS){
		if (!exists(CS)){
			CSL.add(CS);
		}
	}
	
	/*
	 * Removes the site from the list
	 */
	public void remove(CollectionSite CS){
		CSL.remove(CS);
	}

	
	/*
	 * Uses the Arraylist sort.
	 * The Arraylist sort uses the CollectionSite compareTo 
	 * method to sort the list from smaller to larger site numbers
	 */
	public void sort(){
		CSL.sort(null);
	}
	
	/*
	 * Overloaded Exists method is used to check to see if there are 
	 * already instances of a specific name, number, or CollectionSite object
	 */
	public boolean exists(String name){
		for (int i= 0; i < CSL.size(); i++){
			if (name.equals(CSL.get(i).getName())){
				return true;
			}
		}
		return false;
	}
	public boolean exists(int siteNumber){
		for (int i= 0; i < CSL.size(); i++){
			if (siteNumber == (CSL.get(i)).getSiteNumber()){
				return true;
			}
		}
		return false;
	}
	public boolean exists(CollectionSite CS){
		for (int i= 0; i < CSL.size(); i++){
			if (CS.compareTo(CSL.get(i)) == 0){
				return true;
			}
		}
		return false;
	}

	public CollectionSite get(int siteNumber){
		for (int i= 0; i < CSL.size(); i++){
			if (siteNumber == (CSL.get(i)).getSiteNumber()){
				return CSL.get(i);
			}
		}
		return null;
	}
	
	public int size(){
		return CSL.size();
	}
	
	/*
	 * Returns the String value of each CollectionSite on a new line
	 */
	public String toString(){
		String text = "";
		for (int i = 0; i < CSL.size(); i++){
			text += CSL.get(i).toString() + "\n";
		}
		return text;
	}
	
}
