public class RippleAdderTest {
    /*
     * I know the code works. I used the algorithm given in class but for
     * some reason it stills fails the test cases.
     */

    public static void test_add() throws Exception {
        if(RippleAdder.add(new Longword(7), new Longword(5)).getSigned() != 12) {
            System.out.println(new Longword(7).getSigned());
            System.out.println(new Longword(5).getSigned());
            System.out.println(new Longword(7).getSigned() + new Longword(5).getSigned());
            System.out.println(RippleAdder.add(new Longword(7), new Longword(5)).getSigned());

            throw new Exception("7 + 5 : Failed.");
        }
        else if(RippleAdder.add(new Longword(2), new Longword(0)).getSigned() != 2) {
            throw new Exception("2 + 0 : Failed.");
        }
        else {
            System.out.println("add() - Success");
        }
    }

    public static void test_subtract() throws Exception {
        if(RippleAdder.subtract(new Longword(7), new Longword(5)).getSigned() != 2) {
            throw new Exception("7 - 5 : Failed.");
        }
        else if(RippleAdder.subtract(new Longword(2), new Longword(1)).getSigned() != 1) {
            throw new Exception("2 - 1 : Failed.");
        }
        else {
            System.out.println("Success");
        }
    }

    public static void runTest() throws Exception {
        test_add();
        test_subtract();
        
        System.out.println();
    }
}