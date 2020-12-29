package sortingAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class SortingAlgorithm {
	public List<Integer> array;

	public SortingAlgorithm() {
		this.array = new ArrayList<>();
	}

	public abstract List<Integer> sort(List<Integer> list);

	public void populating(int quantity, int minimum, int maximum) {
		Random random = new Random();
		int range = maximum - minimum;
		int randomNuber;
		
		for (int i = 0; i < quantity; i++) {
				this.array.add(randomNuber = minimum + random.nextInt(range + 1));
		}
	}

	public void showArray() {
		System.out.println(array);
	}

	public List<Integer> getArray() {
		return this.array;
	}

	public boolean isCorrect() {
		boolean flag = true;

		for (int i = 0; i < this.array.size() - 1; i++) {
			if (this.array.get(i) > this.array.get(i + 1)) {
				flag = false;
			}
		}

		return flag;
	}

	public void setArray(List<Integer> list) {
		this.array = new ArrayList<>(list);
	}

	public void ascendingArray(int quantity) {
		List<Integer> ascedingArray = new ArrayList<>();
		List<Integer> emptyArray = new ArrayList<>();
		this.array = emptyArray;

		for (int i = 0; i < quantity; i++) {
			ascedingArray.add(i);
		}
		
		this.array = ascedingArray;
	}

	public void decreasingArray(int quantity) {
		List<Integer> decreasingArray = new ArrayList<>();
		List<Integer> emptyArray = new ArrayList<>();
		this.array = emptyArray;

		for (int i = quantity; i > 0; i--) {
			decreasingArray.add(i);
		}
		
		this.array = decreasingArray;
	}
	
	public void clean() {
		List<Integer> emptyArray = new ArrayList<Integer>();
		this.array = new ArrayList<>(emptyArray);
	}
}
