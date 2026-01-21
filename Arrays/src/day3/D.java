package day3;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// Find the ava. of array
		int a[]= new int[5];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter element in array : ");
		for(int i = 0 ; i < a.length ; i++)
		{
		a[i] = sc.nextInt();
		}
		
		System.out.println("Original element in array : ");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Avarage of array : ");
		for(int i = 0 ; i < a.length ; i++)
		{
			sum=sum+a[i];
		}
		double avg = sum / 5.0;
		System.out.println(sum + " " + avg);
		
		
		
		

	}

}
