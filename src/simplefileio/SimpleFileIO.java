package simplefileio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleFileIO {
	
	static String filename;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO code application logic here
		filename = "Data/test.csv";
		//MyFileIO.readFromFile(filename);
		String testString = "S80 34 2.5T 4dr";
		int retValDoors = StringParsing.getNumOfDoors(testString);
		//int retValDoors = 5;
		System.out.println(retValDoors);
	}
	
	static class StringParsing {
		
		public static int getNumOfDoors(String myString) {
			int retVal = 0;
			/*
			find tallet umiddelbart før dr - hvis dr forekommer
			S80 2.5T 4dr
			Focus ZX5 5dr
			IS 300 4dr manual
			Forester X
			*/
			String pattern = "([1-8]{1})dr";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(filename);
			if (m.find()) {
				System.out.println(m.group(0));
				retVal = Integer.parseInt(m.group(0));
			}

			return retVal;
			
		}
	}
	
	
	static class MyFileIO {
		
		public static void readFromFile(String filename) throws FileNotFoundException {
			File file = new File(filename);
			Scanner myScanner = new Scanner(file);
			String line = "";
			System.out.println("iinto write");
			while (myScanner.hasNextLine()){
				line = myScanner.nextLine();
				System.out.println(line);
			}
			
			
		}
	}
	
}
