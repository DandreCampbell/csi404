public class Memory {

    // bit array - 1024 bytes or 8192 bits
    private Bit[] storage = new Bit[8192];
    private final int bit_group = 4;

    public Memory() {
        for(int i = 0; i < 8192; i++) {
            storage[i] = new Bit();
        }
    }

    public Longword read(Longword address) {
        Longword read = new Longword();

        for(int i = 0; i < 8; i++) {
            read.setBit(i, storage[address.getSigned() * i]);
        }

        return read;
    }

    public void write(Longword address, Longword value) {
        for(int i = 0; i < 8; i++) {
            storage[value.getSigned() * i] = address.getBit(i);
        }
    }

    @Override
    public String toString() {
        String output = "";

        for(int i = 0; i < 1024; i++) {
            
        }

        return output;
    }
}