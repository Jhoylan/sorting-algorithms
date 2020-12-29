package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

	/*@Test
	void randomPivotTest() {
		QuickSort array = new QuickSort();	
		array.populating(9, 1, 100);
		
		int pivot = array.getPivot(array.getArray(), "random");
		
		array.sortQuickSort(array.getArray(), pivot, "random", false);
		
		System.out.println("The sorted array is: " + array.getArray());
		
		Assertions.assertEquals(true, array.isCorrect());
		
	}*/
	
	@Test
	void pivotAsHalfTest() {
		QuickSort array = new QuickSort();	
		array.ascendingArray(15000);;
		
		Instant begin = Instant.now();
		
		int pivot = array.getPivot(array.getArray(), "half");
		
		array.sortQuickSort(array.getArray(), pivot, "half", true);
		
		Assertions.assertEquals(true, array.isCorrect());
		
		Instant end = Instant.now();
		
		Duration duration = Duration.between(begin, end);
		
		System.out.println(duration.getNano());
		
	}
	
}
