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
