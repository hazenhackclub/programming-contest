package CjPLU2019.challenge6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class challenge06 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge6/challenge6_input.txt" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            int characters = scan.nextInt();
            int lines = scan.nextInt();
            String text = "";

            for (int j = 0; j < lines; j++) {
                text += (scan.nextLine() + " ");
            }

            System.out.println(text);

            String[] textArray = text.split(" ");

            System.out.println(Arrays.toString(textArray));

            int increment = 0;
            // for (int j = 0; i < textArray.length; j += increment) {
            //     int charCount = 0;
            //     while (charCount < characters) {
            //         if (charCount + textArray[j].length() > characters) {
            //             break;
            //         }
            //         System.out.print(textArray[j] + " ");
            //         charCount = textArray[j].length() + 1;
            //         increment++;
            //     }
            // } 
        }
    }
}
