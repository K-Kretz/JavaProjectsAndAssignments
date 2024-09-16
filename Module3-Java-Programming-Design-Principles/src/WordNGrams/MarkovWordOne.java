package WordNGrams;

/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MarkovWordOne implements IMarkovModel{
	
	private String[] myText;
	private Random myRandom;
	
	public MarkovWordOne() {
		
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
    public String getRandomText(int numWords)
    {
        if(myText==null)
            return "";
        
          StringBuilder sb = new StringBuilder();
          int index = myRandom.nextInt(myText.length-1);
          String key = myText[index];
          sb.append(key);
          sb.append(" ");
    
        for(int k=0; k < numWords-1; k++)
        {
            ArrayList<String> follows = getFollows(key);
//            System.out.println("key is: " + key);
//            System.out.println(follows);
            if(follows.size() == 0)
                break;
        
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }   
        return sb.toString().trim();
    }
	
    private ArrayList<String> getFollows(String key)
    {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while(pos < myText.length)
        {
            int start = indexOf(myText,key,pos);
            if(start ==-1)
                break;
            if(start + key.length() >= myText.length-1)
                break;
            String next = myText[start+1];
            follows.add(next);
            pos = start+1;
        }
        return follows;
    }

	private int indexOf(String[] text,String target, int pos) {
		
		for(int i = pos; i<text.length; i++)
		{
			if(text[i].equals(target))
				return i;
		}
		
		return -1;
	}
	public void testIndexOf() {
		String sent = "this is just a test yes this is a simple test";
		
		String[] testString = sent.split("\\s+");
		System.out.println(indexOf(testString,"this",0));
		
	}
	
}
