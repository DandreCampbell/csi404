public class Computer {

    Bit on_switch = new Bit();
    private Memory mem = new Memory();
    Longword pc = new Longword();
    Longword currentInstruction = new Longword();

    public Computer() {

    }

    /*
        Simulates that computer is on and will run until 
        bit value is false; 
    */
    public void run() {

        while(on_switch.getValue() == true) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    public void fetch() {
        this.currentInstruction = this.mem.read(pc);
        this.pc = RippleAdder.add(pc, new Longword(2));
    }

    public void decode() {

    }
    
    public void execute() {

    }

    public void store() {

    }
}