package day4;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		//Delete element
		
		int size, del, pos ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size : ");
		size = sc.nextInt();
		int a[] =new int[size];
		System.out.println("Enter elements : ");
		for(int i = 0 ; i < size ; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("Enter position : ");
		pos = sc.nextInt();
		for(int i = pos; i <size-1; i++)
		{
			a[i]=a[i+1];
		}
		size--;
		for(int i = 0 ; i < size ; i++)
		{
			System.out.println(a[i]);
		}
	}

}
