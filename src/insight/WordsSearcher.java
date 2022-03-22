package insight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordsSearcher {
	
	public static void main(String[] args) {
		
		String searched = "is";
		
		
		// directory where the input files reside
		final String dir = "/home/rootroot/main/yao_j/workplace_java/insight/src/insight/text/";
		
		ArrayList<String> fileNames = new ArrayList<String>();
		fileNames.add("file0.txt");
		fileNames.add("file1.txt");
		fileNames.add("file2.txt");
		
		String fileName0 = fileNames.get(0).toString();
//		System.out.printf("fileName0: %s%n", fileName0);
		
		String line;
		ArrayList<String> text = new ArrayList<String>();
		
		for (int i = 0; i < fileNames.size(); ++i) {
			BufferedReader reader;
			try {
				String fileName = fileNames.get(i).toString();
				reader = new BufferedReader(new FileReader(dir+fileName));
				line = reader.readLine();
				text.add( line );
				while (line != null) {
//					System.out.println(line);
					text.add( line );
//					String l_one = text.get(text.size()-1).toString();
//					System.out.println(l_one);
					line = reader.readLine(); // read next line
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Y) Result: text.size(): %d\n", text.size());
		
		for (int i = 0; i < text.size(); ++i) {
			String l = text.get(i).toString();
//			System.out.printf("l_i: %d, lin: %s\n", i,l);
			
			int idx = l.indexOf(searched, 0);
			System.out.printf("l_i: %d, lin: %s\n", i,l);
			System.out.printf("idx: %d, str: %s\n", idx,searched);
		}
		
	  }

}
