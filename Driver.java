package theMovieWall;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//File file = new File("C:\\Users\\bo2cr\\Desktop\\tmdbcredits.csv"); //input the CSV link on the local computer if the bottom code isn't working
		String file = args[1]; //to make user file input easier, if it fails, use above to run code
		movieList movieList = new movieList();
		readTheCSV.readingCSV(file, movieList);
		actorList actorList = new actorList();
		actorList.addActor(movieList);
		ArrayList<String> actorNames = actorList.actorName;
		
		//actorNames = sortingStuff.sort(actorNames); //this is wholy optional to try to optimize search times but having issues with sorting algorithm
		System.out.println("Welcome to the Movie Wall!");
		
		//setting up Scanner for user inputs
		Scanner sc = new Scanner(System.in);
		
		boolean key = true;
		
		while(key == true) {
			System.out.println("Enter the name of an actor or 'EXIT' to quit: ");
			String userInput = sc.nextLine();
			int userSearch = BinarySearch.ActorSearch(actorNames, userInput);
			
			//for when exiting the program, I got three exits to take care of case sensitivity
			if(userInput.equals("EXIT") || userInput.equals("Exit") || userInput.equals("exit")) {
				System.out.println("You are now leaving the Movie Wall. Thank you.");
				key = false;
			}
			//if the input matches list and they did not say exit
			else if(userInput != "Exit" || userInput != "exit" || userInput != "EXIT") {
				if(userSearch > 0) {
					System.out.println("Actor : " + userInput);
					int index = actorList.index.indexOf(actorNames.get(userSearch));
					actorList.allActors.get(index).pullDetails();
				}
			}
			//if the input does not match our list
			else {
				int nameSuggest = userSearch;
				if(nameSuggest < 0) {
					nameSuggest*=-1; //will make sure we have a positive index value
				}
				System.out.print("There is no actor with the name: " + userInput + "Did you mean: " + actorNames.get(nameSuggest) + " Y/N: ");
				userInput = sc.nextLine();
				
				if(userInput.equals("Y")) {
					int index = actorList.index.indexOf(actorNames.get(nameSuggest));
					actorList.allActors.get(index).pullDetails();
				}
			}
			userInput = sc.nextLine();
		}
		System.out.println("Thanks for visiting the Movie Wall!");
		sc.close();
		
		return;
	}

}
