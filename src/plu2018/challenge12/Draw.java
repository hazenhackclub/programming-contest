package plu2018.challenge12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Input File: draw.dat
You’re bored during class one day. Instead of drawing shapes all over your paper, you decide to
write a program that will do it for you! Write a program that, when given the type of shape and
the dimensions, will draw the specified shape. The program will also be able to either leave the
shape empty or fill it in. The shape names and examples are shown below.
rectangle ##
##
###
# #
###
###
###
###
left triangle #
##
###
#
##
# #
####
#
##
###
####
right triangle #
##
###
 #
 ##
# #
####
 #
 ##
###
####
diamond #
# #
#
 #
# #
# #
# #
 #
 #
###
#####
###
 #
The rectangle can be any number of rows and columns. The left triangle, the right triangle, and
the diamond will always have the same number of rows and columns. For the diamond, the
number of rows and columns will always be odd.
Input
The first line will contain a single integer n that indicates the number of data sets that follow.
Each data set will be one line that starts with the shape name. If the shape is a rectangle, the
name will be followed by two integers, r and c, representing the number of rows and columns
respectively. If not, then the shape name will be followed by one integer, denoting the number of
both rows and columns. The line will end with either y or n, y meaning that the shape is filled in
and n meaning that the shape is empty.
Output
You will print the specified shape of the specified size, either filled or empty as denoted by the
letter at the end of the line. There are examples of the shapes in the table above. There are no
lines of whitespace between data sets.
Example Input File
3
rectangle 3 5 n
right triangle 4 n
diamond 7 y
Example Output to Screen
#####
# #
#####
 #
 ##
# #
####
 #
 ###
#####
#######
#####
 ###
 #

@formatter:on
*/

public class Draw {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge12/draw.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );
		scan.nextLine( ); // if next scan call is scan.nextLine( )

		for( int i = 0; i < numLines; i++ ) {
			String[] inputs = scan.nextLine( ).split( " " );
			String shape = inputs[0];
			int height, width;
			boolean filled;
			if( shape.equalsIgnoreCase( "rectangle" ) ) { // rectangle

				height = Integer.parseInt( inputs[1] );
				width = Integer.parseInt( inputs[2] );
				filled = inputs[3].equals( "y" );

				for( int row = 0; row < height; row++ ) {
					for( int col = 0; col < width; col++ )
						System.out.print( filled ? "#"
								: ( row == 0 || col == 0 || row == height - 1 || col == width - 1 ? "#" : " " ) );

					System.out.println( );
				}

			} else if( shape.equalsIgnoreCase( "diamond" ) ) { // diamond

				height = Integer.parseInt( inputs[1] );
				filled = inputs[2].equals( "y" );

				int middle = height / 2;

				for( int layer = 0; layer < height; layer++ ) {

					System.out.println( getNumChar( Math.abs( middle - layer ), " " )
							+ ( filled ? ( getNumChar( ( middle - Math.abs( middle - layer ) ) * 2 + 1, "#" ) )
									: ( "#" + getNumChar( ( middle - Math.abs( middle - layer ) ) * 2 - 1, " " )
											+ ( layer != 0 && layer != height - 1 ? "#" : "" ) ) ) );
				}

			} else {

				height = Integer.parseInt( inputs[2] );
				filled = inputs[3].equals( "y" );

				if( shape.equalsIgnoreCase( "left" ) ) { // left triangle
					for( int layer = 0; layer < height; layer++ )
						System.out.println( filled ? ( getNumChar( layer + 1, "#" ) )
								: ( layer == height - 1 ? getNumChar( height, "#" )
										: ( "#" + getNumChar( layer - 1, " " ) + ( layer != 0 ? "#" : "" ) ) ) );

				} else { // right triangle
					for( int layer = 0; layer < height; layer++ )
						System.out.println( getNumChar( height - 1 - layer, " " ) + ( filled
								? ( getNumChar( layer + 1, "#" ) )
								: ( layer == height - 1 ? getNumChar( height, "#" )
										: ( "#" + getNumChar( layer - 1, " " ) + ( layer != 0 ? "#" : "" ) ) ) ) );

				}
			}

		}

	}

	public static String getNumChar( int numSpaces, String character ) {
		String spaces = "";
		for( int i = 0; i < numSpaces; i++ )
			spaces += character;
		return spaces;
	}
}