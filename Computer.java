public class Computer {

    private Bit power_switch = new Bit();
    private Memory computer_memory = new Memory();
    private Longword pc = new Longword();
    private Longword current_instruction = new Longword();
    private Longword[] registers = new Longword[16];
    private Longword opcode = new Longword();
    private Longword op1 = new Longword();
    private Longword op2 = new Longword();
    private Longword result = new Longword();

    public Computer() {
        for(int i = 0; i < 16; i++) {
            registers[i] = new Longword();
        }
    }

    /*
        Simulates that computer is on and will run until 
        bit value is false; 
    */
    public void run() {
        this.power_switch.set();
        while(this.power_switch.getValue() == true) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    /*
        M 
    */
    public void fetch() {
        this.current_instruction = this.computer_memory.read(this.pc);
        this.pc = RippleAdder.add(this.pc, new Longword(2));
    }

    /*
        M 
    */
    public void decode() {
        this.op1 = op_mask(this.current_instruction);
        this.op2 = op_mask(this.current_instruction);
    }
    
    /*
        M 
    */
    public void execute() {
        Bit[] operation = new Bit[4];
        
        for(int i = 3; i >= 0; i--) {
            operation[i] = this.opcode.getBit(i);
        }
        this.result = ALU.doOp(operation, this.op1, this.op2);
    }

    /*
        M 
    */
    public void store() {
        this.registers[current_instruction.getSigned()] = this.result;
    }

    /*
        M 
    */
    public Longword op_mask(Longword instruction) {
        Longword mask = instruction.rightShift(4);
        return mask.and(new Longword(15));
    }
}