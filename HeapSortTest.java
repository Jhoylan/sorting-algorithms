package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void sortTest() {
		HeapSort array = new HeapSort();	
		array.populating(10000, 1, 100);
		array.sort(array.getArray());
		
		Assertions.assertEquals(true, array.isCorrect());
		
		
	}

}
