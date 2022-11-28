public class CPUTest3 {

    public static void assemble_stack() throws Exception {
        System.out.println("Assembling Stack Commands:");

        String[] test_args = new String[]{"push R15", "pop R1", "call R10", "return"};
        String[] binary = Assembler.assemble(test_args);

        for(int i = 0; i < test_args.length; i++) {
            System.out.printf("%s -> %s\n", test_args[i], binary[i]);

        }

        if(Assembler.assemble(test_args)[0].equals("0110000000001111") != true) {
            throw new Exception(" : failed");
        }
        else {
            System.out.printf("%s -> %s \npush assembly : success\n", test_args[0], Assembler.assemble(test_args)[0]);
        }

        if(Assembler.assemble(test_args)[1].equals("0110010000000001") != true) {
            throw new Exception(" : failed");
        }
        else {
            System.out.printf("%s -> %s \npop assembly : success\n", test_args[1], Assembler.assemble(test_args)[1]);
        }

        if(Assembler.assemble(test_args)[2].equals("011010000000001010") != true) {
            throw new Exception(" : failed");
        }
        else {
            System.out.printf("%s -> %s \ncall assembly : success\n", test_args[2], Assembler.assemble(test_args)[2]);
        }

        if(Assembler.assemble(test_args)[3].equals("0110110000000000") != true) {
            throw new Exception(" : failed");
        }
        else {
            System.out.printf("%s -> %s \nreturn assembly : success\n", test_args[3], Assembler.assemble(test_args)[3]);
        }

        System.out.println();
    }

    public static void test_push() {
        System.out.println("Push Tests:");

        String[] commands = new String[]{"move R1 11", "move R2 27", "move R3 163", "push R1", "push R2", "push R3"};
        Computer test_computer = new Computer();
        test_computer.preload(Assembler.assemble(commands));
        test_computer.run();

        test_computer.move(new Longword(1), new Longword(11));
        test_computer.push_stack(new Longword(1));

        test_computer.move(new Longword(2), new Longword(27));
        test_computer.push_stack(new Longword(2));

        test_computer.move(new Longword(3), new Longword(33));
        test_computer.push_stack(new Longword(3));

        test_computer.interrupt_0();
        test_computer.interrupt_1();

        System.out.println();
    }

    public static void test_pop() {
        System.out.println("Pop Tests:");

        String[] commands = new String[]{"move R1 11", "push R1", "move R2 27", "push R2", "pop R9", "pop R10"};
        Computer test_computer = new Computer();
        test_computer.preload(Assembler.assemble(commands));
        test_computer.run();

        test_computer.move(new Longword(1), new Longword(11));
        test_computer.push_stack(new Longword(1));

        test_computer.move(new Longword(2), new Longword(27));
        test_computer.push_stack(new Longword(2));

        test_computer.pop_stack(new Longword(9));
        test_computer.pop_stack(new Longword(10));

        test_computer.interrupt_0();
        test_computer.interrupt_1();

        System.out.println();
    }

    public static void test_call() {
        System.out.println("Call Tests:");

        String[] commands = new String[]{"call 4", "call 10", "call 14"};
        Computer test_computer = new Computer();
        test_computer.preload(Assembler.assemble(commands));
        test_computer.run();

        test_computer.call_stack(new Longword(4));
        test_computer.call_stack(new Longword(10));
        test_computer.call_stack(new Longword(14));

        test_computer.interrupt_0();
        test_computer.interrupt_1();

        System.out.println();
    }

    public static void test_return() {
        System.out.println("Return Tests:");

        String[] commands = new String[]{"move R0 30", "push R0", "move R15 111", "push R15", "pop R6", "pop R7", "return"};
        Computer test_computer = new Computer();
        test_computer.preload(Assembler.assemble(commands));
        test_computer.run();

        test_computer.move(new Longword(0), new Longword(30));
        test_computer.push_stack(new Longword(0));

        test_computer.move(new Longword(15), new Longword(111));
        test_computer.push_stack(new Longword(15));

        test_computer.pop_stack(new Longword(6));
        test_computer.pop_stack(new Longword(7));

        test_computer.return_stack();

        test_computer.interrupt_0();
        test_computer.interrupt_1();

        System.out.println();
    }

    public static void runTests() throws Exception {
        //assemble_stack();
        //test_push();
        //test_pop();
        test_call();
        //test_return();
    }
}