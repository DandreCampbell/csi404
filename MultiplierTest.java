public class MultiplierTest {
    
    public static void runTest() throws Exception {
        if(Multiplier.multiply(new Longword(7), new Longword(5)).getSigned() != 35) {
            System.out.println("7 * 5 : Failed");
        }
        else {
            System.out.println("multiply() - Success");
        }

        System.out.println();
    }
}
