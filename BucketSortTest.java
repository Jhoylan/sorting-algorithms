package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BucketSortTest {

	@Test
	void irregularDistributionTest() {
		BucketSort array = new BucketSort();	
		array.irregularDistributionArray(100, 1000);
		array.sort(array.getArray());
		array.showArray();
		
		Assertions.assertEquals(true, array.isCorrect());
	}
	
	/*@Test
	void uniformDistributionTest() {
		BucketSort array = new BucketSort();	
		array.uniformDistributionArray(100, 10);
		array.sort(array.getArray());
		array.showArray();	
		
		Assertions.assertEquals(true, array.isCorrect());
	}*/
	
}
