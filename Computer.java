public class Computer {

    private Memory computer_memory = new Memory();
    private Bit power_switch = new Bit();
    private Longword pc = new Longword();
    private Longword current_instruction = new Longword();
    private Longword registers[] = new Longword[16];
    private Longword opcode = new Longword();
    private Longword op1 = new Longword();
    private Longword op2 = new Longword();
    private Longword result = new Longword();
    private Longword result_address = new Longword();
    private Longword SP = new Longword(1020);

    // Main operations
    private Bit[] halt_command = {new Bit(), new Bit(), new Bit(), new Bit()}; //0000
    private Bit[] move_command = {new Bit(), new Bit(), new Bit(), new Bit(true)}; //0001
    private Bit[] interrupt_command = {new Bit(), new Bit(), new Bit(true), new Bit()}; //0010
    private Bit[] jump_command = {new Bit(), new Bit(), new Bit(true), new Bit(true)}; //0011

    // Stack operations
    private Bit[] stack_command = {new Bit(), new Bit(true), new Bit(true), new Bit()}; //0110
    private Bit[] push_command = {new Bit(), new Bit(), new Bit(), new Bit()};
    private Bit[] pop_command = {new Bit(), new Bit(true), new Bit(), new Bit()};
    private Bit[] call_command = {new Bit(true), new Bit(), new Bit(), new Bit()};
    private Bit[] return_command = {new Bit(true), new Bit(true), new Bit(), new Bit()};

    /*
       Start computer with empty registers
    */
    public Computer() {
        for(int i = 0; i < this.registers.length; i++) {
            this.registers[i] = new Longword();
        }
    }

    /*
        Simulates that the computer is on and will run until a
        bit value(power_switch) is false; 
    */
    public void run() {
        this.power_switch.set();
        while(power_switch.getValue() == true) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    /*
        Retrieves the next Longword or instruction from our
        simulated computer memory
    */
    public void fetch() {
        this.current_instruction = this.computer_memory.read(this.pc);
        this.current_instruction = this.current_instruction.leftShift(8);
        this.pc = RippleAdder.add(this.pc, new Longword(1));
        this.current_instruction = RippleAdder.add(this.computer_memory.read(this.pc), this.current_instruction);
        this.pc = RippleAdder.add(this.pc, new Longword(1));
    }

    public void decode() {
        this.opcode = opcode_mask(this.current_instruction);
        this.op1 = op1_mask(this.current_instruction);
        this.op2 = op2_mask(this.current_instruction);
        this.result_address = result_mask(this.current_instruction);
    }

    /*
        Masking for opcode
    */
    public Longword opcode_mask(Longword instruction) {
        Longword opcode_mask = instruction.rightShift(12);
        return opcode_mask.and(new Longword(15));
    }

    /*
        Masking for op1
    */
    public Longword op1_mask(Longword instruction) {
        Longword op1_mask = instruction.leftShift(20).rightShift(28);
        return op1_mask.and(new Longword(15));
    }

    /*
        Masking for op2
    */
    public Longword op2_mask(Longword instruction) {
        Longword op2_mask = instruction.leftShift(24).rightShift(28);
        return op2_mask.and(new Longword(15));
    }

    /*
        Masking for result
    */
    public Longword result_mask(Longword instruction) {
        Longword result_mask = instruction.leftShift(28).rightShift(28);
        return result_mask.and(new Longword(15));
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

        Bit[] second_operation = new Bit[4];
        for(int j = 0; j < 4; j++) {
            second_operation[j] = this.op1.getBit(j);
        }

        if(opcode_compare(operation, halt_command) == true) {
            halt();
        }
        else if(opcode_compare(operation, interrupt_command) == true) {
            if(this.result_address.getBit(0).getValue() == true) {
                interrupt_1();
            }
            else if(this.result_address.getBit(0).getValue() == false) {
                interrupt_0();
            }
        }
        else if(opcode_compare(operation, move_command) == true) {
            Longword value = RippleAdder.add(this.op2, this.result);
            move(this.op1, value);
        }
        else if(opcode_compare(operation, stack_command)) { // SP operations
            if(opcode_compare(second_operation, push_command)) {
                push_stack(this.result_address);
            }
            else if(opcode_compare(second_operation, pop_command)) {
                pop_stack(this.result_address);
            }
            else if(opcode_compare(second_operation, call_command)) {
                call_stack(this.result_address);
            }
            else if(opcode_compare(second_operation, return_command)) {
                return_stack();
            }
        }
        else {
            System.out.println("Booting ALU:");
            this.result = ALU.doOp(operation, this.op1, this.op2);
        }
    }

    /*
        Copies the value from the result into the register
    */
    public void store() {
        Bit[] operation = new Bit[4]; // First 4 for bits of opcode
        for(int i = 0; i < 4; i++) {
            operation[i] = this.opcode.getBit(i);
        }

        if(opcode_compare(operation, jump_command)) {
            int amount = 0;

            for(int i = 0; i < 4; i++) {
                if(result_address.getBit(i).getValue() == true) {
                    amount += Math.pow(2, i);
                }
            }
            this.pc = RippleAdder.add(this.pc, new Longword(amount));
        }

        this.registers[this.result_address.getSigned()] = this.result;
    }

    /*
        Temporarily interrupts the program to print all the
        current registers
    */
    public void interrupt_0() {
        System.out.println("Current Registers:");
        for(int i = 0; i < this.registers.length; i++) {
            System.out.printf("%s - %d \n", this.registers[i].toString(), i);
        }
    }

    /*
        Temporarily interrupts the program to print all 1024
        bytes of memory to the screen
    */
    public void interrupt_1() {
        System.out.printf("1024 Bytes Stored in Memory: %s\n", this.computer_memory.toString());
    }

    /*
        Allows computer to set the value of any register
    */
    public void move(Longword address, Longword value) {
        this.registers[address.getSigned()] = value;
        System.out.printf("Moving %d to R%d \n", value.getSigned(), address.getSigned());
    }

    /*
        Stops the computer from running
    */
    public void halt() {
        this.power_switch.clear();
        System.out.println("Halted...");
    }

    /*
        Moves the pc from its current address to the inputted one
    */
    public void jump(Longword address) {
        if(address.getSigned() > 15) {
            System.out.println("Not a valid address.");
        }

        this.pc = address;
        System.out.printf("Jumping to Instruction %d\n", this.pc.getSigned());
    }

    /*
        Pushes values from selected register address into computer memory. Push doesn’t
        change the register that it is copying from
    */
    public void push_stack(Longword address) {
        Longword push = this.registers[address.getSigned()];
        Longword[] write = new Longword[]{new Longword(), new Longword(), new Longword(), new Longword()};
        int i;

        for(i = 0; i < 8; i++) {
            write[0].setBit(i, push.getBit(i + 24));
        }
        this.computer_memory.write(this.SP, write[0]);

        for(i = 0; i < 8; i++) {
            write[1].setBit(i, push.getBit(i + 16));
        }
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(1)), write[1]);

        for(i = 0; i < 8; i++) {
            write[2].setBit(i, push.getBit(i + 8));
        }
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(2)), write[2]);

        for(i = 0; i < 8; i++) {
            write[3].setBit(i, push.getBit(i));
        }
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(3)), write[3]);

        this.SP = RippleAdder.subtract(SP, new Longword(4));
        System.out.println("Pushing to Stack.");
    }

    /*
        Pops values from computer memory into selected register address
    */
    public void pop_stack(Longword address) {
        Longword pop = new Longword();
        this.SP = RippleAdder.add(this.SP, new Longword(4));
        Longword[] read = new Longword[]{new Longword(), new Longword(), new Longword(), new Longword()};

        read[0] = this.computer_memory.read(this.SP).leftShift(24);
        this.computer_memory.write(this.SP, new Longword());

        read[1] = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(1))).leftShift(16);
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(1)), new Longword());

        read[2] = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(2))).leftShift(8);
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(2)), new Longword());

        read[3] = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(3)));
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(3)), new Longword());

        pop = RippleAdder.add(read[1], read[2]);
        pop = RippleAdder.add(pop, read[3]);

        this.registers[address.getSigned()] = pop;
        System.out.println("Popping Stack.");
    }

    /*
        Pushes the address of the next instruction after the call onto the SP. Is a
        combination of push and jump.
    */
    public void call_stack(Longword address) {
        Longword temp = this.pc;
        Longword called_pc = this.op2.leftShift(4);

        called_pc = RippleAdder.add(address, called_pc);
        called_pc.setBit(8, this.op1.getBit(0));
        called_pc.setBit(9, this.op1.getBit(1));

        this.pc = called_pc;

        Longword[] binary = new Longword[]{new Longword(), new Longword(), new Longword(), new Longword()};
        for(int i = 0; i < 8; i++) {
            binary[0].setBit(i, temp.getBit(i + 24));
            binary[1].setBit(i, temp.getBit(i + 16));
            binary[2].setBit(i, temp.getBit(i + 8));
            binary[3].setBit(i, temp.getBit(i));
        }

        this.computer_memory.write(this.SP, binary[0]);
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(1)), binary[1]);
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(2)), binary[2]);
        this.computer_memory.write(RippleAdder.add(this.SP, new Longword(3)), binary[3]);

        this.SP = RippleAdder.subtract(this.SP, new Longword(4));
        System.out.printf("Calling PC %d \n", address.getSigned());
    }

    /*
        Pops the return address from the SP and moves it into PC. Is a
        combination of pop and jump.
     */
    public void return_stack() {
        this.SP = RippleAdder.add(this.SP, new Longword(4));
        Longword return_value = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(1)));

        return_value = return_value.leftShift(8);
        return_value = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(2)));

        return_value = return_value.leftShift(8);
        return_value = this.computer_memory.read(RippleAdder.add(this.SP, new Longword(3)));

        for(int i = 0; i < 8; i++) {
            return_value.setBit((i + 24), this.computer_memory.read(this.SP).getBit(i));
        }

        this.pc = return_value;
        System.out.println("Returning.");
    }

    /*
        Helper method to compare 2 bit arrays
    */
    public boolean opcode_compare(Bit[] a, Bit[] b) {
        if(a[0].getValue() == b[0].getValue()) {
            if(a[1].getValue() == b[1].getValue()) {
                if(a[2].getValue() == b[2].getValue()) {
                    if(a[3].getValue() == b[3].getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
        Converts the strings from an array into Longwords
        and writes them to memory.
    */
    public 	void preload(String[] bits) {
        String[] instructions = new String[bits.length];
        Longword value = new Longword();
        int i, j, address = 0;

        System.out.println("Preloading:");

        // Gets rid of spaces in each string of the bits array
        for(i = 0; i < bits.length; i++) {
            instructions[i] = bits[i].replaceAll(" ", "");
            System.out.println(instructions[i]);
        }

        // Turn each string into a Longword and writes it to memory
        for(i = 0; i < instructions.length; i++) {
            for(j = 0; j < 16; j++) {
                if(instructions[i].charAt(15 - j) == '1') {
                    value.setBit(j, new Bit(true));
                }
                else {
                    value.setBit(j, new Bit(false));
                }
            }

            this.computer_memory.write(new Longword(address), value); // write the first 8 bits to memory
            //System.out.printf("%d %d %s\n", address, this.computer_memory.read(new Longword(address)).getSigned(), this.computer_memory.read(new Longword(address)).toString());

            this.computer_memory.write(new Longword(address + 1), value.rightShift(8)); // writes the second set of 8 to memory
            //System.out.printf("%d %d %s\n", (address + 1), this.computer_memory.read(new Longword(address + 1)).getSigned(), this.computer_memory.read(new Longword(address + 1)).toString());

            address += 2;
        }
    }
}