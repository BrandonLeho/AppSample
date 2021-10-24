/**
 * This program gives the user the opportunity to
 * play with a set of preset arrays. The user has
 * the option to add or remove content from the 
 * array. They also get to see the status of the
 * array such as: if it's empty, the size, and the
 * current content. They will get to do this with two
 * preset arrays, then once they are done with them,
 * they get to compare those two arrays with union,
 * intersection, and difference.
 * 
 * @author Brandon Leho, Brandon Lequang, Sean Solomon
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayBagTest
{
   @SuppressWarnings("unchecked")
public static void main(String[] args)
   {
	   Scanner scan = new Scanner(System.in);
	
	   BagInterface<String> firstArray = new ResizeableArrayBag<>();
	   BagInterface<String> secondArray = new ResizeableArrayBag<>();
	   
	   //This adds the letters A, C, E, G, I to the first array.
	   //Each letter has its own specific function seen further on in the code.
	   firstArray.add("A");
	   firstArray.add("C");
	   firstArray.add("E");
	   firstArray.add("G");
	   firstArray.add("I");
	   
	   //The user is prompted on what they would like to see.
	   //The user is given a multitude of options for the first array.
	   String question = " ";
	   do {
		   System.out.println("Which one would you like to see?:\np = print array\na = add to the array\ne = show if the array is empty\nf = find word\ns = size of the array\nr = remove something from the array\nc = clear array\nq = move onto next array");
		   question = scan.nextLine(); //This scans the user's incoming input from the previous selection and puts it in a switch case.
		   question.toLowerCase(); //This scans the user's input and translates it into a lowercase to enable the switch case.
		   
		   switch(question) { //The switch case enters the user's inputs and acts depending on the given input.
		   	case "p": //Case P displays the current array for the first array that the user input.
		   		System.out.println("The current array is: " + firstArray + "\n");
		   		break;
		   	
		   	case "a": //Case A allows the user to add to the first array and scans the given input.
		   		System.out.println("What would you like to add to the array");
		   		String add = scan.nextLine();
		   		firstArray.add(add);
		   		break;
		   		
		   	case "e": //If the first array is empty, Case E alerts the user with a prompt that says it is empty through an if-else.
			   		//If the first array is not empty, Case E alerts the user with a prompt saying that there is something in it through an if-else.
		   		if(firstArray.isEmpty()) 
		   		{
		   			System.out.println("Empty Status: This ***** empty YEEEEET!\n");
		   		}
		   		else
		   		{
		   			System.out.println("Empty Status: The array got at least something in it.\n");
		   		}
		   		break;
		   		
		   	case "f": //Case F prompts the user what they wish to find.
				   	  //Through an if-else, Case F scans the user input, searches the first array and notifies the user if their input is inside the first array or not.
		   		System.out.println("What do you want to find?: ");
		   		String word = scan.nextLine();
		   		if(firstArray.contains(word))
		   		{
		   			System.out.println("'" + word + "' is in this array\n");
		   		}
		   		else
		   		{
		   			System.out.println("'" + word + "' is not in this array :(\n");
		   		}
		   		break;
		   			
		   	case "s": //Case S scans the size of the first array through firstArray.size() and prints it.
		   		System.out.println("The size of this array is " + firstArray.getCurrentSize() + "\n");
		   		break;
		   		 
		   	case "r": //Case R prompts the user what is to be removed in the first array.
		   		System.out.println("What would you like to remove?: ");
		   		String remove = scan.nextLine(); //The user input is scanned.
		   		if(firstArray.contains(remove)) //If the user input is inside the first array, it is removed and printed that it was removed.
		   		{
		   			firstArray.remove(remove);
		   			System.out.println("'" + remove + "' has been removed\n");
		   		}
		   		else //If the user input is not inside the first array, it printed that it is not in present inside the first array.
		   		{
		   			System.out.println("'" + remove + "' is not in this array, so I can't remove it :(\n");
		   		}
		   		break;
		   		
		   	case "c": //Case C clears the entirety of the first array; however, the user is prompted before and requests confirmation.
		   		System.out.println("Are you sure you want to clear the array? You will lose all of your beloved inputs (press 'y' or 'n'): ");
		   		String clear = scan.nextLine();
		   		clear = clear.toLowerCase();
		   		if(clear.equals("y") || clear.equals("yes")) //Through an if-else, Case C scans the input and acts depending on the user's input.
				   	//If the user inputs y, the first array is cleared and prints a cleared message.
		   		{
		   			firstArray.clear();
		   			System.out.println("RIP array, it's gone now...\n");
		   		}
		   		else if(clear.equals("n") || clear.equals("no")) //If the user inputs n, the first array remains and prints a "kept" message.
		   		{
		   			System.out.println("Array is kept the same\n");
		   		}
		   		else //Case C recognizes false inputs and displays an error message whilist not making any changes to the first array.
		   		{
		   			System.out.println("You didn't put a valid input, array has not been cleared.\n"); 
		   		}
		   		break;
		   		
		   	case "q": //Case Q allows the user to jump to the second array through a while loop further on.
		   		System.out.println("Moving on to second array.\n");
		   		break;
		   		
		   	default: //The code is able to recognize false inputs and displays an error message.
		   		System.out.println("That's not an option unfortunately, try again.\n");
		   		break;
		   }
	   } while (!(question.equals("q")));
	   
	   System.out.println("Now on the second array.\n");

	   //The code distinguishes the different/new array through secondArray
	   
	   //This adds the letters B, C, D, F, G, H to the second array.
	   //Each letter has its own specific function seen further on in the code.
	   secondArray.add("B");
	   secondArray.add("C");
	   secondArray.add("D");
	   secondArray.add("F");
	   secondArray.add("G");
	   secondArray.add("H");
	   
	   //The user is prompted on what they would like to see.
	   //The user is given a multitude of options for the second array.
	   do {
		   System.out.println("Which one would you like to see?:\np = print array\na = add to the array\ne = show if the array is empty\nf = find word\ns = size of the array\nr = remove something from the array\nc = clear array\nq = move onto camparing the arrays");
		   question = scan.nextLine(); //This scans the user's incoming input from the previous selection and puts it in a switch case.
		   question.toLowerCase(); //This scans the user's input and translates it into a lowercase to enable the switch case.
		   
		   switch(question) { //The switch case enters the user's inputs and acts depending on the given input.
		   	case "p": //Case P displays the current array for the second array that the user input.
		   		System.out.println("The current array is: " + secondArray + "\n");
		   		break;
		   		
		   	case "a": //Case A allows the user to add to the first array and scans the given input.
		   		System.out.println("What would you like to add to the array");
		   		String add = scan.nextLine();
		   		secondArray.add(add);
		   		break;
		   		
		   	case "e": //If the second array is empty, Case E alerts the user with a prompt that says it is empty through an if-else.
			   //If the sedcon array is not empty, Case E alerts the user with a prompt saying that there is something in it through an if-else.
		   		if(secondArray.isEmpty())
		   		{
		   			System.out.println("Empty Status: This ***** empty YEEEEET!\n");
		   		}
		   		else
		   		{
		   			System.out.println("Empty Status: The array got at least something in it.\n");
		   		}
		   		break;
		   		
		   	case "f": //Case F prompts the user what they wish to find.
			   //Through an if-else, Case F scans the user input, searches the second array and notifies the user if their input is inside the second array or not.
		   		System.out.println("What do you want to find?: ");
		   		String word = scan.nextLine();
		   		if(secondArray.contains(word))
		   		{
		   			System.out.println("'" + word + "' is in this array\n");
		   		}
		   		else
		   		{
		   			System.out.println("'" + word + "' is not in this array :(\n");
		   		}
		   		break;
		   			
		   	case "s": //Case S scans the size of the second array through secondArray.size() and prints it.
		   		System.out.println("The size of this array is " + secondArray.getCurrentSize() + "\n");
		   		break;
		   		 
		   	case "r": //Case R prompts the user what is to be removed in the second array.
		   		System.out.println("What would you like to remove?: ");
		   		String remove = scan.nextLine(); //The user input is scanned.
		   		if(secondArray.contains(remove)) //If the user input is inside the second array, it is removed and printed that it was removed.
		   		{
		   			secondArray.remove(remove);
		   			System.out.println("'" + remove + "' has been removed\n");
		   		}
		   		else //If the user input is not inside the second array, it printed that it is not in present inside the second array.
		   		{
		   			System.out.println("'" + remove + "' is not in this array, so I can't remove it :(\n");
		   		}
		   		break;
		   		
		   	case "c": //Case C clears the entirety of the second array; however, the user is prompted before and requests confirmation.
		   		System.out.println("Are you sure you want to clear the array? You will lose all of your beloved inputs (press 'y' or 'n'): ");
		   		String clear = scan.nextLine();
		   		clear = clear.toLowerCase();
		   		if(clear.equals("y") || clear.equals("yes")) //Through an if-else, Case C scans the input and acts depending on the user's input.
				   //If the user inputs y, the second array is cleared and prints a cleared message.
		   		{
		   			secondArray.clear();
		   			System.out.println("RIP array, it's gone now...\n");
		   		}
		   		else if(clear.equals("n") || clear.equals("no")) //If the user inputs n, the second array remains and prints a "kept" message.
		   		{
		   			System.out.println("Array is kept the same\n");
		   		}
		   		else //Case C recognizes false inputs and displays an error message whilst not making any changes to the second array.
		   		{
		   			System.out.println("You didn't put a valid input, array has not been cleared.\n");
		   		}
		   		break;
		   		
		   	case "q": //Case Q allows the user to compare the first and second array through a while loop further on.
		   		System.out.println("Moving on to comparing\n");
		   		break;
		   		
		   	default: //The code is able to recognize false inputs and displays an error message.
		   		System.out.println("That's not an option unfortunately, try again.\n");
		   		break;
		   }
	   } while (!(question.equals("q")));
	   
	   
	   
	   System.out.println("Now comparing both arrays with union, intersection, and difference\n");
	   
	   do { //The code pulls from Union, Intersection and difference as options to compare the first and second arrays.
		   System.out.println("Which one would you like to see?: \nu = union\ni = intersection\nd = difference\nq = quit program");
		   question = scan.nextLine();
		   question.toLowerCase();
		   
		   switch(question) { //The switch case enters the user's inputs and acts depending on the given input.
		   	case "u": //Case U scans both arrays and prints their union.
		   		System.out.println(Arrays.toString(firstArray.union(secondArray).toArray())); 		
		   		break;
		   		
		   	case "i": //Case I scans both arrays and prints their intersections.
		   		System.out.println(Arrays.toString(firstArray.intersection(secondArray).toArray()));
		   		break;
		   		
		   	case "d": //Case D scans both arrays and prints their differnece.
		   		System.out.println(Arrays.toString(firstArray.difference(secondArray).toArray()));
		   		break;
		   		
		   	case "q": //Case Q prints a good-bye message and allows the user to quit the program.
		   		System.out.println("Good bye! I hope you had a great time using my program! The program will be right here if you want to come back. Stay safe! :)");
		   		break;
		   		
		   	default:  //The program is able to recognize false inputs and displays an error message.
		   		System.out.println("That's not an option unfortunately, try again.\n");
		   		break;
		   }
	   }while (!(question.equals("q"))); //This ends the while loop.
   } //end main
} //end ArrayBagTest