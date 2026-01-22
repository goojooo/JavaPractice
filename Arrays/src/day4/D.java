package day4;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// Transpose matrix
		int a[][] = new int[2][2];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements : ");
		for(int i = 0 ; i < a.length ; i++) // rows
		{
			for(int j = 0 ; j < a.length ; j++) // columns
			{
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Original matrix elements : ");
		for(int i = 0 ; i < a.length ; i++) // rows
		{
			for(int j = 0 ; j < a.length ; j++) // columns
			{
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("Transpose matrix elements : ");
		for(int i = 0 ; i < a.length ; i++) // rows
		{
			for(int j = 0 ; j < a.length ; j++) // columns
			{
				System.out.print(a[j][i] +" ");
			}
			System.out.println();
		}
	}

}
