public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Bit Test: ");
        BitTest.runTests();

        System.out.println("Longword Test: ");
        LongwordTest.runTests();
        
        System.out.println("RippleAdder Test: ");
        RippleAdderTest.runTest();
        /*
        System.out.println("Multiplier Test");
        MultiplierTest.runTest();

        System.out.println("ALU Test");
        ALUTest.runTest();
        */
    }
}
