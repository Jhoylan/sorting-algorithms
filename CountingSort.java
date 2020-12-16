package sortingAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class CountingSort extends SortingAlgorithm{
	private List<Integer> count;
	private List<Integer> sortedList;
	private int maximum;
	
	@Override
	public List<Integer> sort(List<Integer> list) {
		this.count = new ArrayList<>();
		this.sortedList = new ArrayList<>();
		
		for(int i = 0; i < maximum + 1; i++){
			this.count.add(0);
		}
		
		for(int i = 0; i < list.size(); i++){
			this.sortedList.add(0);
		}
		
		//counting
		for(int i = 0; i < list.size(); i++) {
			this.count.set(list.get(i), count.get(list.get(i)) + 1);
		}
		
		//accumulating
		for(int i = 1; i < count.size(); i++) {
			this.count.set(i, count.get(i - 1) + count.get(i));
		}
		
		//sorting
		for(int i = list.size() - 1; i > -1; i--) {
			int correctPosistion = count.get(list.get(i)) - 1;
			int element = list.get(i);
			int elementPosition = list.get(i);
			
			this.sortedList.set(correctPosistion, element);			
			this.count.set(elementPosition, this.count.get(elementPosition) - 1);
			
		}
		
		this.array = sortedList;
		
		return sortedList;
	}
	
	public void setMaximum(int m) {
		this.maximum = m;
	}
}
