public class ALU {
    
    /* 
        Creates a bit array to be used as a comparison
        in doOp()
    */
    public static Bit[] bit_compare(int value) {
        Bit[] bits = new Bit[4];

        for(int i = 3; i >= 0; i--) {
            if(value % 2 == 1) {
                bits[i] = new Bit(true);
            }
            else {
                bits[i] = new Bit(false);
            }
            value /= 2;
        }
        return bits;
    }

    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        /* 
            Choice based on decimal value of Bit[] operation
            8: and, 9: or, 10: xor, 11: not, 12: leftShift
            13: rightShift, 14: add, 15: subtract, 16: multiply 
        */
        if(operation.equals(bit_compare(8))) {
            return a.and(b);
        }
        else if(operation.equals(bit_compare(9))) {
            return a.or(b);
        }
        else if(operation.equals(bit_compare(10))) {
            return a.xor(b);
        }
        else if(operation.equals(bit_compare(11))) {
            return a.not();
        }
        //  “a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(operation.equals(bit_compare(12))) {
            return a.leftShift(b.getSigned());
        }
        //“a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(operation.equals(bit_compare(13))) {
            return a.rightShift(b.getSigned());
        }
        else if(operation.equals(bit_compare(14))) {
            return RippleAdder.add(a, b);
        }
        else if(operation.equals(bit_compare(15))) {
            return RippleAdder.subtract(a, b);
        }
        else if(operation.equals(bit_compare(16))) {
            return Multiplier.multiply(a, b);
        }

        return new Longword();
    }
}
