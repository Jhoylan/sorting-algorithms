package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingZipCodes {

	@Test
	void test() {
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(null);
		
		List<Integer> zipCodes = new ArrayList<>();
		//the file contains 22302 zip codes
		try {
			zipCodes = txt.txtToArray("C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/zipcodes.txt",
					22302);	
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist");
		}
		
		QuickSort quickSort = new QuickSort();
		zipCodes = quickSort.sort(zipCodes);
		
		List<String> stringZipCodes = new ArrayList<>();
		
		for(int i = 0; i < zipCodes.size(); i++) {
			String temp = String.valueOf(zipCodes.get(i));
			stringZipCodes.add(temp);
		}
		
		ManipulatingTxtFiles text = new ManipulatingTxtFiles(stringZipCodes);
		text.creatingATxtFile("sortedZipCodes.txt");
		
		Assertions.assertEquals(true, quickSort.isCorrect());
	}

}
