public class Assembler {
    
    public static String[] assemble(String[] args) {
        String[] output = {""};
        
        return output;
    }

    public static void lexing() {

    }

    public static void parsing() {

    }

    public static Bit[] bit_pattern(Longword register_name) {
        Bit[] pattern = new Bit[4];

        for(int i = 4; i >= 0; i--) {
            if(register_name.getBit(i).getValue() == true) {
                pattern[i].set(true);
            }
            else if(register_name.getBit(i).getValue() == false) {
                pattern[i].set(false);
            }
        }

        
        return pattern;
    }
}
