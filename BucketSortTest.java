package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BucketSortTest {

	@Test
	void sortTest() {
		BucketSort array = new BucketSort();	
		array.populating(10000, 0, 100);
		array.sort(array.getArray());
					
		Assertions.assertEquals(true, array.isCorrect());
	}

}
