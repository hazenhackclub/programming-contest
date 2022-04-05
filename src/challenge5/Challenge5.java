package challenge5;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.VolatileCallSite;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
@formatter:off

Put challenge here:


@formatter:on
*/

public class Challenge5 {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/challenge5/reverse.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}
		
		while(scan.hasNextLine()) {
			String[] inputArray = scan.nextLine().split(" ");

			if (inputArray.length <= 1) {
				System.out.println(inputArray[0]);
				continue;
			}
			
			ArrayList<Integer> vowelWordsIndexes = new ArrayList<>();

			for(int i = 0; i < inputArray.length; i++) {
				if (inputArray[i].startsWith("a") || 
					inputArray[i].startsWith("e") || 
					inputArray[i].startsWith("i") || 
					inputArray[i].startsWith("o") || 
					inputArray[i].startsWith("u") ||
					inputArray[i].startsWith("A") || 
					inputArray[i].startsWith("E") || 
					inputArray[i].startsWith("I") || 
					inputArray[i].startsWith("O") || 
					inputArray[i].startsWith("U"))
					vowelWordsIndexes.add(i);
			}

			for(int i = 0; i < vowelWordsIndexes.size() / 2; i++) {
				String temp = inputArray[vowelWordsIndexes.get(i)];
				inputArray[vowelWordsIndexes.get(i)] = inputArray[vowelWordsIndexes.get(vowelWordsIndexes.size() - 1 - i)];
				inputArray[vowelWordsIndexes.get(vowelWordsIndexes.size() - 1 - i)] = temp;
			}
			
			for (String word : inputArray) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
}
