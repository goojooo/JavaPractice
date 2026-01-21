package day3;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		int a[] = new int[5];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Enter elements array...");
		for(int i = 0 ; i < a.length ; i++)
		{
			a[i]=sc.nextInt();
		}
		
		System.out.print("Array elements array...");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a[i]+" ");
			sum=a[i]+sum;
		}
		System.out.println("Additon of arr : " + sum);
		

	}

}
