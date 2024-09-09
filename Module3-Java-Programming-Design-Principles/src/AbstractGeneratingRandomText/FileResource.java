package AbstractGeneratingRandomText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileResource {

	private static  File file;
	private String fileText;
	
	
	
	public FileResource() throws IOException {
		
		JFrame frame = new JFrame();

	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.getSelectedFile();

	    int option = fileChooser.showOpenDialog(frame);
	    if(option == JFileChooser.APPROVE_OPTION)
	    {
	       file = fileChooser.getSelectedFile();
	    } 	 
	    fileText = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

	}
	
	public String asString(){
		return fileText;	
	}
	
	
}
