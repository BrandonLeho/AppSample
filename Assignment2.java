/*
// AUTHOR: Brandon Leho
// FILENAME: Assignment2.java
// SPECIFICATION: Run a game of rock, paper, scissors
// FOR: CS 1400 - ASSIGNMENT #2
// TIME SPENT: 3 Hours
//*/

// Question #1 

// string word = "";
// int wordLength = 0;
// wordLength = word.length();
// System.out.print(wordLength);

// Question #2 

// string sentence = "";
// sentence = sentence.toUpperCase();
// System.out.print(sentence);

// Question # 3

// 	String perfect = "perfect";
	
//	String p = String.valueOf(perfect.charAt(0));
//	String E = String.valueOf(perfect.charAt(1));
//	String r = String.valueOf(perfect.charAt(2));
//	String F = String.valueOf(perfect.charAt(3));
//	String e = String.valueOf(perfect.charAt(4));
//	String C = String.valueOf(perfect.charAt(5));
//	String t = String.valueOf(perfect.charAt(6));
	
//	p = p.toLowerCase();
//	E = E.toUpperCase();
//	r = r.toLowerCase();
//	F = F.toUpperCase();
//	e = e.toLowerCase();
//	C = C.toUpperCase();
//	t = t.toLowerCase();

//	System.out.print(String.valueOf(p));
//	System.out.print(String.valueOf(E));
//	System.out.print(String.valueOf(r));
//	System.out.print(String.valueOf(F));
//	System.out.print(String.valueOf(e));
//	System.out.print(String.valueOf(C));
//	System.out.print(String.valueOf(t));

// Question # 4

// a) x == y / 2
// true

// b) x % 2 == 0 || y % 2 != 0
// false

// c) x - y < 0 && !(x >= y)
// true

// d) x + 6 != y || x / y <= 0
// true

import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Declaring variables
		String player1 = "";
		String player2 = "";
		
		//user inputs
		System.out.println("Player 1: Choose rock, paper, or scissors: ");
		player1 = scan.nextLine();
		player1 = player1.toLowerCase();
		
		System.out.println("Player 2: Choose rock, paper, or scissors: ");
		player2 = scan.nextLine();
		player2 = player2.toLowerCase();
		
		//computing all possible outcomes
		if (player1.equals("rock") && player2.equals("paper")) {
			System.out.print("Player 2 wins!");
		}
		
		else if (player1.equals("paper") && player2.equals("paper")) {
			System.out.print("It's a tie");
		}
		
		else if (player1.equals("scissors") && player2.equals("paper")) {
			System.out.print("Player 1 wins!");
		}

		
		else if (player1.equals("rock") && player2.equals("rock")) {
			System.out.print("It's a tie");
		}
		
		else if (player1.equals("paper") && player2.equals("rock")) {
			System.out.print("Player 1 wins!");
		}
		
		else if (player1.equals("scissors") && player2.equals("rock")) {
			System.out.print("Player 2 wins!");
		}
		
		
		else if (player1.equals("rock") && player2.equals("scissors")) {
			System.out.print("Player 1 wins!");
		}
		
		else if (player1.equals("paper") && player2.equals("scissors")) {
			System.out.print("Player 2 wins!");
		}
		
		else if (player1.equals("scissors") && player2.equals("scissors")) {
			System.out.print("It's a tie");
		}
		
		else {
			System.out.print("Wrong choice");
		}
		
	}

}
