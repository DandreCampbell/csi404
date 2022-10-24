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
    private Longword result_address = new Longword();

    Bit[] halt_command = {new Bit(false), new Bit(false), new Bit(false), new Bit(false)};
    Bit[] move_command = {new Bit(false), new Bit(false), new Bit(false), new Bit(true)};
    Bit[] interrupt_command = {new Bit(false), new Bit(false), new Bit(true), new Bit(false)};

    /*
        Start computer with an empty register 
    */
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
        Retrives values from registers that will later be used in the ALU
    */
    public void decode() {
        this.opcode = opcode_mask(this.current_instruction);
        this.op1 = op1_mask(this.current_instruction);
        this.op2 = op2_mask(this.current_instruction);
        this.result_address = result_mask(this.current_instruction);
    }
    
    /*
        Passes 2 operation values (op1 and op2) and operation code that
        will choose what process is done with the ALU. The answer is 
        copied into "result"
    */
    public void execute() {
        Bit[] operation = new Bit[4]; // First 4 for bits of opcode

        for(int i = 0; i < 4; i++) {
            operation[i] = this.opcode.getBit(i);
        }

        if(operation.equals(halt_command)) {
            System.out.println("Turning off...");
            halt();
        }
        else if(operation.equals(interrupt_command)) {
            if(this.opcode.getBit(15).getValue() == true) {
                interrupt_1();
            }
            else if(this.opcode.getBit(15).getValue() == false) {
                interrupt_0();
            }
        }
        else if(operation.equals(move_command)) {
            move(this.op1, new Longword());
        }

        this.result = ALU.doOp(operation, this.op1, this.op2);
    }

    /*
        Copies the value from the result into the register
    */
    public void store() {
        System.out.println("Storing...");
        this.registers[this.result_address.getSigned()] = this.result;
    }

    /*
        Masking for opcode
    */
    public Longword opcode_mask(Longword instruction) {
        Longword mask = instruction.rightShift(4);
        return mask.and(new Longword(15));
    }    

    /*
        Masking for op1
    */
    public Longword op1_mask(Longword instruction) {
        Longword mask = instruction.rightShift(8);
        return mask.and(new Longword(15));
    }

    /*
        Masking for op2 
    */
    public Longword op2_mask(Longword instruction) {
        Longword mask = instruction.rightShift(12);
        return mask.and(new Longword(15));
    }

    /*
        Masking for result address 
    */
    public Longword result_mask(Longword result) {
        Longword mask = result.rightShift(16);
        return mask.and(new Longword(15));
    }

    /*
        Stops the computer from running 
    */
    public void halt() {
        this.power_switch.clear();
        System.out.println("Halted...");
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
        System.out.println("Current Registers:");
        for(int i = 0; i < this.registers.length; i++) {
            System.out.println(this.registers[i].toString());
        }
    }

    /*
        Temporarily interrupts the progam to print all 1024 
        bytes of memory to the screen
    */
    public void interrupt_1() {
        System.out.printf("1024 Bytes Stored in Memory: \n%s\n", this.computer_memory.toString());
    }

    /*
        Converts the strings from an array into Longwords
        and writes them to memory. 
    */
    public void preload(String[] bits) {
        String[] longword = new String[bits.length];
        Longword value = new Longword();
        int i, j, address = 0;

        System.out.println("Preloading...");

        // Gets rid of spaces in each string of the bits array
        for(i = 0; i < bits.length; i++) {
            longword[i] = bits[i].replaceAll(" ", "");
            System.out.println(longword[i]);
        }
        
        // Turn each string into a Longword and writes it to memory
        for(i = 0; i < longword.length; i++) {
            for(j = 0; j < 16; j++) {
                if(longword[i].charAt(15 - j) == '1') {
                    value.setBit(j, new Bit(true));
                }
                else {
                    value.setBit(j, new Bit(false));
                }
            }
            this.computer_memory.write(new Longword(address), value);
            address += 4;
        }
    }
}