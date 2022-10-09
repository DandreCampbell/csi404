public class MemoryTest {

    /*
        Test Case for Memory 
    */
    public static void runTests() throws Exception {
        Memory computer_memory = new Memory();
        try {
            computer_memory.write(new Longword(), new Longword());
            if(computer_memory.read(new Longword(0)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,")) {
                System.out.println("write() - Success");
                System.out.println("read() - Success");
            }
        }
        catch(Exception e) {
            System.out.println("Failed");
        }
    }
}