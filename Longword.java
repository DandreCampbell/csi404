public class Longword {

    private Bit[] longword = new Bit[32];

    // Constructor used for new or empty longword array
    public Longword() {
        set(0);
    }

    // Constructor used for a user inputed longword array
    public Longword(int value) {
        set(value);
    }

    // Get bit at given index
    public Bit getBit(int index) {
        return this.longword[index];
    } 

    // Set Bit at given index with given value
    public void setBit(int index, Bit value) {
        this.longword[index] = value;   
    }   

    /*
        AND two longwords, returning a third   
        Iterate through Bit array and save result to new longword
    */
    public Longword and(Longword other_word) {
        Longword and = new Longword();
        for(int i = 0; i < this.longword.length; i++) {
            and.setBit(i, this.longword[i].and(other_word.getBit(i)));
        }
        return and;
    } 

    /*
        OR two longwords, returning a third   
        Iterate through Bit array and save result to new longword
    */
    public Longword or(Longword other_word) {
        Longword or = new Longword();
        for(int i = 0; i < this.longword.length; i++) {
            or.setBit(i, this.longword[i].or(other_word.getBit(i)));
        }
        return or;
    } 

    /*
        XOR two longwords, returning a third   
        Iterate through Bit array and save result to new longword
        Only false if both words have same value
    */
    public Longword xor(Longword other_word) {
        Longword xor = new Longword();
        for(int i = 0; i < this.longword.length; i++) {
            xor.setBit(i, this.longword[i].xor(other_word.getBit(i)));
        }
        return xor;
    } 
    
    /*
        Negate this Longword, creating another
        Iterate through Bit array and change value of each bit
    */
    public Longword not() {
        Longword not = new Longword();
        for(int i = 0; i < this.longword.length; i++) {
            not.setBit(i, this.longword[i].not());
        }
        return not;
    } 

    /*
        Rightshift this longword by amount bits, creating a new longword
    */
    public Longword rightShift(int amount) {
        Longword rightShift = new Longword();
        for(int i = 0; i + amount < this.longword.length; i++) {
            rightShift.setBit(i, this.longword[i + amount]);
        }
        return rightShift;
    } 

    /*
        Leftshift this longword by amount bits, creating a new longword
    */
    public Longword leftShift(int amount) {
        Longword leftShift = new Longword();
        for(int i = 0; i + amount < this.longword.length; i++) {
            leftShift.setBit(i + amount, this.longword[i]);
        }
        return leftShift;
    } 

    /*
        Returns a comma separated string of 0's and 1's: "0,0,0,0,0 (etc.)" for example
    */
    @Override
    public String toString() {
        String output = "";
        for(int i = 31; i >= 0; i--) {
            if(this.longword[i].getValue() == true) {
                output += "t,";
            }
            else if(this.longword[i].getValue() == false) {
                output += "f,";
            }
        }
        return output;
    } 

    /*
        Iterates through longword and returns the value as a long
    */
    public long getUnsigned() {
        long unsigned = 0L;

        // Iterates through list and converts to decimal
        for(int i = 31; i >= 0; i--) {
            if(this.longword[i].getValue() == true) {
                unsigned +=  Math.pow(2, i);
            }
        }
        return unsigned;
    } 

    /*
        Iterates through longword and returns the value as an int
    */
    public int getSigned() {
        int signed = 0;

        // Iterates through list and converts to decimal
        for(int i = 31; i >= 0; i--) {
            if(this.longword[i].getValue() == true) {
                signed += Math.pow(2, i);
            }
        }
        return signed;
    } 

    /*
        Copies the values of the bits from another longword into this one
    */
    public void copy(Longword other) {
        for(int i = 0; i < this.longword.length; i++) {
            this.setBit(i, other.getBit(i));
        }
    } 

    /*
        Set the value of the bits of this longword (used for tests)
    */
    public void set(int value) {
        int[] binary = new int[this.longword.length];
        int temp = value;

        // Convert value to binary
        int i = 0;
        while(value > 0) {
            binary[i] = value % 2;
            value /= 2;
            i++;
        }

        // Assign boolean value to each bit in longword
        for(int j = 31; j >= 0; j--) {
            if(binary[j] == 1) {
                this.longword[j] = new Bit(true);
            }
            else if(binary[j] == 0) {
                this.longword[j] = new Bit(false);
            }
        }

        // If value is negative
        if(temp < 0) {
            Longword a = not();
            for(int j = 0; j < 31; j++) {
                this.longword[j] = a.getBit(j);
            }
            this.longword[0] = new Bit(true);
        }
    } 
}

