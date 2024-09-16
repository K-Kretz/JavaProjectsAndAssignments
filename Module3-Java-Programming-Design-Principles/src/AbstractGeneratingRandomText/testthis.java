package AbstractGeneratingRandomText;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import AbstractGeneratingRandomText.MarkovRunnerWithInterface;
import GeneratingRandomText.MarkovRunner;

class testthis {

//	@Test
//	void testRunMarkovZero() throws IOException {
//		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovZero();
//	}
//	@Test
//	void testRunMarkovZero() throws IOException {
//		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovModel();
//	}
	@Test
	void testRunMarkovZero() throws IOException {
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		mrwi.testHashMap();
	}

}