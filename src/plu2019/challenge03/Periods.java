package plu2019.challenge03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
@formatter:off

Input File: periods.dat
Eric gets distracted so sometimes he forgets to put periods at the end of his sentences. To help him out, you are to
put a period at the end of his sentences if the period is not already present.
Input
The first line of input will contain a single integer n that indicates the number of lines to follow.
Each line will consist of a sentence which may or may not have a period at the end.
Output
Output the sentence, making sure there is one period at the end.

Example Input File
3
You kicked my dog
No I did not.
It was the kid that did

Example Output to Screen
You kicked my dog.
No I did not.
It was the kid that did.

@formatter:on
*/

public class Periods {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge03/periods.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numLines; i++ ) {
			String input = scan.nextLine( );
			System.out.println( input + ( input.charAt( input.length( ) - 1 ) == '.' ? "" : "." ) );
		}

	}

}
