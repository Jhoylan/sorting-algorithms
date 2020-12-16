package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingSortTest {

	@Test
	void sortTest() {
		CountingSort array = new CountingSort();
		array.setMaximum(100);
		array.populating(1000, 0, 100);
		array.sort(array.getArray());
		
		
		Assertions.assertEquals(true, array.isCorrect());

	}

}
