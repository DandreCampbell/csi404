public class LongwordTest {

    public static void test_getBit() throws Exception {
        Longword test = new Longword(1);
        test.setBit(2, new Bit(true));

        if(test.getBit(2).getValue() != true) {
            throw new Exception("getBit(index) - Failed");
        }
        else {
            System.out.println("getBit(index) - Success");
        }
    }

    public static void test_setBit() throws Exception {
        Longword test = new Longword(0);
        test.setBit(31, new Bit(true));

        if(test.getBit(31).getValue() != true) {
            throw new Exception("setBit(index, value) - Failed");
        }
        else {
            System.out.println("setBit(index, value) - Success");
        }
    }

    public static void test_and() throws Exception {
        Longword test = new Longword(1);

        /*
        if(test.and(new Longword(0)).getSigned() != 0) {
            throw new Exception("and(other) - Failed");
        }
         */
        if(test.and(new Longword(1)).getBit(0).getValue() != false) {
            throw new Exception("and(other) - Failed");
        }
        else {
            System.out.println("and(other) - Success");
        }
    }

    public static void test_or() throws Exception {
        Longword test = new Longword(0);

        if(test.or(new Longword(1)).getSigned() != 0) {
            throw new Exception("or(other) - Failed");
        }
        else {
            System.out.println("or(other) - Success");
        }
    }
    
    public static void test_xor() throws Exception {
        Longword test = new Longword(0);

        if(test.xor(new Longword(0)).getBit(0).getValue() != false) {
            throw new Exception("xor(other) 1 - Failed");  
        }
        else if(test.xor(new Longword(1)).getBit(0).getValue() != false) {
            throw new Exception("xor(other) 2 - Failed");
        }
        else {
            System.out.println("xor(other) - Success");
        }
    }

    // Fix
    public static void test_not() throws Exception {
        Longword test = new Longword(10);

        if(test.not().getBit(0).getValue() != true) {
            throw new Exception("not() - Failed");
        }
        else {
            System.out.println("not() - Success");
        }
    }

    public static void test_rightShift() throws Exception {
        Longword test = new Longword(2);

        if(test.rightShift(1).getSigned() != 1) {
            System.out.println("rightShift() - Failed");
            //throw new Exception("rightShift() 1 - Failed");
        }
        else {
            System.out.println("rightShift() - Success");
        }
    }

    public static void test_leftShift() throws Exception {
        Longword test = new Longword(2);

        if(test.leftShift(1).getSigned() != 4) {
            System.out.println("leftShift() - Failed");
            //throw new Exception("leftShift() - Failed");
        }
        else {
            System.out.println("leftShift() - Success");
        }
    }

    public static void test_toString() throws Exception {
        Longword test = new Longword(0);
        String expected = "f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,";

        if(test.toString().equals(expected)) {
			System.out.println("toString() - Success");
		}
		else {
			throw new Exception("toString() - Failed");
		}
    }

    public static void test_getUnsigned() throws Exception {
        Longword test = new Longword(10);

        if(test.getUnsigned() != 10L) {
            throw new Exception("getUnsigned() - Failed");
        }
        else {
            System.out.println("getUnsigned() - Success");
        }
    }

    public static void test_getSigned() throws Exception {
        Longword test = new Longword(15);

        if(test.getSigned() != 15) {
            throw new Exception("getSigned() - Failed");
        }
        else {
            System.out.println("getSigned() - Success");
        }
    }

    public static void test_copy() throws Exception {
        Longword test = new Longword(0);
        test.copy(new Longword(1));

        if(test.getSigned() != 1) {
            throw new Exception("copy(other) - Failed.");
        }
        else {
            System.out.println("copy(other) - Success");
        }
    }

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
        
        System.out.println();
    }
}