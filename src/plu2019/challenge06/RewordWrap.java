package plu2019.challenge06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

/*
@formatter:off

Input File: rewordwrap.dat
When a window of a text editor resizes, it is often necessary to readjust all of the containing words to fit in the
screen window without splitting up any of the words. This is referred to as word-wrapping. Given a block of text,
word-wrap the data to fit in a specific size.
Input
● The first line of input will contain a single integer n that indicates the number of datasets
to follow. Each dataset will consist of:
o An integer w indicating the number of characters to word wrap,
where 10 ≤ w ≤ 50.
o An integer m indicating the number of lines of text input that are to be word
wrapped, where 1 ≤ m ≤ 100.
o The m lines of text to be word wrapped.
Output
Output the text word wrapped to the proper number of characters, and include one blank line
after each dataset.

Example Input File
2
40
4
Chinua Achebe was born on November 16, 1930 into the Igbo
African ethnic group in southern Nigeria. He was raised in a
Christian family, but he was always fascinated by the
traditional African religion and culture.
35
4
Achebe uses the short story of a hard working man
in a war torn area with a bright outlook on life to act
as a model for other Africans affected by
the Nigerian Civil War.

Example Output to Screen
Chinua Achebe was born on November 16,
1930 into the Igbo African ethnic group
in southern Nigeria. He was raised in a
Christian family, but he was always
fascinated by the traditional African
religion and culture.
Achebe uses the short story of a
hard working man in a war torn area
with a bright outlook on life to
act as a model for other Africans
affected by the Nigerian Civil War.

@formatter:on
*/

public class RewordWrap {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge06/rewordwrap.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numDatasets = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numDatasets; i++ ) {

			int charWrapLimit = Integer.parseInt( scan.nextLine( ) );

			int curLength = Integer.parseInt( scan.nextLine( ) );

			ArrayList<String> words = new ArrayList<>( );

			for( int j = 0; j < curLength; j++ )
				words.addAll( Arrays.asList( scan.nextLine( ).split( " " ) ) );

			String outputLine = "";
			for( int j = 0; j < words.size( ); j++ ) {
				String curWord = words.get( j );
				if( outputLine.length( ) + curWord.length( ) <= charWrapLimit ) {
					outputLine += curWord;
					if( j < words.size( ) - 1
							&& outputLine.length( ) + 1 + words.get( j + 1 ).length( ) <= charWrapLimit )
						outputLine += " ";
				} else {
					System.out.println( outputLine );
					outputLine = curWord + " ";
				}

			}
			
			System.out.println( outputLine );

		}

	}
}