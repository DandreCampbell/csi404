public class RippleAdderTest {

    // Test case for add(Longword, Longword)
    public static void test_add() throws Exception {
        Longword result = new Longword();

        result = RippleAdder.add(new Longword(7), new Longword(5));
        if(result.getSigned() != 12) {
            throw new Exception("add() 1 - Failed");
        }
        else {
            System.out.println("add() - Success");
            System.out.printf("Expected: 12 | Result: %d\n", result.getSigned());
        }

        result = RippleAdder.add(new Longword(2), new Longword(2));
        if(result.getSigned() != 4) {
            throw new Exception("add() 2 - Failed");
        }
        else {
            System.out.println("add() - Success");
            System.out.printf("Expected: 4 | Result: %d\n", result.getSigned());
        }

        System.out.println();
    }

    // Test case for subtract(Longword, Longword)
    public static void test_subtract() throws Exception {
        Longword result = new Longword();

        result = RippleAdder.subtract(new Longword(7), new Longword(5));
        if(result.getSigned() != 2) {
            throw new Exception("subtract() - Failed");
        }
        else {
            System.out.println("subtract() - Success");
            System.out.printf("Expected: 2 | Result: %d\n", result.getSigned());
        }

        result = RippleAdder.subtract(new Longword(40), new Longword(4));
        if(result.getSigned() != 36) {
            throw new Exception("subtract() - Failed");
        }
        else {
            System.out.println("subtract() - Success");
            System.out.printf("Expected: 36 | Result: %d\n", result.getSigned());
        }

        System.out.println();
    }

    public static void runTest() throws Exception {
        System.out.println("RippleAdder Test: ");

        test_add();
        test_subtract();
    }
}