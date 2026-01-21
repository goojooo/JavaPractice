package day3;

import java.util.Arrays;

public class G {

	public static void main(String[] args) {
		// Compare Arrays
		// 1. ==
		// 2. equals()
		
		int a[] = {1,2,3,4,5};
		int b[] = {1,2,3,4,5};
		
//		Scanner sc = new Scanner(System.in);
		if(a == b)
		{
			System.out.println("Both are equals...");
		} else
		{
			System.out.println("Both are NOT equals...");
		}
		
		if(Arrays.equals(a,b))
		{
			System.out.println("Both are equals...");
		} else
		{
			System.out.println("Both are NOT equals...");
		}
	}

}
