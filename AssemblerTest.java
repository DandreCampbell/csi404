public class AssemblerTest {
    
    public static void test_assemble1() {
        try {
            String[] commands = {"move R1 10", "halt", "interrupt 1", "interrupt 0"};

            for(int i = 0; i < commands.length; i ++) {
                System.out.printf("%s: %s \n", commands[i], Assembler.assemble(commands)[i]);
            }
            System.out.println("assemble() 1 - success.\n");
        }
        catch(Exception e) {
            System.out.println("Assembler Failed.");
            e.printStackTrace();
        }
    }

    public static void test_assemble2() {
        try {
            String[] commands = {"and R1 R2 R7", "or R2 R3 R8", "xor R3 R4 R9",
                    "not R4 R5 R10", "leftShift R5 R6 R11", "rightShift R6 R7 R12"};

            for(int i = 0; i < commands.length; i ++) {
                System.out.printf("%s: %s \n", commands[i], Assembler.assemble(commands)[i]);
            }
            System.out.println("assemble() 2 - success.\n");
        }
        catch(Exception e) {
            System.out.println("Assembler Failed.");
            e.printStackTrace();
        }
    }

    public static void test_assemble3() {
        try {
            String[] commands = {"add R1 R2 R3", "subtract R2 R3 R4", "multiply R3 R4 R5"};

            for(int i = 0; i < commands.length; i ++) {
                System.out.printf("%s: %s \n", commands[i], Assembler.assemble(commands)[i]);
            }
            System.out.println("assemble() 3 - success.\n");
        }
        catch(Exception e) {
            System.out.println("Assembler Failed.");
            e.printStackTrace();
        }
    }

    public static void runTest() {
        System.out.println("Assembler Test ");

        test_assemble1();
        test_assemble2();
        test_assemble3();
    }
}
