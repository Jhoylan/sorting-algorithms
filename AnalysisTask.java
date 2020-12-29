package sortingAlgorithms;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class AnalysisTask {
	private List<String> results;
	private boolean everythingIsCorrect = true;
	
	public AnalysisTask() {
		results = new ArrayList<>();
	}

	public List<String> getResults() {
		return this.results;
	}
	
	public boolean runAllMethods(String fileName, int quantity) {
		int times = 1;
				
		for(int i = 0; i < 1; i++){
			this.progressBar(quantity);
			
			this.isCorrect(firstQuestionAscendingLetterC(times, quantity));

			this.isCorrect(firstQuestionDecreasingLetterC(times, quantity));

			this.isCorrect(firstQuestionRandomLetterC(times, quantity));

			this.isCorrect(firstQuestionAscendingLetterD(times, quantity));

			this.isCorrect(firstQuestionDecreasingLetterD(times, quantity));

			this.isCorrect(firstQuestionRandomLetterD(times, quantity));

			this.isCorrect(SecondQuestionAscendingLetterC(times, quantity));

			this.isCorrect(SecondQuestionDecreasingLetterC(times, quantity));

			this.isCorrect(SecondQuestionRandomLetterC(times, quantity));

			this.isCorrect(ThirdQuestionRandomLetterA(times, quantity));

			//this.isCorrect(ThirdQuestionLetterB(times, quantity));

			this.isCorrect(ThirdQuestionLetterCUniformDistribution(times, quantity));

			this.isCorrect(ThirdQuestionLetterCIrregularDistribution(times, quantity));
		}
		
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(this.results);
		txt.creatingATxtFile(fileName);
		
		return everythingIsCorrect;
	}

	public boolean firstQuestionAscendingLetterC(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.ascendingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "half", "ascending");

		String message = times + " times, ascending entries, "
				+ "first question letter c, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean firstQuestionDecreasingLetterC(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.decreasingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "half", "decreasing");

		String message = times + " times, decreasing entries, "
				+ "first question letter c, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean firstQuestionRandomLetterC(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.populating(quantity, 1, 100);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "half", "random");

		String message = times + " times, random entries, "
				+ "first question letter c, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean firstQuestionAscendingLetterD(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.ascendingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "random", "ascending");

		String message = times + " times, ascending entries, "
				+ "first question letter d, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean firstQuestionDecreasingLetterD(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.decreasingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "random", "decreasing");

		String message = times + " times, decreasing entries, "
				+ "first question letter d, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean firstQuestionRandomLetterD(int times, int quantity) {
		QuickSort array = new QuickSort();

		array.populating(quantity, 1, 100);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, "random", "random");

		String message = times + " times, random entries, "
				+ "first question letter d, QuickSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean SecondQuestionAscendingLetterC(int times, int quantity) {
		HeapSort array = new HeapSort();

		array.ascendingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), array, null, "ascending");

		String message = times + " times, ascending entries, "
				+ "second question letter c, HeapSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean SecondQuestionDecreasingLetterC(int times, int quantity) {
		HeapSort array = new HeapSort();

		array.decreasingArray(quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, null, "decreasing");

		String message = times + " times, decreasing entries, "
				+ "second question letter c, HeapSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean SecondQuestionRandomLetterC(int times, int quantity) {
		HeapSort array = new HeapSort();

		array.populating(quantity, 1, 100);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, null, "random");

		String message = times + " times, random entries, "
				+ "second question letter c, HeapSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean ThirdQuestionRandomLetterA(int times, int quantity) {
		CountingSort array = new CountingSort(100);

		array.populating(quantity, 1, 100);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, null, "random");

		String message = times + " times, random entries, "
				+ "third question letter a, CountingSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean ThirdQuestionLetterB(int times, int zipCodesQuantity) {
		RadixSort array = new RadixSort();
		ManipulatingTxtFiles txt = new ManipulatingTxtFiles(null);

		List<Integer> zipCodes = new ArrayList<>();

		try {
			zipCodes = txt.txtToArray(
					"C:/Users/Jhoylan Gonçalves/Desktop/arquivos_java/Algorithm Analysis/" 
			+ "zipcodes.txt", zipCodesQuantity);
		} catch (FileNotFoundException e) {
			System.out.println("The file wasn't found!!!");
		}

		List<Float> testsDuration = this.timeMeasurement(times, zipCodes, 
				array, null, "zipCodes");

		String message = times + " times, random entries, "
				+ "third question letter b, RadixSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean ThirdQuestionLetterCUniformDistribution(int times, int quantity) {
		BucketSort array = new BucketSort();

		array.uniformDistributionArray(100, quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(), 
				array, null, "uniformDistribution");

		String message = times + " times, uniform distribution, "
				+ "third question letter c, BucketSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public boolean ThirdQuestionLetterCIrregularDistribution(int times, int quantity) {
		BucketSort array = new BucketSort();

		array.irregularDistributionArray(100, quantity);

		List<Float> testsDuration = this.timeMeasurement(times, array.getArray(),
				array, null, "irregularDistribution");

		String message = times + " times, irregular distribution, "
				+ "third question letter c, BucketSort";

		this.setMessage(message, testsDuration);

		boolean isCorrect = this.isInAscendingOrder(testsDuration);

		return isCorrect;
	}

	public List<Float> timeMeasurement(int times, List<Integer> referenceArray, 
			SortingAlgorithm sortAlgorithm,	String quickSortPivot, String arrayType) {

		List<Float> testsDuration = new ArrayList<>();
		List<List<Integer>> randomArrayList = new ArrayList<>();
		List<Integer> array = new ArrayList<>(referenceArray);
		
		boolean result = false;
		
		if (arrayType.equals("random")) {
			randomArrayList.add(array);

			for (int i = 0; i < times - 1; i++) {
				sortAlgorithm.clean();
				sortAlgorithm.populating(array.size(), 1, 100);
				randomArrayList.add(sortAlgorithm.getArray());
			}
		}else if(arrayType.equals("uniformDistribution")) {
			BucketSort bucketSort = (BucketSort) sortAlgorithm;
			randomArrayList.add(array);
			
			for (int i = 0; i < times - 1; i++) {
				bucketSort.clean();				
				bucketSort.uniformDistributionArray(100, array.size());
				randomArrayList.add(bucketSort.getArray());
			}
		}else if(arrayType.equals("irregularDistribution")) {
			BucketSort bucketSort = (BucketSort) sortAlgorithm;
			randomArrayList.add(array);
			
			for (int i = 0; i < times - 1; i++) {
				bucketSort.clean();				
				bucketSort.irregularDistributionArray(100, array.size());
				randomArrayList.add(bucketSort.getArray());
			}
		}
		
		for (int i = 0; i < times; i++) {
			Instant begin = Instant.now();

			if (arrayType.equals("random") || arrayType.equals("uniformDistribution") || 
					arrayType.equals("irregularDistribution")) {
				sortAlgorithm.setArray(randomArrayList.get(i));
			} else {
				sortAlgorithm.setArray(array);
			}

			if (sortAlgorithm instanceof QuickSort) {
				QuickSort quickSort = (QuickSort) sortAlgorithm;
				int pivot = quickSort.getPivot(sortAlgorithm.getArray(), quickSortPivot);
				quickSort.sortQuickSort(sortAlgorithm.getArray(), pivot, quickSortPivot, true);
			} else {
				sortAlgorithm.sort(sortAlgorithm.getArray());
			}

			result = sortAlgorithm.isCorrect();

			Instant end = Instant.now();

			float temp = ((float) (i + 1) / times) * 100;
			BigDecimal progress = new BigDecimal(String.valueOf((int) temp));
			System.out.println(progress + "% of progress");

			Duration duration = Duration.between(begin, end);

			float durationMiliSeconds = (float) (duration.getNano() /*/ Math.pow(10, 6)*/);
			
			/*if (arrayType.equals("random") || arrayType.equals("uniformDistribution") || 
					arrayType.equals("irregularDistribution")){
				testsDuration.add(durationMiliSeconds);
			} else {
				if(sortAlgorithm instanceof HeapSort) {
					if (i > 1) {
						testsDuration.add(durationMiliSeconds);
					}
				}else if (i > 0) {
					testsDuration.add(durationMiliSeconds);
				}
			}*/
			
			testsDuration.add(durationMiliSeconds);
		}

		if (result) {
			return testsDuration;
		} else {
			return null;
		}
	}

	public void setMessage(String message, List<Float> testsDuration) {
		BigDecimal average = new BigDecimal("0");
		String tempSize = String.valueOf(testsDuration.size());
		BigDecimal size = new BigDecimal(tempSize);

		results.add(message);

		for (int i = 0; i < testsDuration.size(); i++) {
			String temp = String.valueOf(testsDuration.get(i));
			BigDecimal trunckedTemp = new BigDecimal(temp);
			trunckedTemp = trunckedTemp.setScale(2, BigDecimal.ROUND_HALF_DOWN);
			average = average.add(trunckedTemp);
			temp = trunckedTemp.toString();
			results.add(temp);// unitary measurements
		}

		average = average.divide(size, 2, RoundingMode.HALF_UP);
		
		String message2 = "The average is:";
		String time = average.toString();

		results.add(message2);
		results.add(time);
	}

	public boolean isInAscendingOrder(List<Float> testsDuration) {
		if (testsDuration != null) {
			return true;
		} else {
			return false;
		}
	}

	public void isCorrect(boolean methodResult) {
		this.everythingIsCorrect = this.everythingIsCorrect && methodResult;
	}

	public void progressBar(int quantity) {
		String division = "================================================";
		String numberOfEntries = quantity + " entries";
		
		results.add(division);
		results.add(numberOfEntries);
		
		System.out.println(division);
		System.out.println(numberOfEntries);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("The system did interrupt the sleep thread!");
		}
	}
	
}
