import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractice{
	public static void main(String args[]){

		/*
		** First task
		*/

		List <Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,1,2,3)); //Int's List
		System.out.println("list content : " + list); // Print int's list
		int num = list.stream().collect(Collectors.toSet()).size(); // get unique ints quantity
		System.out.println("Number of unique integers: " + num); // print quantity

		/*
		** Second task
		*/

		//create list of lists
		ArrayList<ArrayList<Boolean>> listOfLists = new ArrayList<ArrayList<Boolean>>();
		ArrayList<Boolean> firstList = new ArrayList<>(Arrays.asList(true, false, true, true, false)); //create 1
		ArrayList<Boolean> secondList = new ArrayList<>(Arrays.asList(false, false, true, true, true)); //create 2
		ArrayList<Boolean> thirdList = new ArrayList<>(Arrays.asList(true, true, true, false, false)); // create 3
		listOfLists.add(firstList); //add first list
		listOfLists.add(secondList); // add second list
		listOfLists.add(thirdList); // add third list
		System.out.println("Content of listOfLists: " + listOfLists);

	}
}