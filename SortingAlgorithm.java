package sortingAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class SortingAlgorithm {
	public List<Integer> array;
	
	public SortingAlgorithm() {
		array = new ArrayList<>();
	}
	
	public abstract List<Integer> sort(List<Integer> list);
	
	public void populating(int quantity, int minimum, int maximum) {
		Random random = new Random(); 
		int range = maximum - minimum;
		
		int randomNuber;
		
		for(int i = 0; i < quantity; i++) {
			array.add(randomNuber = minimum + random.nextInt(range + 1));
		}
		
	}
	
	public void showArray() {
		System.out.println(array);
	}
	
	public List<Integer> getArray(){
		return this.array;
	}
	
	public boolean isCorrect() {
		boolean flag = true;
		
		for(int i = 0; i < array.size() - 1; i++) {
			if(array.get(i) > array.get(i + 1)) {
				flag = false;
			}
		}
		
		return flag;
	}
}
