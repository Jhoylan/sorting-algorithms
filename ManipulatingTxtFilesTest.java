package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ManipulatingTxtFilesTest {

	@Test
	void txtToArrayTest() {
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(null);
		List<Integer> zipCodes = new ArrayList<>();
		//the file contains 22302 zip codes
		try {
			zipCodes = txt.txtToArray("C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/zipcodes.txt",
					5);	
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist");
		}
		
		System.out.println(zipCodes);
	}
	
	@Test
	void ArrayToTxtTest() {
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(null);
		
		List<Integer> zipCodes = new ArrayList<>();
		
		try {
			zipCodes = txt.txtToArray("C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/zipcodes.txt",
					5);	
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist");
		}
		
		List<String> zipCodeString = new ArrayList<>();
		
		for(int i = 0; i < zipCodes.size(); i++) {
			String temp = String.valueOf(zipCodes.get(i));
			zipCodeString.add(temp);
		}
		
		ManipulatingTxtFiles text = new ManipulatingTxtFiles(zipCodeString);
		text.creatingATxtFile("C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/test.txt");
	}
}
