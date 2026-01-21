package day3;

import java.util.Scanner;

public class J {

	public static void main(String[] args) {
		// Insert items
		int size,pos,ele , i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		size=sc.nextInt();
		
		System.out.println("Enter elements : ");
		int a[] = new int[size + 1] ;
		for( i = 0 ; i < size ; i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Enter element position : ");
		pos = sc.nextInt();
		System.out.println("Enter item : ");
		ele = sc.nextInt();
		
		for(i =size; i > pos; i--)
		{
			a[i]=a[i-1];
		}
		a[pos] = ele;
		size++;
		
		for(i = 0 ; i < size;i++)
		{
			System.out.print(a[i] + " ");
		}
	}

}
