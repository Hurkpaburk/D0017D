
public class Elitserietabelljohbef {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2014-09-01
	// Senast uppdaterad: 2014-09-01, Johan Bergström 
	// Beskrivning: This class shall create a table with Hockey score
	// Version: 1, First Release 
	//****************************************************************** 

	//------------------------------------------------------
	// Beskrivning: Calculates goal differance and print a hockey table 
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public static void main(String[] args) {
		int[] gm = {122, 107, 91}; // Declare GM array, [HV71, SAIK, LHF]
		int[] im = {90, 83, 80}; // Declare IM array, [HV71, SAIK, LHF]
		int[] goalDiff = new int[gm.length]; // Declare GM - IM Variable, same length as gm
		
		for (int i = 0; i < gm.length; i++) { // Loop over GM and IM arrays to calculate goal difference for each team
			goalDiff[i] = gm[i] - im[i];
		}

		System.out.println("\tM\tV\tO\tF\tGM\tIM\t"+"+\\-\t"+"P"); // Print Header of hockey table
		System.out.println("="+"="+"="+"="+"="+"="+"="+"="+"="+"="
				+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="
				+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="
				+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="
				+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="+"="
				+"="+"="+"="+"="+"="+"="+"="+"="); // Print divider
		System.out.println("1. HV71\t38\t19\t8\t11\t"+gm[0]+"\t"+im[0]+"\t"+goalDiff[0]+"\t71"); // Print HV71 score, Array position 0
		System.out.println("2. SAIK\t36\t18\t7\t11\t"+gm[1]+"\t"+im[1]+"\t"+goalDiff[1]+"\t65"); // Print SAIK score, Array position 1
		System.out.println("3. LHF\t38\t18\t6\t14\t"+gm[2]+"\t"+im[2]+"\t"+goalDiff[2]+"\t64"); // Print LHF score, Array position 2
	}
}
