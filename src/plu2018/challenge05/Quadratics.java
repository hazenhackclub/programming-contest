package plu2018.challenge05;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*


@formatter:off

@formatter:on
*/

public class Quadratics {

	static Scanner scan;

	public static void main( String[] args ) {

		try {
			scan = new Scanner( new File( "../programming-contest/src/plu2018/challenge05/quadratics.dat" ) );
		} catch( FileNotFoundException e ) {
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		while(scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");

			if (line.length != 3) {
				continue;
			}

			double[] numbers = new double[3];
			for (int i = 0; i < line.length; i++) {
				numbers[i] = Double.parseDouble(line[i]);
			}
			
			double a = numbers[0];
			double b = numbers[1];
			double c = numbers[2];

			DecimalFormat df = new DecimalFormat( "0.000" );

			double positiveResult = ((-b) + Math.sqrt((b*b) - (4*a*c))) / (2 * a);
			double negativeResult = ((-b) - Math.sqrt((b*b) - (4*a*c))) / (2 * a);

			System.out.print(df.format(roundThousandths(positiveResult)) + " ");
			System.out.println(df.format(roundThousandths(negativeResult)));
		}
	}

	public static double roundThousandths(double number) {
		return Math.round(number * 1000) / 1000.0;
	}
}