import java.util.Scanner;

public class insertionArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size...");
        int n = sc.nextInt(); // size of array

        int[] arr = new int[n];

        System.out.println("Enter " + n + " element...");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter to insert...");
        int element = sc.nextInt();

        System.out.println("Enter position (0 to " + n + ")...");

        int pos = sc.nextInt();

        int[] newArr = new int[n + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];

            newArr[pos] = element;

        }
        for (int i = pos; i < n; i++) {
            newArr[i + 1] = arr[i];
        }

        System.out.println("Array after insertion ...");

        for (int val : newArr) {
            System.out.println(val + " ");
        }

    }

}