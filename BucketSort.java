package sortingAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BucketSort extends SortingAlgorithm {

	
	@Override
	public List<Integer> sort(List<Integer> list) {
		List<LinkedList<Integer>> buckets = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}

		int bucketsNumber = list.size();

		for (int i = 0; i < bucketsNumber; i++) {
			LinkedList<Integer> linkedList = new LinkedList<>();
			buckets.add(linkedList);
		}

		for (int i = bucketsNumber - 1; i > -1; i--) {
			int bucketPosition = (int) list.get(i) * bucketsNumber / (max + 1);
			buckets.get(bucketPosition).add(list.get(i));
		}

		QuickSort quickSort = new QuickSort();

		List<Integer> sortedLinkedList = new LinkedList<>();

		for (int i = 0; i < bucketsNumber; i++) {
			if (buckets.get(i).size() > 1) {
				int pivot = quickSort.getPivot(buckets.get(i), "half");
				sortedLinkedList = quickSort.sortQuickSort(buckets.get(i), 
						pivot, "half", true);
				buckets.set(i, (LinkedList<Integer>) sortedLinkedList);
			}
		}

		LinkedList<Integer> bucketsConcatenaded = new LinkedList<>();

		for (int i = 0; i < bucketsNumber; i++) {
			bucketsConcatenaded.addAll(buckets.get(i));
		}

		this.array = bucketsConcatenaded;

		return bucketsConcatenaded;
	}

	public void irregularDistributionArray(int maximum, int quantity) {
		List<Integer> percentages = new ArrayList<>();
		int bucketsSize = (int) maximum / quantity;
		int quantityOfElements = quantity;
		
		if (quantity > maximum) {
			Random random = new Random();
			int numberOfBuckets = random.nextInt((int) (maximum / 10) - 1) + 2;
			
			bucketsSize = (int) maximum / numberOfBuckets;
						
			quantity = numberOfBuckets;
		}

		percentages = this.defineRandomPercentages(quantity);
		
		float standardDeviation = this.standardDevation(percentages);
		
		while(standardDeviation < 10) {
			percentages = this.defineRandomPercentages(quantity);
			standardDeviation = this.standardDevation(percentages);
		}
		
		for (int i = 0; i < quantity; i++) {
			int numberOfElements = percentages.get(i) * quantityOfElements / 100;
			
			if(i < quantity - 2) {
				this.populating(numberOfElements, bucketsSize * i, (bucketsSize * (i + 1)) - 1);
			}else {
				this.populating(numberOfElements, bucketsSize * i, bucketsSize * (i + 1));
			}
			
		}
		
		int addedElements = quantityOfElements - this.array.size();;
				
		if (addedElements > 0) {
			this.populating(addedElements, (quantity - 1) * bucketsSize,
					quantity * bucketsSize);
		}
		
		this.array.set(this.array.size() - 1, maximum);
		
		if(percentages.get(percentages.size() - 1) == 0) {
			addedElements++;
		}
		
		if(addedElements > 0) {
			percentages.set(percentages.size() - 1, (int) Math.ceil(addedElements/quantityOfElements));
			standardDeviation = this.standardDevation(percentages);
		}
		
		standardDeviation =  this.standardDevation(percentages);
		
		while(standardDeviation < 10) {
			this.irregularDistributionArray(maximum, quantityOfElements);
			standardDeviation = this.standardDevation(percentages);
		}
		
		
		
		this.array = this.randomnessImprovement(this.array);
	}

	public void uniformDistributionArray(int maximum, int quantity) {
		int bucketsNumber = 0;
				
		if(maximum >= quantity) {
			bucketsNumber = quantity;
		}else {
			bucketsNumber = maximum;
		}
		
		int bucketsSize = 1;
		
		if(maximum >= quantity) {
			bucketsSize = (int)maximum/quantity;
		}
			
		for(int i = 0; i < bucketsNumber; i++) {
			if(maximum <= quantity) {
				this.populating(quantity/bucketsNumber, i * bucketsSize + 1, (i + 1) * bucketsSize);
			}else {
				if(i < bucketsNumber - 1) {
					this.populating(quantity/bucketsNumber, i * bucketsSize, (i + 1) * bucketsSize - 1);
				}else {
					this.populating(quantity/bucketsNumber, i * bucketsSize, (i + 1) * bucketsSize);
				}
			}									
		}
		
		this.populating(quantity - this.array.size(), 0, maximum);
		
		this.array = this.randomnessImprovement(this.array);
		
	}
	
	public List<Integer> defineRandomPercentages(int quantity){
		List<Integer> percentages = new ArrayList<>();
		int total = 0;
		
		for (int i = 0; i < quantity; i++) {
			percentages.add(0);
		}

		for (int i = 0; i < quantity - 1; i++) {
			Random random = new Random();
			
			if(total < 100) {
				int value = random.nextInt(101 - total);
				
				 while(percentages.indexOf(value) != -1) {
					boolean infinityLoop = true;
					
					if(100 - total == value) {
						for(int j = 0; j <= value; j++) {
							if(percentages.indexOf(j) == -1) {
								infinityLoop = false;
							}
						}
					}
					
					if(infinityLoop) {
						break;
					}
					
					value = random.nextInt(101 - total);
					
				}
				
				total += value;
				percentages.set(i, value);
			}else {
				break;
			}
			
		}

		if (total < 100) {
			percentages.set(quantity - 1, 100 - total);
		}
		
		return percentages;
	}
	
	public float standardDevation(List<Integer> percentages) {
		float standardDeviation;
		float average = 0;
		int max = 0;
		int min = 100;
		int size = 0;
		
		for(int i = 0; i < percentages.size(); i++) {
			int percentage = percentages.get(i);
			
			average += percentage;
						
			if(percentage > max) {
				max = percentage;
			}
			
			if(percentage < min) {
				min = percentage;
			}
			
			if(percentage > 0) {
				size++;
			}			
		}
		
		average /= size;
		
		if(max - average > average - min) {
			standardDeviation = max - average;
		}else {
			standardDeviation =  average - min;
		}
		
		return standardDeviation;
	}

	public List<Integer> randomnessImprovement(List<Integer> list){
		List<Integer> array = new ArrayList<>();
		List<Integer> missingNumbers = new ArrayList<>();
		List<Integer> newElmentsPosition = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i = 0; i < list.size(); i++) {
			missingNumbers.add(i);
			array.add(0);
		}
		
		while(missingNumbers.size() > 0) {
			int newPostion = random.nextInt(missingNumbers.size());
			newElmentsPosition.add(missingNumbers.get(newPostion));
			missingNumbers.remove(newPostion);
		}
		
		for(int i = 0; i < array.size(); i++) {
			array.set(newElmentsPosition.get(i), list.get(i));
		}
		
		return array;
	}
}
