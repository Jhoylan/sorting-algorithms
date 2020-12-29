package sortingAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class CountingSort extends SortingAlgorithm{
	
	private int maximum;
	
	public CountingSort(int max) {
		this.maximum = max;
	}
	
	@Override
	public List<Integer> sort(List<Integer> list) {
		 List<Integer> count = new ArrayList<>();
		 List<Integer> sortedList = new ArrayList<>();
		 
		for(int i = 0; i < this.maximum + 1; i++){
			count.add(0);
		}
		
		for(int i = 0; i < list.size(); i++){
			sortedList.add(0);
		}
		
		//counting
		for(int i = 0; i < list.size(); i++) {
			count.set(list.get(i), count.get(list.get(i)) + 1);
		}
		
		//accumulating
		for(int i = 1; i < count.size(); i++) {
			count.set(i, count.get(i - 1) + count.get(i));
		}
		
		//sorting
		for(int i = list.size() - 1; i > -1; i--) {
			int correctPosistion = count.get(list.get(i)) - 1;
			int element = list.get(i);
			int elementPosition = list.get(i);
			
			sortedList.set(correctPosistion, element);			
			count.set(elementPosition, count.get(elementPosition) - 1);			
		}
		
		this.array = sortedList;
		
		return sortedList;
	}
	
}
