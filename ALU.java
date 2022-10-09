public class ALU {
    
    /* 
        Creates a bit array from a given int value 
    */
    public static Bit[] bit_conversion(int value) {
        Bit[] bits = new Bit[4];
        int[] binary = new int[32];

        // Convert value to binary
        int i = 0;
        while(value > 0) {
            binary[i] = value % 2;
            value /= 2;
            i++;
        }

        // Assign boolean value to each bit in the array
        for(int j = 3; j >= 0; j--) {
            if(binary[j] == 1) {
                bits[j] = new Bit(true);
            }
            else if(binary[j] == 0) {
                bits[j] = new Bit(false);
            }
        }

        // Return bit array
        return bits;
    }
    
    /*
        Compares operation[] and the bit array created from 
        the given int value
    */
    public static boolean bit_compare(Bit[] operation, int value) {
        if(operation.equals(bit_conversion(value))) {
            return true;
        }
        return false;
    }


    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        Longword result = new Longword();
        int shift = 0;

        /* 
            Choice based on decimal value of Bit[] operation
            8: and(), 9: or(), 10: xor(), 11: not(), 12: leftShift()
            13: rightShift(), 14: add(), 15: subtract(), 16: multiply()
        */
        if(bit_compare(operation, 8)) {
            result = a.and(b);
        }
        else if(bit_compare(operation, 9)) {
            result = a.or(b);
        }
        else if(bit_compare(operation, 10)) {
            result = a.xor(b);
        }
        else if(bit_compare(operation, 11)) {
            result = a.not();
        }
        //  “a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 12)) {
            shift = 0;
            for(int i = 5; i >= 0; i--) {
                if(b.getBit(i).getValue() == true) {
                    shift = (int) Math.pow(2, i);
                }
            }
            result = a.leftShift(shift);
        }
        //“a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 13)) {
            shift = 0;
            for(int i = 5; i >= 0; i--) {
                if(b.getBit(i).getValue() == true) {
                    shift = (int) Math.pow(2, i);
                }
            }
            result = a.rightShift(shift);
        }
        else if(bit_compare(operation, 14)) {
            result = RippleAdder.add(a, b);
        }
        else if(bit_compare(operation, 15)) {
            result = RippleAdder.subtract(a, b);
        }
        else if(bit_compare(operation, 16)) {
            result = Multiplier.multiply(a, b);
        }
        
        return result;
    }

    public static String toString(Bit[] operation) {
        String output = "";
        for(int i = 3; i >= 0; i--) {
            output += operation[i].toString();
        }

        return output;
    }
}
