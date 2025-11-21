class Light{
    public static void main(String[] args) {
        int lightspeed; 
        long days;
        long second;
        long distance;
        lightspeed = 186000;

        days = 1000;  // specify number of days here seconds
        second = days * 24 * 60 *60;  // convert to seconds distance 
        distance = lightspeed * second; // compute distance 
        System.out.println("In " + days + " days light will travel about  " + distance + " miles");
    }
}