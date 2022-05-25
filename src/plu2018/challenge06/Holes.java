package plu2018.challenge06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*


@formatter:off

@formatter:on
*/

public class Holes {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge06/holes.txt" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int loops = scan.nextInt();

		for (int i = 0; i < loops; i++) {

			char[][] box = boxScanner();

			printBoard(box);

			System.out.println(countSpaces(box));
			System.out.println();

			int numBoxSections = 1;

			for (int j = 1; j < box.length - 2; j++) {
				boolean rowHasGap = false;
				for (int k = 1; k < box[j].length - 2; k++) {
					if (!(box[j][k] == '.'))
						rowHasGap = true;
				}
				if (!rowHasGap)
					numBoxSections++;
			}

			System.out.println(numBoxSections);

			for (int j = 1; j < box[0].length - 2; j++) {
				boolean columnHasGap = false;
				for (int k = 1; k < box.length - 2; k++) {
					if (!(box[k][j] == '.'))
						columnHasGap = true;
				}	
				if (!columnHasGap)
					numBoxSections++;
			}

			System.out.println(numBoxSections);
		}
	}

	public static char[][] boxScanner() {
		int rows = scan.nextInt();
		int columns = scan.nextInt();

		char[][] box = new char[rows][columns];

		for (int i = 0; i < rows; i++) {
			box[i] = scan.next().toCharArray();
		}

		return box;
	}

	public static int countSpaces(char[][] arr) {
		int spaceCounter = 0;
		for (int j = 0; j < arr.length - 1; j++) {
			for (int k = 0; k < arr[j].length - 1; k++) {
				if (arr[j][k] == '.')
					spaceCounter++;
			}
		}
		return spaceCounter;
	}

	public static void printBoard(char[][] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println(Arrays.toString(arr[j]));
		}
	}
}