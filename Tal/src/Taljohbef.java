import java.math.*;
import java.util.*;

public class Taljohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-09-24
	// Senast uppdaterad: 2014-09-24, Johan Bergström 
	// Beskrivning: Present random numbers in [0 999] in arrays
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Create an array of random numbers based on input length.
	// Divide the random numbers in <500 and >500 arrays
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public static void main(String []args){

		Scanner keyboardInput = new Scanner(System.in); // Create object
		int underHalfInd = 0; // init of array index
		int overHalfInd = 0; // init of array index

		System.out.print("Hur många slumptal i intervallet 0 – 999 önskas? "); // print  
		
		int randomNumbers = keyboardInput.nextInt(); // read number of random numbers needed

		System.out.println("\nHär är de slumpade talen: "); // print  
		
		int[] randomArray = new int[randomNumbers]; // declare random array with correct size

		for (int i = 0; i < randomArray.length; i++) // loop over the random array
		{
			randomArray[i] = (int)(Math.random()*1000); // assign random value to each array element, double to integer

			if (randomArray[i] < 500) // check if element is under 500
			{
				underHalfInd++; // increase numbers for under 500
			}
			else  // element is over 500
			{
				overHalfInd++; // increase numbers for over 500
			}
			System.out.print(randomArray[i]+ " ");  // print random array, one element each loop
		}
		
		int[] underHalfArray = new int[underHalfInd]; // declare under 500 array with correct size
		int[] overHalfArray = new int[overHalfInd]; // declare over 500 array with correct size
		int underHalf = 0; // init of new array index
		int overHalf = 0; // init of new array index
		
		System.out.println("\n\nDessa " + underHalfInd + " tal är i intervallet 0 – 499"); // print  
		
		for (int i = 0; i < randomArray.length; i++) // loop over the random array
		{
			if (randomArray[i] < 500)  // check if element is under 500
			{
				underHalfArray[underHalf] = randomArray[i]; // assign to under 500 array
				System.out.print(underHalfArray[underHalf] + " "); // print under 500 array,  one element each loop
				underHalf++; // increase index counter

			}
		}
		
		System.out.println("\n\nDessa " + overHalfInd + " tal är i intervallet 500 – 999"); // print  
		
		for (int i = 0; i < randomArray.length; i++) // loop over the random array
		{
			if (randomArray[i] >= 500) // check if element is over 500
			{
				overHalfArray[overHalf] = randomArray[i];  // assign to over 500 array
				System.out.print(overHalfArray[overHalf] + " ");// print over 500 array,  one element each loop
				overHalf++; // increase index counter
			}
		}
	}
}