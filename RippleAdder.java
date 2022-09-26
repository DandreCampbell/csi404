public class RippleAdder {
    
    /* 
        Iterates through both longwords and adds their values into a new result
    */
    public static Longword add(Longword a, Longword b) {
        Longword result = new Longword();
        Bit carry = new Bit(false);

        for(int i = 31; i >= 0; i--) {
            result.setBit(i, a.getBit(i).xor(b.getBit(i)).xor(carry));
            carry = a.getBit(i).and(b.getBit(i)).or(carry.and(a.getBit(i).xor(b.getBit(i))));
        }
        return result;
    }
    
    /* 
        Iterates through both longwords and subtracts their values in a new result
    */
    public static Longword subtract(Longword a, Longword b) {
        Longword result = add(a, add(b.not(), new Longword(1)));

        return result;
    }
}
