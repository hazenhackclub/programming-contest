package plu2019.challenge3;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;

public class challange3_2020_PLU_ver2 {
	static Scanner scan;
	static ArrayList<Integer[]> uncleaned_locs;

	public static void main( String[] args ) {

		System.out.println( );
		try {
			File file = new File( ".\\challange3\\challange3-ver2.dat" );
			scan = new Scanner( file );
		} catch( FileNotFoundException e ) {
			System.out.println( "FILE NOT FOUND !!!." );
			e.printStackTrace( );
		}

		char[][] grid = new char[10][10];

		int row = -1;
		Integer[] robot_location = new Integer[2];
		uncleaned_locs = new ArrayList<Integer[]>( );

		while( scan.hasNextLine( ) && row <= 8 ) {
			String data = scan.nextLine( );
			row++;
			for( int col = 0; col < data.length( ); col++ ) {
				grid[row][col] = data.charAt( col );

				if( data.charAt( col ) != 'W' && data.charAt( col ) != 'F' && data.charAt( col ) != 'B' ) {
					Integer[] not_clean_pos = { col, row };
					uncleaned_locs.add( not_clean_pos );
				} else if( data.charAt( col ) == 'B' ) {
					robot_location[0] = col;
					robot_location[1] = row;
					uncleaned_locs.add( robot_location );
				}
			}
		}

		while( scan.hasNextLine( ) ) {
			String data = scan.nextLine( );
			String[] result = data.substring( 1, data.length( ) - 1 ).split( "," );
			grid[Integer.parseInt( result[1] )][Integer.parseInt( result[0] )] = 'W';
		}

		clean( grid, robot_location );
		for( Integer[] dirty_loc : uncleaned_locs ) {
			System.out.println( Arrays.toString( dirty_loc ) );
		}
	}

	public static void clean( char[][] grid, Integer[] robot_location, int... z ) {

		int col = robot_location[0];
		int row = robot_location[1];
		Integer[] potential_location_up = { col, row - 1 };
		Integer[] potential_location_down = { col, row + 1 };
		Integer[] potential_location_left = { col - 1, row };
		Integer[] potential_location_right = { col + 1, row };
		if( grid[row - 1][col] != 'W' ) {
			boolean found_new = false;
			int index = 0;
			for( Integer[] dirty_pos : uncleaned_locs ) {
				if( Arrays.equals( dirty_pos, potential_location_up ) ) {
					found_new = true;
					break;
				}
				index++;
			}
			if( found_new ) {
				uncleaned_locs.remove( index );
				clean( grid, potential_location_up, index );

			}
		}
		if( grid[row + 1][col] != 'W' ) {
			boolean found_new = false;
			int index = 0;
			for( Integer[] dirty_pos : uncleaned_locs ) {
				if( Arrays.equals( dirty_pos, potential_location_down ) ) {
					found_new = true;
					break;
				}
				index++;
			}
			if( found_new ) {
				uncleaned_locs.remove( index );
				clean( grid, potential_location_down, index );

			}

		}
		if( grid[row][col - 1] != 'W' ) {
			boolean found_new = false;
			int index = 0;
			for( Integer[] dirty_pos : uncleaned_locs ) {
				if( Arrays.equals( dirty_pos, potential_location_left ) ) {
					found_new = true;
					break;
				}
				index++;
			}
			if( found_new ) {
				uncleaned_locs.remove( index );
				clean( grid, potential_location_left, index );

			}
		}
		if( grid[row][col + 1] != 'W' ) {
			boolean found_new = false;
			int index = 0;
			for( Integer[] dirty_pos : uncleaned_locs ) {
				if( Arrays.equals( dirty_pos, potential_location_right ) ) {
					found_new = true;
					break;
				}
				index++;
			}
			if( found_new ) {
				uncleaned_locs.remove( index );
				clean( grid, potential_location_right, index );

			}
		}
	}
}
