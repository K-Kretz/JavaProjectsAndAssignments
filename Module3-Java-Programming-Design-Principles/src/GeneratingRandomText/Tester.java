package GeneratingRandomText;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import AbstractGeneratingRandomText.MarkovRunnerWithInterface;

class Tester {

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
		mrwi.runMarkov();
	}

}
