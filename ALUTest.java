public class ALUTest {
    
    // Binary Value = 1000 | Decimal Value = 8
    public static void test_and() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(true);
 
        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : and - Failed");
        }
        else {
            System.out.println("doOp() : and - Success");
        }
    }

    // Binary Value = 1001 | Decimal Value = 9
    public static void test_or() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : or - Failed");
        }
        else {
            System.out.println("doOp() : or - Success");
        }
    }

    // Binary Value = 1010 | Decimal Value = 10
    public static void test_xor() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : xor - Failed");
        }
        else {
            System.out.println("doOp() : xor - Success");
        }
    }

    // Binary Value = 1011 | Decimal Value = 11
    public static void test_not() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(true);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : not - Failed");
        }
        else {
            System.out.println("doOp() : not - Success");
        }
    }

    // Binary Value = 1100 | Decimal Value = 12
    public static void test_leftShift() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : leftShift - Failed");
        }
        else {
            System.out.println("doOp() : leftShift - Success");
        }
    }

    // Binary Value = 1101 | Decimal Value = 13
    public static void test_rightShift() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(false);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : rightShift - Failed");
        }
        else {
            System.out.println("doOp() : rightShift - Success");
        }
    }

    // Binary Value = 1110 | Decimal Value = 14
    public static void test_add() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : add - Failed");
        }
        else {
            System.out.println("doOp() : add - Success");
        }
    }

    // Binary Value = 1111 | Decimal Value = 15
    public static void test_subtract() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(0)) {
            throw new Exception("doOp() : subtract - Failed");
        }
        else {
            System.out.println("doOp() : subtract - Success");
        }
    }

    // Binary Value = 10000 | Decimal Value = 16 ?
    public static void test_multiply() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(false);

        if(ALU.doOp(test, new Longword(2), new Longword(2)).equals(4)) {
            throw new Exception("doOp() : multiply - Failed");
        }
        else {
            System.out.println("doOp() : multiply - Success");   
        }
    }

    public static void runTest() throws Exception {
        test_and();
        test_or();
        test_xor();
        test_not();
        test_leftShift();
        test_rightShift();

        test_add();
        test_subtract();
        test_multiply();

        System.out.println();
    }
}
