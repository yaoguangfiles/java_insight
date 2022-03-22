package insight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordsSearcher {
	
	public static void main(String[] args) {
		
		String input = "Russian";
		String searched = input.toUpperCase();
		
		System.out.printf("Y) searched: %s\n", searched);
		
		// directory where the input files reside
		final String dir = "/home/rootroot/main/yao_j/workplace_java/insight/src/insight/text/";
		
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
		
		System.out.printf("Y) Result: text.size(): %d\n", text.size());
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		
		for (int i = 0; i < text.size(); ++i) {
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
					++cnt;
//					System.out.printf("l_i: %d, lin: %s\n", i,l);
//					System.out.printf("idx: %d, str: %s\n", idx,searched);
					
					sb.replace(idx, idx+searched.length(), searched.toUpperCase());
//					System.out.printf("rep: %d, rep: %s\n", i,sb.toString());
				}
				
//				idx = l.indexOf(searched, idx+searched.length());

				idx = l_up.indexOf(searched, idx+searched.length());
			}
			System.out.printf("rep: %d, rep: %s\n", i,sb.toString());
			
		}
		
		System.out.printf("Summary): sub: %s, cnt: %d\n", searched,cnt);
		
	  }

}
