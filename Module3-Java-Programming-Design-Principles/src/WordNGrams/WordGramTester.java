package WordNGrams;

import java.util.*;

import org.junit.Test;

public class WordGramTester {

//	@Test
//	public void testWordGram() {
//		String source = "this is a test this is a test this is a test of words";
//		String[] words = source.split("\\s+");
//		int size =4;
//		for(int index =0; index<=words.length-size; index++)
//		{
//			WordGram wg = new WordGram(words, index, size);
//			System.out.println(index + "\t" + wg.length()+"\t" + wg);
//		}
//	}
	
//	@Test
//	public void testWordGramEquals() {
//		String source = "this is a test this is a test this is a test of words";
//		String[] words = source.split("\\s+");
//		ArrayList<WordGram> list = new ArrayList<WordGram>();
//		int size =4;
//		for(int index =0; index<=words.length-size; index++)
//		{
//			WordGram wg = new WordGram(words, index, size);
//			list.add(wg);
//		}
//		WordGram first = list.get(0);
//		System.out.println("Checking first "+first);
//		for(int i= 0; i<list.size(); i++)
//		{
//			if(first.equals(list.get(i)))
//				System.out.println("MAtched at "+i+ " "+ list.get(i));
//		}
//	}
	@Test
	public void testWordGram() {
		String source = "this is a test";
		String[] words = source.split("\\s+");
		int size =4;

			WordGram wg = new WordGram(words, 0, size);
			System.out.println(wg.hashCode());
			wg = wg.shiftAdd("shift");
			System.out.println(wg);

	}
}
