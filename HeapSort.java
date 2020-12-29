package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort extends SortingAlgorithm {

	@Override
	public List<Integer> sort(List<Integer> array) {
		int firstSon = 0, secondSon = 0, firstSonPosition = 0, secondSonPosition = 0;
		List<Integer> sortedArray = new ArrayList<>();
		List<Integer> list = new ArrayList<>(array);
		
		while (list.size() > 0) {
			boolean isMaxHeap = false;
			int count = 0;

			while (!isMaxHeap) {
				for (int i = list.size() - 1; i > 0; i -= 2) {
					firstSonPosition = i;

					if (list.size() % 2 != 0) {
						firstSon = list.get(firstSonPosition);
						secondSonPosition = i - 1;
						secondSon = list.get(secondSonPosition);

					} else {
						firstSon = list.get(firstSonPosition);

						if ((i + 1) < list.size() - 1) {
							secondSonPosition = i + 1;
							secondSon = list.get(secondSonPosition);
						}
						
					}
					
					if(list.size() % 2 == 0) {
						if(i == list.size() - 1) {
							secondSon = 0;
						}
					}
										
					int parentPosition = Math.floorDiv(i + 1, 2) - 1;
					int parent = list.get(parentPosition);

					if (firstSon > parent || secondSon > parent) {
						if (firstSon > secondSon) {
							Collections.swap(list, firstSonPosition, parentPosition);
						} else {
							Collections.swap(list, secondSonPosition, parentPosition);
						}
						count++;
					}					
				}
								
				if (count == 0) {
					isMaxHeap = true;
				}

				count = 0;
			}
			
			sortedArray.add(0, list.get(0));

			Collections.swap(list, 0, list.size() - 1);

			list.remove(list.size() - 1);
		}
		
		this.array = sortedArray;
		
		return sortedArray;
	}
}
