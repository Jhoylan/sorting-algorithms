package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void sortTest() {
		HeapSort array = new HeapSort();	
		array.populating(1000);
		array.sort(array.getArray());
		array.showArray();
		Assertions.assertEquals(true, array.isCorrect());
	}

}
