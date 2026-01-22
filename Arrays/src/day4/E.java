package day4;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// Mirro matrix
		
		int a[][] = new int[2][2];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter matric elements :");
		
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = 0 ; j < a.length; j++)
			{
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Original matric elements :");
		
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = 0 ; j < a.length; j++)
			{
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("Mirror matric elements :");
		
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = a.length-1 ; j >=0; j--)
			{
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}

	}

}
