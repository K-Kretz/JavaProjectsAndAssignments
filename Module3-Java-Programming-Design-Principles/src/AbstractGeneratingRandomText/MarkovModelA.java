package AbstractGeneratingRandomText;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModelA extends AbstractMarkovModel{

	private int model;
	
	 public MarkovModelA(int n) 
	 {
	        model = n;
	        myRandom = new Random();
	 }
	
	public String getRandomText(int numChars)
	{ 
        if(myText==null)
           return "";
       
       StringBuilder sb = new StringBuilder();
       int index = myRandom.nextInt(myText.length()-model);
       String key = myText.substring(index,index+model);
       sb.append(key);
   
       for(int k=0; k < numChars-model; k++)
       {
           ArrayList<String> follows = getFollows(key);
           //System.out.println("key " + key + " " + follows);
           if(follows.size() == 0)
               break;
       
           index = myRandom.nextInt(follows.size());
           String next = follows.get(index);
           sb.append(next);
           key = key.substring(1) + next;
       }   
       return sb.toString();
   }

	@Override
	public String toString() {
		return "MarkovModel of order " + model;
	}

}
