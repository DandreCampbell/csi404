public class BitTest {

	// Test case for set(boolean)
	public static void test_setValue() throws Exception {
		Bit test = new Bit(false);
		
		test.set(true);
		if(test.getValue() != true) {
			throw new Exception("set(boolean) - Failed");
		}
		else {
			System.out.println("set(boolean) - Success");
		}

		test.set(false);
		if(test.getValue() != false) {
			throw new Exception("set(boolean) - Failed");
		}
		else {
			System.out.println("set(boolean) - Success");
		}

		System.out.println();
	}

	// Test case for toggle()
	public static void test_toggle() throws Exception {
		Bit test = new Bit(false);

		test.toggle();
		if(test.getValue() != true) {
			throw new Exception("toggle() - Failed");
		}
		else {
			System.out.println("toggle() - Success");
		}

		test.toggle();
		if(test.getValue() != false) {
			throw new Exception("toggle() - Failed");
		}
		else {
			System.out.println("toggle() - Success");
		}

		System.out.println();
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

		System.out.println();
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

		System.out.println();
	}

	// Test case for getValue()
	public static void test_getValue() throws Exception {
		if(new Bit(false).getValue() != false) {
			throw new Exception("getValue() - Failed");
		}
		else {
			System.out.println("getValue() - Success");
		}

		if(new Bit(true).getValue() != true) {
			throw new Exception("getValue() - Failed");
		}
		else {
			System.out.println("getValue() - Success");
		}

		System.out.println();
	}

	// Test case for and(Bit)
	public static void test_and() throws Exception {
		Bit test = new Bit(true);

		if(test.and(new Bit(true)).getValue() != true) {
			throw new Exception("and(Bit) - Failed");
		}
		else {
			System.out.println("and(Bit) - Success");
		}

		if(test.and(new Bit(false)).getValue() != false) {
			throw new Exception("and(Bit) - Failed");
		}
		else {
			System.out.println("and(Bit) - Success");
		}

		System.out.println();
	}

	// Test case for or(Bit)
	public static void test_or() throws Exception {
		Bit test = new Bit(true);

		if(test.or(new Bit(true)).getValue() != true) {
			throw new Exception("or(Bit) - Failed");
		}
		else {
			System.out.println("or(Bit) - Success");
		}

		if(test.or(new Bit(false)).getValue() != true) {
			throw new Exception("or(Bit) - Failed");
		}
		else {
			System.out.println("or(Bit) - Success");
		}

		System.out.println();
	}

	// Test case for xor(Bit)
	public static void test_xor() throws Exception {
		Bit test = new Bit(true);

		if(test.xor(new Bit(true)).getValue() != false) {
			throw new Exception("xor(Bit) - Failed");
		}
		else {
			System.out.println("xor(Bit) - Success");
		}

		if(test.xor(new Bit(false)).getValue() != true) {
			throw new Exception("xor(Bit) - Failed");
		}
		else {
			System.out.println("xor(Bit) - Success");
		}

		System.out.println();
	}

	// Test case for not()
	public static void test_not() throws Exception {
		if(new Bit(false).not().getValue() != true) {
			throw new Exception("not() - Failed");
		}
		else {
			System.out.println("not() - Success");
		}

		if(new Bit(true).not().getValue() != false) {
			throw new Exception("not() - Failed");
		}
		else {
			System.out.println("not() - Success");
		}

		System.out.println();
	}

	// Test case for toString()
	public static void test_toString() throws Exception {
		if(new Bit(true).toString().equals("t")) {
			System.out.println("toString() - Success");
		}
		else {
			throw new Exception("toString() - Failed");
		}

		if(new Bit(false).toString().equals("f")) {
			System.out.println("toString() - Success");
		}
		else {
			throw new Exception("toString() - Failed");
		}

		System.out.println();
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
	}
}	