import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("practice.dat"));

        int num = Integer.parseInt(scan.nextLine());

        String testCase = "How  are you guys    doing rn?";

        // HashMap<String, Integer> lines = new HashMap<>();

        // for (int i = 0; i < num; i++) {
        //     String line = scan.nextLine();
        //     lines.put(line, line.length());
        // }

        
        
        System.out.println(new ArrayList<>(Arrays.asList(testCase.split(" "))));
        System.out.println(new ArrayList<>(Arrays.asList(testCase.split("\\s+"))));
    }
}