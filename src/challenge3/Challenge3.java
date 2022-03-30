package challenge3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Put challenge here:
Input File: floor_cleaner.dat

You have built a floor cleaning robot and now you are writing an algorithm that will report all
the locations of the house it could not clean. The robot has layout of the house that includes
where the walls, furniture and flooring are. When it cleans it will log locations where it finds
unexpected obstructions.

Key:
 �W� - Wall
 �F� - Furniture
 �-� - Flooring
 �B� - Base

Input
The input will start with a 10 by 10 grid that describes the house with columns and rows
numbered 0 to 9. The grid will be followed by an unknown number of locations where
obstructions were found, in the following format:
(column,row)

Output
Display all the locations that were not able to be cleaned in the following format:
(column,row)

Display each location on its own line. Locations must be displayed in ascending order first by
row and then by column.

Example Input File
W W W W W W W W W W
W - ? - - - - - B W
W F - - F W - - - W
W - - - F W - - F W
W W W W W - - - F W
W - - W W - - - W W
W - F W - - - - F W
W - W W W F - - - W
W ? - - - - - - - W
W W W W W W W W W W
(2,1)
(1,8)

Example Output to Screen
(1,1)
(2,1)
(1,5)
(2,5)
(1,6)
(1,7)
(1,8)

@formatter:on
*/

public class Challenge3 {

	static Scanner scan;

	static boolean[][] cleaned = new boolean[10][10];

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/Challenges/challenge3/floor_cleaner-2.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		// get floor layout
		boolean[][] housePosOccupied = new boolean[10][10];

		int[] robotStartPos = new int[] { 0, 0 };

		for( int i = 0; i < housePosOccupied.length; i++ ) {
			String row = scan.nextLine( );
			for( int j = 0; j < housePosOccupied[0].length; j++ ) { // row index
				housePosOccupied[i][j] = !( row.charAt( j ) == '-' || row.charAt( j ) == 'B' );
				if( row.charAt( j ) == 'B' )
					robotStartPos = new int[] { j, i };
			}
		}

		print2dArray( housePosOccupied );

		while( scan.hasNextLine( ) ) {
			String input = scan.nextLine( );
			input = input.substring( 1, input.length( ) - 1 );
			String[] pos = input.split( "," );
			housePosOccupied[Integer.parseInt( pos[1] )][Integer.parseInt( pos[0] )] = true;
		}

		print2dArray( housePosOccupied );

		clean( housePosOccupied, robotStartPos );

		for( int i = 1; i < housePosOccupied.length - 1; i++ ) {
			for( int j = 1; j < housePosOccupied[0].length - 1; j++ )
				// if not cleaned and not occupied print position
				if( !cleaned[i][j] && !housePosOccupied[i][j] )
					System.out.println( "(" + i + ", " + j + ")" );
		}

		print2dArray( cleaned );

	}

	/**
	 * 
	 * @param occupiedLayout array of the house where position is true if position is occupied
	 * @param curPos         current position on baord between 0 & 9 [column, row]
	 */
	public static void clean( boolean[][] occupiedLayout, int[] curPos ) {
		// check other squares for cleaning and check for already cleaned
		// if position 'X', that position is uncleanable

		int col = curPos[0], row = curPos[1];
		cleaned[row][col] = true;

		if( !occupiedLayout[row - 1][col] && !cleaned[row - 1][col] ) // check up
			clean( occupiedLayout, new int[] { col, row - 1 } );
		if( !occupiedLayout[row + 1][col] && !cleaned[row + 1][col] ) // check down
			clean( occupiedLayout, new int[] { col, row + 1 } );
		if( !occupiedLayout[row][col - 1] && !cleaned[row][col - 1] ) // check left
			clean( occupiedLayout, new int[] { col - 1, row } );
		if( !occupiedLayout[row][col + 1] && !cleaned[row][col + 1] ) // check right
			clean( occupiedLayout, new int[] { col + 1, row } );
	}

	public static void print2dArray( boolean[][] array ) {

		for( int i = 0; i < array.length; i++ ) {
			for( int j = 0; j < array[0].length; j++ )
				System.out.print( ( array[i][j] ? "X" : "-" ) + " " );
			System.out.println( );
		}
	}
}
