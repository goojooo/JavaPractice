package day2;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// Print array in elemets in reverse order
		int a[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements...");
		for(int i = 0 ; i < a.length ; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("Array elemets...");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("Array reverse elemets...");
		for(int i = a.length-1 ; i >= 0 ; i--)
		{
			System.out.print(a[i] + " ");
		}

	}

}
