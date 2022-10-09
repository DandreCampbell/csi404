public class ALUTest {
    
    /*
        Binary Value = 1000 | Decimal Value = 8
    */
    public static void test_and() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(true);
 
        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 2
        if(test.equals(ALU.bit_conversion(8))) {
            throw new Exception("doOp() : and - Failed");
        }
        else {
            System.out.printf("doOp() : and - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1001 | Decimal Value = 9
    */
    public static void test_or() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 2
        if(test.equals(ALU.bit_conversion(9))) {
            throw new Exception("doOp() : or - Failed");
        }
        else {
            System.out.printf("doOp() : or - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1010 | Decimal Value = 10
    */
    public static void test_xor() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 0
        if(test.equals(ALU.bit_conversion(10))) {
            throw new Exception("doOp() : xor - Failed");
        }
        else {
            System.out.printf("doOp() : xor - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1011 | Decimal Value = 11
    */
    public static void test_not() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(true);
        test[2] = new Bit(false);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword()); // 0
        if(test.equals(ALU.bit_conversion(11))) {
            throw new Exception("doOp() : not - Failed");
        }
        else {
            System.out.printf("doOp() : not - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1100 | Decimal Value = 12      
    */
    public static void test_leftShift() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 8
        if(test.equals(ALU.bit_conversion(12))) {
            throw new Exception("doOp() : leftShift - Failed");
        }
        else {
            System.out.printf("doOp() : leftShift - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1101 | Decimal Value = 13      
    */
    public static void test_rightShift() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(false);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(20), new Longword(2)); // 5
        if(test.equals(ALU.bit_conversion(13))) {
            throw new Exception("doOp() : rightShift - Failed");
        }
        else {
            System.out.printf("doOp() : rightShift - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1110 | Decimal Value = 14      
    */
    public static void test_add() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 4
        if(test.equals(ALU.bit_conversion(14))) {
            throw new Exception("doOp() : add - Failed");
        }
        else {
            System.out.printf("doOp() : add - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 1111 | Decimal Value = 15      
    */
    public static void test_subtract() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(true);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 0
        if(test.equals(ALU.bit_conversion(15))) {
            throw new Exception("doOp() : subtract - Failed");
        }
        else {
            System.out.printf("doOp() : subtract - Success: %d\n", result.getSigned());
        }
    }

    /*
        Binary Value = 10000 | Decimal Value = 16 ?      
    */
    public static void test_multiply() throws Exception {
        Bit[] test = new Bit[5];
        test[0] = new Bit(false);
        test[1] = new Bit(false);
        test[2] = new Bit(false);
        test[3] = new Bit(false);
        test[4] = new Bit(true);

        Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 4
        if(test.equals(ALU.bit_conversion(16))) {
            throw new Exception("doOp() : multiply - Failed");
        }
        else {
            System.out.printf("doOp() : multiply - Success: %d\n", result.getSigned());
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
