package challenge4;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/*
@formatter:off

Put challenge here:

Input File: feed_store.dat

You work at a feed store and want to make your delivery routes more efficient. You have a list of
how much feed each nearby farm needs, a map of the roads and the total amount of feed your
truck can carry. Write a program that will take in all that data and give you the shortest number
of miles for completing your first delivery and the path for the route. A delivery route will
always start and end with ‘A’. ‘A’ will always be the store you are delivering from.

Note: There may be several best paths with the same distance, so you may not get the same
exact path as the sample data, but your solution needs to be correct and be of the shortest
distance.

Here is an example:
Input
The first line will contain a number that indicates how much feed your truck can carry.
The second line will contain how much feed each farm wants. A farm name will always be a
single uppercase letter. Each farm will list how much feed they want as 0 to 9 units of feed. The
data for each farm will be a single letter followed immediately by a single digit. Each farm’s data
will be separated by a single space.
Finally, there will be an unknown number of lines defining the connections between farms and
the store / other farms. Connections will be in the following format:
locationA/locationB-distanceApart

Output
Output the distance of the shortest solution and the path for that solution. The format will for the
solution will be:
(distance) – path
with a single space on each side of the dash.

Example Input File
10
B2 C3 D4 E1 F6 G3 H4 I0 J3
A/C-5
A/B-5
A/J-1
A/D-4
I/J-1
I/D-2
C/B-7
C/D-4
C/E-3
H/D-8
H/E-3
H/G-4
E/F-3
F/G-5
Example Output to Screen
(13) - ACDIJA

@formatter:on
*/

public class FeedStore {

	static Scanner scan;

	static HashMap<String, Integer> routes = new HashMap<>( );
	static ArrayList<String> sortedRoutes = new ArrayList<>( );

	static int shortestRoute = Integer.MAX_VALUE;

	static HashMap<String, Integer> allPossibleRoutes = new HashMap<>( );

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/challenge4/feed_store.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int truckCapacity = scan.nextInt( );

		scan.nextLine( );

		String[] destinationStrings = scan.nextLine( ).split( " " );

		HashMap<String, Integer> farms = new HashMap<>( );

		farms.put( "A", 0 );

		for( int i = 0; i < destinationStrings.length; i++ )
			if( destinationStrings[i].length( ) >= 2 )
				farms.put( destinationStrings[i].substring( 0, 1 ),
						Integer.parseInt( destinationStrings[i].substring( 1 ) ) );

		while( scan.hasNextLine( ) ) {
			String pathInput = scan.nextLine( );

			routes.put( pathInput.substring( 0, 1 ) + pathInput.substring( 2, 3 ),
					Integer.parseInt( pathInput.substring( 4, 5 ) ) );
		}

		sortRoutes( false );

		findRoutes( farms, truckCapacity );

		for( String route : allPossibleRoutes.keySet( ) ) {
			String key = route.toString( );
			String value = allPossibleRoutes.get( route ).toString( );
			System.out.println( "(" + value + ") - " + key );
		}

	}

	private static void findRoutes( HashMap<String, Integer> farms, int feedLeft ) {

		findRoutes( new ArrayList<>( Arrays.asList( 'A' ) ), farms, feedLeft, 0 );
	}

	private static void sortRoutes( boolean headingBack ) {

		String[] keys = routes.keySet( ).toArray( new String[0] );
		Integer[] entries = new Integer[keys.length];
		for( int i = 0; i < entries.length; i++ )
			entries[i] = routes.get( keys[i] );
		ArrayList<String> stringRoutes = new ArrayList<>( Arrays.asList( keys ) );
		sortedRoutes = new ArrayList<>( Arrays.asList( keys ) );

		sortedRoutes.sort( ( o1, o2 ) -> {
			int comp = entries[stringRoutes.indexOf( o1 )].compareTo( entries[stringRoutes.indexOf( o2 )] );
			return ( headingBack ? 1 : -1 ) * ( comp == 0 ? o1.compareTo( o2 ) : comp );
		} );

	}

	private static ArrayList<String> availablePaths( HashMap<String, Integer> destinations, char position ) {

		ArrayList<String> availablePaths = new ArrayList<>( );

		for( String destination : destinations.keySet( ) )
			if( destination.contains( "" + position ) )
				availablePaths.add( destination );

		return availablePaths;
	}

	private static void findRoutes( ArrayList<Character> currentPath, HashMap<String, Integer> farms, int feedLeft,
			int distanceTravelled ) {

		for( int routeNum = 0; routeNum < sortedRoutes.size( ); routeNum++ ) {
			String route = sortedRoutes.get( routeNum );
			// }
			// for( String route : routes.keySet( ) ) {
			Character position = currentPath.get( currentPath.size( ) - 1 );
			if( route.contains( "" + position ) ) {
				char destination = route.substring( 0, 1 ).equals( "" + position ) ? route.charAt( 1 )
						: route.charAt( 0 );

				String currentPathString = "";
				for( Character character : currentPath )
					currentPathString = currentPathString.concat( "" + character );

				boolean needToBreak = false;
				for( int index = 0; index < currentPath.size( ); index++ ) {
					char pos = currentPath.get( index );
					int count = (int) currentPathString.chars( ).filter( ch -> ch == pos ).count( );
					if( count >= 3 ) {
						// findRoutes( new ArrayList<>( Arrays.asList( currentPath.get( 0 ), currentPath.get( 1 ) ) ),
						// 		farms, feedLeft, distanceTravelled );
						// return;
						needToBreak = true;
					}
				}
				if( needToBreak )
					continue;

				int feedRequired = farms.get( "" + destination );

				if( feedLeft - feedRequired == 0 ) // head back to A
					sortRoutes( true );
				if( feedLeft == 0 && destination == 'A' ) // arriving back at A
					allPossibleRoutes.put( currentPathString + destination, distanceTravelled + routes.get( route ) );
				if( feedLeft - feedRequired <= 0 )
					continue;

				farms.replace( "" + destination, 0 );

				ArrayList<Character> newPath = (ArrayList<Character>) currentPath.clone( );
				newPath.add( destination );

				findRoutes( newPath, farms, feedLeft - feedRequired, distanceTravelled + routes.get( route ) );

			}
		}
	}

	private static char shiftLetter( char letter, int distance ) {
		int letterNum = letter + distance;
		char newLetter = (char) letterNum;
		return Character.isLetter( newLetter ) ? newLetter : 'A';
	}

}
