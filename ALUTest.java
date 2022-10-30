public class ALUTest {
    
    /*
        Binary Value = 1000 | Decimal Value = 8
    */
    public static void test_and() throws Exception {
        Bit[] test = new Bit[]{new Bit(false), new Bit(), new Bit(), new Bit(true)};

        if(ALU.bit_compare(test, 8) != true) {
            throw new Exception("doOp() : and - Failed");
        }
        else {
            System.out.println("doOp() : and - Success");
            System.out.printf("Expected: 2 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
            System.out.printf("Expected: 4 | Result: %d\n", ALU.doOp(test, new Longword(13), new Longword(4)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1001 | Decimal Value = 9
    */
    public static void test_or() throws Exception {
        Bit[] test = new Bit[]{new Bit(true), new Bit(), new Bit(), new Bit(true)};

        if(ALU.bit_compare(test, 9) != true) {
            throw new Exception("doOp() : or - Failed");
        }
        else {
            System.out.println("doOp() : or - Success");
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(8), new Longword(2)).getSigned());
            System.out.printf("Expected: 7 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1010 | Decimal Value = 10
    */
    public static void test_xor() throws Exception {
        Bit[] test = new Bit[]{new Bit(false), new Bit(true), new Bit(false), new Bit(true)};

        if(ALU.bit_compare(test, 10) != true) {
            throw new Exception("doOp() : xor - Failed");
        }
        else {
            System.out.println("doOp() : xor - Success");
            System.out.printf("Expected: 0 | Result: %d\n", ALU.doOp(test, new Longword(4), new Longword(4)).getSigned());
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(9), new Longword(3)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1011 | Decimal Value = 11
    */
    public static void test_not() throws Exception {
        Bit[] test = new Bit[]{new Bit(true), new Bit(true), new Bit(false), new Bit(true)};

        if(ALU.bit_compare(test, 11) != true) {
            throw new Exception("doOp() : not - Failed");
        }
        else {
            System.out.println("doOp() : not - Success");
            System.out.println("Expected: t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,f,t,t,f,t,t,");
            System.out.printf("Result: %s\n", ALU.doOp(test, new Longword(100), new Longword()).toString());
            //System.out.printf("Expected: 4294966629 | Result: %d\n", ALU.doOp(test, new Longword(100), new Longword()));
        }

        System.out.println();
    }

    /*
        Binary Value = 1100 | Decimal Value = 12      
    */
    public static void test_leftShift() throws Exception {
        Bit[] test = new Bit[]{new Bit(), new Bit(), new Bit(true), new Bit(true)};

        if(ALU.bit_compare(test, 12) != true) {
            throw new Exception("doOp() : leftShift - Failed");
        }
        else {
            System.out.println("doOp() : leftShift - Success");
            System.out.printf("Expected: 8 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
            System.out.printf("Expected: 112 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1101 | Decimal Value = 13      
    */
    public static void test_rightShift() throws Exception {
        Bit[] test = new Bit[]{new Bit(true), new Bit(), new Bit(true), new Bit(true)};

        if(ALU.bit_compare(test, 13) != true) {
            throw new Exception("doOp() : rightShift - Failed");
        }
        else {
            System.out.println("doOp() : rightShift - Success");
            System.out.printf("Expected: 5 | Result: %d\n", ALU.doOp(test, new Longword(20), new Longword(2)).getSigned());
            System.out.printf("Expected: 20 | Result: %d\n", ALU.doOp(test, new Longword(40), new Longword(1)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1110 | Decimal Value = 14      
    */
    public static void test_add() throws Exception {
        Bit[] test = new Bit[]{new Bit(), new Bit(true), new Bit(true), new Bit(true)};

        if(ALU.bit_compare(test, 14) != true) {
            throw new Exception("doOp() : add - Failed");
        }
        else {
            System.out.println("doOp() : add - Success");
            System.out.printf("Expected: 8 | Result: %d\n", ALU.doOp(test, new Longword(6), new Longword(2)).getSigned());
            System.out.printf("Expected: 11 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 1111 | Decimal Value = 15      
    */
    public static void test_subtract() throws Exception {
        Bit[] test = new Bit[]{new Bit(true), new Bit(true), new Bit(true), new Bit(true)};

        if(ALU.bit_compare(test, 15) != true) {
            throw new Exception("doOp() : subtract - Failed");
        }
        else {
            System.out.println("doOp() : subtract - Success");
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(50), new Longword(40)).getSigned());
            System.out.printf("Expected: 7 | Result: %d\n", ALU.doOp(test, new Longword(45), new Longword(38)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 0111 | Decimal Value = 7      
    */
    public static void test_multiply() throws Exception {
        Bit[] test = new Bit[]{new Bit(true), new Bit(true), new Bit(true), new Bit()};

        if(ALU.bit_compare(test, 7) != true) {
            throw new Exception("doOp() : multiply - Failed");
        }
        else {
            System.out.println("doOp() : multiply - Success");
            System.out.printf("Expected: 4 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
        }

        System.out.println();
    }

    public static void runTest() throws Exception {
        System.out.println("ALU Test: ");

        test_and();
        test_or();
        test_xor();
        test_not();
        test_leftShift();
        test_rightShift();
        
        test_add();
        test_subtract();
        test_multiply();
    }
}
