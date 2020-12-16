package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadixSortTest {

	@Test
	void sortTest() {
		RadixSort radix = new RadixSort();
		radix.populating(10000, 0, 100);
		radix.sort(radix.getArray());
		
		Assertions.assertEquals(true, radix.isCorrect());
		
	}

}
