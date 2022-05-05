package CjPLU2019.challenge2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class challenge02 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge2/friends.dat" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            int numGroups = Integer.parseInt(scan.nextLine());
            
            HashMap<Integer,String> friendsWithValues= new HashMap<>();

            for (int j = 0; j < numGroups; j++) {
                String person = scan.nextLine();

                friendsWithValues.put(Integer.parseInt(person.substring(person.indexOf(" ") + 1, person.length())), person.substring(0, person.indexOf(" ")));
            }

            String result = "";
            for (int j = 500; j > 0; j--) {
                String item = friendsWithValues.get(j);
                if (item != null)
                    result += (friendsWithValues.get(j) + ", ");
            }
            System.out.println(result.substring(0, result.length()-2)); ;

        }

    }
}
