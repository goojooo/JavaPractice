public class reverseArray{
    public static void main(String args []){

        int [] arr = {4,7,3,1,2,3,8,9};
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}