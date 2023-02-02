package plu2017.challenge02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Bunnies {

	static Scanner scan;

	static Hashtable<Integer, Integer> fib = new Hashtable<>( );

	public static void main( String[] args ) {
		fib.put( 0, 1 );
		fib.put( 1, 1 );
		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2017/challenge02/Bunnies.in" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found." );
			return;
		}
		int numDataSets = Integer.parseInt( scan.nextLine( ) );
		for( int i = 0; i < numDataSets; i++ ) {
			System.out.println( f( Integer.parseInt( scan.nextLine( ) ) ) );
		}

	}

	public static int f( int n ) {
		if( fib.containsKey( n ) )
			return fib.get( n );
		fib.put( n, f( n - 1 ) + f( n - 2 ) );

		return fib.get( n );
	}

}
