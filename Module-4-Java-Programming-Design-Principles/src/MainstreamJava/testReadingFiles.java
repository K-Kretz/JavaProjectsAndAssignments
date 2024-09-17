package MainstreamJava;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class testReadingFiles {

	@Test
	void testReadAndPrint() throws IOException {
		ReadingFiles rf = new ReadingFiles();
		rf.readAndPrint();
	}
//
//	@Test
//	void testReadAndPrintURL() {
//		fail("Not yet implemented"); // TODO
//	}

}
