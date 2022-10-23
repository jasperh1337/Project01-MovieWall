package theMovieWall;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class sortingStuff {
	
	//not sure if needed because the files all work without

	public static ArrayList<String> sort(ArrayList<String> names) {
		//Using insertion sort to sort the array for optimal time & space complexity
		for(int i = 0; i<names.size(); i++) {
			String temp = names.get(i);
			int j = i - 1;
			while(j>=0 && (names.get(j)).value > temp.value) {
				names.set(j,  names.get(j-1));
				--j;
				}
				names.set(j, temp);
		}
	}
}
