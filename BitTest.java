public class BitTest {

	// Test case for set(boolean)
	public static void test_setValue() throws Exception {
		Bit test = new Bit(false);
		
		test.set(true);
		if(test.getValue() != true) {
			throw new Exception("set(boolean) 1 - Failed");
		}
		else {
			System.out.println("set(boolean) 1 - Success");
		}

		test.set(false);
		if(test.getValue() != false) {
			throw new Exception("set(boolean) 2 - Failed");
		}
		else {
			System.out.println("set(boolean) 2 - Success");
		}
	}

	// Test case for toggle()
	public static void test_toggle() throws Exception {
		Bit test = new Bit(false);

		test.toggle();
		if(test.getValue() != true) {
			throw new Exception("toggle() 1 - Failed");
		}
		else {
			System.out.println("toggle() 1 - Success");
		}

		test.toggle();
		if(test.getValue() != false) {
			throw new Exception("toggle() 2 - Failed");
		}
		else {
			System.out.println("toggle() 2 - Success");
		}
	}

	// Test case for set()
	public static void test_set() throws Exception {
		Bit test = new Bit(false);

		test.set();
		if(test.getValue() != true) {
			throw new Exception("set() - Failed");
		}
		else {
			System.out.println("set() - Success");
		}
	}

	// Test case for clear()
	public static void test_clear() throws Exception {
		Bit test = new Bit(true);

		test.clear();
		if(test.getValue() != false) {
			throw new Exception("clear() - Failed");
		}
		else {
			System.out.println("clear() - Success");
		}
	}

	// Test case for getValue()
	public static void test_getValue() throws Exception {
		if(new Bit(false).getValue() != false) {
			throw new Exception("getValue() 1 - Failed");
		}
		else {
			System.out.println("getValue() 1 - Success");
		}

		if(new Bit(true).getValue() != true) {
			throw new Exception("getValue() 2 - Failed");
		}
		else {
			System.out.println("getValue() 2 - Success");
		}
	}

	// Test case for and(Bit)
	public static void test_and() throws Exception {
		Bit test = new Bit(true);

		if(test.and(new Bit(true)).getValue() != true) {
			throw new Exception("and(Bit) 1 - Failed");
		}
		else {
			System.out.println("and(Bit) 1 - Success");
		}

		if(test.and(new Bit(false)).getValue() != false) {
			throw new Exception("and(Bit) 2 - Failed");
		}
		else {
			System.out.println("and(Bit) 2 - Success");
		}
	}

	// Test case for or(Bit)
	public static void test_or() throws Exception {
		Bit test = new Bit(true);

		if(test.or(new Bit(true)).getValue() != true) {
			throw new Exception("or(Bit) 1 - Failed");
		}
		else {
			System.out.println("or(Bit) 1 - Success");
		}

		if(test.or(new Bit(false)).getValue() != true) {
			throw new Exception("or(Bit) 2 - Failed");
		}
		else {
			System.out.println("or(Bit) 2 - Success");
		}
	}

	// Test case for xor(Bit)
	public static void test_xor() throws Exception {
		Bit test = new Bit(true);

		if(test.xor(new Bit(true)).getValue() != false) {
			throw new Exception("xor(Bit) 1 - Failed");
		}
		else {
			System.out.println("xor(Bit) 1 - Success");
		}

		if(test.xor(new Bit(false)).getValue() != true) {
			throw new Exception("xor(Bit) 2 - Failed");
		}
		else {
			System.out.println("xor(Bit) 2 - Success");
		}
	}

	// Test case for not()
	public static void test_not() throws Exception {
		if(new Bit(false).not().getValue() != true) {
			throw new Exception("not() 1 - Failed");
		}
		else {
			System.out.println("not() 1 - Success");
		}

		if(new Bit(true).not().getValue() != false) {
			throw new Exception("not() 2 - Failed");
		}
		else {
			System.out.println("not() 2 - Success");
		}
	}

	// Test case for toString()
	public static void test_toString() throws Exception {
		if(new Bit(true).toString().equals("t")) {
			System.out.println("toString() 1 - Success");
		}
		else {
			throw new Exception("toString() 1 - Failed");
		}

		if(new Bit(false).toString().equals("f")) {
			System.out.println("toString() 2 - Success");
		}
		else {
			throw new Exception("toString() 2 - Failed");
		}
	}

	public static void runTests() throws Exception {
		test_setValue();
		test_toggle();
		test_set();
		test_clear();
		test_getValue();
		test_and();
		test_or();
		test_xor();
		test_not();
		test_toString();

		System.out.println();
	}
}	