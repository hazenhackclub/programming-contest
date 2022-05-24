package plu2019.challenge07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

/*
@formatter:off

Input File: seasons.dat
Marie is travelling on a long journey to a far away land by foot. She moves at different speeds at different times of
the year due to different weather patterns. More specifically, she can move 3 miles a day during the hot season of
January through April, 5 miles a day during the warm season of May through August, and 1 mile per day during the
cold season of September through December. Given a starting date, and the distance Marie must travel, calculate
when Marie will reach her destination.
Input
● The first line of input will contain a single integer n that indicates the number of datasets
to follow.
● Each dataset will be composed of:
o An integer d between 1 and 12000, which is the distance Marie must travel.
o A date in the format “m d, y”, where m, d, and y are the month, day of the
month, and year, respectively, on which Marie begins her journey. All dates will
be valid.
Output
Output the valid date that Marie will arrive at her far away destination in the format “m d, y”,
where m, d, and y are the month, day of the month, and year, respectively.

Example Input File
3
1000
January 1, 1999
365
August 12, 2034
712
December 31, 1991

Example Output to Screen
September 26, 1999
February 17, 2035
July 09, 1992





@formatter:on
*/

public class Seasons {

	static Scanner scan;
	// static ArrayList<String> monthNames = new ArrayList<>( Arrays.asList(
	// 		new String[]  ) );
	static String[] monthNames = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	static int[] monthLength = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge07/seasons.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numDates = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < numDates; i++ ) {
			int distance = Integer.parseInt( scan.nextLine( ) );
			String[] dateInput = scan.nextLine( ).split( " " );
			String month = dateInput[0];
			int day = Integer.parseInt( dateInput[1].substring( 0, 1 ) );
			int year = Integer.parseInt( dateInput[2] );

			/*
			@formatter:off

			3 mi per day : jan - apr
			5 mi per day : may - aug
			1 mi per day : sep - dec
			
			@formatter:on

			 */

			while( distance > 0 ) {

				if( month.equals( monthNames[0] ) || month.equals( monthNames[1] ) || month.equals( monthNames[2] )
						|| month.equals( monthNames[3] ) ) {
				}

			}
		}

	}

	public static int monthTranslator( String month ) {
		month = month.toLowerCase( ).substring( 0, 3 );
		return monthNames.indexOf( month );
	}

	public static String monthTranslator( int month ) {
		return monthNames.get( month );
	}
}