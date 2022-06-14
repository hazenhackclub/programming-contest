package plu2018.challenge02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Input File: mathematics.dat
A mathematician has stolen your calculator! Luckily, you know how to code and can write a
program that adds together numbers. Write a program that adds together a list of integers.
Input
The first line will contain a single integer n that indicates the number of integers to add together.
The next n lines will each contain one integer. Your task is to write a program that adds all of the
integers together.
Output
Output the resulting integer. The output should be one line containing one integer value.
Example Input File
3
1
2
3
Example Output File
6

@formatter:on
*/

public class Mathematics {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge02/mathematics.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );

		int total = 0;

		for( int i = 0; i < numLines; i++ )
			total += scan.nextInt( );

		System.out.println( total );

	}
}