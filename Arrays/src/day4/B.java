package day4;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// 2D array
		
		int a[][] = new int[2][2];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array elements: ");
		for(int i = 0 ; i < a.length ;i++)
		{
			for(int j = 0 ; j < a.length ; j++)
			{
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.print("Matrix : \n");
		for(int i = 0 ; i < a.length ;i++)
		{
			for(int j = 0 ; j < a.length ; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

}
