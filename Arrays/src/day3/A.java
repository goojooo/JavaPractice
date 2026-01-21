package day3;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		int a[] = new int[5];
		int b[] = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter original array...");
		for(int i = 0 ; i <a.length;i++)
		{
			a[i] = sc.nextInt();
		}
		
		System.out.println("First Array original array...");
		for(int i = 0 ; i <a.length;i++)
		{
			System.out.println(a[i]+ " ");
		}
		
		System.out.println("Second Array original array...");
		for(int i = 0 ; i <a.length;i++)
		{	b[i] = a[i];
			System.out.print(b[i]+ " ");
		}
		
	}

}
