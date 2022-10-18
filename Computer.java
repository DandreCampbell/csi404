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
            this.registers[i] = new Longword();
        }
    }

    /*
        Simulates that the computer is on and will run until 
        bit value(power_switch) is false; 
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
        Retrieves an the next longword or instruction from our
        simluated computer memory
    */
    public void fetch() {
        this.current_instruction = this.computer_memory.read(this.pc);
        this.pc = RippleAdder.add(this.pc, new Longword(2));
    }

    /*
        Retrives values from registers (op1 and op2) that will later 
        be used in the ALU
    */
    public void decode() {
        this.op1 = op_mask(this.current_instruction);
        this.op2 = op_mask(this.current_instruction);
    }
    
    /*
        Passes 2 operation values (op1 and op2) and operation code that
        will choose what process is done with the ALU. The answer is 
        copied into "result"
    */
    public void execute() {
        Bit[] operation = new Bit[4];
        
        for(int i = 3; i >= 0; i--) {
            operation[i] = this.opcode.getBit(i);
        }
        this.result = ALU.doOp(operation, this.op1, this.op2);
    }

    /*
        Copies the value from the result into the register
    */
    public void store() {
        this.registers[this.current_instruction.getSigned()] = this.result;
    }

    /*
        Shifts and masks the 2 operation values 
    */
    public Longword op_mask(Longword instruction) {
        Longword mask = instruction.rightShift(4);
        return mask.and(new Longword(15));
    }

    /*
        Stops the computer from running 
    */
    public void halt() {
        this.power_switch.clear();
    }

    /*
        Allows computer to set the value of any register
    */
    public void move(Longword address, Longword value) {
        this.registers[address.getSigned()] = value;
    }

    /*
        Temporarily interrupts the program to print all the 
        current registers
    */
    public void interrupt_0() {
        System.out.println("Current Registers");
        for(int i = 0; i < this.registers.length; i++) {
            System.out.println(this.registers[i].toString());
        }
    }

    /*
        Temporarily interrupts the progam to print all 1024 
        bytes of memory to the screen
    */
    public void interrupt_1() {
        System.out.println("1024 Bytes Stored in Memory");
        System.out.println(this.computer_memory.toString());
    }

    /*
        M 
    */
    public void preload(String[] bits) {
        Longword output = new Longword();
        String[] longword = {""};
        int i;

        // Breaks the bits string array into 4 seperate strings
        for(i = 0; i < bits.length; i++) {
            longword[i] += bits[i].split(" ");
        }
        /* 
        for(i = 0; i < 4; i++) {
            if(longword[0] == "1") {
                output.setBit(i, new Bit(true));
            }
        }
        */
        // need to find out how to determine "write" address
        this.computer_memory.write(op1, output);
    }
}