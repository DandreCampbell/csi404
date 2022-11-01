public class AssemblerTest {
    
    public static void test_assemble1() {
        try {
            String[] commands = {"move R1 10", "halt", "interrupt 1", "interrupt 0"};

            for(int i = 0; i < commands.length; i ++) {
                System.out.printf("%s: %s \n", commands[i], Assembler.assemble(commands)[i]);
            }
            System.out.println();
        }
        catch(Exception e) {
            System.out.println("Assembler Failed.");
            e.printStackTrace();
        }
    }

    public static void test_assemble2() {
        try {
            String[] commands = {"interrupt 0", "move R15 100", "halt", "interrupt 1"};

            for(int i = 0; i < commands.length; i ++) {
                System.out.printf("%s: %s \n", commands[i], Assembler.assemble(commands)[i]);
            }
            System.out.println();
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
    }
}
