
import java.util.List;
import java.util.ArrayList;

public class Shuffle{
	protected static List<String> arrlist = new ArrayList<>();
	public List<String> getPermutations(String str, int charIndex, String output){

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
