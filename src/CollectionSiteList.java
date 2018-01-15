import java.util.ArrayList;

public class CollectionSiteList {
	private ArrayList<CollectionSite> CSL;
	
	
	public CollectionSiteList(){
		CSL = new ArrayList<CollectionSite>();
	}
	
	public void add(CollectionSite CS){
		if (!exists(CS)){
			CSL.add(CS);
		}
	}
	
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
	
	public void remove(CollectionSite CS){
		CSL.remove(CS);
	}
	
	public void sort(){
		CSL.sort(null);
	}
	
	public String toString(){
		String text = "";
		for (int i = 0; i < CSL.size(); i++){
			text += CSL.get(i).toString() + "\n";
		}
		return text;
	}
	
	
	
	
}
