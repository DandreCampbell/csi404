public class MemoryTest {

    public static void runTests() throws Exception {
        Memory mem = new Memory();
        mem.write(new Longword(), new Longword());

        if(mem.read(new Longword(100)).equals(null)) {

        }

        System.out.println();
    }
}