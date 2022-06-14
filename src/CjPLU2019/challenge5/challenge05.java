package CjPLU2019.challenge5;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Challenge05 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge5/presidents.dat" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        HashMap<String, Integer> money = new HashMap<>();

        money.put("Franklin", 100);
        money.put("Grant", 50);
        money.put("Jackson", 20);
        money.put("Hamilton", 10);
        money.put("Lincoln", 5);
        money.put("Washington", 1);

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            String[] names = scan.nextLine().split(" ");

            int value = 0;
            
            for (int j = 0; j < names.length; j++) {
                value += money.get(names[j]);
            }
            System.out.println("$" + value);
        }


    }
}
