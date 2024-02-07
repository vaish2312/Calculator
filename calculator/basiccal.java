package number_system;

import java.util.ArrayList;
import java.util.Scanner;

interface CalculatorOperation {
	void displayMenu();
    double performOperation();

    double add(ArrayList<Double> numbers);

    double subtract(ArrayList<Double> numbers);

    double multiply(ArrayList<Double> numbers);

    double divide(ArrayList<Double> numbers) throws ArithmeticException;

    double square(double a);

    double squareRoot(double a);

    ArrayList<Double> getInputNumbers();

    void closeScanner();
}

abstract class basiccal implements CalculatorOperation {
    protected Scanner scanner = new Scanner(System.in);
    
    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square");
        System.out.println("6. Square Root");
    }
    
    

    public double performOperation() {
        double result = 0;

        try {
            int choice;
            do {
                displayMenu();
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a valid option (1-6).");
                }
            } while (choice < 1 || choice > 6);

            ArrayList<Double> numbers = getInputNumbers();

            switch (choice) {
                case 1:
                    result = add(numbers);
                    break;
                case 2:
                    result = subtract(numbers);
                    break;
                case 3:
                    result = multiply(numbers);
                    break;
                case 4:
                    result = divide(numbers);
                    break;
                case 5:
                    System.out.println("Enter number:");
                    double squareNumber = scanner.nextDouble();
                    result = square(squareNumber);
                    break;
                case 6:
                    System.out.println("Enter number:");
                    double squareRootNumber = scanner.nextDouble();
                    result = squareRoot(squareRootNumber);
                    break;
            }

            System.out.println("Result: " + result);

            System.out.println("Do you want to perform another operation? (y/n)");
            char continueChoice = scanner.next().charAt(0);

            if (continueChoice == 'y') {
                performOperation();
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }

        return result;
    }

    public double add(ArrayList<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue)
                .sum();
    }

    public double subtract(ArrayList<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .reduce((x, y) -> x - y)
                .orElse(0.0);
    }

    public double multiply(ArrayList<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .reduce((x, y) -> x * y)
                .orElse(1.0);
    }

    public double divide(ArrayList<Double> numbers) throws ArithmeticException {
        System.out.println("Enter divisor:");
        double divisor = scanner.nextDouble();
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .reduce((a, b) -> a / b).orElse(0.0);
    }

    public double square(double a) {
        return a * a;
    }

    public double squareRoot(double a) {
        return Math.sqrt(a);  
    }
    
    
    
    
    

    public ArrayList<Double> getInputNumbers() {
        ArrayList<Double> numbers = new ArrayList<>();

        System.out.println("Enter numbers separated by spaces (terminate with 'n'):");

        try {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            for (String token : tokens) {
                if (token.equalsIgnoreCase("n")) {
                    break;
                }

                try {
                    double number = Double.parseDouble(token);
                    numbers.add(number);
                } catch (Exception e) {
                    System.out.println("Invalid number format: " + token);
                    return getInputNumbers();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers or 'n' to stop inputting numbers.");
            return getInputNumbers();
        }

        return numbers;
    }


    }


