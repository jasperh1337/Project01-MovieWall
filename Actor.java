package theMovieWall;

import java.util.ArrayList;

public class Actor {
	//actor object class, has the actor's name and all the movies and characters he was in
	String name;
	ArrayList<String> moviesParticipated;
	ArrayList<String> movieCharacter;
	
	ArrayList<movieDetails> d; //trying to create a list that holds 2 attributes in each element, not working so used above lists

	
	public void setName(String theName) {
		name = theName;
	}
	
	public void setMovieParticipated(String theTitle) {
		moviesParticipated.add(theTitle);
	}
	
	public void setMovieCharacter(String theCharacter) {
		movieCharacter.add(theCharacter);
	}
	
	public void setMovieDetails(String theTitle, String theCharacter) {
		movieDetails md = new movieDetails();
		md.setMovieIn(theTitle);
		md.setCharacterIn(theCharacter);
		d.add(md);
	}
	
	public void pullDetails() {
		for(int i =0; i<moviesParticipated.size(); i++) {
			//for first version
			System.out.println("* Movie: " + moviesParticipated.get(i) + " as " + movieCharacter.get(i));
		}
		
		//attempted to use movieDetails, failed
//		for(int i =0; i<d.size(); i++) {
//			System.out.println("* Movie " + movieDetails.pullMovieDetails(i));
//		}
		
	}

}
