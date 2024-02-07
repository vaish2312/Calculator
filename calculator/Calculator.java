package number_system;

import java.util.ArrayList;

public class Calculator extends basiccal {

	 @Override
	    public void displayMenu() {
	        System.out.println("\nMenu:");
	        System.out.println("1. Addition");
	        System.out.println("2. Subtraction");
	        System.out.println("3. Multiplication");
	        System.out.println("4. Division");
	        System.out.println("5. Square");
	        System.out.println("6. Square Root");
	    }

	    @Override
	    public void closeScanner() {
	        scanner.close();
	    }

	    public static void main(String[] args) {
	        CalculatorOperation calc = new Calculator();
	        calc.performOperation();
	        calc.closeScanner();
	    }
	}
