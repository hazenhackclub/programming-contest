package plu2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AllAboutThatBass {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("bass.dat"));

		int num = Integer.parseInt(scan.nextLine());

		DecimalFormat df = new DecimalFormat("0.00");

		for (int i = 0; i < num; i++) {
			String[] nums = scan.nextLine().split(" ");
			double N = Integer.parseInt(nums[0]);
			double q = Integer.parseInt(nums[1]);
			double T = Integer.parseInt(nums[2]);
			// System.out.println(N + " " + q + " " + T);
			double result = Math.pow(N, q) / Math.sqrt(Math.abs(42 * Math.sin(Math.sin(T))));

			double roundOff = (double) Math.round(result * 100) / 100;

			System.out.printf("%.2f\n", roundOff);
		}

	}
}