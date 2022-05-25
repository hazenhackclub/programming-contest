package plu2018.challenge01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
@formatter:off

Input File: zero.dat
You’re writing the positive integers in increasing order starting from one. But you’ve never
learned the digit zero, and thus omit any number that contains a zero in any position. The first ten
integers you write are: 1, 2, 3, 4, 5, 6, 7, 8, 9, and 11. You have just written down the integer k
(which is guaranteed to not contain the digit zero). What will be the next integer that you write
down?
Input
The first line will contain a single integer n that indicates the number of data sets that follow.
Each data set will consist of a single line containing the integer k (1 ≤ k ≤ 999,999). It is
guaranteed that k does not contain the digit zero.
Output
For each data set print, on a single line, the next integer you will be writing down.
Example Input File
2
99
1234
Example Output to Screen
111
1235

@formatter:on
*/

public class Zero {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge01/zero.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );

		for( int i = 0; i < numLines; i++ ) {
			int start = scan.nextInt( );
			while( (++start + "").contains( "0" ) );
			System.out.println( start );
		}

	}
}