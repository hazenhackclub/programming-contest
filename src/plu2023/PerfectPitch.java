package plu2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PerfectPitch {

	public static void main( String[] args ) throws FileNotFoundException {
		Scanner scan = new Scanner( new File( "pitch.dat" ) );

		int num = Integer.parseInt( scan.nextLine( ) );

		HashMap<String, String> map = new HashMap<>( );
		map.put( "A Flat", "G Sharp" );
		map.put( "B Flat", "A Sharp" );
		map.put( "C Flat", "B Sharp" );
		map.put( "D Flat", "C Sharp" );
		map.put( "E Flat", "D Sharp" );

		map.put( "A Sharp", "B Flat" );
		map.put( "B Sharp", "C Flat" );
		map.put( "C Sharp", "D Flat" );
		map.put( "D Sharp", "E Flat" );
		map.put( "E Sharp", "F Flat" );

		for( int i = 0; i < num; i++ ) {
			String input = scan.nextLine( );

			System.out.println( map.get( input ) );
		}

	}
}
