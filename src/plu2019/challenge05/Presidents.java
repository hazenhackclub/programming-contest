package plu2019.challenge05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

/*
@formatter:off

Input File: presidents.dat
Mark keeps a log of all the bills in his wallet, but the log does not indicate the actual value of the bills - it simply
states the last name of the president on the front of each bill. You are to determine the actual value of the bills in
Mark’s wallet.
Input
The first line of input will contain a single integer n that indicates the number of lines to follow.
Each line will consist of a series of last names of presidents. The presidents that could appear
are: Franklin, Grant, Jackson, Hamilton, Lincoln, and Washington. The values
of these presidents are $100, $50, $20, $10, $5, and $1, respectively.
Output
Output the value of the money in the wallet with a dollar sign in front.

Example Input File
3
Franklin Grant Jackson
Hamilton Lincoln Washington
Washington Washington Washington Franklin Jackson

Example Output to Screen
$170
$16
$123

@formatter:on
*/

public class Presidents {

	static Scanner scan;

	static String[] presidents = { "Franklin", "Grant", "Jackson", "Hamilton", "Lincoln", "Washington" };
	static int[] worths = { 100, 50, 20, 10, 5, 1 };

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge05/presidents.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numLines; i++ ) {

			int curCost = 0;
			String names = scan.nextLine( );
			for( int j = 0; j < presidents.length; j++ )
				if( names.contains( presidents[j] ) )
					curCost += worths[j];

			System.out.println( "$" + curCost );
		}

	}
}