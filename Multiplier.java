public class Multiplier {
    
	/*
	 	Iterates through both the longwords while using RippleAdder 
		to get the multiple of both longwords
	*/
    public static Longword multiply(Longword a, Longword b) {
        Longword result = new Longword();

        for(int i = 31; i >= 0; i--) {
			if(a.getBit(i).getValue() == true) {
				result = RippleAdder.add(result, b.leftShift(i));
			}
		}
        return result;
    }
}
