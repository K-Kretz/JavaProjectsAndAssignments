package AbstractGeneratingRandomText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel {
	
	private int model;
	private HashMap<String, ArrayList<String>> myMap;
	
	public EfficientMarkovModel(int n) 
	{
	        model = n;
	        myRandom = new Random();
	        myMap = new HashMap<String, ArrayList<String>>();
	}
	 public void setTraining(String s) {
	        myText = s.trim();
	        buildMap();
	        printHashMapInfo();
	}
	 
	public void buildMap() {
		
		for(int i = 0; i<=myText.length()-model; i++)
		{
			String key = myText.substring(i,i+model);
			 
			if(!myMap.containsKey(key))
			{
				myMap.put(key, getFollows(key));
			} 
		}	 
	}
	public String getRandomText(int numChars) {
		
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-model);
	    String key = myText.substring(index,index+model);
	    sb.append(key);
	    
		for(int i = 0; i<myText.length()-model; i++)
		{	
			if(myMap.get(key).size() != 0)
			{
				index = myRandom.nextInt(myMap.get(key).size());
		        String next = myMap.get(key).get(index);
		        sb.append(next);
		        key = key.substring(1) + next;
			}
		}
		return sb.toString();
	}
	protected ArrayList<String> getFollows(String key)
	{
		ArrayList<String> follows = new ArrayList<String>();
	        
		int pos = 0;
	        
		while(pos < myText.length())
        {
            int start = myText.indexOf(key,pos);
            if(start ==-1)
                break;
            if(start + key.length() >= myText.length()-1)
                break;
            String next = myText.substring(start+key.length(), start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }
        return follows;
	}
	public void printHashMapInfo() {
		
//		for(String key : myMap.keySet())
//		{
//			System.out.println(key + " - " + myMap.get(key).toString());
//		}
		System.out.println(myMap.keySet().size());
		
		int largestValue = 0;
		String keysMax = "";
		for(String key : myMap.keySet())
		{
			if(myMap.get(key).size() > largestValue)
				largestValue = myMap.get(key).size();
		}
		System.out.println("Max number of values following a key is: " + largestValue);
		for(String key : myMap.keySet())
		{
			if(myMap.get(key).size() == largestValue)
				System.out.println("key that is max size: " + key);
		}
	}

	@Override
	public String toString() {
		return "MarkovModel of order " + model;
	}

}
