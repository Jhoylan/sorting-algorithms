package sortingAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipulatingTxtFiles {
	List<String> list;

	public ManipulatingTxtFiles(List<String> list) {
		this.list = list;
	}
	
	public void creatingATxtFile(String fileName) {
		File elementFile = new File(fileName);
		
		try {
			PrintStream writer = new PrintStream(elementFile);
			
			for(int i = 0; i < this.list.size(); i++) {
				writer.println(list.get(i));
			}
			
			writer.close();
			
		} catch (FileNotFoundException fnf) {
			System.out.println("The file wasn't found");
		}
		
	}
	
	public List<Integer> txtToArray(String path, int quantity) throws FileNotFoundException {
		List<Integer> list = new ArrayList<>();
		
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int size = 0;
		
		for(int i = 0; i < quantity; i++) {
			String zipCodeString = scan.nextLine();
			int zipCode = Integer.parseInt(zipCodeString);
			list.add(zipCode);
		}
				
		return list;
	}
	
	
	 
}
