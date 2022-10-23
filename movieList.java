package theMovieWall;

import java.util.ArrayList;

public class movieList {
	//List class that holds all the movies in a separate section for organization
	
	protected ArrayList<Movie> allMovies = new ArrayList<Movie>();
	
	public void addMovie(Movie m) {
		allMovies.add(m);
	}
	
	public int getMovieLength() {
		return allMovies.size();
	}
}
