public class PatternTopLeftTriangleNumbers {
    public static void main(String args[]) {
        int x =1;
        for(int i = 1 ; i <= 4 ; i++){
            for(int j = 1 ; i >= j ; j++){
                System.out.print(x);
                x++;
            }
            System.out.println();
        }
    }
}
