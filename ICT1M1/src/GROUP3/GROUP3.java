package GROUP3;
import java.util.Scanner;

public class GROUP3 {
	
	  // ANSI Escape Codes for text and background colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Loading screen
        loadingScreen();

        do {
            System.out.println(CYAN_BACKGROUND + BLUE + "*** MENU ***" + RESET);
            System.out.println("1. Calculator");
            System.out.println("2. Area and Circumference of a Circle");
            System.out.println("3. Area and Perimeter of a Rectangle");
            System.out.println("4. Conversion (cm to mm, cm to m)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println(RED + "Invalid input! Please enter a number." + RESET);
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    calculator(sc);
                    break;
                case 2:
                    areaCircumference(sc);
                    break;
                case 3:
                    areaPerimeter(sc);
                    break;
                case 4:
                    conversion(sc);
                    break;
                case 5:
                    System.out.println(GREEN + "Exiting... Goodbye BOSS'.'!! " + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid choice! Please select a valid option." + RESET);
            }
        } while (choice != 5);

        sc.close();
    }

    // Loading screen simulation
    public static void loadingScreen() throws InterruptedException {
        System.out.println(WHITE_BACKGROUND + GREEN + "Loading application, please wait..." + RESET);
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print("." + RESET);
        System.out.println("\n" + GREEN + "Application Loaded!" + RESET);
    }

    // Calculator method
    public static void calculator(Scanner sc) {
        System.out.println(BLUE + "Calculator:" + RESET);
        System.out.print("Enter first number: ");
        double num1 = validateDouble(sc);
        System.out.print("Enter second number: ");
        double num2 = validateDouble(sc);
        System.out.println("Choose operation: (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println(GREEN + "Result: " + (num1 + num2) + RESET);
                break;
            case '-':
                System.out.println(GREEN + "Result: " + (num1 - num2) + RESET);
                break;
            case '*':
                System.out.println(GREEN + "Result: " + (num1 * num2) + RESET);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println(RED + "Error! Division by zero." + RESET);
                } else {
                    System.out.println(GREEN + "Result: " + (num1 / num2) + RESET);
                }
                break;
            default:
                System.out.println(RED + "Invalid operator!" + RESET);
        }
    }

    // Area and Circumference of a Circle
    public static void areaCircumference(Scanner sc) {
        System.out.print("Enter the radius of the circle: ");
        double radius = validateDouble(sc);
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println(GREEN + "Area: " + area + RESET);
        System.out.println(GREEN + "Circumference: " + circumference + RESET);
    }

    // Area and Perimeter of a Rectangle
    public static void areaPerimeter(Scanner sc) {
        System.out.print("Enter length of the rectangle: ");
        double length = validateDouble(sc);
        System.out.print("Enter width of the rectangle: ");
        double width = validateDouble(sc);
        double area = length * width;
        double perimeter = 2 * (length + width);
        System.out.println(GREEN + "Area: " + area + RESET);
        System.out.println(GREEN + "Perimeter: " + perimeter + RESET);
    }

    // Conversion: cm to mm and cm to m
    public static void conversion(Scanner sc) {
        System.out.print("Enter the value in cm: ");
        double cm = validateDouble(sc);
        System.out.println(GREEN + "Value in mm: " + (cm * 10) + " mm" + RESET);
        System.out.println(GREEN + "Value in meters: " + (cm / 100) + " m" + RESET);
    }

    // Helper method to validate double input
    public static double validateDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println(RED + "Di-wastong input! Mangyaring magpasok ng wastong numero." + RESET);
            sc.next();
        }
        return sc.nextDouble();
    }

}
