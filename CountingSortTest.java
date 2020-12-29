package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingSortTest {

	@Test
	void sortTest() {
		CountingSort array = new CountingSort(100);
		array.populating(1000, 1, 100);
		array.sort(array.getArray());
		
		
		Assertions.assertEquals(true, array.isCorrect());

	}

}
