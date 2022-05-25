package plu2018.challenge07;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*


@formatter:off

@formatter:on
*/

public class Ornaments {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge07/ornaments.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int loops = scan.nextInt();

		for (int i = 0; i < loops; i++) {
			long number = scan.nextInt();
			
			long sum = 0;

			for (long j = number; j > 0; j--) {
				sum += (0.5 * j * (j+1));
			}

			System.out.println(sum);
		}
	}
}