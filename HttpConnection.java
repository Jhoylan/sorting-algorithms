package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpConnection {

	public List<String> getTagsCeps(String pageNumber){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;
		List<String> ceps = new ArrayList<>();
		String urlAdress = "https://www.brasilao.com/cep/pa/" + pageNumber + ".html";
		
		try {
			url = new URL(urlAdress);
			is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				if (line.contains("<b>6")) {
					ceps.add(line);
				}
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		
		return ceps;
	
	}
	
	public List<String> tagToString(List<String> list){
		List<String> zipCodes = new ArrayList<>();
		String zipCode = null;
			
		for(int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			int lastNumberPosition = temp.length() - 14;
			
			zipCode= list.get(i).substring(lastNumberPosition - 10, lastNumberPosition);
			
			String firstPartZipCode = zipCode.substring(0, 5);
			String secondPartZipCode = zipCode.substring(6, 9);
			
			zipCode = firstPartZipCode.concat(secondPartZipCode);
			
			zipCodes.add(zipCode);
			
		}
		
		return zipCodes;
	}
}
