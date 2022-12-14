public class ALU {

    /*
        Choice based on decimal value of Bit[] operation
        8: and(), 9: or(), 10: xor(), 11: not(), 12: leftShift()
        13: rightShift(), 14: add(), 15: subtract(), 16: multiply()
    */
    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        if(bit_compare(operation, 8)) {
            return a.and(b);
        }
        else if(bit_compare(operation, 9)) {
            return a.or(b);
        }
        else if(bit_compare(operation, 10)) {
            return a.xor(b);
        }
        else if(bit_compare(operation, 11)) {
            return a.not();
        }
        //  “a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 12)) {
            return a.leftShift(bit_shift(b));
        }
        //“a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 13)) {
            return a.rightShift(bit_shift(b));
        }
        else if(bit_compare(operation, 14)) {
            return RippleAdder.add(a, b);
        }
        else if(bit_compare(operation, 15)) {
            return RippleAdder.subtract(a, b);
        }
        else if(bit_compare(operation, 7)) {
            return Multiplier.multiply(a, b);
        }

        return new Longword();
    }

    /*
        Returns the decimal value of the last 5 bits
        in a Longword
    */
    public static int bit_shift(Longword b) {
        int shift = 0;
        for(int i = 0; i < 5; i++) {
            if(b.getBit(i).getValue() == true) {
                shift += (int) Math.pow(2, i);
            }
        }
        return shift;
    }

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
        if(operation[0].getValue() == bit_conversion(value)[0].getValue()) {
            if(operation[1].getValue() == bit_conversion(value)[1].getValue()) {
                if(operation[2].getValue() == bit_conversion(value)[2].getValue()) {
                    if(operation[3].getValue() == bit_conversion(value)[3].getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
