package plu2018.challenge03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
@formatter:off

Input File: reverse.dat
In the String class, there exists a function called substring. Your task is to do the opposite of
the substring function. Rather than returning a specified substring within the String, you will
output the String with the substring taken out.
Input
The first line will contain a single integer n that indicates the number of data sets that
follow. Each data set will be one line with a string and two integers i and j, separated by
spaces. The first int, i, is the start index of the substring to be taken out, and the substring
removed extends to index j-1. Thus the length of the substring removed is j-i. You may
assume that 0 ≤ i ≤ j ≤ length(string).
Output
Output the given string, with the substring taken out specified by the given integers. The output
will be n lines, with no leading or trailing white space.
Example Input File
3
COMPUTER 1 3
SCIENCE 3 7
RULES 3 4
Example Output to Screen
CPUTER
SCI
RULS

@formatter:on
*/

public class Reverse {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge03/reverse.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );
		scan.nextLine( );

		for (int i = 0; i < numLines; i++) {
			String[] inputs = scan.nextLine( ).split( " " );
			String word = inputs[0];
			int beg = Integer.parseInt( inputs[1] );
			int end = Integer.parseInt( inputs[2] );

			if( beg <= word.length() && end <= word.length() )
				System.out.println( word.substring( 0, beg ) + word.substring( end, word.length( ) ) );

		}



	}
}