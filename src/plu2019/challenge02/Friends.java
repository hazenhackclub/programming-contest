package plu2019.challenge02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
@formatter:off

Input File: friends.dat
Jane has many friends, but she likes some less than others. She has a number associated with each friend which
represents how much she likes each friend. The higher the number, the more she likes that friend. Given her list of
friends, sort them so that the best friends are at the top and the least best friends are at the bottom.
Input
The first line of input will contain a single integer n that indicates the number datasets to follow.
Each dataset will consist an integer m, (0 < m < 500), which is the number of friends that will be
in the dataset. The next m lines will have the format “name num”, where name is the name of
the friend and num (0 < num < 500) is the number that represents how much she likes her friend.
The name will only be one word. No two friends will have the same num value.
Output
Output a list of names, separated by a comma and one space, of the friends in order of how much
Jane likes them.

Example Input File
2
2
bill 2
greg 5
4
jim 5
phil 8
paul 7
rob 2

Example Output to Screen
greg, bill
phil, paul, jim, rob

@formatter:on
*/

public class Friends {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge02/friends.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numDatasets = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numDatasets; i++ ) {

			HashMap<String, Integer> friends = new HashMap<>( );

			int numFriends = Integer.parseInt( scan.nextLine( ) );

			for( int j = 0; j < numFriends; j++ ) {
				String[] input = scan.nextLine( ).split( " " );
				friends.put( input[0], Integer.parseInt( input[1] ) );
			}

			String[] keys = friends.keySet( ).toArray( new String[0] );
			ArrayList<String> names = new ArrayList<>( Arrays.asList( keys ) );
			names.sort( ( o1, o2 ) -> friends.get( o2 ).compareTo( friends.get( o1 ) ) );
			
			for (int j = 0; j < names.size( ); j++)
				System.out.print( names.get( j ) + ( j == names.size( ) - 1 ? "\n" : ", " ) );
		

		}

	}

}
