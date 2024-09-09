package AbstractGeneratingRandomText;


/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */
import java.util.*;
import java.util.Random;

import AbstractGeneratingRandomText.AbstractMarkovModel;

public class MarkovZeroA extends AbstractMarkovModel{

	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	public String getRandomText(int numChars)
	{
		if (myText == null)
		{
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++)
		{
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		return sb.toString();
	}
}