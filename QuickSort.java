package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort extends SortingAlgorithm{
	
	public List<Integer> sortQuickSort(List<Integer> list, int pivot, 
			String pivotPosition, boolean improvedQuickSort) {
			
		Collections.swap(list, pivot, list.size() - 1);
		
		pivot = list.size() - 1;
						
		int itemFromLeft = 0, itemFromRight = 0;
		
		boolean flagLeft = false, flagRight = false;
		
		for(int i = 0; i < (int) list.size() / 2; i++) {
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
			
			if(improvedQuickSort) {
				if(!flagLeft && !flagRight) {
					return list;
				}
				
				if(!flagLeft) {
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
		
		int upperListPivot = 0, lowerListPivot = 0;
		
		if(upperList.size() > 1) {
			upperListPivot = getPivot(upperList, pivotPosition);
		}
				
		if(lowerList.size() > 1) {
			lowerListPivot = getPivot(lowerList, pivotPosition);
		}
		
		
		if(upperList.size() > 1) {
			upperList = this.sortQuickSort(upperList, upperListPivot, pivotPosition, improvedQuickSort);
		}
		
		if(lowerList.size() > 1) {
			lowerList = this.sortQuickSort(lowerList, lowerListPivot, pivotPosition, improvedQuickSort);
		}
		
		for(int i = 0; i < lowerList.size(); i++) {
			list.set(i, lowerList.get(i));
		}
		
		for(int i = 0; i < upperList.size(); i++) {
			list.set(itemFromLeft + 1 + i, upperList.get(i));
		}
		
		return list;
	}

	public int getPivot(List<Integer> list, String pivotPosition) {
		int pivot = 0;
		
		if(pivotPosition.equals("half")) {
			 pivot = Math.floorDiv(list.size(), 2);
		}else if(pivotPosition.equals("random")) {
			Random random = new Random();
			pivot = random.nextInt(list.size());
		}else {
			System.err.println("You can only select half or random as pivots");
		}
		
		return pivot;
	}

	@Override
	public List<Integer> sort(List<Integer> list) {
		System.err.println("This method is deprecated!");
		return null;
	}
	
	
	
}
