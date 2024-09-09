package AbstractGeneratingRandomText;

/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Random;

import AbstractGeneratingRandomText.AbstractMarkovModel;

public class MarkovFourA extends AbstractMarkovModel
{ 
    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }
    
    public String getRandomText(int numChars)
    {      
         if(myText==null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index,index+4);
        sb.append(key);
    
        for(int k=0; k < numChars-4; k++)
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
}
