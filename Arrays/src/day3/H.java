package day3;

public class H {

	public static void main(String[] args) {
		// Find biggest element
		
		int a[] = {10,43,12,5};
		int max ;
		System.out.print("Array elements...\n");
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.print(a[i] + " \n");
		}
		max = a[0];
		for(int i = 1 ; i <a.length ; i++)
		{
			if(a[i] > max)
			{
			max =	a[i];
			}
		}
		System.out.println("Largest element of the array : " + max);
	}

}
