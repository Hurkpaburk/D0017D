import java.math.*;
import java.util.*;

public class Bankomatjohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-10-21
	// Senast uppdaterad: 2014-10-21, Johan Bergström 
	// Beskrivning: Enable several math functions based on user choice and input.
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// which math method to be used.
	// Main function also print the result from the underlying methods.
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public static void main(String []args){

		int arrayMaxLength = 10; // Change number to change size of transaction array
		int[] trans = new int[0]; // declare and allocate array memory
		
		int balance = 0;
		int amount = 0;
		int numberOfTrans = 0;
		
		Scanner keyboardInput = new Scanner(System.in); // Create object

		int function = menu();		
		
		while (function != 4) {

			switch(function) {

			case 1: // Deposit
				System.out.print("Amount to deposit: ");
				amount = keyboardInput.nextInt();
				makeTransaction(trans, amount);
				break;
				
			case 2: // Deposit
				System.out.print("Amount to withdraw: ");
				amount = -1*keyboardInput.nextInt();
				makeTransaction(trans, amount);
				break;
				
			case 3: // Balance
				showTransactions(trans, balance);
				break;
				
			case 4: // Exit
				break;

			default: // Do Nothing
				System.out.println("Enter a number between 1 - 5!");
				break;
			}

			balance = balance + amount; // Calculate balance, the sum of all deposits and withdraws  
			
			function = menu();
		}
		
		keyboardInput.close();
	}

	//------------------------------------------------------
	// Beskrivning: Present menu and return user input
	// Inparametrar: None 
	// Returvärde: userInput - User input 
	//------------------------------------------------------
	public static int menu() { 

		Scanner keyboardInput = new Scanner(System.in); // Create object
		// complain about resource leak but it can not be closed in method <- gives exception errors for following inputs 
		
		int userInput;
		
		System.out.print("1. Insättning\n"
				+ "2. Uttag\n"
				+ "3. Saldobesked\n"
				+ "4. Avsluta\n"
				+ "Ditt val: "); // print
		
		userInput = keyboardInput.nextInt();
		
		return userInput;
	}

	//------------------------------------------------------
	// Beskrivning: Present the last transactions and balance
	// Inparametrar: trans - Transactions , balance - Account balance
	// Returvärde: None
	//------------------------------------------------------
	public static void showTransactions(int[] trans, int balance) { 
		
		System.out.println("Current balance is: " + balance);
		System.out.println("The last transactions: ");
		
		for (int i = 0; i < trans.length; i++) { // loop from 1 to number of transactions or max 
			System.out.println(trans[i]);  // print result
		}
		
	}

	//------------------------------------------------------
	// Beskrivning: Places amount in to transaction array
	// Inparametrar: trans - Transaction array, amount - Withdraw or deposit amount 
	// Returvärde: None
	//------------------------------------------------------
	public static void makeTransaction(int[] trans, int amount) { 
		
		int transPos = findNr(trans);
		System.out.println(transPos);
		
		if (trans.length <= transPos) {
			
			System.out.println("sdfdg");
			
			int[] transTemp = new int[trans.length+1];
			
			for(int i = 0; i < trans.length; i++) {
				transTemp[i] = trans[i];
			}
			trans = transTemp;
			System.out.println(transTemp.length);
		}

		System.out.println(trans.length);

		moveTrans(trans);
		
		trans[transPos] = amount;
	}

	//------------------------------------------------------
	// Beskrivning: Will return the position where transaction shall be placed
	// Inparametrar: trans - Transaction array
	// Returvärde: transPos - Transaction position in array 
	//------------------------------------------------------
	private static int findNr(int[] trans) { 

		int arrayMaxLength = 10;
		int transPos = 0;
		if (trans.length < arrayMaxLength-1) {
			
			transPos = trans.length;
		}
		else {
			transPos = arrayMaxLength-1;
		}
		
		return transPos;
	}

	//------------------------------------------------------
	// Beskrivning: Moves all transaction in array one step to make room for new transaction 
	// Inparametrar: trans - Transaction array
	// Returvärde: None
	//------------------------------------------------------
	private static void moveTrans(int[] trans) {
		
		for(int i = 1; i <= (trans.length-1); i++) {
			trans[i] = trans[i-1];
		}
	}
}