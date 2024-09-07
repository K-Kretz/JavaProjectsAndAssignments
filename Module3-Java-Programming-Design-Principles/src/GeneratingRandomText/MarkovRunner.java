package GeneratingRandomText;

import java.io.IOException;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */
import java.util.*;
import java.util.Random;

public class MarkovRunner {
    public void runMarkovZero() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        markov.setRandom(88);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovOne() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setRandom(273);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    public void testGetFollows(){
        MarkovOne markov = new MarkovOne();
        String st = "This is a test";
        ArrayList<String> list = markov.getFollows(st);
        for(String followsWords : list)
            System.out.println(followsWords);
            
        System.out.println(list.size());
    }
    public void runMarkovTwo() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //testing
        //st = "this is a test yes a test";
        MarkovTwo markov = new MarkovTwo();
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    public void runMarkovThree() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //testing
        //st = "this is a test yes a test";
        MarkovThree markov = new MarkovThree();
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
     public void runMarkovFour() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //testing
        //st = "this is a test yes a test";
        MarkovFour markov = new MarkovFour();
        markov.setRandom(371);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    public void runMarkovModel() throws IOException {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //testing
        //st = "this is a test yes a test";
        MarkovModel markov = new MarkovModel(8);
        markov.setRandom(365);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
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

