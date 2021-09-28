/** This program starts with two identical bags.
 * Then bag1 will go through multiple test. After
 * that, bag1 and bag2 will be compared with union
 * intersection, and difference.
 * 
 * @author Brandon Leho, Brandon Lequang, Sean Soloman
 */
import java.util.Arrays;

public class LinkedBagTest 
{
	public static void main(String[] args)
	{
		//This creates brand new bags called bag1 and bag2.
		BagInterface<String> bag1 = new LinkedBag<>();
		BagInterface<String> bag2 = new LinkedBag<>();

		//This adds strings into both bag1 and bag2.
		bag1.add("A");
		bag1.add("C");
		bag1.add("D");
		bag1.add("E");
		bag1.add("D");
		bag1.add("F");
		
		bag2.add("A");
		bag2.add("C");
		bag2.add("D");
		bag2.add("E");
		bag2.add("D");
		bag2.add("F");
		
		//These are the options of prompts that the system asks the user.
		System.out.println("Is the bag empty?: " + bag1.isEmpty()); //This checks if the bag is empty.
		System.out.println("How many D's are in the bag?: " + bag1.getFrequencyOf("D")); //This checks how many D's are in the bag.
		System.out.println("Does the bag contain 'D'?: " + bag1.contains("D")); //This checks if the bag contains D.
		System.out.println("Removing the letter D...\n"); //This removes D from the bag.
		bag1.remove("D");
				
		//This adds more strings to the bag.
		System.out.println("Adding A D B A to your bag...\n");
		bag1.add("A");
		bag1.add("D");
		bag1.add("B");
		bag1.add("Z");
		bag1.add("G");
				
		//This tests the updated arrays, checking what it has.
		System.out.println("Is the bag empty?: " + bag1.isEmpty());
		System.out.println("There are " + bag1.getFrequencyOf("A") + " A's in the bag.");
		System.out.println("There are " + bag1.getFrequencyOf("B") + " B's in the bag.");
		System.out.println("There are " + bag1.getFrequencyOf("C") + " C's in the bag.");
		System.out.println("There are " + bag1.getFrequencyOf("D") + " D's in the bag.");
		System.out.println("There are " + bag1.getFrequencyOf("Z") + " Z's in the bag.");
		System.out.println("Does the bag contain A?: " + bag1.contains("A"));
		System.out.println("Does the bag contain B?: " + bag1.contains("B"));
		System.out.println("Does the bag contain C?: " + bag1.contains("C"));
		System.out.println("Does the bag contain D?: " + bag1.contains("D"));
		System.out.println("Does the bag contain Z?: " + bag1.contains("Z\n"));
				
		//This removes strings from the bag.
		System.out.println("Removing B A C Z from your bag...\n");
		bag1.remove("B");
		bag1.remove("A");
		bag1.remove("C");
		bag1.remove("F");

		//This checks the union.
		System.out.println("Union: " + Arrays.toString(bag1.union(bag2).toArray()));

		//This checks the intersection.
		System.out.println("Intersection: " + Arrays.toString(bag1.intersection(bag2).toArray()));

		//This checks the difference.
		System.out.println("Difference: " + Arrays.toString(bag1.difference(bag2).toArray()));
		
		//This clears the array.
		System.out.println("\nClearing the bag...");
		bag1.clear();
				
		//This checks if the bag is empty.
		System.out.println("Is the bag empty?: " + bag1.isEmpty());
	} //end main
	
}
