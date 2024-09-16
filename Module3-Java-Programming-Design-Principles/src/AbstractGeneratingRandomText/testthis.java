package AbstractGeneratingRandomText;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import AbstractGeneratingRandomText.MarkovRunnerWithInterface;

class testThis {

//	@Test
//	void testRunMarkovZero() throws IOException {
//		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovZero();
//	}
//	@Test
//	void testRunMarkovZero() throws IOException {
//		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovZero();
//	}
	@Test
	void testRunMarkovZero() throws IOException {
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		mrwi.testHashMap();
	}

}