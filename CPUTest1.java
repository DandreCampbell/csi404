public class CPUTest1 {

    public static void test_1() throws Exception {
        try {
            Computer test_computer = new Computer();
            test_computer.preload(null);
            test_computer.run();
            test_computer.move(new Longword(1), new Longword(10));

            Bit[] test = new Bit[4]; // add
            test[0] = new Bit(false);
            test[1] = new Bit(true);
            test[2] = new Bit(true);
            test[3] = new Bit(true);
            System.out.printf("Running ALU...\n" + 
                "10 + 2: %d\n", ALU.doOp(test, new Longword(10), new Longword(2)).getSigned());

            test_computer.interrupt_0();
            test_computer.halt();
            test_computer.interrupt_1();

            System.out.println("CPU Test 1 Success.");
        }
        catch(Exception e) {
            System.out.println("CPU Test 1 Failed.");
            System.out.println(e);
        }
    }

    public static void test_2() throws Exception {
        try {
            Computer test_computer = new Computer();
            test_computer.preload(null);
            test_computer.run();
            test_computer.move(new Longword(2), new Longword(27));

            Bit[] test = new Bit[4]; // subtract
            test[0] = new Bit(true);
            test[1] = new Bit(true);
            test[2] = new Bit(true);
            test[3] = new Bit(true);
            System.out.printf("Running ALU...\n" + 
                "4 - 4: %d\n", ALU.doOp(test, new Longword(4), new Longword(4)).getSigned());

            test_computer.interrupt_0();
            test_computer.halt();
            test_computer.interrupt_1();

            System.out.println("CPU Test 1 Success.");
        }
        catch(Exception e) {
            System.out.println("CPU Test 1 Failed.");
            System.out.println(e);
        }
    }

    public static void runTest() throws Exception{
        test_1();
        test_2();

        System.out.println();
    }
}