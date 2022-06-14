package CjPLU2019.challenge4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class challenge04 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge4/population.dat" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            int initialPop = scan.nextInt();
            int time = scan.nextInt();
            
            if (scan.hasNextLine())
                scan.nextLine();

            int died = time / 7;
            int born = time / 4;

            System.out.println(initialPop + born - died);
        }

    }
}
