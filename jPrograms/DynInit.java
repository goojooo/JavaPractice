public class DynInit {
    public static void main(String[] args) {
        double a = 3.0, b = 4.0;
        double c = Math.sqrt(a * a + b * b);
        System.out.println("Hypoteneous is : " + c);
    }
}

/*
 * This is the core of the program. Let's break down the calculation from the
 * inside out:
 * 
 * a * a: This calculates a squared (a
 * 2
 * ), which is 3.0∗3.0=9.0.
 * 
 * b * b: This calculates b squared (b
 * 2
 * ), which is 4.0∗4.0=16.0.
 * 
 * a * a + b * b: This adds the two results together: 9.0+16.0=25.0.
 * 
 * Math.sqrt(...): This is a built-in Java function from the Math library that
 * calculates the square root of the number inside the parentheses. So,
 * Math.sqrt(25.0) is 5.0.
 * 
 * double c = ...: The final result, 5.0, is assigned to a new double variable
 * named c.
 */