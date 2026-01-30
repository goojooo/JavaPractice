package problems;

import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		// Sum Of Array
		
		int a[] = {10,20,30,40,50};
		int sum = a[0];
		for(int i = 1; i <= a.length-1; i++)
		{
			sum = sum + a[i];
		}
		System.out.println(sum);

	}

}
