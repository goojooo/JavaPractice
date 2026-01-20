package day2;

import java.util.Arrays;

public class B {

	public static void main(String[] args) {
		
		// Print arrays elements without loop
		String a[] = {"Enaa","Minna","Dikaa","HolaBSDKa"};
		
		System.out.println("toString() "+Arrays.toString(a));
		
		System.out.println("asList() "+Arrays.asList(a));
		
		int arr[][] = {{20,30},{67,89}};
		System.out.println("deeptoString() "+Arrays.deepToString(arr));

	}

}
