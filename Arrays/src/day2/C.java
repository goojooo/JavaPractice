package day2;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// FIND THE LENGTH OF THE ARRAYS
		int a[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements in array...");
		for(int i = 0 ; i < a.length ; i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Arrays elements...");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a[i] + " ");
		}
		
		System.out.println("Array length..." + a.length);

	}

}
