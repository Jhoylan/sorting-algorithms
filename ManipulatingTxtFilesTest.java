package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ManipulatingTxtFilesTest {

	@Test
	void readinTxtTest() {
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(null);
		List<Integer> zipCodes = new ArrayList<>();
		//the file contains 22302 zip codes
		try {
			zipCodes = txt.txtToArray("C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/zipcodes.txt",
					22302);	
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist");
		}
		
		
	}

}
