public class Multiplier {
    
    // Taken | Fix | https://github.com/jalvarezdelgado/Java-CPU/blob/main/multiplier.java
    
    public static Longword multiply(Longword a, Longword b) {
        Longword result = new Longword();

        for(int i = 0; i < 31; i++) {
			if(a.getBit(i).getValue() == true) {
				result = RippleAdder.add(result, b.leftShift(i));
			}
		}
		if(a.getBit(31).xor(b.getBit(31)).getValue() == true) {
			result.setBit(31, new Bit(true));
		}

        return result;
    }
}
