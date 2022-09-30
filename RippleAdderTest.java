public class RippleAdderTest {

    // Test case for add(Longword, Longword)
    public static void test_add() throws Exception {
        Longword result = RippleAdder.add(new Longword(7), new Longword(5));

        if(result.getSigned() != 12) {
            throw new Exception("add() - Failed");
        }
        else {
            System.out.println("add() - Success");
            System.out.println("Expected: 12");
            System.out.printf("Result: %d \n", result.getSigned());
        }
    }

    // Test case for subtract(Longword, Longword)
    public static void test_subtract() throws Exception {
        Longword result = RippleAdder.subtract(new Longword(7), new Longword(5));

        if(result.getSigned() != 2) {
            System.out.println("subtract() - Failed");
        }
        else {
            System.out.println("subtract() - Success");
            System.out.println("Expected: 2");
            System.out.printf("Result: %d \n", result.getSigned());
        }
    }

    public static void runTest() throws Exception {
        test_add();
        test_subtract();
        
        System.out.println();
    }
}