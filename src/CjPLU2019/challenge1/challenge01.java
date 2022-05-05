package CjPLU2019.challenge1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class challenge01 {

    public static Scanner scan;
    public static void main(String[] args) {

        try {
            scan = new Scanner( new File( "../programming-contest/src/CjPLU2019/challenge1/clothes.dat" ) );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
            System.exit( 0 );
        }

        int numLoops = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLoops; i++) {
            int numClothes = Integer.parseInt(scan.nextLine());
            ArrayList<String> shirts = new ArrayList<>();
            ArrayList<String> pants = new ArrayList<>();
            ArrayList<String> socks = new ArrayList<>();

            for (int j = 0; j < numClothes; j++) {
                String item = scan.nextLine();
                if (item.contains("shirt"))
                    shirts.add(0,item.substring(0,item.indexOf("(")));
                else if (item.contains("pants"))
                    pants.add(0,item.substring(0,item.indexOf("(")));
                else if (item.contains("socks"))
                    socks.add(0,item.substring(0,item.indexOf("(")));
            }

            int numGroups = Math.min(shirts.size(), Math.min(pants.size(),socks.size()));

            for (int j = 0; j < numGroups; j++) {
                System.out.println(shirts.get(j) + ", " + pants.get(j) + ", " + socks.get(j));
            }
            System.out.println();


        }

    }
}
