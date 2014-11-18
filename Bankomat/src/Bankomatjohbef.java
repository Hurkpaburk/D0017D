import java.math.*;
import java.util.*;

public class Bankomatjohbef {
    //****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-09-24
	// Senast uppdaterad: 2014-09-24, Johan Bergström 
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

		Scanner keyboardInput = new Scanner(System.in); // Create object

		int function = 1; // Init menu variable;
		
		while(function != 0) {
			
			System.out.print("Choose math function:\n0 - Exit Program\n1 - Sphere Volume"
					+ "\n2 - Cylinder Volume\n3 - Fraction\n4 - Sum\n5 - Linear equation\n"); // print  
			
			function = keyboardInput.nextInt(); 
			
			switch(function) { // Choose method to call
			case 0: // Exit
				break;
			case 1: // Sphere 
				System.out.print("Choose sphere Radius: ");
				int radiusArgSphere = keyboardInput.nextInt(); // Radius Input
				double sphereVol = volume(radiusArgSphere); // Call method 
				System.out.printf("Sphere Volume is: %.2f\n", sphereVol); // print result
				break;
			case 2: // Cylinder
				System.out.print("Choose cylinder Radius: ");
				int radiusArgCyl = keyboardInput.nextInt(); // Radius Input
				System.out.print("Choose cylinder Heigth: ");
				int HeigthArgCyl = keyboardInput.nextInt(); // Heigth Input
 				double cylinderVol = volume(radiusArgCyl,HeigthArgCyl); // Call method  
				System.out.printf("Cylinder Volume is: %.2f\n", cylinderVol); // print result
				break;
			case 3: // Fraction
				System.out.print("Choose numerator for fraction: ");
				int numerator = keyboardInput.nextInt(); // Numerator Input
				System.out.print("Choose denominator for fraction: ");
				int denominator = keyboardInput.nextInt(); // Denominator Input
				String fractionOutput =  fraction(numerator,denominator);  // Call method 
				System.out.println("Fraction is: " + fractionOutput + "\n");  // print result
				break;
			case 4: // Sum
				System.out.print("Choose number to sum: ");
				int sumN = keyboardInput.nextInt(); // Sum Input
				int sumOutput =  sum(sumN);  // Call method 
				System.out.println("Sum is: " + sumOutput + "\n");  // print result
				break;
			case 5: // Straight Line Equation1
				
				
				break;
			default: // Print Menu
				System.out.println("Choose a number between 0 - 5\n");
				break;
			}
		}	
		keyboardInput.close();
	}
	
	//------------------------------------------------------
	// Beskrivning: volume calculate the spfere volume based on radius
	// which math method to be used.
	// Main function also print the result from the underlying methods.
	// Inparametrar: radius - Sphere radius 
	// Returvärde: volume - Sphere Volume
	//------------------------------------------------------
	static double volume(int radius){ 
		/* This is one of the methods called volume. 
		This is possible due to method overloading.
		It is possible if the methods have different arguments,
		it does not have to be number of inputs the differs it us sufficient
		if the argument are of different data type. */
		
		double volume = (4 * Math.PI * Math.pow(radius,3) / 3); // Calculate sphere volume 
		return volume;
		}
	
	//------------------------------------------------------
	// Beskrivning: volume calculate the cylinder volume based on radius
	// Inparametrar: radius - Sphere radius , heigth - Cylinder height
	// Returvärde: volume - Cylinder Volume
	//------------------------------------------------------
	static double volume(int radius, int heigth){ 
		/* This is one of the methods called volume. 
		This is possible due to method overloading.
		It is possible if the methods have different arguments,
		it does not have to be number of inputs the differs it us sufficient
		if the argument are of different data type. */
		
		double volume = Math.PI * Math.pow(radius,2) * heigth; // Calculate cylinder volume 
		return volume;
	}
	
	//------------------------------------------------------
	// Beskrivning: fraction calculate the fraction based on numerator and denominator
	// The output is the fraction presented as a string.
	// Inparametrar: numerator - Numerator in fraction, denominator - Denominator in fraction
	// Returvärde: fraction - fraction presented as a string
	//------------------------------------------------------
	static String fraction(int numerator, int denominator){ 
	
		String fraction;
		
		int frac = numerator / denominator; // calculate  the fraction 
		int remainder = numerator % denominator; // calculate  the remainder  
		
		if (remainder == 0) { // difference in string if remainder is 0
			fraction = "" + frac;	// No remainder
		}
		else {
			fraction = "" + frac + " " + remainder + "/"+  denominator; // with remainder
		}
		return fraction;
	}
	
	//------------------------------------------------------
	// Beskrivning: sum shall sum numbers  1...n
	// The output is the fraction presented as a string.
	// Inparametrar: endNumber - sequence end number
	// Returvärde: sum - sum of all number up to n
	//------------------------------------------------------
	static int sum(int endNumber){ 
	
		if (endNumber > 1) { // n is larger then 1, addition is needed
			return endNumber + sum(endNumber - 1); // Recursion, input goes from n down to 1
		}
		else {
			return endNumber; // return since endNumber is 1
		}

	}
	
	//------------------------------------------------------
	// Beskrivning: Straight Line Equation, this method call 
	// Take user input and print the correct straight line equation
	// Inparametrar: None
	// Returvärde: None
	//------------------------------------------------------
	static void straightLine(){ 
	
		
		 
	}
	
	//------------------------------------------------------
	// Beskrivning: calcPoint calculate the y value in the
	// straight line equation
	// Inparametrar: xValue - 
	// Returvärde: None
	//------------------------------------------------------
	static int calcPoint(){
		
		int yValue = 0;
		
		return yValue;
	}
}