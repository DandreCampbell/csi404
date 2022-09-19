public class ALU {
    
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

        /*
        for(int i = 0; i < 4; i++) {
            if(bits[i].getValue() =)
        }
        */
        return bits;
    }

    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        int operation_value = 0;

        /* 
            Convert Bits to decimal value
        */
        for(int i = 0; i < 4; i++) {
            if(operation[i].getValue() == true) {
                operation_value += Math.pow(2, i);
            }
        }

        /* 
            Choice based on decimal value of Bit[] operation
        */
        if(operation_value == 8) {
            return a.and(b);
        }
        else if(operation_value == 9) {
            return a.or(b);
        }
        else if(operation_value == 10) {
            return a.xor(b);
        }
        else if(operation_value == 11) {
            return a.not();
        }
        //  “a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(operation_value == 12) {
            return a.leftShift(b.getSigned());
        }
        //“a” is the value to shift, “b” is the amount to shift it; ignore all but the lowest 5 bits
        else if(operation_value == 13) {
            return a.rightShift(b.getSigned());
        }
        else if(operation_value == 14) {
            return RippleAdder.add(a, b);
        }
        else if(operation_value == 15) {
            return RippleAdder.subtract(a, b);
        }
        else if(operation_value == 16) {
            return Multiplier.multiply(a, b);
        }
        else {
            System.out.println("Invalid number.");
        }
        return new Longword();
    }
}
