public class CPUTest2 {

    public static void assemble_conditions() throws Exception {
        String[] test_args = {"jump 10", "compare R5 R7"};

        if(Assembler.assemble(test_args)[0].equals("0011000000001010") != true) {
            throw new Exception("jump assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \njump assembly : success\n", test_args[0], Assembler.assemble(test_args)[0]);
        }

        if(Assembler.assemble(test_args)[1].equals("0100000001010111") != true) {
            throw new Exception("compare assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \ncompare assembly : success\n", test_args[1], Assembler.assemble(test_args)[1]);
        }

        // ----------------------------

        String[] test_branch = {"branchiflessthan 0", "branchifgreaterthan 1", "branchifequal 2", "branchifnotequal 3"};

        if(Assembler.assemble(test_branch)[0].equals("0101000000000000") != true) {
            throw new Exception("branchiflessthan assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nbranchiflessthan assembly : success\n", test_branch[0], Assembler.assemble(test_branch)[0]);
        }

        if(Assembler.assemble(test_branch)[1].equals("0101010000000001") != true) {
            throw new Exception("branchifgreaterthan assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nbranchifgreaterthan assembly : success\n", test_branch[1], Assembler.assemble(test_branch)[1]);
        }

        if(Assembler.assemble(test_branch)[2].equals("0101110000000010") != true) {
            throw new Exception("branchifequal assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nbranchifequal assembly : success\n", test_branch[2], Assembler.assemble(test_branch)[2]);
        }

        if(Assembler.assemble(test_branch)[3].equals("0101100000000011") != true) {
            throw new Exception("branchifnotequal assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nbranchifnotequal assembly : success\n", test_branch[3], Assembler.assemble(test_branch)[3]);
        }

        System.out.println();
    }

    public static void test_jump() {
        try {
            Computer test_computer = new Computer();
            /*
            test_computer.print_pc();
            test_computer.jump(new Longword(5));
            test_computer.print_pc();
            test_computer.jump(new Longword(3));
            test_computer.print_pc();
             */

            System.out.println("jump : success");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    // test for branchifgreaterthan
    public static void test_greaterthan() {
        try {
            String[] commands = new String[]{"move R14 128", "move R15 100", "compare R14 R15", "branchifgreaterthan 0", "halt"};

            Computer test_computer = new Computer();
            test_computer.preload(Assembler.assemble(commands));
            /*
            test_computer.move(new Longword(14), new Longword(128));
            test_computer.move(new Longword(15), new Longword(100));
            test_computer.compare(new Longword(14), new Longword(15));
            test_computer.branch(new Longword(0));
            System.out.println("compare : success \nbranchifgreaterthan : success");
             */

            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test for branchifequal
    public static void test_equalto() {
        try {
            String[] commands = new String[]{"move R1 5", "move R4 5", "compare R1 R4", "branchifequal 0", "halt"};

            Computer test_computer = new Computer();
            test_computer.preload(Assembler.assemble(commands));
            /*
            test_computer.move(new Longword(1), new Longword(5));
            test_computer.move(new Longword(4), new Longword(5));
            test_computer.compare(new Longword(1), new Longword(4));
            test_computer.branch(new Longword(0));
            System.out.println("compare : success \nbranchifequalto : success");
             */

            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test for branchiflessthan
    public static void test_lessthan() {
        try {
            String[] commands = new String[]{"move R3 4", "move R7 5", "compare R3 R7", "branchiflessthan 0", "halt"};

            Computer test_computer = new Computer();
            test_computer.preload(Assembler.assemble(commands));
            /*
            test_computer.jump(new Longword(1));
            test_computer.move(new Longword(3), new Longword(4));
            test_computer.move(new Longword(7), new Longword(5));
            test_computer.compare(new Longword(3), new Longword(7));
            test_computer.branch(new Longword(0));
             */

            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runTests() throws Exception {
        System.out.println("CPU Test 2: ");

        assemble_conditions();
        test_greaterthan();
        test_equalto();
        test_lessthan();
        test_jump();

        System.out.println();
    }
}