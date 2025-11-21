public class Constant2 {
    public static final double CM_PER_INCH = 2.54;
    public static void main(String[] args) {
        double paperWidth = 8.5;
        double paperHeigth = 11;
        System.out.println("Paper size in centimeter : " + paperWidth * CM_PER_INCH +"  by " + paperHeigth * CM_PER_INCH);
    }
}
