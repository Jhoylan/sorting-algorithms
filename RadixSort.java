package sortingAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class RadixSort extends SortingAlgorithm{
	
	@Override
	public List<Integer> sort(List<Integer> list) {
		int max = 0, greaterNumberDigits = 0;
				
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
		}
		
		double doubleMax = max;
		
		greaterNumberDigits = (int) (Math.floor(Math.log10(doubleMax)) + 1);
		
		for(int i = 0; i < greaterNumberDigits; i++) {
			list = this.countingSortDigits(list, i + 1);
		}
		
		this.array = list;
		
		return list;
	}
	
	//Digit position from right to left
	public List<Integer> countingSortDigits(List<Integer> list, int digitPosition) {
		List<Integer> digitList = new ArrayList<Integer>();
		List<Integer> sortedDigitList = new ArrayList<Integer>();
		List<Integer> newDigitsPosition = new ArrayList<>();
		
		CountingSort countingSort = new CountingSort();
		countingSort.setMaximum(9);
		
		for(int i = 0; i < list.size(); i++) {
			int digit = (Math.floorDiv(list.get(i), (int) Math.pow(10, digitPosition - 1))) % 10;
			digitList.add(digit);
		}
		 
		sortedDigitList = countingSort.sort(digitList);
		
		for(int i = 0; i < sortedDigitList.size(); i++) {
			int newDigitIndex = sortedDigitList.indexOf(digitList.get(i));
			newDigitsPosition.add(newDigitIndex);
			sortedDigitList.set(newDigitIndex, 10);			
		}
		
		for(int i = 0; i < list.size(); i++) {
			sortedDigitList.set(newDigitsPosition.get(i), list.get(i));
		}
		
		return sortedDigitList;
	}
}
