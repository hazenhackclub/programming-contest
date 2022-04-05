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
			scan = new Scanner( new File( "../programming-contest/src/CJHchallenge6/pegs.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}
		
		int boardCount = scan.nextInt();
	
		for (int i = 0; i < boardCount; i++) {
			String[][] board = boardCreator();
			
			try {
				String result = findIfBoardSolveable(board) ? "Solveable!" : "Impossible.";
				System.out.println(result);
			} catch (StackOverflowError e) {
				System.out.println("recursive error");
			}
		}
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
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals("@"))
					counter++;
			}
		}
		return counter == 1;
	}

	public static boolean findIfBoardSolveable(String[][] board) {
		String[][] temp = new String[board.length][board[0].length];

		for(int i = 0; i < board.length; i++)
			temp[i] = board[i].clone();

		// printBoard(board);
		ArrayList<String> moves = findLegalMoves(temp);
		// for(String move : moves)
		// 	System.out.println(move);
	
		if(moves.size() == 0) {
			// if(boardSolved(temp)) {
			// 	System.out.println("Board is Solved!");
			// 	System.out.println("---------------");
			// 	return true;
			// }
			// else {
			// 	System.out.println("Board is not Solved.");
			// 	System.out.println("---------------");
			// 	return false;
			// }
			return boardSolved(temp);
		}
		for (int i = 0; i < moves.size(); i++) {
			// System.out.println("\nMove executed " + moves.get(i));
			executeMove(temp, moves.get(i));
			if(findIfBoardSolveable(temp))
				return true;
		}
		return false;
	}
}
