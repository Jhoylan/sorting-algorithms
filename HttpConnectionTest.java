package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HttpConnectionTest {

	@Test
	void readingZipCodesAndCreatingATxtFile() {
		HttpConnection test = new HttpConnection();
		List<String> zipCodes = new ArrayList<>();
			
		//745 is the last page
		for(int i = 1; i < 746; i++) {
			String number = String.valueOf(i);
			List<String> list = test.tagToString(test.getTagsCeps(number));
			zipCodes.addAll(list);
		}
		
	}

}
