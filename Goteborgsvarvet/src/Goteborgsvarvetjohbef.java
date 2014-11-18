import java.util.*;

public class Goteborgsvarvetjohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-10-12
	// Senast uppdaterad: 2014-10-13, Johan Bergström 
	// Beskrivning: This class shall create a table with Hockey score
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Calculate and present the time for Göteborgsvarvet based on
	//	keyboard inputs.  Does not take in to account possibilities for "negative" times 
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public static void main(String[] args) {
		int hoursStart, minutesStart, secondsStart, hoursGoal, minutesGoal,
		secondsGoal, timeStart, timeGoal, timeDiff, resultHour, timeHourRem,
		resultMinute, resultSecond; // initialize variables for function  
		Scanner keyboardInput; // initialize variables for function 
		
		keyboardInput = new Scanner(System.in); // Scan keyboard input 
		
		System.out.println("Starttid:"); // Print text
		System.out.println("---------"); // Print text
		System.out.print("Timme: "); // Print text
		hoursStart = keyboardInput.nextInt(); // Read keyboard input, (integer)
		System.out.print("Minut: ");
		minutesStart = keyboardInput.nextInt(); // Read keyboard input, (integer)
		System.out.print("Sekund: ");
		secondsStart = keyboardInput.nextInt(); // Read keyboard input, (integer)
		
		System.out.println(); // Print text
		System.out.println("Målgångstid:"); // Print text
		System.out.println("------------"); // Print text
		System.out.print("Timme: "); // Print text
		hoursGoal = keyboardInput.nextInt(); // Read keyboard input, (integer)
		System.out.print("Minut: "); // Print text
		minutesGoal = keyboardInput.nextInt(); // Read keyboard input, (integer)
		System.out.print("Sekund: "); // Print text
		secondsGoal = keyboardInput.nextInt(); // Read keyboard input, (integer)
		
		timeStart = hoursStart*3600 + minutesStart*60 + secondsStart; // Recalculate the start time to seconds
		timeGoal = hoursGoal*3600 + minutesGoal*60 + secondsGoal; // Recalculate the goal time to seconds
		timeDiff = timeGoal-timeStart; // Time difference between goal and start time, can be negative if goal time is earlier then start time
		resultHour = timeDiff/3600; // Calculate the number of hours for varvet time
		timeHourRem = timeDiff%3600; // Take the remainder to get minutes and seconds for varvet time
		resultMinute = timeHourRem/60; // Calculate the number of minutes for varvet time
		resultSecond = timeHourRem%60; // What is left are the seconds for varvet time
		
		System.out.println(); // Print text
		System.out.println("Resultat: "+ resultHour + " timme " + resultMinute + " minuter " + resultSecond + " sekunder "); // Print the result time 
	}
}