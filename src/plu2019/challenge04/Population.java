package plu2019.challenge04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

/*
@formatter:off

Input File: population.dat
In Emily’s country it is estimated that a person dies every 7 seconds, and a person is born every 4 seconds. Given a
beginning population, estimate the population after a certain period of time.
Input
The first line of input will contain a single integer n that indicates the number of lines to follow.
Each line will consist of two integers, p and t, where p is the beginning population, and t is the
amount of time that will pass. Both p and t will be between the number 1 and the number 2
billion.
Output
Output the estimated population after the period of time based on the above statistics.

Example Input File
3
12 14
530 200
4786 3543

Example Output to Screen
13
552
5165

@formatter:on
*/

public class Population {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge04/population.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numLines; i++ ) {

			int pop = scan.nextInt( );
			int time = scan.nextInt( );
			if( scan.hasNext() )
				scan.nextLine( );
			System.out.println( "" + ( pop - time/7 + time/4 ) );
		}

	}
}