package WordNGrams;

import java.io.IOException;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */
import java.util.*;
import java.util.Random;

import AbstractGeneratingRandomText.EfficientMarkovModel;
import AbstractGeneratingRandomText.IMarkovModel;
import AbstractGeneratingRandomText.MarkovFourA;
import AbstractGeneratingRandomText.MarkovModelA;
import AbstractGeneratingRandomText.MarkovOneA;
import AbstractGeneratingRandomText.MarkovZeroA;
import GeneratingRandomText.FileResource;

public class MarkovRunner {
   
	public void runModel(WordNGrams.IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
	public void runModel(WordNGrams.IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    public void runMarkov() throws IOException {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 50;
    
//        MarkovWordOne mwo = new MarkovWordOne();
//        runModel(mwo, st, size, 139);
        
//        MarkovWordTwo mwt = new MarkovWordTwo();
//        runModel(mwt, st, size, 832);
		
		 MarkovWord mwt = new MarkovWord(3);
         runModel(mwt, st, size, 621);

    }
    public void testHashMap() throws IOException {
    	FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 50;
    	
    	
//    	hashMapMarkovWord hmmw = new hashMapMarkovWord(2);
//    	runModel(hmmw, "this is a test yes this is really a test",50,42);
    	
    	hashMapMarkovWord hmmw = new hashMapMarkovWord(2);
    	runModel(hmmw, st,50,65);
    }
    public void compareMethods() throws IOException {
    	FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 100;
		
		
		
		long startTime = System.nanoTime();
		
		MarkovWord mThree = new MarkovWord(2);
	    runModel(mThree, st, size, 42);
	    
	    long endTime = System.nanoTime();
	    long executionTime
        = (endTime - startTime) / 1000000;
	    
	    
	    long startTime1 = System.nanoTime();
		
	    hashMapMarkovWord emm = new hashMapMarkovWord(2);
	    runModel(emm,st,size,42);
	    
	    long endTime1 = System.nanoTime();
	    long executionTime1
        = (endTime1 - startTime1) / 1000000;
	    
	    System.out.println("MarkoModel takes "
                + executionTime + "ms");
	    
	    System.out.println("EfficientMarkovModel takes "
                + executionTime1 + "ms");
 		
 		
    	
    }
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}

