package homework;

public class Calculator {

	public static double Operation(String operation, double num1, double num2) {
		double result = 0.0;

		switch (operation) {

		case "addition":
			result = num1 + num2;
			break;
		case "subtraction":
			result = num1 - num2;
			break;
		case "multiplication":
			result = num1 * num2;
			break;
		case "division":
			if (num2 == 0) {
				System.out.println("You cannot devide by 0");
				result = 0;
			} else {
				result = num1 / num2;
				break;
			}

		}
		return result;

	}

}
