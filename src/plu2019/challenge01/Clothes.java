package plu2019.challenge01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*


@formatter:off

Input File: clothes.dat
Billy’s mom recently washed his clothes. When his mom finishes washing his clothes, she folds them and stacks
them in one large pile. It is then Billy’s responsibility to sort the clothes into three drawers for shirts, pants, and
socks. When he places these items in the drawers he takes the top one off of the stack his mom gave to him and
places it at the top of the stack in the respective drawer.
Each day Billy must wear a shirt, pants, and socks. He simply picks the top one off each stack in each drawer to
wear for that day. Given the original stack of washed clothes, determine what Billy will wear up until he needs
more clothes washed. Billy needs more clothes when he runs out of any necessary article of clothing for the day.
Billy will only wear a piece of clothing once before it is declared dirty and needs washing. He does not ever wear
dirty clothes.
Input
The first line of input will contain a single integer n that indicates the number datasets to follow.
Each dataset begins with an integer c which is between 1 and 50. The next c lines are the stack
of clean clothing in the format “article (type)” where article is the name of the article
of clothing and type is the type of clothing. The value of type will be shirt, pants, or
socks.
Output
The output will be a series of lines. Each line will contain the three articles of clothing for the
specific day separated by a comma and one space. The shirt will be printed first followed by the
pants and socks. The type should not be printed. There should be one blank line after each
dataset.
Example Input File
2
6
mario logo (shirt)
red (pants)
hawaiian (shirt)
baggy (pants)
white (socks)
fancy (socks)
10
khaki (pants)
blueish green (shirt)
apple (shirt)
bright (socks)
blue (pants)
red (pants)
purple (socks)
ugly (shirt)
stupid (socks)
big red (pants)

Example Output to Screen
hawaiian, baggy, fancy
mario logo, red, white

ugly, big red, stupid
apple, red, purple
blueish green, blue, bright

@formatter:on
*/

public class Clothes {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2019/challenge01/clothes.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}
		int datasets = Integer.parseInt( scan.nextLine( ) );

		for( int i = 0; i < datasets; i++ ) {

			ArrayList<String> shirts = new ArrayList<>( ), pants = new ArrayList<>( ), socks = new ArrayList<>( );

			int numClothes = Integer.parseInt( scan.nextLine( ) );

			for( int j = 0; j < numClothes; j++ ) {

				String input = scan.nextLine( );

				if( input.contains( "shirt" ) )
					shirts.add( 0, input.substring( 0, input.indexOf( " (" ) ) );
				else if( input.contains( "pants" ) )
					pants.add( 0, input.substring( 0, input.indexOf( " (" ) ) );
				else if( input.contains( "socks" ) )
					socks.add( 0, input.substring( 0, input.indexOf( " (" ) ) );

			}

			int minLength = Math.min( shirts.size( ), Math.min( pants.size( ), socks.size( ) ) );

			for( int j = 0; j < minLength; j++ )
				System.out.println( shirts.get( j ) + ", " + pants.get( j ) + ", " + socks.get( j ) );
			System.out.println( );
		}

	}

}
