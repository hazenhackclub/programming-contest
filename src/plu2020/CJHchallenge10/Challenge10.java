package plu2020.CJHchallenge10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
@formatter:off

Put challenge here:


@formatter:on
*/

public class Challenge10 {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/CJHchallenge10/rain_boots.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		while (scan.hasNextLine()) {
			String[][] board = boardCreator();
			printBoard(board);
		}
	}

	public static String[][] boardCreator() {
		String[][] board = new String[8][8];

		for (int i = 0; i < board.length; i++) {
			board[i] = scan.nextLine().substring(0,8).split("");
		}

		try {
			scan.nextLine();
		} catch (NoSuchElementException e) {}

		return board;
	}

	public static void printBoard(String[][] board) {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static String[][] findMoves(String[][] board) {
		int posX, posY;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				
			}
		}
		return new String[][]{};
	}
}

