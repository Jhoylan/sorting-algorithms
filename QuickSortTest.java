package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void sortTest() {
		QuickSort array = new QuickSort();
		array.populating(100, 1, 100);
		array.sort(array.getArray());	
				
		Assertions.assertEquals(true, array.isCorrect());
		
		
		
	}

}
