package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void partitionTest() {
		QuickSort array = new QuickSort();
		List<Integer> controlledArray = new ArrayList<>();
		
		/*controlledArray.add(10);
		controlledArray.add(8);
		controlledArray.add(2);
		controlledArray.add(5);
		controlledArray.add(7);
		controlledArray.add(9);
		controlledArray.add(3);
		controlledArray.add(1);
		controlledArray.add(4);
		controlledArray.add(6);*/
		
		//controlledArray.add(4);
		controlledArray.add(4);
		controlledArray.add(8);
		controlledArray.add(5);
		
		System.out.println(controlledArray);
		
		List<Integer> orderedArray = array.partition(controlledArray);
		
		System.out.println("The final array is");
		System.out.println(orderedArray);
	}

}
