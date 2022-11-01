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

        System.out.println();
    }

    public static void test_move() {
        try {
            Computer test_computer = new Computer();
            test_computer.move(new Longword(0), new Longword(333));
            test_computer.move(new Longword(1), new Longword(1000));
            test_computer.move(new Longword(2), new Longword(245));
            test_computer.interrupt_0();
        }
        catch(Exception e) {
            System.out.println("Move/Interrupt-0 Error.");
            e.printStackTrace();
        }

        System.out.println();
    }

    public static void test_halt() {
        try {
            Computer test_computer = new Computer();
            test_computer.halt();
        }
        catch(Exception e) {
            System.out.println("Halt Error.");
            e.printStackTrace();
        }

        System.out.println();
    }

    public static void test_interrupt1() {
        try {
            Computer test_computer = new Computer();
            test_computer.interrupt_1();
        }
        catch(Exception e) {
            System.out.println("Interrupt-1 Error.");
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void test_alu1() {
        Bit[] test = new Bit[]{new Bit(), new Bit(true), new Bit(true), new Bit(true)}; //add

        System.out.printf("""
                Running ALU...
                10 + 2: %d
                """, ALU.doOp(test, new Longword(10), new Longword(2)).getSigned());

        System.out.println();
    }

    public static void runTest() {
        System.out.println("CPU Test 1:");

        test_preload();
        test_move();
        test_alu1();
        test_halt();
        test_interrupt1();

        System.out.println();
    }
}