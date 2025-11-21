public class FIzzBuzz {
    // Print Fizz if the number is completely is divisible by 3 , and print Buzz if divisible by 5 and Print FizzBuzz if the number is both divisible by both 3 and 5 

    public static void main(String [] args) {
        for(int i = 1 ; i <= 20 ; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz : " + i);
            }
            else if(i % 3 == 0) {
                System.out.println("Fizz : " + i);
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz : " + i);
            }
          
        }
    }
}
