package insight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsSearcher {
	
	public static void main(String[] args) {
		
		StringBuilder stat = new StringBuilder();
		int num_search = 0;
		
		while(true) {
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n-------------------------------\n");
			System.out.println("Enter a word to be searched:");
			String word = scanner.nextLine();
			
			if (word.equalsIgnoreCase("-1"))
				break;
			
//			System.out.printf("Y) word searched: %s\n", word);
		      
	//		String input = "Russian";
	//		String searched = input.toUpperCase();
			
			String searched = word.toUpperCase();
			
//			System.out.printf("Y) searched: %s\n", searched);
			
			// directory where the input files reside
			final String dir = "/home/rootroot/main/yao_j/workplace_java/insight/src/insight/text/";
//			final String file_result = "result.txt";
			
			ArrayList<String> fileNames = new ArrayList<String>();
			fileNames.add("file2.txt");
			fileNames.add("file0.txt");
			fileNames.add("file1.txt");
			
			
			
			String line;
			ArrayList<String> text = new ArrayList<String>();
			
			for (int i = 0; i < fileNames.size(); ++i) {
				BufferedReader reader;
				try {
					String fileName = fileNames.get(i).toString();
					reader = new BufferedReader(new FileReader(dir+fileName));
					line = reader.readLine();
					while (line != null) {
						if (line.trim().length() > 0)
							text.add( line );
						
						line = reader.readLine(); // read next line
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
//			System.out.printf("Y) Result: text.size(): %d\n", text.size());
			StringBuilder sb = new StringBuilder();
			
			int cnt = 0;
			
			System.out.println("");
			
			for (int i = 0; i < text.size(); ++i) {
				
				Boolean is_match = false;
				
				String l = text.get(i).toString();
	
				String l_up = l.toUpperCase();
	//			System.out.printf("l_up: %d, l_up: %s\n", i,l_up.toString());
				
				int idx = l_up.indexOf(searched, 0);
				
	//			StringBuilder sb = new StringBuilder(l);
				sb.setLength(0);
				sb.append(l);
				
				while (idx != -1) {
					
					Boolean should_record = true;
					
					if (idx > 0) 							// if it is not the first charater of the checking line
						if (Character.isAlphabetic(l.charAt(idx-1)))
							should_record = false;
					
					if (idx+searched.length() < l.length()-1) // if it is not the last charater of the checking line
						if (Character.isAlphabetic(l.charAt(idx+searched.length())))
							should_record = false;
					
					if (should_record) {
						is_match = true;
						++cnt;
						
						sb.replace(idx, idx+searched.length(), searched.toUpperCase());
					}
	
					idx = l_up.indexOf(searched, idx+searched.length());
				}

				if (is_match)
					System.out.printf("%s\n", sb.toString());
			}
			
//			System.out.printf("\nSummary): search: %s, cnt: %d\n\n\n", searched,cnt);
			
			++num_search;
			stat.append("searched: "+word+"\t, matched: "+Integer.toString(cnt)+"\n");
			
//			try {
//			      FileWriter myWriter = new FileWriter(dir+file_result);
//			      myWriter.write(word);
//			      myWriter.write(cnt);
//			      myWriter.close();
//			      System.out.println("Successfully wrote to the file.");
//			    } catch (IOException e) {
//			      System.out.println("An error occurred.");
//			      e.printStackTrace();
//			    }
			
//			try {
//			      File myObj = new File(dir+file_result);
//			      if (myObj.createNewFile()) {
//			        System.out.println("File created: " + myObj.getName());
//			      } else {
//			        System.out.println("File already exists.");
//			      }
//			    } catch (IOException e) {
//			      System.out.println("An error occurred.");
//			      e.printStackTrace();
//			    }
			
		  }
		
		System.out.println("\n------ Summary of search: -------\n");
		System.out.printf("Number of search: %d\n", num_search);
//		System.out.println("Summary of search: ");
		System.out.println(stat.toString());
		System.out.println("----------------------------------\n");
		
	}

}
