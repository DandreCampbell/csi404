public class LongwordTest {

    // Test case for getBit(int)
    public static void test_getBit() throws Exception {
        Longword test = new Longword(1);

        test.setBit(2, new Bit(true));
        if(test.getBit(2).getValue() != true) {
            throw new Exception("getBit(index) 1 - Failed");
        }
        else {
            System.out.println("getBit(index) 1 - Success");
        }
        
        test.setBit(2, new Bit(false));
        if(test.getBit(2).getValue() != false) {
            throw new Exception("getBit(index) 2 - Failed");
        }
        else {
            System.out.println("getBit(index) 2 - Success");
        }

        System.out.println();
    }

    // Test case for setBit(int, Bit)
    public static void test_setBit() throws Exception {
        Longword test = new Longword(0);
        test.setBit(31, new Bit(true));

        if(test.getBit(31).getValue() != true) {
            throw new Exception("setBit(index, value) - Failed");
        }
        else {
            System.out.println("setBit(index, value) - Success");
        }

        System.out.println();
    }

    // Test case for and(Longword)
    public static void test_and() throws Exception {
        Longword test = new Longword(10);
        Longword result = test.and(new Longword(2));

        if(result.getSigned() != 2) {
            throw new Exception("and(other) - Failed");
        }
        else {
            System.out.println("and(other) - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,"); // 
            System.out.printf("Result: %s \n", result.toString()); 
        }

        System.out.println();
    }

    // Test case for or(Longword)
    public static void test_or() throws Exception {
        Longword test = new Longword(25);
        Longword result = test.or(new Longword(10));

        if(result.getSigned() != 27) {
            throw new Exception("or(other) - Failed");
        }
        else {
            System.out.println("or(other) - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,t,f,t,t,"); 
            System.out.printf("Result: %s \n", result.toString()); 
        }

        System.out.println();
    }
    
    // Test case for xor(Longword)
    public static void test_xor() throws Exception {
        Longword test = new Longword(12);
        Longword result = test.xor(new Longword(4));

        if(result.getSigned() != 8) {
            throw new Exception("xor(other) - Failed");  
        }
        else {
            System.out.println("xor(other) - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f,f,");
            System.out.printf("Result: %s \n", result.toString());
        }

        System.out.println();
    }

    // Test case for not()
    public static void test_not() throws Exception {
        Longword test = new Longword(100);
        Longword result = test.not();

        if(result.toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,f,t,t,f,t,t,")) {
            System.out.println("not() - Success");
            System.out.println("Expected: t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,f,t,t,f,t,t,");
            System.out.printf("Result: %s \n", result.toString());
        }
        else {
            throw new Exception("not() - Failed");
        }

        System.out.println();
    }

    // Test case for rightShift(int)
    public static void test_rightShift() throws Exception {
        Longword test = new Longword(2);
        Longword result = test.rightShift(1);

        if(result.getSigned() != 1) {
            throw new Exception("rightShift() - Failed");
        }
        else {
            System.out.println("rightShift() - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,");
            System.out.printf("Result: %s \n", result.toString());
        }

        System.out.println();
    }

    // Test case for leftShift(int)
    public static void test_leftShift() throws Exception {
        Longword test = new Longword(2);
        Longword result = test.leftShift(1);

        if(result.getSigned() != 4) {
            throw new Exception("leftShift() - Failed");
        }
        else {
            System.out.println("leftShift() - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f,");
            System.out.printf("Result: %s \n", result.toString());
        }

        System.out.println();
    }

    // Test case for toString()
    public static void test_toString() throws Exception {
        Longword test = new Longword(1);
        String expected = "f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,";

        if(test.toString().equals(expected)) {
			System.out.println("toString() - Success");
		}
		else {
			throw new Exception("toString() - Failed");
		}

        System.out.println();
    }

    // Test case for getUnsigned()
    public static void test_getUnsigned() throws Exception {
        Longword test = new Longword();

        test = new Longword(10);
        if(test.getUnsigned() != 10L) {
            throw new Exception("getUnsigned() - Failed");
        }
        else {
            System.out.println("getUnsigned() - Success");
            System.out.printf("Expected: 10L | Result: %d\n", test.getUnsigned());
        }

        test = new Longword(56);
        if(test.getUnsigned() != 56L) {
            throw new Exception("getUnsigned() - Failed");
        }
        else {
            System.out.println("getUnsigned() - Success");
            System.out.printf("Expected: 56L | Result: %d\n", test.getUnsigned());
        }

        System.out.println();
    }

    // Test case for getSigned()
    public static void test_getSigned() throws Exception {
        Longword test = new Longword();

        test = new Longword(15);
        if(test.getSigned() != 15) {
            throw new Exception("getSigned() - Failed");
        }
        else {
            System.out.println("getSigned() - Success");
            System.out.printf("Expected: 15 | Result: %d\n", test.getSigned());
        }

        test = new Longword(39);
        if(test.getSigned() != 39) {
            throw new Exception("getSigned() - Failed");
        }
        else {
            System.out.println("getSigned() - Success");
            System.out.printf("Expected: 39 | Result: %d\n", test.getSigned());
        }

        System.out.println();
    }

    // Test case for copy(Longword)
    public static void test_copy() throws Exception {
        Longword test = new Longword(0);
        test.copy(new Longword(5));

        if(test.getSigned() != 5) {
            throw new Exception("copy(other) - Failed.");
        }
        else {
            System.out.println("copy(other) - Success");
            System.out.println("Expected: f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t,");
            System.out.printf("Result: %s \n", test.toString());
        }

        System.out.println();
    }

    // Test case for set(int)
    public static void test_set() throws Exception {
        Longword test = new Longword(0);
        test.set(10);

        if(test.getSigned() != 10) {
            throw new Exception("set(value) - Failed.");
        }
        else {
            System.out.println("set(value) - Success");
        }

        test.set(100);
        if(test.getSigned() != 100) {
            throw new Exception("set(value) - Failed.");
        }
        else {
            System.out.println("set(value) - Success");
        }

        System.out.println();
    }

    public static void runTests() throws Exception {
        test_getBit();
        test_setBit();
        test_and();
        test_or();
        test_xor();
        test_not();
        test_rightShift();
        test_leftShift();
        test_toString();
        test_getUnsigned();
        test_getSigned();
        test_copy();
        test_set();
    }
}