public class AssemblerTest {
    
    public static void test_assemble() throws Exception {

    }

    public static void test_lexing() throws Exception {

    }

    public static void test_parsing() throws Exception {

    }

    public static void test_pattern() throws Exception {
        Longword lw = new Longword();
        Bit[] test_pattern = new Bit[4]; 
        
        lw = new Longword(13); // ttft
        test_pattern[0] = new Bit(true);
        test_pattern[1] = new Bit(false);
        test_pattern[2] = new Bit(true);
        test_pattern[3] = new Bit(true);
        if(Assembler.bit_pattern(lw).equals(test_pattern)) {
            System.out.println("test_pattern() 1 - Success");
        }
        else {
            throw new Exception("test_pattern 1 - Failed");
        }

        lw = new Longword(7); // fttt
        test_pattern[0] = new Bit(true);
        test_pattern[1] = new Bit(true);
        test_pattern[2] = new Bit(true);
        test_pattern[3] = new Bit(false);
        if(Assembler.bit_pattern(lw).equals(test_pattern)) {
            System.out.println("test_pattern() 2 - Success");
        }
        else {
            throw new Exception("test_pattern 2 - Failed");
        }

    }

    public static void runTest() throws Exception {
        test_assemble();
        test_lexing();
        test_parsing();
        test_pattern();
    }
}
