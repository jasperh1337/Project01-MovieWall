package theMovieWall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class readTheCSV {
	
	public static void readingCSV(String file, movieList m) {
		//adding movie titles into an array and assembling the components
		try {
			BufferedReader br = new BufferedReader((new FileReader(file))); 
			String line;
			line = br.readLine(); //will skip the header i.e. title id, title, cast, crew
//			line = br.readLine();
			String[] movieTitles = null;			 
			while((line != null)) {
				if (line.contains("title")) { 
					continue;
					//used as a check to make sure we got are grabbing the titles
				}  
				movieTitles = line.split(",");
				
				ArrayList<String> actorList = grabbingActor(line);
				ArrayList<String> characterList = grabCharacter(line);
				Movie movie = new Movie();
				movie.setMovieTitle(movieTitles[1]);
				movie.setMovieCharacter(characterList);
				movie.setActor(actorList);
				m.addMovie(movie);
				
				line = br.readLine();
			}
			
			br.close(); //closing the reader as per instructions
		}
		catch (Exception e){
			e.printStackTrace();
		//catching errors just incase something weird is inputed 
		}

	}
	
	public static ArrayList<String> grabCharacter(String line){
			ArrayList<String> movieCharacterList = new ArrayList<String>();				
			//replacing all the JSON stuff...
			line = line.replaceAll(",", "").replace("{", "").replace("}", "").replace("\"\"","");
			String[] row = line.split(",");
			//adds characters into the movie character list which will be adapted in other functions
			for(int i=0;i<row.length;i++) {
				if(row[i].equals("character :")) { //will insure that we are adding characters into the list and not other names
					movieCharacterList.add(row[i]);
				}
			}
		return movieCharacterList;
	}
	
	
	public static ArrayList<String> grabbingActor(String line){
		//copied the same method from grabCharacter, changed variable names for actor
		ArrayList<String> actorNameList = new ArrayList<String>();
		line = line.replaceAll(",", "").replace("{", "").replace("}", "").replace("\"\"","|");
		String[] row = line.split("|");
		//adding actor names into an array
		for(int i = 0; i<row.length; i++) {
			if(row[i].equals("name :")) {
				actorNameList.add(row[i]);
			}
		}
		return actorNameList;
	}
}
