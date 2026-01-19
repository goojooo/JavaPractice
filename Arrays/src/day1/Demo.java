package day1;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
//	int a[] = {1,2,3,4,5};
//	System.out.println(a[4]);
		int size , i;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array...");
		size = sc.nextInt();
		int a[] = new int [size];
		
		for( i = 0; i < size;i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("Printed arrays elements :");
		for( i = 0; i < size;i++)
		{
			System.out.print(a[i]+ " ");
		}
	}

}
