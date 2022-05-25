package plu2018.challenge04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
@formatter:off

Input File: square.dat
Your mother has asked you to create a template for the squares of a quilt she is making. Her quilt
will be based on words! Print out a square of the given word, in the style shown in the example
output.
Input
The first line will contain a single integer n that indicates the number of data sets that follow.
Each data set will consist of a single line with one word of length k (0 < k < 100).
Output
Output the square in the format shown in the example output. There are no spaces between data
sets. The final square should be both as wide and as tall as the length of the word.
Example Input File
3
one
three
fifteen
Example Output to Screen
one
n n
eno
three
h e
r r
e h
eerht
fifteen
i e
f e
t t
e f
e i
neetfif

@formatter:on
*/

public class Square {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge04/square.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );
		scan.nextLine( );

		for (int i = 0; i < numLines; i++) {
			String input = scan.nextLine( );
			System.out.println( input );
			for (int j = 1; j < input.length( ) - 1; j++)
				System.out.println( input.charAt( j ) + " " + input.charAt( input.length( ) - j - 1 ) );
			for (int j = 0; j < input.length( ); j++)
				System.out.print( input.charAt( input.length( ) - 1 - j ) );
			System.out.println(  );
		}
	}
}