package day3;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// Sort array in asc
		
		int a[] = new int[5];
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter array elements...");
		
		for(int i = 0; i < a.length; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("Original array elements...");
		
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		for(int i = 0 ; i < a.length ;i++)
		{
			for(int j = i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("\nSorted array ascending elements...");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		for(int i = 0 ; i < a.length ;i++)
		{
			for(int j = i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("\nSorted array descdeing elements...");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}

	}

}
