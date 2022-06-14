package CjPLU2019.challenge3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class challenge03 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge3/periods.dat" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            String line = scan.nextLine();
            System.out.println(line + (line.charAt(line.length()-1) != '.' ? "." : "")  );
        }
    }
}
