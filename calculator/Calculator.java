package number_system;

import java.util.ArrayList;

public class Calculator extends basiccal {

	public static void main(String[] args) {
		basiccal cal= new Calculator();
		
		 ArrayList<Double> numbers = cal.getInputNumbers();
	        System.out.println("Result: " + cal.performOperation());
	    }

	@Override
	public void closeScanner() {
		// TODO Auto-generated method stub
		
	}
	}


