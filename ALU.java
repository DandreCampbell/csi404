public class ALU {
    
    // For some reason, it works when comparing string values but not bit array values
    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        /* 
            Choice based on decimal value of Bit[] operation
            8: and(), 9: or(), 10: xor(), 11: not(), 12: leftShift()
            13: rightShift(), 14: add(), 15: subtract(), 16: multiply()
        */
        if(toString(operation).equals(toString(bit_conversion(8)))) {
            return a.and(b);
        }
        else if(toString(operation).equals(toString(bit_conversion(9)))) {
            return a.or(b);
        }
        else if(toString(operation).equals(toString(bit_conversion(10)))) {
            return a.xor(b);
        }
        else if(toString(operation).equals(toString(bit_conversion(11)))) {
            return a.not();
        }
        else if(toString(operation).equals(toString(bit_conversion(12)))) {
            return a.leftShift(bit_shift(b));
        }
        else if(toString(operation).equals(toString(bit_conversion(13)))) {
            return a.rightShift(bit_shift(b));
        }
        else if(toString(operation).equals(toString(bit_conversion(14)))) {
            return RippleAdder.add(a, b);
        }
        else if(toString(operation).equals(toString(bit_conversion(15)))) {
            return RippleAdder.subtract(a, b);
        }
        else if(toString(operation).equals(toString(bit_conversion(7)))) {
            return Multiplier.multiply(a, b);
        }
        
        /*
        if(bit_compare(operation, 8) == true) {
            result = a.and(b);
            return result;
        }
        
        else if(bit_compare(operation, 9)  == true) {
            result = a.or(b);
        }
        else if(bit_compare(operation, 10) == true) {
            result = a.xor(b);
        }
        else if(bit_compare(operation, 11) == true) {
            result = a.not();
        }
        //  “a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 12) == true) {
            result = a.leftShift(bit_shift(b));
        }
        //“a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(bit_compare(operation, 13) == true) {
            result = a.rightShift(bit_shift(b));
        }
        else if(bit_compare(operation, 14) == true) {
            result = RippleAdder.add(a, b);
        }
        else if(bit_compare(operation, 15) == true) {
            result = RippleAdder.subtract(a, b);
        }
        else if(bit_compare(operation, 7) == true) {
            result = Multiplier.multiply(a, b);
        }
        */

        return new Longword();
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
        /* 
        for(int i = 0; i < 4; i++) {
            if(bit_conversion(value)[i].equals(operation[i])) {
                return true;
            }
        }  
        */
        if(operation.equals(bit_conversion(value))) {
            return true;
        }
        return false;
    }

    /*
        Returns the decimal value of the last 5 bits 
        in a longword  
    */
    public static int bit_shift(Longword b) {
        int shift = 0;
        for(int i = 15; i >= 11; i--) {
            if(b.getBit(i).getValue() == true) {
                shift += (int) Math.pow(2, i);
            }
        }

        return shift;
    }

    /*
        Gets the 4 bit boolean value of "operation" and returns
        it as a string
    */
    public static String toString(Bit[] operation) {
        String output = "";
        for(int i = 3; i >= 0; i--) {
            output += operation[i].toString();
        }

        return output;
    }
}
