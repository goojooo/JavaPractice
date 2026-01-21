package day3;

public class I {

	public static void main(String[] args) {
		// Smallest element
		
		int a[] = {35,643,4,54,67,854,67,82};
		int min = 0;
		System.out.println("Array : ");
		for(int i= 0 ; i < a.length;i++)
		{
			System.out.print(a[i] + " ");
		}
		min=a[0];
		for(int i = 1 ; i <a.length ; i++)
		{
			if(min> a[i]){
				min = a[i];
			}
		}
		System.out.println("\nSmallest elemet : " + min);
	}

}
