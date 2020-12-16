package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingSortTest {

	@Test
	void sortTest() {
		CountingSort array = new CountingSort();
		array.populating(10000000);
		array.sort(array.getArray());

		Assertions.assertEquals(true, array.isCorrect());

	}

}
