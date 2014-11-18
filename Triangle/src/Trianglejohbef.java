import java.util.*;

public class Trianglejohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-09-19
	// Senast uppdaterad: 2014-09-19, Johan Bergström 
	// Beskrivning: Create a triangle with the same length as requested input
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Present at triangle  based on keyboard inputs.
	// Can decide if it shall be "up" or "down" 
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public static void main(String []args){

		Scanner keyboardInput = new Scanner(System.in); // Create object 

		int direction; // declare variable
		int triangle = 0; // initilaze variable with default value

		while (triangle != -1) // Perform triangle pattern until keyboard input -1. Does not consider negative values
		{
			System.out.print("Ange längden på de 2 lika långa sidorna (Avsluta med -1):"); // print out

			triangle = keyboardInput.nextInt(); // Assign triangle new value

			if (triangle != -1) // make a triangle
			{
				System.out.print("Ska den räta vinkeln vara nedåt (0) eller uppåt (1):"); // print out

				direction = keyboardInput.nextInt(); // Assign direction new value

				if (direction == 0) // Decide up or down triangle
					for (int k = 1; k <= triangle; k++) // loop over the triangle length to get number correct number of rows
					{
						for (int j = 1; j <= k-1; j++)  // loop at current row to get number of '*' to print out
						{
							System.out.print("*"); // print, no new line
						}
						System.out.println("*"); // print, new line
					}
				else if (direction == 1)            
				{
					for (int k = triangle; k >= 1; k--) // loop over the triangle length to get number correct number of rows
					{
						for (int j = 1; j <= k-1; j++)   // loop at current row to get number of '*' to print out
						{
							System.out.print("*");  // print, no new line
						}
						System.out.println("*"); // print, new line
					}
				}
				else // default for if statement, do nothing
				{ }
			}
			else // -1 as input, do not make triangle
			{ }
		}
	}
}