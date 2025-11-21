public class Fizz {
    // Print the word fizz if number is completely divisible by 3 between the range of number 1 to 10
    public static void main(String[] args) {
        for(int i = 1 ; i <= 10 ; i++) {
            if(i % 3 == 0) {
                System.out.println("Fizz : " + i);
            }
        }
    }
}
