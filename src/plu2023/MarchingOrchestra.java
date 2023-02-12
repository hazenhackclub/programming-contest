package plu2023;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import javafx.util.Pair;
import java.io.File;

public class MarchingOrchestra {

	enum Dir {
		N, E, S, W;
	}

	public static boolean found;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("marching.dat"));

		int numLines = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < numLines; i++) {
			int n = scan.nextInt(), m = scan.nextInt();
			scan.nextLine();
			char[][] map = new char[n][m]; // y, x
			boolean[][] visited = new boolean[n][m]; // y, x
			HashMap<Character, Pair<Integer, Integer>> startingPositions = new HashMap<>();
			HashMap<Character, Pair<Integer, Integer>> endingPositions = new HashMap<>();

			for (int row = 0; row < n; row++) {
				String line = scan.nextLine();
				for (int column = 0; column < m; column++) {
					map[row][column] = line.charAt(column);
					int num = map[row][column];
					if (num >= 65 && num <= 90)
						startingPositions.put(map[row][column], new Pair<Integer, Integer>(row, column));
					else if (num >= 97 && num <= 122)
						endingPositions.put(map[row][column], new Pair<Integer, Integer>(row, column));
				}
			}

			int length = 0;
			for (Character key : startingPositions.keySet())
				length += findShortestPath(startingPositions.get(key), endingPositions.get(Character.toLowerCase(key)),
						map, clone(visited), 0);

			System.out.println(length);
		}
	}

	public static int findShortestPath(Pair<Integer, Integer> pos, Pair<Integer, Integer> des, char[][] map,
			boolean[][] visited, int length) {

		if (pos.getKey().equals(des.getKey()) && pos.getValue().equals(des.getValue()))
			return length;

		visited[pos.getKey()][pos.getValue()] = true; // check off this square
		Dir[] orderedDirections = closestDirection(pos, des);

		for (Dir dir : orderedDirections) {
			if (canMove(pos, dir, map, visited)) {
				int result = findShortestPath(moveDirection(pos, dir), des, map, clone(visited), length + 1);
				if (result != -1)
					return result;
			}
		}

		return -1;

	}

	public static boolean[][] clone(boolean[][] clone) {
		boolean[][] myArr = new boolean[clone.length][];
		for (int i = 0; i < clone.length; i++)
			myArr[i] = clone[i].clone();
		return myArr;
	}

	public static boolean canMove(Pair<Integer, Integer> pos, Dir direction, char[][] map, boolean[][] visited) {
		Pair<Integer, Integer> newPos = moveDirection(pos, direction);
		return newPos.getKey() >= 0 && newPos.getValue() >= 0 && newPos.getKey() < map.length
				&& newPos.getValue() < map[0].length && map[newPos.getKey()][newPos.getValue()] != '#'
				&& !visited[newPos.getKey()][newPos.getValue()];
	}

	public static Pair<Integer, Integer> moveDirection(Pair<Integer, Integer> pos, Dir direction) {
		switch (direction) {
			default:
			case N:
				return new Pair<Integer, Integer>(pos.getKey() - 1, pos.getValue());
			case E:
				return new Pair<Integer, Integer>(pos.getKey(), pos.getValue() + 1);
			case S:
				return new Pair<Integer, Integer>(pos.getKey() + 1, pos.getValue());
			case W:
				return new Pair<Integer, Integer>(pos.getKey(), pos.getValue() - 1);
		}
	}

	public static Dir[] closestDirection(Pair<Integer, Integer> pos, Pair<Integer, Integer> des) {

		int dY = -(des.getKey() - pos.getKey()), dX = des.getValue() - pos.getValue();
		Dir[] arr = new Dir[4];
		if (Math.abs(dX) > Math.abs(dY)) {
			if (dX > 0) {
				arr[0] = Dir.E;
				arr[3] = Dir.W;
			} else {
				arr[0] = Dir.W;
				arr[3] = Dir.E;
			}

			if (dY > 0) {
				arr[1] = Dir.N;
				arr[2] = Dir.S;
			} else {
				arr[1] = Dir.S;
				arr[2] = Dir.N;
			}
		} else {
			if (dY > 0) {
				arr[0] = Dir.N;
				arr[3] = Dir.S;
			} else {
				arr[0] = Dir.S;
				arr[3] = Dir.N;
			}

			if (dX > 0) {
				arr[1] = Dir.E;
				arr[2] = Dir.W;
			} else {
				arr[1] = Dir.W;
				arr[2] = Dir.E;
			}
		}

		return arr;
	}

}