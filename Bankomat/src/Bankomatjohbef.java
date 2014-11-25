import java.math.*;
import java.util.*;

public class Bankomatjohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-11-25
	// Senast uppdaterad: 2014-11-25, Johan Bergström 
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

		/********************************/
		int arrayMaxLength = 10; // **** Change number to change size of transaction array ****
		/********************************/
		
		int[] trans = new int[arrayMaxLength]; // declare and allocate array memory
		
		for(int i = 0; i < trans.length; i++) { // Fill array with zeros
			trans[i] = 0;
		}
		
		int balance = 0;
		int amount = 0;

		
		Scanner keyboardInput = new Scanner(System.in); // Create object

		int function = menu();		// Call Menu
		
		while (function != 4) { // Exit on 4

			switch(function) { // Decide what to do based on user input

			case 1: // Deposit
				System.out.print("Amount to deposit: ");
				amount = keyboardInput.nextInt();
				if (amount > 0) {  // Check if amount is less or equal to then zero, can not deposit such amount
					balance = balance + amount; // Calculate balance, the sum of all deposits and withdraws  
					makeTransaction(trans, amount);
				}
				else {
					System.out.println("Amount to deposit has to be larger then 0!");
				}
				break;
				
			case 2: // Withdraw
				System.out.print("Amount to withdraw: ");
				amount = keyboardInput.nextInt(); 
				if (amount <= 0) { // Check if amount is less or equal to then zero, can not withdraw such amount
					System.out.println("Amount to withdraw has to be larger then 0!");
				}
				else if (amount > balance) { // Can not withdraw more then balance
					System.out.println("Can not withdraw: " + amount + " Balance is: " + balance);
				}
				else {
					amount = -1*amount;
					balance = balance + amount; // Calculate balance, the sum of all deposits and withdraws  
					makeTransaction(trans, amount);
				}
				break;
				
			case 3: // Balance
				showTransactions(trans, balance);
				break;
		
			default: // Do Nothing
				System.out.println("Enter a number between 1 - 5!");
				break;
			}

			function = menu(); // Call Menu
		}
		System.out.println("Thank You!\nHave a nice day!");
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
		
		System.out.println("Current balance is: " + balance); // Present Account balance
		System.out.println("The last transactions (last first): "); // Present last transactions
		
		for (int i = trans.length-1; i >= 0; i--) { // loop from trans length to 0 
			if (trans[i] != 0) { // Do not present cells with zeros
			System.out.println(trans[i]);  // print result of transactions 
			}
		}
	}

	//------------------------------------------------------
	// Beskrivning: Places amount in to transaction array
	// Inparametrar: trans - Transaction array, amount - Withdraw or deposit amount 
	// Returvärde: None
	//------------------------------------------------------
	public static void makeTransaction(int[] trans, int amount) { 
		
		int transPos = findNr(trans);
		
		if (trans.length == transPos+1 && (trans[transPos] != 0)) { 
			// Move elements in array when filled and place last transaction in last element of array  
			moveTrans(trans);
			trans[transPos] = amount;
		}
		else {
			// Place last transaction in last element of array  
			trans[transPos] = amount;

		}

	}

	//------------------------------------------------------
	// Beskrivning: Will return the position where transaction shall be placed
	// Inparametrar: trans - Transaction array
	// Returvärde: transPos - Transaction position in array 
	//------------------------------------------------------
	private static int findNr(int[] trans) { 

		int i = 0;
		
		while (trans[i] != 0 && (i < trans.length-1)) {
			// Decide which position in array to fill 
			i++;
		}
		
		return i;
	}

	//------------------------------------------------------
	// Beskrivning: Moves all transaction in array one step "left" to make room for new transaction 
	// Inparametrar: trans - Transaction array
	// Returvärde: None
	//------------------------------------------------------
	private static void moveTrans(int[] trans) {

		for(int i = 0; i < trans.length; i++) {
			// Move elements in array to the left, all elements except 0 element
			if (i != 0) {
				trans[i-1] = trans[i];	
			}
		}
	}
}
