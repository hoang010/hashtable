import java.util.Random;
import java.util.Scanner;

public class Hash_Table_App {
	public static void main(String[] args) {
		Hash_Table table1 = new Hash_Table();											//table to store data using first hash function
		Hash_Table table2 = new Hash_Table();					//table to store data using second hash function
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
//		int list1 [] = {1234567, 2134567, 2134580, 7546123, 5421367, 5241637, 2514367, 7425136, 5472361, 4582697, 6645268, 2124563, 5422136, 5236241, 2634152, 3124256, 4589523,
//				2635874, 9475862, 9652478, 7845123, 7843152, 3154278, 5418723, 6478591, 7145896, 4857691, 9687451, 9784561, 9874516, 9145687, 9584761,
//				9746135, 9741563, 9637415, 9471635, 9514763, 9874613, 1478963, 6748913, 9167843, 9117484, 9494786, 9644987, 8475691, 8754691, 8164579};
// to use hard coded data
		for (int x = 0; x < 126; x++) {													//loop to control amount of numbers generated
			int randnum = rand.nextInt(999999) + ((rand.nextInt(8) + 1)*1000000);		//generate random 7digit number; 1st rand gives us the last 6 digits, 2nd rand is separate and gives us the 1st digit so that the resulting number will always be 7 digits
			table1.create_node(randnum);												//adds number to first hash table
		}
		for (int a = 0; a <26;a++) {													//adds number to second hash table
//			table2.create_node2(list1[a]);	
			int randnum = rand.nextInt(999999) + ((rand.nextInt(8) + 1)*1000000);		//generate random 7digit number; 1st rand gives us the last 6 digits, 2nd rand is separate and gives us the 1st digit so that the resulting number will always be 7 digits
			table2.create_node2(randnum);				
		}
		System.out.println("Table generated");			
		//feedback to know table operation completed
		
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Add NRIC number");
			System.out.println("2.Delete a NRIC number");
			System.out.println("3.Print out whole list of NRIC number");
			System.out.println("4.Search for a NRIC number");
			System.out.print("Enter Selection: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:												//allows user to manually add nric number
				System.out.print("Enter the NRIC number to be added: " );
				int nric = sc.nextInt();				
				table1.create_node(nric);	
				table2.create_node2(nric);		
				break;
				
			case 2:												//allows user to delete a nric number
				System.out.print("Enter the NRIC number to be deleted: ");
				nric = sc.nextInt();				
				table1.delete_node(nric);
				table2.delete_node2(nric);
				break;
		
			case 3:												//prints out whole list of numbers 
				System.out.println("Table 1:");
				for (int i = 0;i<400;i++) {
					table1.print_node(i);
					
				}
				System.out.println();
				System.out.println("Table 2:");
				for (int i = 0;i<20;i++) {
					table2.print_node(i);
				}
				System.out.println();
				break;
				
			case 4:												//search for a specific nric number
				System.out.print("Enter NRIC number to search for: ");
				nric = sc.nextInt();
				System.out.println("\nTable 1:");
				table1.search(nric);
				System.out.println("\nTable 2: ");
				table2.search2(nric);
				System.out.println();
				break;
			}
		}
		
	}
}
