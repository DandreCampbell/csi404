public class CPUTest1 {

    public static void test_preload() throws Exception {
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
            System.out.println(e);
        }
        System.out.println();
    }

    public static void test_move() throws Exception {
        try {
            Computer test_computer = new Computer();
            test_computer.move(new Longword(0), new Longword(333));
            test_computer.move(new Longword(1), new Longword(1000));
            test_computer.move(new Longword(2), new Longword(245));
            test_computer.interrupt_0();
        }
        catch(Exception e) {
            System.out.println("Move/Interrupt-0 Error.");
            System.out.println(e);
        }
        System.out.println();
    }

    public static void test_halt() throws Exception {
        try {
            Computer test_computer = new Computer();
            test_computer.halt();
        }
        catch(Exception e) {
            System.out.println("Halt Error.");
            System.out.println(e);
        }
        System.out.println();
    }

    public static void test_interrupt1() throws Exception {
        try {
            Computer test_computer = new Computer();
            test_computer.interrupt_1();
        }
        catch(Exception e) {
            System.out.println("Interrupt-1 Error.");
            System.out.println(e);
        }
        System.out.println();
    }

    public static void test_alu1() {
        Bit[] test = new Bit[4]; // add
        test[0] = new Bit(false);
        test[1] = new Bit(true);
        test[2] = new Bit(true);
        test[3] = new Bit(true);
        System.out.printf("Running ALU...\n" + 
            "10 + 2: %d\n", ALU.doOp(test, new Longword(10), new Longword(2)).getSigned());

        System.out.println();
    }

    public static void runTest() throws Exception{
        test_preload();
        test_move();
        test_alu1();
        test_halt();
        test_interrupt1();

        System.out.println();
    }
}