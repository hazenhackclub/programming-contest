package plu2018.challenge11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
@formatter:off

Input File: bomb.dat
You decide to create a game involving a 3D maze with destructible walls, where all the character
has to work with is bombs. In order to determine the number of bombs to provide for each level,
you need to know the minimum amount necessary to reach the exit and base it off of that. Your
task is to write a program that will find the smallest number of bombs necessary to reach the exit.
Each bomb can destroy one wall, leaving a blank space in its place.
Input
The first line will contain a single integer n that indicates the number of data sets that follow.
Each data set will start with three integers f, r, and c, representing the number of layers, rows,
and columns, respectively. The next f sets of r lines will be the maze, with every set of r lines
being one layer of the maze.
The # represents a destructible wall, . represents an open space, S is the start location, and
E is the exit location. You can only move up, down, left, and right (i.e., you cannot move
diagonally). You can move freely between layers, but a move between layers stays in the same
relative grid location.
Output
Output the smallest number of bombs necessary to escape the maze. There will be no trailing
white space.
Example Input File
2
2 3 3
S##
##E
###
#.#
#..
###
1 2 10
S#.####.#E
..##..###.
Example Output to Screen
1
5


# destructible wall
. open space
S start location
E exit location.

@formatter:on
*/

public class Bomb {

	enum MazePos {
		VISITED, NOT_VISITED
	};

	static Scanner scan;

	static int minBombs = 0;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge11/bomb.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		int numLines = scan.nextInt( );
		scan.nextLine( ); // if next scan call is scan.nextLine( )

		for( int inputSection = 0; inputSection < numLines; inputSection++ ) {
			int layers = scan.nextInt( ), rows = scan.nextInt( ), columns = scan.nextInt( );
			scan.nextLine( ); // if next scan call is scan.nextLine( )

			char[][][] maze = new char[layers][rows][columns];

			for( int curLayer = 0; curLayer < layers; curLayer++ )
				for( int curRow = 0; curRow < rows; curRow++ )
					maze[curLayer][curRow] = scan.nextLine( ).toCharArray( );
			// created 3d array of the maze

			Position startPos = new Position( 0, 0, 0 );
			for( int curLayer = 0; curLayer < layers; curLayer++ )
				for( int curRow = 0; curRow < rows; curRow++ )
					for( int curCol = 0; curCol < columns; curCol++ )
						if( maze[curLayer][curRow][curCol] == 'S' )
							startPos = new Position( curLayer, curRow, curCol );

			System.out.println( getMinBombs( maze, startPos ) );
		}

	}

	public static boolean[][][] clone( boolean[][][] oldArray ) {
		boolean[][][] newArray = new boolean[oldArray.length][oldArray[0].length][oldArray[0][0].length];

		for( int i = 0; i < oldArray.length; i++ )
			for( int j = 0; j < oldArray[0].length; j++ )
				for( int k = 0; k < oldArray[0][0].length; k++ )
					newArray[i][j][k] = oldArray[i][j][k];
					
		return newArray;
	}

	public static int getMinBombs( char[][][] maze, Position startPos ) {
		minBombs = Integer.MAX_VALUE;
		return getMinBombs( maze, new boolean[maze.length][maze[0].length][maze[0][0].length], startPos, 0 );
	}

	public static int getMinBombs( char[][][] maze, boolean[][][] visitedPositions, Position pos, int bombsUsed ) {

		if( bombsUsed < minBombs ) {
			visitedPositions[pos.f][pos.r][pos.c] = true;

			if( maze[pos.f][pos.r][pos.c] == 'E' )
				minBombs = bombsUsed;

			else {

				if( pos.r - 1 >= 0 && !visitedPositions[pos.f][pos.r - 1][pos.c] ) // move up
					getMinBombs( maze, clone( visitedPositions ), pos.copyR( pos.r - 1 ),
							bombsUsed + ( maze[pos.f][pos.r - 1][pos.c] == '#' ? 1 : 0 ) );

				if( pos.r + 1 < maze[0].length && !visitedPositions[pos.f][pos.r + 1][pos.c] ) // move down
					getMinBombs( maze, clone( visitedPositions ), pos.copyR( pos.r + 1 ),
							bombsUsed + ( maze[pos.f][pos.r + 1][pos.c] == '#' ? 1 : 0 ) );

				if( pos.c - 1 >= 0 && !visitedPositions[pos.f][pos.r][pos.c - 1] ) // move left
					getMinBombs( maze, clone( visitedPositions ), pos.copyC( pos.c - 1 ),
							bombsUsed + ( maze[pos.f][pos.r][pos.c - 1] == '#' ? 1 : 0 ) );

				if( pos.c + 1 < maze[0][0].length && !visitedPositions[pos.f][pos.r][pos.c + 1] ) // move right
					getMinBombs( maze, clone( visitedPositions ), pos.copyC( pos.c + 1 ),
							bombsUsed + ( maze[pos.f][pos.r][pos.c + 1] == '#' ? 1 : 0 ) );

				if( pos.f + 1 < maze.length && !visitedPositions[pos.f + 1][pos.r][pos.c] ) // move forward
					getMinBombs( maze, clone( visitedPositions ), pos.copyF( pos.f + 1 ),
							bombsUsed + ( maze[pos.f + 1][pos.r][pos.c] == '#' ? 1 : 0 ) );

				if( pos.f - 1 >= 0 && !visitedPositions[pos.f - 1][pos.r][pos.c] ) // move backward
					getMinBombs( maze, clone( visitedPositions ), pos.copyF( pos.f - 1 ),
							bombsUsed + ( maze[pos.f - 1][pos.r][pos.c] == '#' ? 1 : 0 ) );
			}

		}

		return minBombs;
	}

}

class Position {
	int f;
	int r;
	int c;

	Position( int f, int r, int c ) {
		this.f = f;
		this.r = r;
		this.c = c;
	}

	Position copyF( int f ) {
		return new Position( f, this.r, this.c );
	}

	Position copyR( int r ) {
		return new Position( this.f, r, this.c );
	}

	Position copyC( int c ) {
		return new Position( this.f, this.r, c );
	}
}