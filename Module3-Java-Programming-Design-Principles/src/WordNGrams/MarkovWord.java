package WordNGrams;

import java.util.*;

public class MarkovWord implements IMarkovModel{

	private String[] myText;
	private Random myRandom;
	private int myOrder;
	
	public MarkovWord(int order) {
		myOrder = order;
		myRandom = new Random();
	}
	
	@Override
	public void setTraining(String text) {
		myText = text.split("\\s+");
		
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
        WordGram kGram = new WordGram(myText, index, numWords);
        sb.append(kGram);
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows.size() == 0) {
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
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while(pos < myText.length)
        {
            int start = indexOf(myText,kGram,pos);
            if(start ==-1)
                break;
            if(start + kGram.length() >= myText.length-1)
                break;
            String next = myText[start+1];
            follows.add(next);
            pos = start+myOrder;
        }
        return follows;
    }

	@SuppressWarnings("unlikely-arg-type")
	private int indexOf(String[] words,WordGram target, int start) {
		
		for(int i = start; i<words.length; i++)
		{
			if(words[i].equals(target))
				return i;
		}
		
		return -1;
	}
}
