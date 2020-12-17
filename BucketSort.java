package sortingAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort extends SortingAlgorithm{

	@Override
	public List<Integer> sort(List<Integer> list) {
		List<LinkedList<Integer>> buckets = new ArrayList<>();
		int max = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
		}
		
		int bucketsNumber = list.size();
		
		for(int i = 0; i < bucketsNumber; i++) {
			LinkedList<Integer> linkedList = new LinkedList<>();
			buckets.add(linkedList);			
		}
		
		for(int i = bucketsNumber - 1; i > -1; i--) {
			int bucketPosition = (int) list.get(i) * bucketsNumber/(max + 1);
			buckets.get(bucketPosition).add(list.get(i));			
		}
		
		QuickSort quickSort = new QuickSort();
		
		List<Integer> sortedLinkedList = new LinkedList<>();
			
		for(int i = 0; i < bucketsNumber; i++) {
			if(buckets.get(i).size() > 0) {
				sortedLinkedList = quickSort.sort(buckets.get(i));
				buckets.set(i,(LinkedList<Integer>) sortedLinkedList);
			}			
		}
		
		LinkedList<Integer> bucketsConcatenaded = new LinkedList<>();
		
		for(int i = 0; i < bucketsNumber; i++) {
			bucketsConcatenaded.addAll(buckets.get(i));
		}
		
		this.array = bucketsConcatenaded;
		
		return bucketsConcatenaded;
	}
	
	
}
