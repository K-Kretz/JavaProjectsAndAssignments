package MainstreamJava;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFiles {

	public void readAndPrint() throws IOException {
		Path p = Paths.get("C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module-4-Java-Programming-Design-Principles\\src\\data\\testData");
		BufferedReader reader = Files.newBufferedReader(p);
		while(true) {
			String line = reader.readLine();
			if( line == null)
				break;

		System.out.println(line);
		}
	}
	
	public void readAndPrintURL(String url) throws IOException {
		URL source = new URL(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(source.openStream()));
		while(true) {
			String line = reader.readLine();
			if( line == null)
				break;

		System.out.println(line);
		}
	}
}
