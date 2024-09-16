package WordNGrams;

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
//	@Test
//	void testRunMarkovZero() throws IOException {
//		MarkovRunner mrwi = new MarkovRunner();
//		mrwi.runMarkov();
//	}
	@Test
	void testHashCodeMarkovWord() throws IOException {
		MarkovRunner mrwi = new MarkovRunner();
		mrwi.runMarkov();
	}

}
