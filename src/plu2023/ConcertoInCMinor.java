package plu2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConcertoInCMinor {

	public static void main( String[] args ) throws FileNotFoundException {
		Scanner scan = new Scanner( new File( "concerto.dat" ) );

		int numLines = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numLines; i++ ) {
			String[] line = scan.nextLine( ).split( "mino" );
			int appearences = 0;
			for( int index = 0; index < line.length; index++ )
				if( line[index].length( ) > 0 )
					if( line[index].charAt( 0 ) == 'r' )
						appearences++;

			if( appearences > 2 )
				System.out.println( "It's over Vee Valdee! I have the high ground!" );
			else
				System.out.println( "You underestimate my music!" );

		}

	}
}
