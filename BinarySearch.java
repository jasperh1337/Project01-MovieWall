package theMovieWall;

import java.util.ArrayList;

public class BinarySearch {
	
	//adapted from lab 3, searches for the actor we need
	
	public static int ActorSearch(ArrayList<String> item, String target) {
		return Searcher(item, target, 0, item.size()-1);
	}
		
	public static int Searcher(ArrayList<String> item, String target, int min, int max) {
	    int mid = (max + min)/2; //using mid to make this binary search
	    
	    if(min > max ) {
	    	return -(mid+1); //so that the actor isn't there, means we have a new actor, give negative value
	    }
	    if(item.get(mid).compareTo(target) == 0) {
	    	return mid;
	    }
	    else if(item.get(mid).compareTo(target) < 0) {
	    	return Searcher(item, target, mid+1, max); 
	    	//This cuts the list in half and mid replaces left, recurse the function
	    }
	    else { //basically if our mid value is greater than the target
	    	return Searcher(item, target, min, mid-1);

	    }
	}

}
