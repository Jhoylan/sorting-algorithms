package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalysisTaskTest {

	/*@Test
	void firstQuestionAscendingLetterCtest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionAscendingLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/	
	
	/*@Test
	void firstQuestionDecreasingLetterCTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionDecreasingLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void firstQuestionRandomLetterCTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionRandomLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void firstQuestionAscendingLetterDTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionAscendingLetterD(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void firstQuestionDecreasingLetterDTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionDecreasingLetterD(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void firstQuestionRandomLetterDTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.firstQuestionRandomLetterD(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void SecondQuestionAscendingLetterCTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.SecondQuestionAscendingLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void SecondQuestionDecreasingLetterC() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.SecondQuestionDecreasingLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void SecondQuestionRandomLetterC() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.SecondQuestionRandomLetterC(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void ThirdQuestionRandomLetterA() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.ThirdQuestionRandomLetterA(5, 2500);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void ThirdQuestionLetterB() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.ThirdQuestionLetterB(5, 22302);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void ThirdQuestionLetterCUniformDistributionTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.ThirdQuestionLetterCUniformDistribution(5, 10000);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	/*@Test
	void ThirdQuestionLetterCIrregularDistributionTest() {
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.ThirdQuestionLetterCIrregularDistribution(10, 10000);
		System.out.println(analysis.getResults());
		
		Assertions.assertEquals(true, isCorrect);
	}*/
	
	@Test
	void everythingTest() {
		List<String> fileNames = new ArrayList<>();
		fileNames.add("5000.txt");
		fileNames.add("10000.txt");
		fileNames.add("15000.txt");
		fileNames.add("20000.txt");
		
		List<Integer> sizes = new ArrayList<>();
		sizes.add(5000);
		sizes.add(10000);
		sizes.add(15000);
		sizes.add(20000);
		
		
		AnalysisTask analysis = new AnalysisTask();
		boolean isCorrect = analysis.runAllMethods(fileNames.get(3), sizes.get(3));

		Assertions.assertEquals(true, isCorrect);
		
		
	}
}
