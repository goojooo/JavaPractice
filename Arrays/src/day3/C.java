package day3;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// Search elements
		int a[] = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter elements : ");
		for(int i = 0; i < a.length ; i++)
		{
			a[i] =sc.nextInt();
		}
		
		System.out.print("Array elements : ");
		for(int i = 0; i < a.length ; i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Enter search element : ");
		int n = sc.nextInt();
		int counter = 0;
		
		for(int i = 0 ; i <a.length;i++)
		{
			if(a[i] == n)
			{
				counter++;
			}
		}
		if(counter > 0)
		{
			System.out.println("Item found...");
		} else {
			System.out.println("Item not found...");
		}
	}

}
