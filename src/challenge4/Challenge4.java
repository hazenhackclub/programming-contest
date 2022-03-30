package challenge4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Put challenge here:


@formatter:on
*/

public class Challenge4 {

	static Scanner scan;

	static boolean[][] cleaned = new boolean[10][10];

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/challenge4/____.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

	}
}
