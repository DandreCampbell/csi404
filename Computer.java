public class Computer {

    Bit on_switch = new Bit();
    private Memory mem = new Memory();

    public Computer() {

    }

    public void run() {

        while(on_switch.getValue() == true) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    public void fetch() {

    }

    public void decode() {

    }
    
    public void execute() {

    }

    public void store() {

    }
}