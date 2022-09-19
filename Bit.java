public class Bit {

	private boolean bit_value; // value of a bit

	// Constructor defaults bit value to false
	public Bit() {
		bit_value = false;
	}

	// Constructor that allows you to set the bit's value at creation
	public Bit(boolean value) {
		bit_value = value;
	}

	// Sets the value of the bit
	public void set(boolean bit_value) {
		this.bit_value = bit_value;
	}

	// Changes the value from true to false or false to true
	public void toggle() {
		if(bit_value == true) {
			bit_value = false;
		}
		else if(bit_value == false) {
			bit_value = true;
		}
	} 

	// Sets the bit to true
	public void set() {
		bit_value = true;
	} 

	// Sets the bit to false
	public void clear() {
		bit_value = false;
	}

	// Returns the current value
	public boolean getValue() {
		return bit_value;
	} 

	// Performs and on two bits and returns a new bit set to the result
	// Both bit values must be true for the new bit to be true
	public Bit and(Bit other_bit) {

		if(bit_value == true) {
			if(other_bit.getValue() == true) {
				return new Bit(true);
			}
		}
		return new Bit();
	}

	// Performs or on two bits and returns a new bit set to the result
	// One of the bit values must be true for the new bit to be true
	public Bit or(Bit other_bit) {
		if(bit_value == true) {
			return new Bit(true);
		}
		else if(other_bit.getValue() == true) {
			return new Bit(true);
		}
		return new Bit(false);
	}

	// Performs xor on two bits and returns a new bit set to the result
	// Either bit values can be true but not both
	public Bit xor(Bit other_bit) {
		if(bit_value == other_bit.getValue()) {
			return new Bit(false);
		}
		return or(other_bit);
	}

	// Performs not on the existing bit, returning the result as a new bit
	public Bit not() {
		if(bit_value == true) {
			return new Bit(false);
		}
		else if(bit_value == false) {
			return new Bit(true);
		}
		return new Bit(false);
	}

	// Returns “t” or “f” depending on bit_value
	@Override
	public String toString() {
		String output = "";

		if(bit_value == true) {
			output = "t";
		}
		else if(bit_value == false) {
			output = "f";
		}
		return output;
	}
}