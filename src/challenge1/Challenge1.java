package challenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Put challenge here:

Input File: scale.dat

Write a program that takes in a list of integers and produces a new list of scaled integer values.
The value of each will be the original value multiplied by its neighbors.

Input
There will be an unknown number of inputs each on its own line. Each input will contain an
unknown number of values separated by spaces.

Output
Display the result of each input on its own line, with each value separated by a single space.

Example Input File
1 1 1 1 1
2 3 1 4 5 3
7 4 18 5 2 6

Example Output to Screen
1 1 1 1 1
6 6 12 20 60 15
28 504 360 180 60 12

@formatter:on
*/

public class Challenge1 {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/challenge1/scale.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		while( scan.hasNextLine( ) ) {

			String inputLine = scan.nextLine( );

			String[] inputArray = inputLine.split( " " );

			if( inputArray.length < 1 || inputArray[0].equals( "" ) )
				continue;

			int length = inputArray.length;

			int[] inputIntArray = new int[length];

			for( int i = 0; i < inputArray.length; i++ )
				inputIntArray[i] = Integer.parseInt( inputArray[i] );

			if( length > 1 ) {
				for( int i = 0; i < length; i++ ) {
					if( i == 0 )
						System.out.print( inputIntArray[i] * inputIntArray[i + 1] + " " );
					else if( i == inputIntArray.length - 1 )
						System.out.print( inputIntArray[i - 1] * inputIntArray[i] + " " );
					else
						System.out.print( inputIntArray[i - 1] * inputIntArray[i] * inputIntArray[i + 1] + " " );
				}
				System.out.println( );
			} else { // if size is one, print zero index
				System.out.println( inputIntArray[0] );
			}
		}
	}

}
