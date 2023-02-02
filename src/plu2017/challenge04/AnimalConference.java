package plu2017.challenge04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class AnimalConference {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2017/challenge04/conference.in" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found." );
			System.exit( 0 );
		}

		// System.out.println( new Point( 1, 2 ) );

		int numDataSets = Integer.parseInt( scan.nextLine( ) );
		for( int dataSet = 0; dataSet < numDataSets; dataSet++ ) {
			int numLocations = Integer.parseInt( scan.nextLine( ) );

			Hashtable<String, Double> distances = new Hashtable<>( );
			ArrayList<Point> locations = new ArrayList<>( );

			for( int i = 0; i < numLocations; i++ ) {
				String[] location = scan.nextLine( ).split( " " );
				locations.add( new Point( Integer.parseInt( location[0] ), Integer.parseInt( location[1] ) ) );
			}

			// double smallestDistance = -1;
			String smallestLocation = "";
			// int[] smallestLocations = new int[] { 0, 1 };
			for( int i = 0; i < locations.size( ); i++ ) {
				for( int j = 0; j < locations.size( ); j++ ) {

					String name = Point.uniqueName( locations.get( i ), locations.get( j ) );

					// if those 2 points haven't been checked already
					if( distances.get( name ) == null && i != j ) {
						double dist = locations.get( i ).dist( locations.get( j ) );
						distances.put( name, locations.get( i ).dist( locations.get( j ) ) );

						if( smallestLocation.equals( "" ) || dist < distances.get( smallestLocation ) )
							smallestLocation = name;
						else if( dist == distances.get( smallestLocation ) ) {
							int[] cur = parseStringArray( name.split( " " ) );
							int[] smallest = parseStringArray( smallestLocation.split( " " ) );
							if( cur[0] < smallest[0] ) { // if x is smaller set it
								smallestLocation = name;
							} else if( cur[0] == smallest[0] ) { // if x's are the same check y
								if( cur[1] < smallest[1] ) // if y is smaller set it
									smallestLocation = name;
								else if( cur[1] == smallest[1] ) { // if y's are alse the same check x2
									if( cur[2] < smallest[2] ) // if x1 is smaller set it
										smallestLocation = name;
									else if( cur[2] == smallest[2] ) // if x2's are alse the same check y2
										if( cur[3] < smallest[3] ) // if y2 is smaller set it
											smallestLocation = name;
								}
							}
						}
					}
					// if( i != j && ( smallestDistance < 0 || dist < smallestDistance ) ) {
					// 	smallestDistance = dist;
					// 	smallestLocations = new int[] { i, j };
					// }
				}
			}

			// System.out.println( locations[smallestLocations[0]][0] + " " + locations[smallestLocations[0]][1] + " "
			// 		+ locations[smallestLocations[1]][0] + " " + locations[smallestLocations[1]][1] );

			// System.out.println( distances );
			System.out.println( smallestLocation );
		}

	}

	public static int[] parseStringArray( String[] stringArray ) {
		int[] intArray = new int[stringArray.length];
		for( int j = 0; j < intArray.length; j++ )
			intArray[j] = Integer.parseInt( stringArray[j] );

		return intArray;
	}

	static double distBetweenPoints( double x1, double y1, double x2, double y2 ) {

		return Math.sqrt( Math.pow( x2 - x1, 2 ) + Math.pow( y2 - y1, 2 ) );
	}

	static class Point {
		public int x;
		public int y;

		public Point( int x, int y ) {
			this.x = x;
			this.y = y;
		}

		public Point( int[] array ) {
			this.x = array[0];
			this.y = array[1];
		}

		public boolean smaller( Point point ) {
			return x < point.x || ( x == point.x && y < point.y );
		}

		@Override
		public boolean equals( Object point ) {
			return x == ( (Point) point ).x && y == ( (Point) point ).y;
		}

		public double dist( Point point ) {

			return Math.sqrt( Math.pow( x - point.x, 2 ) + Math.pow( y - point.y, 2 ) );
		}

		public String toString( ) {
			return "[" + x + ", " + y + "]";
		}

		public static String uniqueName( Point p1, Point p2 ) {
			if( p1.smaller( p2 ) )
				return p1.x + " " + p1.y + " " + p2.x + " " + p2.y;
			return p2.x + " " + p2.y + " " + p1.x + " " + p1.y;
		}
	}

}