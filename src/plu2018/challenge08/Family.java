package plu2018.challenge08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*


@formatter:off

@formatter:on
*/

public class Family {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge08/family.txt" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		HashMap<String,ArrayList<String>> peoplesRelations = new HashMap<>();

		int loops = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < loops; i++) {
			String[] line = scan.nextLine().split(" ");

			System.out.println(Arrays.toString(line));

			if (!peoplesRelations.containsKey(line[0])) {
				peoplesRelations.put(line[0], new ArrayList<>());
				peoplesRelations.get(line[0]).add(line[2]);
			} else {
				peoplesRelations.get(line[0]).add(line[2]);
				for (int j = 0; j < peoplesRelations.get(line[0]).size(); j++) {
					if (peoplesRelations.get(line[0]).get(j) != line[2])
						peoplesRelations.get(peoplesRelations.get(line[0]).get(j)).add(line[2]);
				}
			}

			if (!peoplesRelations.containsKey(line[2])) {
				peoplesRelations.put(line[2], new ArrayList<>());
				peoplesRelations.get(line[2]).add(line[0]);
			} else {
				peoplesRelations.get(line[2]).add(line[0]);
				for (int j = 0; j < peoplesRelations.get(line[2]).size(); j++) {
					if (peoplesRelations.get(line[2]).get(j) != line[0])
						peoplesRelations.get(peoplesRelations.get(line[2]).get(j)).add(line[0]);
				}
			}

		}
		for(String key : peoplesRelations.keySet()) {
			System.out.print(key + ":");
			System.out.print(peoplesRelations.get(key));
			System.out.println();
		}
	}
}