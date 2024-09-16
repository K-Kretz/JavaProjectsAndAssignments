package WordNGrams;
import java.util.*;

public class MarkovWordTwo implements IMarkovModel{
	
	private String[] myText;
	private Random myRandom;
	
	public MarkovWordTwo() {
		
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
          int index = myRandom.nextInt(myText.length-2);
          String key1 = myText[index];
          String key2 = myText[index+1];
          sb.append(key1);
          sb.append(" ");
          sb.append(key2);
          sb.append(" ");
    
        for(int k=0; k < numWords-2; k++)
        {
            ArrayList<String> follows = getFollows(key1,key2);
//            System.out.println("key is: " + key);
//            System.out.println(follows);
            if(follows.size() == 0)
                break;
        
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }   
        return sb.toString().trim();
    }
	
    private ArrayList<String> getFollows(String key1,String key2)
    {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while(pos < myText.length)
        {
            int start = indexOf(myText,key1,key2,pos);
            if(start ==-1)
                break;
            if(start + key2.length() >= myText.length-1)
                break;
            String next = myText[start+2];
            follows.add(next);
            pos = start+1;
        }
        return follows;
    }

	private int indexOf(String[] text,String target1, String target2, int pos) {
		
		for(int i = pos; i<text.length; i++)
		{
			if(text[i].equals(target1) && text[i+1].equals(target2))
				return i;
		}
		
		return -1;
	}
	public void testIndexOf() {
		String sent = "this is just a test yes this is a simple test";
		
		String[] testString = sent.split("\\s+");
		System.out.println(indexOf(testString,"this","is",0));
		
	}
}
