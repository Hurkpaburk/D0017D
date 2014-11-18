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

		Scanner keyboardInput = new Scanner(System.in); // Create object

		int function = 1; // Init menu variable;
		double sphereVol;
		double cylinderVol;
		String fractionOutput;
		String yValue[];
		int sumOutput;
		int xValue;
		int kValue;
		int mValue;
		int nValue;


		while(function != 0) {

			System.out.print("Choose math function:\n0 - Exit Program\n1 - Sphere Volume"
					+ "\n2 - Cylinder Volume\n3 - Fraction\n4 - Sum\n5 - Linear equation, y(x) = kx + m"
					+ "\n6 - Linear Equation, with y value for specfic x values\n"); // print  

			try {
				function = keyboardInput.nextInt(); 

				switch(function) { // Choose method to call
				case 0: // Exit
					break;

				case 1: // Sphere 
					System.out.print("Choose sphere Radius: ");
					int radiusArgSphere = keyboardInput.nextInt(); // Radius Input
					try {
						sphereVol = volume(radiusArgSphere); // Call method 
					}
					catch (IllegalArgumentException e) { // Catch method exception
						System.out.println(e + "\n");
						break;
					}
					System.out.printf("Sphere Volume is: %.2f\n\n", sphereVol); // print result
					break;

				case 2: // Cylinder
					System.out.print("Choose cylinder Radius: ");
					int radiusArgCyl = keyboardInput.nextInt(); // Radius Input
					System.out.print("Choose cylinder Heigth: ");
					int HeigthArgCyl = keyboardInput.nextInt(); // Heigth Input
					try {
						cylinderVol = volume(radiusArgCyl,HeigthArgCyl); // Call method  
					}
					catch (IllegalArgumentException e) { // Catch method exception
						System.out.println(e + "\n");
						break;
					}
					System.out.printf("Cylinder Volume is: %.2f\n\n", cylinderVol); // print result
					break;

				case 3: // Fraction
					System.out.print("Choose numerator for fraction: ");
					int numerator = keyboardInput.nextInt(); // Numerator Input
					System.out.print("Choose denominator for fraction: ");
					int denominator = keyboardInput.nextInt(); // Denominator Input
					try {
						fractionOutput =  fraction(numerator,denominator);  // Call method 
					}
					catch (IllegalArgumentException e) { // Catch method exception
						System.out.println(e + "\n");
						break;
					}
					System.out.println("Fraction is: " + fractionOutput + "\n");  // print result
					break;

				case 4: // Sum
					System.out.print("Choose number to sum: ");
					int sumN = keyboardInput.nextInt(); // Sum Input
					try {
						sumOutput =  sum(sumN);  // Call method 
					}
					catch (IllegalArgumentException e) { // Catch method exception
						System.out.println(e + "\n");
						break;
					}
					System.out.println("Sum is: " + sumOutput + "\n");  // print result
					break;

				case 5: // Straight Line Equation, y = kx + m 
					System.out.print("Choose x value in y(x) = kx + m: ");
					xValue = keyboardInput.nextInt(); // x Input
					System.out.print("Choose k value in y(x) = kx + m: ");
					kValue = keyboardInput.nextInt(); // k Input
					System.out.print("Choose m value in y(x) = kx + m: ");
					mValue = keyboardInput.nextInt(); // m Input
					straightLine(xValue,kValue,mValue);  // Call method 
					break;

				case 6:  // Straight Line Equation, calcLine
					System.out.print("Choose n value where x goes from 1-n in y(x) = kx + m: ");
					nValue = keyboardInput.nextInt(); // n Input
					System.out.print("Choose k value in y(x) = kx + m: ");
					kValue = keyboardInput.nextInt(); // k Input
					System.out.print("Choose m value in y(x) = kx + m: ");
					mValue = keyboardInput.nextInt(); // m Input
					yValue = calcLine(nValue,kValue,mValue);  // Call method
					for (int i = 0; i < nValue; i++) {// loop from 1-size(yValue)
						System.out.println(yValue[i] + "\n");  // print result
					}					
				default: // Print Menu
					System.out.println("Choose a number between 0 - 5\n");
					break;
				}	
			}
			catch (InputMismatchException e) { // Catch method exception, Input is not a integer
				System.out.println("Input has to be a Integer\nExiting Program");
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
	static double volume(int radius) 
			throws IllegalArgumentException, InputMismatchException { 
		/* This is one of the methods called volume. 
		This is possible due to method overloading.
		It is possible if the methods have different arguments,
		it does not have to be number of inputs the differs it us sufficient
		if the argument are of different data type. */
		if (radius <= 0) {  // Exception for negative or zero values as input
			IllegalArgumentException e = new IllegalArgumentException ("Sphere Radius has to be one or above");
			throw e;
		}

		double volume = (4 * Math.PI * Math.pow(radius,3) / 3); // Calculate sphere volume 
		return volume;
	}

	//------------------------------------------------------
	// Beskrivning: volume calculate the cylinder volume based on radius
	// Inparametrar: radius - Sphere radius , heigth - Cylinder height
	// Returvärde: volume - Cylinder Volume
	//------------------------------------------------------
	static double volume(int radius, int heigth)
			throws IllegalArgumentException { 
		/* This is one of the methods called volume. 
		This is possible due to method overloading.
		It is possible if the methods have different arguments,
		it does not have to be number of inputs the differs it us sufficient
		if the argument are of different data type. */
		if (radius <= 0 || heigth <= 0) {  // Exception for negative or zero values as input
			IllegalArgumentException e = new IllegalArgumentException ("Cylinder Radius or Heigth has to be one or above");
			throw e;
		}

		double volume = Math.PI * Math.pow(radius,2) * heigth; // Calculate cylinder volume 
		return volume;
	}

	//------------------------------------------------------
	// Beskrivning: fraction calculate the fraction based on numerator and denominator
	// The output is the fraction presented as a string.
	// Inparametrar: numerator - Numerator in fraction, denominator - Denominator in fraction
	// Returvärde: fraction - fraction presented as a string
	//------------------------------------------------------
	static String fraction(int numerator, int denominator) 
			throws IllegalArgumentException { 

		if (denominator == 0 ) {  // Exception for divide by zero
			IllegalArgumentException e = new IllegalArgumentException ("Divide by zero");
			throw e;
		}

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
	static int sum(int endNumber)
			throws IllegalArgumentException { 

		if (endNumber <= 0 ) { // Exception for negative or zero values as input
			IllegalArgumentException e = new IllegalArgumentException ("Input to sum has to be above zero");
			throw e;
		}

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
	static void straightLine(int xValue, int kValue, int mValue) {

		int yValue = calcPoint(xValue,kValue,mValue);

		String lineEq = "y(" + xValue + ") = " + yValue; // Create string 
		System.out.println(lineEq + "\n");  // print result
		return;
	}

	//------------------------------------------------------
	// Beskrivning: calcPoint calculate the y value in the
	// straight line equation
	// Inparametrar: xValue - x in Straight line equation,  kValue - k in Straight line equation, mValue - m in Straight line equation   
	// Returvärde: yValue - y in Straight line equation
	//------------------------------------------------------
	static int calcPoint(int xValue, int kValue, int mValue){

		int yValue = kValue * xValue + mValue; // Calculate y value

		return yValue;
	}

	//------------------------------------------------------
	// Beskrivning: calcPoint calculate the y value in the
	// straight line equation
	// Inparametrar: nValue - n value,  kValue - k in Straight line equation, mValue - m in Straight line equation,     
	// Returvärde: yValue - y:s in Straight line equation, depending on x and n
	//------------------------------------------------------
	static String[] calcLine(int nValue, int kValue, int mValue){

		String yValue[] = new String[nValue]; // Size of return array
		int values[] = new int[nValue]; // Size of y returned y values from calcPoint

		for (int i = 0; i < nValue; i++) {// loop from 1-n
			values[i] = calcPoint(i,kValue,mValue);
			yValue[i] = "y(" + (i+1) + ") = " + values[i]; // Create string
		}
		return yValue;
	}

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