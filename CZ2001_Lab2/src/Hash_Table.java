import java.util.*;

public class Hash_Table {
	LinkedList<Integer>[] hash_table = new LinkedList[400];	
	public Hash_Table(){
		for (int i = 0; i <400;i++) {
			hash_table[i] = new LinkedList();
		}
	}
	
	public int hash_f(int nric) {
		int i=0;
		int sum=0;
		for (i=0; i<6; i++) {
			sum  = sum + nric%10;
			nric = nric/10;
		}
		sum += nric;
		return sum;
	}
	
	public int hash_f2(int nric) {
		return (nric%13);
	}
	
	public void create_node (int nric) {
		int key = hash_f(nric);		//change the nric into a key through a hash function
		hash_table[key].add(nric);	// adding the nric to the linked list
	}
	
	public void delete_node (int nric) {
		int key = hash_f(nric);			//change the nric into a key through a hash function
		hash_table[key].remove(nric);	//deleting the nric from the linked list
	}
	
	public void create_node2 (int nric) {
		int key = hash_f2(nric);
		hash_table[key].add(nric);
	}
	
	public void delete_node2 (int nric) {
		int key = hash_f2(nric);
		hash_table[key].remove(nric);
	}
	public void print_node (int key) {
		int i = hash_table[key].size();
		if (hash_table[key].size() != 0) {
			for (int j = 0; j < i ;j++) {
				System.out.print(hash_table[key].get(j) + " ");	
			}
			System.out.print("\n");
		}
	}
	
	
	public int search (int nric) {
		int key = hash_f(nric);
		int temp=0;	//hold the index in the linked list to print later
		long startTime = System.nanoTime();	//start timer
		boolean found = false;
		for (int x=0; x<=100; x++) {
			int len = hash_table[key].size();
			for (int i = 0; i < len; i++) {
				if(hash_table[key].get(i) == nric) {	//check if the index has the nric
					temp = i;
					found = true;
					break;
				}
			}
		}
		long endTime = System.nanoTime();	//end timer
		if (!found) {
			System.out.println("nric not in hash table");
		System.out.println("The number of comparison is "+ hash_table[key].size());}
		else
			System.out.println("Hash key: " + key + " "  + "At index: " + temp);
		System.out.println("Runtime is " + (endTime - startTime)/100 + "ns");
		return temp;
	}
	public void search2 (int nric) {
		int key = hash_f2(nric);
		int temp=0;
		long startTime = System.nanoTime();
		boolean found = false;
		for (int x =0; x<=100; x++) {

			
			int len = hash_table[key].size();

			for (int i = 0; i < len; i++) {
				if(hash_table[key].get(i) == nric) {

					temp = i;
					found = true;
				}
			}
		
		}
		long endTime = System.nanoTime();
		if (!found) {
			System.out.println("NRIC not in hash table");
			System.out.println("The number of comparison is "+ hash_table[key].size());
		}
		else
			System.out.println("Hash key: " + key + " "  + "At index: " + temp);
		System.out.println("Runtime is " + (endTime - startTime)/101 + "ns");
	}
}
