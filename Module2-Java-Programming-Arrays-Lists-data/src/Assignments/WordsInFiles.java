/**
 * Assignment 1: CodonCount
 * 
 * Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in. 
 * 
 * Developer: Keith Kretz
 * Date Created: 7/12/2024
 * Last Updated: 7/12/2024
 */
package Assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordsInFiles {


	private static HashMap<String,ArrayList<String>> wordsInFile;
	
	public WordsInFiles() {
		
		wordsInFile = new HashMap<String, ArrayList<String>>();
		
	}
	
	private static void addWordsFromFile(File f) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String line;
		
		while((line = br.readLine()) != null)
		{
			String[] words = line.split("\\s+");
			
			for(int i=0; i<words.length; i++)
			{
				if(!wordsInFile.containsKey(words[i]))
				{	
					ArrayList<String> wordFileList = new ArrayList<>();
					wordsInFile.put(words[i], wordFileList);
					wordsInFile.get(words[i]).add(f.getName());	
				}
				else
				{				
					if(!wordsInFile.get(words[i]).contains(f.getName()))
					{
						wordsInFile.get(words[i]).add(f.getName());	
					}
				}
			}
			words = null;
		}
		br.close();
	}
	
	public void buildWordFileMap() throws IOException {
		
		if(!wordsInFile.isEmpty())
			wordsInFile.clear();
		
		JFrame frame = new JFrame();

		DirectoryResource(frame);
	    

		//addWordsFromFile(files[i]);

		
		
	}
	
	private static void DirectoryResource(final JFrame frame) throws IOException{  
	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION)
        {
           File[] files = fileChooser.getSelectedFiles();
           for(File file: files)
           {
        	   addWordsFromFile(file);
           }    
        } 
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		WordsInFiles wif = new WordsInFiles();
		
		wif.buildWordFileMap();

	}

}
