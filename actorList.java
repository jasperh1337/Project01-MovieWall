package theMovieWall;

import java.util.ArrayList;

public class actorList {

	//holds the list of actors we pull from the readTheCSV class into a list
	protected ArrayList<String> actorName;
	protected ArrayList<Actor> allActors;
	protected ArrayList<String> index;

	//make method that loops movie, create another loop that iterates the actors in the movie
	public void addActor(movieList theList) {
		
		for(int i = 0; i<theList.getMovieLength(); i++) {
			Movie currM = theList.allMovies.get(i);
			
			for(int j = 0; j<currM.getActorSize(); j++) {
				String currA = currM.actor.get(j);
				String currC = currM.movieCharacter.get(j);
	
				int searchActor = BinarySearch.ActorSearch(actorName, currA);
				
				if((searchActor < 0)) { 
				//this is when we do not find a match in our binary search
				//So we add a new actor into our list
					Actor newA = new Actor();
					newA.setName(currA);
					
					//version 1
					newA.setMovieCharacter(currC);
					newA.setMovieParticipated(currM.movieTitle);
					
					//version 2 for this 
					//newA.setMovieDetails(currM.movieTitle, currC);
					
					
					allActors.add(newA);
					
					//adding to the index so we can search it later
					index.add(currA); 
					
					addNewActor(currA);					
				}
				else {
					//adding additional movies and characters into the actor object which then gets added to the list
					int count = index.indexOf(actorName.get(searchActor));
					allActors.get(count).setMovieParticipated(currM.movieTitle);
					allActors.get(count).setMovieCharacter(currC);
				}
			}
		}
	}
	
	public void addNewActor(String theActor) {
		int checker = BinarySearch.ActorSearch(actorName, theActor);
		if(checker < 0) { //just so we can work with the function instead of having negative values
			checker *= -1;
		}
		//this is when the list is brand new w/o inputs
		if(actorName.isEmpty()) {
			actorName.add(0, theActor);
		}
		//basically compares the first element in the list, if not a match, we slot in the new actor in the 0 index
		else if(theActor.compareTo(actorName.get(0))<0) {
			actorName.add(0, theActor);
		}
		//throws the actor into the index
		else {
			actorName.add(checker,theActor);
		}
	}
}
