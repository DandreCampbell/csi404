public class CPUTest1 {

    public static void test_preload() {
        try {
            String halt = "0000 0000 0000 0000"; // stops computer from running
            String interrupt0 = "0010 0000 0000 0000"; // print registers
            String interrupt1 = "0010 0000 0000 0001"; // print bytes
            String move = "0001 0010 0000 1010"; // move R2 10 – moves the literal value 10 into R2.
            String[] commands = {move, interrupt0, halt, interrupt1};

            Computer test_computer = new Computer();
            test_computer.preload(commands);
            test_computer.run();
        }
        catch(Exception e) {
            System.out.println("Run Error.");
            e.printStackTrace();
        }
    }

    public static void test_move() {
        try {
            Computer test_computer = new Computer();
            test_computer.move(new Longword(0), new Longword(333));
            test_computer.move(new Longword(1), new Longword(1000));
            test_computer.move(new Longword(2), new Longword(245));
            System.out.println("move() - success");

            test_computer.interrupt_0();
            System.out.println("interrupt_0() - success\n");
        }
        catch(Exception e) {
            System.out.println("move()/interrupt_0()-0 error.");
            e.printStackTrace();
        }
    }

    public static void test_halt() {
        try {
            Computer test_computer = new Computer();
            test_computer.halt();
            System.out.println("halt() - success");
        }
        catch(Exception e) {
            System.out.println("halt() Error.");
            e.printStackTrace();
        }
    }

    public static void test_interrupt1() {
        try {
            Computer test_computer = new Computer();
            test_computer.interrupt_1();
            System.out.println("interrupt_1() - success");
        }
        catch(Exception e) {
            System.out.println("interrupt_1()-1 error.");
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void test_alu1() throws Exception {
        Bit[] test = new Bit[]{new Bit(), new Bit(true), new Bit(true), new Bit(true)}; //add
        int result = ALU.doOp(test, new Longword(10), new Longword(2)).getSigned();

        if(result != 12) {
            throw new Exception("alu - failed");
        }
        else {
            System.out.println("alu - success");
            System.out.printf("Running ALU...\n10 + 2: %d\n", result);
        }
        
        System.out.println();
    }

    public static void runTest() throws Exception {
        System.out.println("CPU Test 1:");

        test_preload();
        test_move();
        test_alu1();
        test_halt();
        test_interrupt1();

        System.out.println();
    }
}