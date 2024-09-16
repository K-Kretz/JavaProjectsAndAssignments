package WordNGrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class hashMapMarkovWord implements IMarkovModel{

	private String[] myText;
	private Random myRandom;
	private int myOrder;
	private HashMap<WordGram, ArrayList<String>> myMap;
	
	public hashMapMarkovWord(int order) {
		myMap = new HashMap<WordGram, ArrayList<String>>();
		myOrder = order;
		myRandom = new Random();
	}
	
	@Override
	public void setTraining(String text) {
		myText = text.split("\\s+");
		buildMap();
		printHashMapInfo();
	}
	
	@Override
	public String toString() {
		return "MarkovModel of order 1";
	}
	
	@Override
	public void setRandom(int seed) {
		myRandom = new Random(seed);
		
	}
	
	@Override
	public String getRandomText(int numWords){
		
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, myOrder);
        sb.append(kGram.toString());
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows == null || follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }
        return sb.toString().trim();
    }
	
    private ArrayList<String> getFollows(WordGram kGram)
    {
    	return myMap.get(kGram);
    }
    public void buildMap() {
    	
		for(int i = 0; i<=myText.length-myOrder; i++)
		{

			WordGram wg1 = new WordGram(myText, i, myOrder);
			if(i==myText.length-myOrder && !myMap.containsKey(wg1))
			{
				myMap.put(wg1, new ArrayList<String>());
				break;
			}
			if(i==myText.length-myOrder)
				break;
			
			String follows = myText[i+myOrder];
			
            if (myMap.containsKey(wg1)) {
                myMap.get(wg1).add(follows);
            }
        	else if(i==myText.length-myOrder)
        	{
        			myMap.put(wg1, new ArrayList<String>());
        	}
        	else
        	{
        		 myMap.put(wg1, new ArrayList<String>());
        		 myMap.get(wg1).add(follows);
            }
		}	 
	}
    public void printHashMapInfo() {
		
//		for(WordGram key : myMap.keySet())
//		{
//			System.out.println(key + " - " + myMap.get(key).toString());
//		}
		System.out.println(myMap.keySet().size());
		
		int largestValue = 0;

		for(WordGram key : myMap.keySet())
		{
			if(myMap.get(key).size() > largestValue)
				largestValue = myMap.get(key).size();
		}
		System.out.println("Max number of values following a key is: " + largestValue);
		for(WordGram key : myMap.keySet())
		{
			if(myMap.get(key).size() == largestValue)
				System.out.println("key that is max size: " + key);
		}
	}
}
