package AbstractGeneratingRandomText;

import java.io.IOException;

import GeneratingRandomText.FileResource;
import GeneratingRandomText.MarkovFour;
import GeneratingRandomText.MarkovModel;
import GeneratingRandomText.MarkovOne;
import GeneratingRandomText.MarkovZero;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */


public class MarkovRunnerWithInterface {
    
	public void runModel(IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
//			printOut(st);
		}
    }
	public void compareMethods() throws IOException {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 1000;
		
		
		
		long startTime = System.nanoTime();
		
		MarkovModelA mThree = new MarkovModelA(2);
	    runModel(mThree, st, size, 42);
	    
	    long endTime = System.nanoTime();
	    long executionTime
        = (endTime - startTime) / 1000000;
	    
	    
	    long startTime1 = System.nanoTime();
		
	    EfficientMarkovModel emm = new EfficientMarkovModel(2);
	    runModel(emm,st,size,42);
	    
	    long endTime1 = System.nanoTime();
	    long executionTime1
        = (endTime1 - startTime1) / 1000000;
	    
	    System.out.println("MarkoModel takes "
                + executionTime + "ms");
	    
	    System.out.println("EfficientMarkovModel takes "
                + executionTime1 + "ms");
		
	}
	public void testHashMap() throws IOException {    
		
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		
	     EfficientMarkovModel emm = new EfficientMarkovModel(6);
	     runModel(emm,st,50,792);
	}
    
    public void runMarkov() throws IOException {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		
		MarkovZeroA mz = new MarkovZeroA();
        runModel(mz, st, size, 0);
    
        MarkovOneA mOne = new MarkovOneA();
        runModel(mOne, st, size, 0);
        
        MarkovModelA mThree = new MarkovModelA(3);
        runModel(mThree, st, size, 0);
        
        MarkovFourA mFour = new MarkovFourA();
        runModel(mFour, st, size, 0);

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
