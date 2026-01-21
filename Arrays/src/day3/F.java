package day3;

import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		//Sort() Equals() copyOf()
		
		int a[] = new int [5];
//		int b[] = new int [5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array elements in A : ");
		for(int i = 0 ; i < a.length ; i++)
		{
			a[i] = sc.nextInt();
		}
		int a2[] = Arrays.copyOf(a,5);
		
		System.out.println("Array elements a : ");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a2[i]);
		}
		
//		System.out.println("Enter array elements in B : ");
//		for(int i = 0 ; i < b.length ; i++)
//		{
//			b[i] = sc.nextInt();
//		}
//		Arrays.sort(a);
//		System.out.println("Array elements : ");
//		for(int i = 0 ; i <a.length ; i++)
//		{
//			System.out.print(a[i] + " ");
//		}
		
//	boolean X =	Arrays.equals(a,b);
//	System.out.println("Is the both array equals or not ? " + X);
		

	}

}
