public class MemoryTest {

    /*
        Test Case for Memory 
    */
    public static void runTests() throws Exception {
        Memory mem = new Memory();
        try {
            mem.write(new Longword(), new Longword());
            if(mem.read(new Longword(0)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,")) {
                System.out.println("write() - Success");
                System.out.println("read() - Success");
            }
        }
        catch(Exception e) {
            System.out.println("Failed");
        }
    }
}