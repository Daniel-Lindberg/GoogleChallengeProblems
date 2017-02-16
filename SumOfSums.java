import java.util.Scanner;
import java.util.*;


public class SumOfSums
{
	protected static List<String> arrlist = new ArrayList<>();
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number of tests:");
		int trials = reader.nextInt();
		List<List<Integer>> listOfIntArrays = new ArrayList<List<Integer>>();
		List<Integer> intArray = new ArrayList<Integer>();		

		for(int i= 0; i< trials+1; i++){
			String[] tempArray = (reader.nextLine().split("\\s+"));
			if(tempArray.length>1){			
				for(int j = 0; j< tempArray.length; j++){
					intArray.add(Integer.parseInt(tempArray[j]));
				}
				listOfIntArrays.add(intArray);
				System.out.println(intArray);
				intArray.clear();
			}
		}
		for(int i = 0; i< listOfIntArrays.size(); i++){
			List<Integer[]>	subArray = getAllSubArrays(listOfIntArrays.get(i));
			List<Integer> maxValues = new ArrayList<Integer>();			
			for(int j = 0; j< subArray.size(); j++){
				int max = 0;				
				for(int k =0; k< subArray.get(j).length; k++){
					if(subArray.get(j)[k] > max ) {
						max = subArray.get(j)[k];
					}									
				}
				maxValues.add(max);
			}
			Collections.sort(maxValues);	
		}

	}

	static List<Integer[]> getAllSubArrays(List<Integer> ie){
		Integer[] array1 = new String[ie.size()];
		array1 = ie.toArray(array1);
		List<Integer[]> subArrays = new ArrayList<Integer[]>();
		int myArrayLength = sizeof(myArray)/sizeof(*myArray);
		int i, j;
		for(j=i=0;i<myArrayLength;++i){
		    printf("(%d,%d)", myArray[j], myArray[i]);
		    if(i == myArrayLength -1){
		        i = j++;//++j - 1;
		        printf("\n");
		    }
		}
			
		return subArrays;
	}
}
