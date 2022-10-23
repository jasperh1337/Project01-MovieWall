package theMovieWall;

import java.util.ArrayList;

public class Movie {
	//movie object class
	
	String movieTitle;
	ArrayList<String> actor;
	ArrayList<String> movieCharacter;
	
	//sets general movie detail characteristics
	public void setMovieTitle(String title) {
		movieTitle = title;
	}
	
	public void setActor(ArrayList<String> name) {
		actor = name;
	}
	
	public void setMovieCharacter(ArrayList<String> character) {
		movieCharacter = character;
	}
	
	public int getActorSize() {
		return actor.size();
		//have to create locally because it wasn't working by using a direct code in the actorlist file
	}
	
	
}
