public class PatternTopLeftTriangleCharecter {

    public static void main(String args[]) {
        // Variable ch declared outside for loop
        char ch = 'A';
        for (int i = 1; i < 5; i++) {
            for (int j = 1; i >= j; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }

        // Variable ch declared inside for loop
        for (int i = 1; i < 5; i++) {
            char c1 = 'A';
            for (int j = 1; i >= j; j++) {
                System.out.print(c1);
                c1++;
            }
            System.out.println();
        }

        // Variable ch is used as condition in for loop
        for(char x = 'A' ; x <= 'E' ; x++)
        {
            for(char y = 'A';y<=x; y++)
            {
                System.out.print(x);
                
            }
            System.err.println();
        }

        for(int i = 1;  i <=5 ; i++){
            for(int j = 1 ; j <= i; j++){
                System.out.print((i+j)%2);
            }
            System.err.println();
        }
    }
}
