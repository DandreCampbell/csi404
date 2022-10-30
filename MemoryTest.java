public class MemoryTest {

    /*
        Test Case for Memory 

        Add a Longword to a set address. We then pull that Longword from that address 
        and compare it to our expected Longword's binary string.
    */
    public static void runTests() {
        System.out.println("Memory Test: ");
        Memory computer_memory = new Memory();

        String output = "";
        try {
            output = "f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,"; // 0 in binary
            computer_memory.write(new Longword(), new Longword());
            if(computer_memory.read(new Longword(0)).toString().equals(output)) {
                System.out.println("write() - Success");
                System.out.println("read() - Success");
            }

            output = "f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,"; // 1 in binary
            computer_memory.write(new Longword(1), new Longword(1));
            if(computer_memory.read(new Longword(1)).toString().equals(output)) {
                System.out.println("write() - Success");
                System.out.println("read() - Success");
            }

            output = "f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t,f,"; // 10 in binary
            computer_memory.write(new Longword(2), new Longword(10));
            if(computer_memory.read(new Longword(2)).toString().equals(output)) {
                System.out.println("write() - Success");
                System.out.println("read() - Success");
            }
        }
        catch(Exception e) {
            System.out.println("MemoryTest - Failed");
            e.printStackTrace();
        }

        System.out.println();
    }
}