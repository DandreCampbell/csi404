public class MemoryTest {

    public static void runTests() throws Exception {
        Memory mem = new Memory();
        
        mem.write(new Longword(), new Longword());
        System.out.println(mem.read(new Longword(100)).toString());
    }
}