package AbstractGeneratingRandomText;


/**
 * Write a description of MarkovThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Random;

import AbstractGeneratingRandomText.AbstractMarkovModel;

public class MarkovThreeA extends AbstractMarkovModel{
    
    public String getRandomText(int numChars)
    { 
         if(myText==null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-3);
        String key = myText.substring(index,index+3);
        sb.append(key);
    
        for(int k=0; k < numChars-3; k++)
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
		return "MarkovModel of order 3";
	}
}
