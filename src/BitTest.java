public class BitTest {

	public static void test_setValue() throws Exception {
		Bit test = new Bit(false);
		test.set(false);

		if(test.getValue() != false) {
			throw new Exception("set(boolean) - Failed");
		}
		else {
			System.out.println("set(boolean) - Success");
		}
	}

	public static void test_toggle() throws Exception {
		Bit test = new Bit(false);
		test.toggle();

		if(test.getValue() != true) {
			throw new Exception("toggle() - Failed");
		}
		else {
			System.out.println("toggle() - Success");
		}
	}

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

	public static void test_clear() throws Exception {
		Bit test = new Bit(false);
		test.clear();

		if(test.getValue() != false) {
			throw new Exception("clear() - Failed");
		}
		else {
			System.out.println("clear() - Success");
		}
	}

	public static void test_getValue() throws Exception {
		Bit test = new Bit(false);

		if(test.getValue() != false) {
			throw new Exception("getValue() - Failed");
		}
		else {
			System.out.println("getValue() - Success");
		}
	}

	public static void test_and() throws Exception {
		Bit test = new Bit(true);

		if(test.and(new Bit(true)).getValue() != true) {
			throw new Exception("and(Bit) - Failed");
		}
		else {
			System.out.println("and(Bit) - Success");
		}
	}

	public static void test_or() throws Exception {
		Bit test = new Bit(false);

		if(test.or(new Bit(true)).getValue() != true) {
			throw new Exception("or(Bit) - Failed");
		}
		else {
			System.out.println("or(Bit) - Success");
		}
	}

	public static void test_xor() throws Exception {
		Bit test = new Bit(true);

		if(test.xor(new Bit(true)).getValue() != false) {
			throw new Exception("xor(Bit) - Failed");
		}
		else if(test.xor(new Bit(false)).getValue() != true) {
			throw new Exception("xor(Bit) - Failed");
		}
		else {
			System.out.println("xor(Bit) - Success");
		}
	}

	public static void test_not() throws Exception {
		Bit test = new Bit(false);

		if(test.not().getValue() != true) {
			throw new Exception("not() - Failed");
		}
		else {
			System.out.println("not() - Success");
		}
	}

	public static void test_toString() throws Exception {
		Bit test = new Bit(true);
		String expected = "t";

		if(test.toString().equals(expected)) {
			System.out.println("toString() - Success");
		}
		else {
			throw new Exception("toString() - Failed");
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