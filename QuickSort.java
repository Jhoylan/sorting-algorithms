package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {
	
	List<Integer> array;
	
	public QuickSort() {
		array = new ArrayList<>();
	}
	
	public List<Integer> partition(List<Integer> list) {
		
		int half = Math.floorDiv(list.size(), 2);
		
		System.out.println("The half is : " + half);
		
		Collections.swap(list, half, list.size() - 1);
		
		int pivot = list.size() - 1;
		
		System.out.println("The pivot is : " + list.get(pivot));
		
		int itemFromLeft = 0, itemFromRight = 0;
		
		for(int i = 0; i < list.size(); i++) {
			for(int  j = 0; j < list.size(); j++) {
				if(list.get(j) > list.get(pivot)) {
					itemFromLeft = j;
					break;
				}
			}
			
			for(int k = list.size() - 2; k > 0; k--) {
				if(list.get(k) < list.get(pivot)) {
					itemFromRight = k;
					break;
				}
			}
						
			if(itemFromLeft < itemFromRight) {
				Collections.swap(list, itemFromLeft, itemFromRight);
			}else if(itemFromLeft > itemFromRight) {
				Collections.swap(list, itemFromLeft, pivot);
				break;
			}else {
				break;
			}
						
		}
		
		List<Integer> lowerList = new ArrayList<>();
		List<Integer> upperList = new ArrayList<>();
				
		for(int i = 0; i < list.size(); i++) {
			if(i < itemFromLeft) {
				lowerList.add(list.get(i));
			}
			
			if(i > itemFromLeft) {
				upperList.add(list.get(i));
			}
		}
		
		System.out.println("This is the upper list");
		System.out.println(upperList);
		
		System.out.println("This is the lower list");
		System.out.println(lowerList);
		
		if(upperList.size() > 1) {
			upperList = this.partition(upperList);
		}
		
		if(lowerList.size() > 1) {
			lowerList = this.partition(lowerList);
		}
		
		for(int i = 0; i < lowerList.size(); i++) {
			list.set(i, lowerList.get(i));
		}
		
		for(int i = 0; i < upperList.size(); i++) {
			list.set(itemFromLeft + 1, upperList.get(i));
		}
		
		return list;
	}
	
	public void populating(int size) {
		Random random = new Random(); 
		int randomNuber;
		
		for(int i = 0; i < size; i++) {
			array.add(randomNuber = random.nextInt(100));
		}
		
	}
	
	public void showArray() {
		System.out.println(array);
	}
	
	public List<Integer> getArray(){
		return this.array;
	}
}
