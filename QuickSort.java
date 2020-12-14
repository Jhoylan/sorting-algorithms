package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort extends SortingAlgorithm{
	
	public List<Integer> sort(List<Integer> list) {
		
		int half = Math.floorDiv(list.size(), 2);
		
		Collections.swap(list, half, list.size() - 1);
		
		int pivot = list.size() - 1;
		
		int itemFromLeft = 0, itemFromRight = 0;
		boolean flagLeft = false, flagRight = false;
		
		for(int i = 0; i < list.size(); i++) {
			for(int  j = 0; j < list.size() - 1; j++) {
				if(list.get(j) > list.get(pivot)) {
					itemFromLeft = j;
					flagLeft = true;
					break;
				}
			}
			
			for(int k = list.size() - 2; k > -1; k--) {
				if(list.get(k) < list.get(pivot)) {
					itemFromRight = k;
					flagRight = true;
					break;
				}
			}
						
			if(itemFromLeft  < itemFromRight && flagLeft && flagRight) {
				Collections.swap(list, itemFromLeft, itemFromRight);
			}
			
			if(itemFromLeft > itemFromRight) {
				Collections.swap(list, itemFromLeft, pivot);
				break;
			}
			
			if((itemFromLeft == itemFromRight) && flagLeft && !flagRight) {
				Collections.swap(list, itemFromLeft, pivot);
				break;
			}
						
		}
		
		List<Integer> lowerList = new ArrayList<>();
		List<Integer> upperList = new ArrayList<>();
		
		if(!flagLeft) {
			itemFromLeft = list.size() - 1;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(i < itemFromLeft) {
				lowerList.add(list.get(i));
			}
			
			if(i > itemFromLeft) {
				upperList.add(list.get(i));
			}
		}
		
		if(upperList.size() > 1) {
			upperList = this.sort(upperList);
		}
		
		if(lowerList.size() > 1) {
			lowerList = this.sort(lowerList);
		}
		
		for(int i = 0; i < lowerList.size(); i++) {
			list.set(i, lowerList.get(i));
		}
		
		for(int i = 0; i < upperList.size(); i++) {
			list.set(itemFromLeft + 1 + i, upperList.get(i));
		}
		
		return list;
	}
	
	
	
}
