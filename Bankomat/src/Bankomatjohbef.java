import java.math.*;
import java.util.*;

public class Bankomatjohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergstr�m, johbef-4@student.ltu.se
	// Datum: 2014-10-21
	// Senast uppdaterad: 2014-10-21, Johan Bergstr�m 
	// Beskrivning: Enable several math functions based on user choice and input.
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// which math method to be used.
	// Main function also print the result from the underlying methods.
	// Inparametrar: None 
	// Returv�rde: None
	//------------------------------------------------------
	public static void main(String []args){

		int function = 1; // Init menu variable;

		while (function != 4) {


			function = menu();
			
			switch(function) {
			case 1: // Withdraw

			case 2: // Deposit

			case 3: // Balance

			case 4: // Exit
				break;

			default: // Print Menu
				function = menu();
			}
		}

	}

	//------------------------------------------------------
	// Beskrivning: Present menu and return user input
	// Inparametrar: None 
	// Returv�rde: userInput - User input 
	//------------------------------------------------------
	public static int menu()
			throws IllegalArgumentException, InputMismatchException { 

		Scanner keyboardInput = new Scanner(System.in); // Create object
		int userInput;
		
		System.out.print("1. Ins�ttning\n"
				+ "2. Uttag\n"
				+ "3. Saldobesked\n"
				+ "4. Avsluta\n"
				+ "Ditt val: "); // print
		
		userInput = keyboardInput.nextInt();
		
		keyboardInput.close();
		
		return userInput;
		
	}

//	//------------------------------------------------------
//	// Beskrivning: Present the last transactions and balance
//	// Inparametrar: trans - Transactions , balance - Account balance
//	// Returv�rde: None
//	//------------------------------------------------------
//	public static void showTransactions(int[] trans, int balance)
//			throws IllegalArgumentException { 
//		
//
//	}
//
//	//------------------------------------------------------
//	// Beskrivning: Places amount in to transaction array
//	// Inparametrar: trans - Transaction array, amount - Withdraw or deposit amount 
//	// Returv�rde: None
//	//------------------------------------------------------
//	public static void makeTransaction(int[] trans, int amount)
//			throws IllegalArgumentException { 
//
//	}
//
//	//------------------------------------------------------
//	// Beskrivning: Will return the position where transaction shall be placed
//	// Inparametrar: trans - Transaction array
//	// Returv�rde: transPos - Transaction position in array 
//	//------------------------------------------------------
//	private static int findNr(int[] trans)
//			throws IllegalArgumentException { 
//
//		return transPos;
//	}
//
//	//------------------------------------------------------
//	// Beskrivning: Moves all transaction in array one step to make room for new transaction 
//	// Inparametrar: trans - Transaction array
//	// Returv�rde: None
//	//------------------------------------------------------
//	private static void moveTrans(int[] trans) {
//	
//	}
}