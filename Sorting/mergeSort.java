public class mergeSort {

    public static void MergeSort(int[] arr) {
        if (arr.length <= 1)
            return; // already sorted if 1 element
        int mid = arr.length / 2 ;
        
        //split array into two halves
        
        int[] left = new int[mid];
        int [] right = new int[arr.length - mid];

        for(int i = 0 ; i < mid; i++){
            left[i] = arr[i];
        }

        for(int i = mid; i < arr.length; i++){
            right[i - mid] = arr[i];
        }

         // Sort each half
        MergeSort(left);
        MergeSort(right);

        //Merge sorted halves

        merge(arr, left, right)
         
    }
}