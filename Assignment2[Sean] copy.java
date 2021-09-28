/*
// AUTHOR: Sean Solomon
// FILENAME: Assignment2
// SPECIFICATION: Using conditional (if, if-else) statements, rock-paper-scissors game
// FOR: CS 1400 - ASSIGNMENT #2
// TIME SPENT: 3 Hours //*/

//*

//Question 1:public class sample{
//		public static void main(String[] args){
//			String myString = "Practice makes perfect!";
//		System.out.println(myString.length()); }
//Question 2: public class sample{
//		public static void main(String[] args){
//			String myString = "Practice makes perfect!";
//		System.out.println(myString.toUpperCase()); }
//Question 3: public class sample {
//		    public static void main(String[] args) {
//		    	
//		    	String myString = "Practice makes perfect!";
//		    	String p = String.valueOf(myString.charAt(15));
//		    	String E = String.valueOf(myString.charAt(16));
//		    	String r = String.valueOf(myString.charAt(17));
//		    	String F = String.valueOf(myString.charAt(18));
//		    	String e = String.valueOf(myString.charAt(19));
//		    	String C = String.valueOf(myString.charAt(20));
//		    	String t = String.valueOf(myString.charAt(21));
//		    	String perfect = new String(p.toLowerCase() + E.toUpperCase() + r.toLowerCase() + F.toUpperCase() + e.toLowerCase() + C.toUpperCase() + t.toLowerCase());
//		    	System.out.println(perfect);
//		    		
//		   
//	}//end main method
//Question 4a: true
//Question 4b: false
//Question 4c: true
//Question 4d: true

import java.util.Scanner;

	//class name should match the file name
	public class Assignment2 {
		// we must have a main method to run the program
        public static void main(String[] args) {
		 
		 	//The Variables
        	//Create a Scanner object to get the input from the keyboard
		 	String Player1Input = "";
	        String Player2Input = ""; 
	        Scanner scan = new Scanner(System.in);
	        
	        //Player1 prompt
	        System.out.println("Player 1: Choose rock, scissors, or paper: ");
	        //Player1 Input
	        Player1Input = scan.nextLine();
	        Player1Input = Player1Input.toLowerCase();
	        //Player2 prompt
	        System.out.println("Player 2: Choose rock, scissors, or paper: ");
	        //Player2 Input
	        Player2Input = scan.nextLine();
	        Player2Input = Player2Input.toLowerCase();
	      
	        //Display Outcomes of Game
	        if (Player1Input.equals("rock") && Player2Input.equals("rock")) {
	        	System.out.println("It's a tie");
	        } 
	        	else if (Player1Input.equals("paper") && Player2Input.equals("paper")) {
	        		System.out.print("It's a tie");
	        } 
	        	else if (Player1Input.equals("scissors") && Player2Input.equals("scissors")) {
	        		System.out.print("It's a tie");
	        	
	        } 
	        	else if (Player1Input.equals("scissors") && Player2Input.equals("paper")) {
	        		System.out.print("Player 1 wins.");
	        } 
	        	else if (Player1Input.equals("rock") && Player2Input.equals("scissors")) {
	        		System.out.print("Player 1 wins.");
	        } 
	        	else if (Player1Input.equals("paper") && Player2Input.equals("rock")) {
	        		System.out.print("Player 1 wins.");
	        	
	        } 
	        	else if (Player2Input.equals("scissors") && Player1Input.equals("paper")) {
	        		System.out.println("Player 2 wins.");
	        } 
	        	else if (Player2Input.equals("rock") && Player1Input.equals("scissors")) {
	        		System.out.print("Player 2 wins.");
	        } 	
	        	else if (Player2Input.equals("paper") && Player1Input.equals("rock")) {
	        		System.out.print("Player 2 wins.");
	       
	        }
	        	else {
	        		System.out.println("Wrong choice!");
	        	}
	
	 }//end main method
}