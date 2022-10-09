public class Memory {

    // bit array - 1024 bytes or 8192 bits
    private Bit[] storage = new Bit[8192];

    public Memory() {
        for(int i = 0; i < 8192; i++) {
            this.storage[i] = new Bit(true);
        }
    }

    /*
        Reads the bits stores in "memory"
    */
    public Longword read(Longword address) {
        Longword read = new Longword();

        for(int i = 0; i < 8; i++) {
            read.setBit(i, this.storage[address.getSigned() * i]);
        }
        return read;
    }
    
    /*
        writes news bites into "memory"
    */
    public void write(Longword address, Longword value) {
        for(int i = 0; i < 8; i++) {
            this.storage[address.getSigned() * i] = value.getBit(i);
        }
    }

    /*
        Returns storage as a string value
    */
    @Override
    public String toString() {
        String output = "";

        for(int i = 0; i < 1024; i++) {
            if(this.storage[i].getValue() == true) {
                output += "t";
            }
            else if(this.storage[i].getValue() == false) {
                output += "f";
            }
        }
        return output;
    }
}