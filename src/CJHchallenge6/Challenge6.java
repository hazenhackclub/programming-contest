package CJHchallenge6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
@formatter:off

Put challenge here:


@formatter:on
*/

public class Challenge6 {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/challenge6/pegs-2.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}
		
		int boardCount = scan.nextInt();
		
		
	
		String[][] board = boardCreator();
		printBoard(board);
		
		ArrayList<String> legalMoves = findLegalMoves(board);

		for (int j = 0; j < legalMoves.size(); j++) {
			System.out.println(legalMoves.get(j));
		}

		findIfBoardSolveable(board,0);
		
	}

	public static String[][] boardCreator() {
		int arrayRows = scan.nextInt();
		int arrayCols = scan.nextInt();
		scan.nextLine();

		String[][] board = new String[arrayRows][arrayCols];

		for (int i = 0; i < board.length; i++) {
			String[] row = scan.nextLine().replaceAll(" ", "").split("");

			int nullSpotsPerSide = (arrayRows - row.length) / 2;

			for (int j = 0; j < board[i].length; j++) {
				if(j < nullSpotsPerSide || j >= row.length + nullSpotsPerSide)
					board[i][j] = "X";
				else
					board[i][j] = row[j - nullSpotsPerSide];
			}
		}
		return board;
	}

	public static void printBoard(String[][] board) {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static ArrayList<String> findLegalMoves(String[][] board) {
		ArrayList<String> legalMoves = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals("@")) {
					if (i-2 >= 0 & j-2 >= 0) {
						if (board[i-1][j-1].equals("@") & board[i-2][j-2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i-2) + "," + (j-2));
						}
					}
					if(i-2 >= 0) {
						if (board[i-1][j].equals("@") & board[i-2][j].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i-2) + "," + (j));
						}
					}
					if(i-2 >= 0 & j+2 < board.length) {
						if (board[i-1][j+1].equals("@") & board[i-2][j+2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i-2) + "," + (j+2));
						}
					}
					if(j+2 < board.length) {
						if (board[i][j+1].equals("@") & board[i][j+2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i) + "," + (j+2));
						}
					}
					if(i+2 < board.length & j+2 < board.length) {
						if (board[i+1][j+1].equals("@") & board[i+2][j+2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i+2) + "," + (j+2));
						}
					}
					if(i+2 < board.length) {
						if (board[i+1][j].equals("@") & board[i+2][j].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i+2) + "," + (j));
						}
					}
					if(i+2 < board.length & j-2 >= 0) {
						if (board[i+1][j-1].equals("@") & board[i+2][j-2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i+2) + "," + (j-2));
						}
					}
					if(j-2 >= 0) {
						if (board[i][j-1].equals("@") & board[i][j-2].equals(".")) {
							legalMoves.add(i + "," + j + " -> " + (i) + "," + (j-2));
						}
					}
				}
			}
		}
		return legalMoves;
	}
	
	public static void executeMove(String[][] board, String move) {
		int initialX = Integer.parseInt(move.substring(0,1));
		int initialY = Integer.parseInt(move.substring(2,3));
		int newX = Integer.parseInt(move.substring(7,8));
		int newY = Integer.parseInt(move.substring(9,10));

		board[initialX][initialY] = ".";
		board[(initialX+newX)/2][(initialY+newY)/2] = ".";
		board[newX][newY] = "@";
	}

	public static boolean boardSolved(String[][] board) {
		int counter = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].equals("@"))
					counter++;
			}
		}
		return counter == 1;
	}

	public static boolean findIfBoardSolveable(String[][] board, int counter) {
		if (boardSolved(board) || counter == 100)
			return true;
		
		String[][] temp = new String[board.length][];
		for(int i = 0; i < board.length; i++)
			temp[i] = board[i].clone();
		
		ArrayList<String> moves = findLegalMoves(temp);
	

		printBoard(temp);
		for (int i = 0; i < moves.size(); i++) {
			executeMove(temp, moves.get(i));
			printBoard(temp);
			return findIfBoardSolveable(temp, counter + 1);
		}
		return false;
	}
}
