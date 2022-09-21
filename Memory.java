public class Memory {

    private Bit[] storage = new Bit[1024];

    public Memory() {
        for(int i = 0; i < 1024; i++) {
            storage[i] = new Bit(false);
        }
    }

    public Longword read(Longword address) {
        Longword read = new Longword();


        return read;
    }

    public void write(Longword address, Longword value) {

    }
}