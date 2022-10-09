public class MultiplierTest {
    
    // Test case for multiply(Longword, Longword)
    public static void runTest() throws Exception {
        Longword result = new Longword();

        result = Multiplier.multiply(new Longword(7), new Longword(5));
        if(result.getSigned() != 35) {
            System.out.println("multiply() : 7 * 5 : Failed");
        }
        else {
            System.out.println("multiply() - Success");
            System.out.println("Expected: 35");
            System.out.printf("Result: %d\n", result.getSigned());
        }

        result = Multiplier.multiply(new Longword(2), new Longword(2));
        if(result.getSigned() != 4) {
            System.out.println("multiply() : 2 * 2 : Failed");
        }
        else {
            System.out.println("multiply() - Success");
            System.out.println("Expected: 4");
            System.out.printf("Result: %d\n", result.getSigned());
        }

        System.out.println();
    }
}
