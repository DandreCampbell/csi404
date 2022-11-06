public class AssemblerTest {

    // Test Cases for Computer commands
    public static void assemble_computer_commands() throws Exception {
        String[] test_args = {"move R1 10", "halt", "interrupt 1", "interrupt 0"};

        if(Assembler.assemble(test_args)[0].equals("0001000100001010") != true) {
            throw new Exception("move assembly - failed");
        }
        else {
            System.out.printf("%s -> %s \nmove assembly - success\n", test_args[0], Assembler.assemble(test_args)[0]);
        }

        if(Assembler.assemble(test_args)[1].equals("0000000000000000") != true) {
            throw new Exception("halt assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nhalt assembly : success\n", test_args[1], Assembler.assemble(test_args)[1]);
        }

        if(Assembler.assemble(test_args)[2].equals("0010000000000001") != true) {
            throw new Exception("interrupt-1 : failed");
        }
        else {
            System.out.printf("%s -> %s \ninterrupt-1 : success\n", test_args[2], Assembler.assemble(test_args)[2]);
        }

        if(Assembler.assemble(test_args)[3].equals("0010000000000000") != true) {
            throw new Exception("interrupt-0 : failed");
        }
        else {
            System.out.printf("%s -> %s \ninterrupt-0 : success\n", test_args[3], Assembler.assemble(test_args)[3]);
        }

        System.out.println();
    }

    // Test Cases for Bit operations
    public static void assemble_alu_1() throws Exception {
        String[] test_args = {"and R1 R2 R7", "or R2 R3 R8", "xor R3 R4 R9",
                "not R4 R5 R10", "leftShift R5 R6 R11", "rightShift R6 R7 R12"};

        if(Assembler.assemble(test_args)[0].equals("1000000100100111") != true) {
            throw new Exception("and assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nand assembly : success\n", test_args[0], Assembler.assemble(test_args)[0]);
        }

        if(Assembler.assemble(test_args)[1].equals("1001001000111000") != true) {
            throw new Exception("or assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nor assembly : success\n", test_args[1], Assembler.assemble(test_args)[1]);
        }

        if(Assembler.assemble(test_args)[2].equals("1010001101001001") != true) {
            throw new Exception("xor assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nxor assembly  : success\n", test_args[2], Assembler.assemble(test_args)[2]);
        }

        if(Assembler.assemble(test_args)[3].equals("1011010001011010") != true) {
            throw new Exception("not assembly  : failed");
        }
        else {
            System.out.printf("%s -> %s \nnot assembly  : success\n", test_args[3], Assembler.assemble(test_args)[3]);
        }

        if(Assembler.assemble(test_args)[4].equals("1100010101101011") != true) {
            throw new Exception("leftShift assembly  : failed");
        }
        else {
            System.out.printf("%s -> %s \nleftShift assembly  : success\n", test_args[4], Assembler.assemble(test_args)[4]);
        }

        if(Assembler.assemble(test_args)[5].equals("1101011001111100") != true) {
            throw new Exception("rightShift assembly  : failed");
        }
        else {
            System.out.printf("%s -> %s \nrightShift assembly  : success\n", test_args[5], Assembler.assemble(test_args)[5]);
        }

        System.out.println();
    }

    // Test Cases for Math operations
    public static void assemble_alu_2() throws Exception {
        String[] test_args = {"add R1 R2 R3", "subtract R2 R3 R4", "multiply R3 R4 R5"};

        if(Assembler.assemble(test_args)[0].equals("1110000100100011") != true) {
            throw new Exception("add assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nadd assembly : success\n", test_args[0], Assembler.assemble(test_args)[0]);
        }

        if(Assembler.assemble(test_args)[1].equals("1111001000110100") != true) {
            throw new Exception("subtract assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nsubtract assembly : success\n", test_args[1], Assembler.assemble(test_args)[1]);
        }

        if(Assembler.assemble(test_args)[2].equals("0111001101000101") != true) {
            throw new Exception("multiply assembly : failed");
        }
        else {
            System.out.printf("%s -> %s \nmultiply assembly : success\n", test_args[2], Assembler.assemble(test_args)[2]);
        }

        System.out.println();
    }

    public static void runTest() throws Exception {
        System.out.println("Assembler Test ");

        assemble_computer_commands();
        assemble_alu_1();
        assemble_alu_2();

        System.out.println();
    }
}