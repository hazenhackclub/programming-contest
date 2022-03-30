package src.challenges.challenge2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*

@formatter:off

Put challenge here:
Input File: playtime.dat

All your games track your time played in minutes. You have decided to create a program that
will convert the minutes into years, days, hours and minutes.

Notes:
 Years will be treated as 365 days.
 Playtime will never be 0 minutes

Input
The first line will contain the number of inputs that follow. Each input will consist of a game title
and the number of minutes played, in the following format:
gameTitle,minutesPlayed

Output
For each input display the game title followed by how long it has been played in years, days,
hours and minutes. Each unit of time is only printed if it has a value is greater than 0. All the text
on the same line is separated by a single space.

Result Format:
GameTitle - # year(s) # day(s) # hour(s) # minute(s)

Example Input File
5
2048,800
Halo,1097578
Heroes of the Storm,6736732
Infinity Blade,78
Xcom,43

Example Output to Screen
2048 - 13 hour(s) 20 minute(s)
Halo - 2 year(s) 32 day(s) 4 hour(s) 58 minute(s)
Heroes of the Storm - 12 year(s) 298 day(s) 6 hour(s) 52 minute(s)
Infinity Blade - 1 hour(s) 18 minute(s)
Xcom - 43 minute(s)

@formatter:on
*/

public class challenge2 {

	public static Scanner scan;

	public static void main( String args[] ) {

		try {
			scan = new Scanner( new File( "../programming-contest/Challenges/challenge2/playtime-2.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		while( scan.hasNextLine( ) ) {

			String inputLine = scan.nextLine( );

			String[] inputArray = inputLine.split( "," );

			if( inputArray.length < 2 )
				continue;

			System.out.print( inputArray[0] + " - " );

			int minutes = Integer.parseInt( inputArray[1] );

			// get time data here:
			int years = minutes / 525600; // 365

			minutes -= years * 525600;

			int days = minutes / 1440;

			minutes -= days * 1440;

			int hours = minutes / 60;

			minutes -= hours * 60;

			String output = "";

			if( years != 0 )
				output += years + " year(s) ";

			if( days != 0 )
				output += days + " day(s) ";

			if( hours != 0 )
				output += hours + " hour(s) ";

			if( minutes != 0 )
				output += minutes + " minute(s)";

			System.out.println( output );

			// System.out.println();

		}
	}
}
