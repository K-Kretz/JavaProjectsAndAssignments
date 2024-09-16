package WordNGrams;
import java.util.*;

public class WordGram{

	private String[] myWords;
	private int myHash;
	
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		System.arraycopy(source, start, myWords, 0, size);
	}
	@Override
	public int hashCode() {
		int myHash = this.toString().hashCode();
		return myHash;	
	}
	
	public String wordAt(int index) {
		
		if(index <0 || index >= myWords.length)
		{
			throw new IndexOutOfBoundsException("bad index "+index);
		}
		return myWords[index];
	}
	
	public int length() {
		return myWords.length;
	}
	
	public String toString()
	{
		String thisString = "";
		for(String word : myWords)
		{
			thisString += word + " ";;
		}
		return thisString.trim();
	}
	
	public boolean equals(Object o) {
		
		WordGram other = (WordGram) o;
		
		if(this.length() != other.length())
			return false;

		for(int i=0; i<myWords.length; i++)
		{
			if(! myWords[i].equals(other.wordAt(i)))
				return false;
		}
		return true;
	}
	public WordGram shiftAdd(String word) {
		
		WordGram nwg = new WordGram(myWords, 0, myWords.length);
		
		for(int i=0; i<myWords.length-1; i++)
		{
			nwg.myWords[i] = myWords[i+1];	
		}
		nwg.myWords[myWords.length-1] = word;
		
		return nwg;
	}

}
