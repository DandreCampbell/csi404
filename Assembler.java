public class Assembler {

    //public static final String[] keywords = {"move", "halt", "interrupt"};

    public static String[] assemble(String[] instructions) {
        String[] output = new String[instructions.length];

        for(int i = 0; i < instructions.length; i++) {
            String[] command = instructions[i].split(" ");

            if(command[0].equalsIgnoreCase("move")) {
                output[i] = "0001";
                output[i] += get_register(command[1]);
                output[i] += get_value(command[2]); // last 8 bits / value to be moved to an address
            }
            else if(command[0].equalsIgnoreCase("halt")) {
                output[i] = "0000000000000000";
            }
            else if(command[0].equalsIgnoreCase("interrupt")) {
                if(command[1].equals("0")) {
                    output[i] = "0010000000000000";
                }
                else if(command[1].equals("1")) {
                    output[i] = "0010000000000001";
                }
            }
        }
        
        return output;
    }

    /*
        Helper method for the move command.
        Returns the register address for as a 4 bit string.
    */
    public static String get_register(String arg) {
        String output = "";
        String temp_register = arg.replaceAll("R", "");
        int address = Integer.parseInt(temp_register);

        // Must be within range of 16 possible registers
        if(address > 15) {
            output = "Address is out of range.";
        }

        // Converts address to a binary array
        int[] binary = new int[4];
        int i = 0;
        while(address > 0) {
            binary[i] = address % 2;
            address /= 2;
            i++;
        }

        // Converts binary array to a string
        for(i = 3; i >= 0; i--) {
            if(binary[i] == 1) {
                output += "1";
            }
            else if(binary[i] == 0) {
                output += "0";
            }
        }

        return output;
    }

    /*
        Helper method for move command.
        Returns the value that'll be stored in a register
        as an 8 bit string.
    */
    public static String get_value(String arg) {
        String output = "";
        int temp_value = Integer.parseInt(arg);
        int[] binary = new int[8];

        // Converts decimal value to a binary array
        int i = 0;
        while(temp_value > 0) {
            binary[i] = temp_value % 2;
            temp_value /= 2;
            i++;
        }

        // Converts binary array to a string
        for(i = 7; i >= 0; i--) {
            if(binary[i] == 1) {
                output += "1";
            }
            else if(binary[i] == 0) {
                output += "0";
            }
        }

        return output;
    }
}
