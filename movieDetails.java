package theMovieWall;

public class movieDetails {

	//should store the actor's movies and characters in the movies
	String actorMovie;
	String actorMovieCharacter;
	
	public void setMovieIn(String theMovie) {
		actorMovie = theMovie;
	}
	public void setCharacterIn(String theCharacter) {
		actorMovieCharacter = theCharacter;
	}
	
	
	//all of these are optional, tried this method but running into errors that I can't figure out
	public void getMovie() {
		return actorMovie;
	}
	
	public void getCharacter() {
		return actorMovieCharacter;
	}
	
	public void pullMovieDetails(int i) {
		System.out.println(getMovie() + " as " + getCharacter());
	}
}
