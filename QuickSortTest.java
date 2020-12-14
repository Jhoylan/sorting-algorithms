package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void partitionTest() {
		QuickSort array = new QuickSort();
		array.populating(100000);
		array.sort(array.getArray());	
		array.showArray();
		
		Assertions.assertEquals(true, array.isCorrect());
		
		
		
	}

}
