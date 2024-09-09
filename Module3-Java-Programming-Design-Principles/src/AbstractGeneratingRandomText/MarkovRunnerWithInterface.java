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
    
	public void runModel(IMarkovModel markov, String text, int size) {
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
		int size = 200;
		
		MarkovZeroA mz = new MarkovZeroA();
        runModel(mz, st, size);
    
        MarkovOneA mOne = new MarkovOneA();
        runModel(mOne, st, size);
        
        MarkovModelA mThree = new MarkovModelA(3);
        runModel(mThree, st, size);
        
        MarkovFourA mFour = new MarkovFourA();
        runModel(mFour, st, size);

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
