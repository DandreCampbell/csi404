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
 
        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(8)));

        if(test.equals(ALU.bit_conversion(8))) {
            throw new Exception("doOp() : and - Failed");
        }
        else {
            System.out.printf("doOp() : and - Success\n");
            System.out.printf("Expected: 2 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
            System.out.printf("Expected: 4 | Result: %d\n", ALU.doOp(test, new Longword(13), new Longword(4)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(9)));

        //Longword result = ALU.doOp(test, new Longword(2), new Longword(2)); // 2
        if(test.equals(ALU.bit_conversion(9))) {
            throw new Exception("doOp() : or - Failed");
        }
        else {
            System.out.printf("doOp() : or - Success\n");
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(8), new Longword(2)).getSigned());
            System.out.printf("Expected: 7 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(10)));

        if(test.equals(ALU.bit_conversion(10))) {
            throw new Exception("doOp() : xor - Failed");
        }
        else {
            System.out.printf("doOp() : xor - Success\n");
            System.out.printf("Expected: 0 | Result: %d\n", ALU.doOp(test, new Longword(4), new Longword(4)).getSigned());
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(9), new Longword(3)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(11)));

        if(test.equals(ALU.bit_conversion(11))) {
            throw new Exception("doOp() : not - Failed");
        }
        else {
            System.out.printf("doOp() : not - Success\n");
            System.out.printf("Expected: 4294966629 | Result: %d\n", ALU.doOp(test, new Longword(666), new Longword()).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(12)));

        if(test.equals(ALU.bit_conversion(12))) {
            throw new Exception("doOp() : leftShift - Failed");
        }
        else {
            System.out.printf("doOp() : leftShift - Success\n");
            System.out.printf("Expected: 8 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
            System.out.printf("Expected: 112 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(13)));

        if(test.equals(ALU.bit_conversion(13))) {
            throw new Exception("doOp() : rightShift - Failed");
        }
        else {
            System.out.printf("doOp() : rightShift - Success\n");
            System.out.printf("Expected: 5 | Result: %d\n", ALU.doOp(test, new Longword(20), new Longword(2)).getSigned());
            System.out.printf("Expected: 20 | Result: %d\n", ALU.doOp(test, new Longword(40), new Longword(1)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(14)));

        if(test.equals(ALU.bit_conversion(14))) {
            throw new Exception("doOp() : add - Failed");
        }
        else {
            System.out.printf("doOp() : add - Success\n");
            System.out.printf("Expected: 8 | Result: %d\n", ALU.doOp(test, new Longword(6), new Longword(2)).getSigned());
            System.out.printf("Expected: 11 | Result: %d\n", ALU.doOp(test, new Longword(7), new Longword(4)).getSigned());
        }

        System.out.println();
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

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(15)));

        if(test.equals(ALU.bit_conversion(15))) {
            throw new Exception("doOp() : subtract - Failed");
        }
        else {
            System.out.printf("doOp() : subtract - Success\n");
            System.out.printf("Expected: 10 | Result: %d\n", ALU.doOp(test, new Longword(50), new Longword(40)).getSigned());
            System.out.printf("Expected: 7 | Result: %d\n", ALU.doOp(test, new Longword(45), new Longword(38)).getSigned());
        }

        System.out.println();
    }

    /*
        Binary Value = 0111 | Decimal Value = 7      
    */
    public static void test_multiply() throws Exception {
        Bit[] test = new Bit[4];
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);

        System.out.println(ALU.toString(test));
        System.out.println(ALU.toString(ALU.bit_conversion(7)));

        if(test.equals(ALU.bit_conversion(7))) {
            throw new Exception("doOp() : multiply - Failed");
        }
        else {
            System.out.printf("doOp() : multiply - Success\n");
            System.out.printf("Expected: 4 | Result: %d\n", ALU.doOp(test, new Longword(2), new Longword(2)).getSigned());
        }

        System.out.println();
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
