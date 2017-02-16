import java.util.Scanner;
import java.util.*;


public class LazySpellingBee
{
	protected static List<String> arrlist = new ArrayList<>();
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number of tests:");
		int trials = reader.nextInt();
		String [] words = new String[trials];
		Integer[] totalIterations = new Integer[trials];

		for(int i= 0; i< trials; i++){
			words[i] = reader.next().toString();		
		}

		List<String> tempWordList = new ArrayList<String>();		
		for(String str: words){
			tempWordList = getPermutations(str, str.length()-1, "");
			int counter = 0;
			Set<String> uniqueWords = new HashSet<String>();
			for(String str1: tempWordList){
				if(checkWord(str,str1)){
					uniqueWords.add(str1);		
				}							
			}
			System.out.println("Case: "+ str+ " count: " + uniqueWords.size());
			arrlist.clear();
		}
		
/* outdated solution
		Set<Character> characterList = new HashSet<Character>();
		List<Integer> totalCharOcc = new ArrayList<Integer>();		
		int letterIndex=0;
		for(int i =0; i< words.length; i++){
			while(letterIndex< words[i].length()){
				characterList.add(words[i].charAt(letterIndex));
				letterIndex++;		
			}
			Iterator<Character> it = characterList.iterator();
			char value = Character.MIN_VALUE;			
			while(it.hasNext()){
				totalCharOcc.add(findAllLetters(words[i], it.next()));	
			}
			int recursiveChars = 1;
			for (int j = 0; j< totalCharOcc.length(); j++){
				recursiveChars *= factorial(totalCharOcc.get(j));			
			}
			totalIterations[i] = factorial(words[i].length())/recursiveChars;  
			totalCharOcc.clear();			
			characterList.clear();
			letterIndex=0;
		}
		for(int i = 0; i< totalIterations.length; i++){
			System.out.println("Word: "+ words[i] + " count: "+ totalIterations[i]);

		}
*/				
	}
	int factorial(int n){
		int fact =1;
		for(int i =1; i<=n ; i++){
			fact *= i;		
		}
		return fact;
	}
	int findAllLetters(String word, char searchCharacter){		
		int index = word.indexOf(searchCharacter);		
		while(index >= 0){
			index = word.indexOf(searchCharacter, index+1);		
		}	
		return index;
	}

	//bad way to check for this
	static boolean checkWord(String W, String A){
		//Check for length
		if(W.length() != A.length()){
			return false;		
		}
		boolean isThere = false;
		for (int i =0; i< A.length(); i++){
			if(A.charAt(i) == W.charAt(i)){
				isThere = true;			
			}
			if(i-1>0){
				if(A.charAt(i) == W.charAt(i-1)){
					isThere = true;			
				}			
			}
			if(i+1<W.length()){
			  	if(A.charAt(i) == W.charAt(i+1)){
					isThere = true;
				}
			}
			if(!isThere){
				return false;			
			}	
			isThere = false;
		}
		return true;
	}

	static List<String> getPermutations(String str, int charIndex, String output){

		if (str.length() == 0){
			arrlist.add(output);
			return null;
		}	
		if (charIndex == -1){
			return null;
		}
		String character = str.toCharArray()[charIndex]+"";
		getPermutations(str, --charIndex, output);
	
		String remaining = "";
	
		output = output +character;

		remaining = str.substring(0, charIndex+1) + str.substring(charIndex +2);
	
		getPermutations(remaining, remaining.length() -1 , output);
	
		return arrlist;

	}
}
