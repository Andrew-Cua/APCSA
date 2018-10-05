package assignment_4;

import java.util.Scanner;

public class Main {
	
	static String[] swears = {" ^^  ", " $  ", " qey  "};
	static String[] rawSwears = {"^^","$","qey"};
	static int[] swearCounter = {0,0,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String sentence = "asdfasdfasdfasdf ^^ asdfasdfasdf ^^ ^^ qey $ $" + "          ";
		sentence.toLowerCase();
		String userName = getUserName(sentence);
		checkSwears(sentence);
		if(swearCounter[0] ==0 && swearCounter[1] == 0 && swearCounter[2] == 0)
		{
			System.out.println("Clean");
		}else
		{
			
		}

	}
	
	public static String getUserName(String sentence)
	{
		if(sentence.contains("-"))
		{
			int userNameIndex = sentence.indexOf("-");
			String userName = sentence.substring(0, userNameIndex -1);
			return userName;
		}
		return "No user found";
	}
	
	public static void checkSwears(String sentence)
	{
		for(int i = 0; i < swears.length; i++)
		{
			String tempSentence = sentence;
			//System.out.println("starting array index: " + i);
			countSwear(tempSentence, i);
			
		}
	}
	
	public static void countSwear(String sentence, int index)
	{
		String tempSentence = sentence;
		boolean hasSwear = tempSentence.contains(swears[index].substring(1, swears[index].length() - 1)); 
		if(hasSwear)
		{
			//System.out.println("has a swear");
			while(hasSwear)
			{
				
				int possibleSwearIndex = tempSentence.indexOf(rawSwears[index].substring(0,1));
				//System.out.println("Possibly Found Swear at: " + possibleSwearIndex);
				
				String possibleSwear = tempSentence.substring(possibleSwearIndex, rawSwears[index].length()+ 1 + possibleSwearIndex);
				//System.out.println("Possible Swear String:" + possibleSwear);
				
				String baseWord = swears[index].substring(1, swears[index].length()-1);
				String endBaseWord = swears[index].substring(0, swears[index].length()-2);
			    //System.out.println("Comparing to: " + baseWord);
				//System.out.println("Comparing to:" + endBaseWord);
				
				boolean isTrueSwear = possibleSwear.equals(baseWord);
				//System.out.println("Checks Out?: " + isTrueSwear);
				//at end of sentence
				boolean isTrueSwearEnd = possibleSwear.equals(endBaseWord);
				//System.out.println("How about at the end?: " + isTrueSwearEnd);
				
				if(isTrueSwear)
				{
					swearCounter[index]++;
				}else if(isTrueSwearEnd)
				{
					swearCounter[index]++;
				}
				
				//System.out.println(swearCounter[index]);
				tempSentence = tempSentence.substring(possibleSwearIndex + rawSwears[index].length());
				//System.out.println("Priting New Sentence");
				//System.out.println(tempSentence);
				hasSwear = tempSentence.contains(rawSwears[index]); 
			}
		}
	}

}
