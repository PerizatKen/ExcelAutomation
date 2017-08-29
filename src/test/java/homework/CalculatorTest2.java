package homework;

import org.junit.Test;

public class CalculatorTest2 {

	@Test
	public void testMyCalculator() {
		Calculator.Operation("addition", 3.5, 2.1);
		System.out.println(Calculator.Operation("addition", 3.5, 2.1));

		System.out.println(Calculator.Operation("subtraction", 3.5, 2.1));

		System.out.println(Calculator.Operation("multiplication", 3.5, 2.1));

		System.out.println(Calculator.Operation("division", 3.5, 2.1));
	}

}
