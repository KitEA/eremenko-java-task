package org.kit;

import java.util.Scanner;

public class Main {
    private final static int GREETING_THRESHOLD = 7;
    private final static String THE_ONLY_NAME = "John";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        processNumberInput(scanner);
        processStringInput(scanner);
        processIntegerArray(scanner);

        scanner.close();
    }

    private static void processNumberInput(Scanner scanner) {
        System.out.println("Enter a number:");
        try {
            int number = scanner.nextInt();
            if (number > GREETING_THRESHOLD) {
                System.out.println("Hello");
            }
        } catch (Exception e) {
            System.out.println("Invalid number entered.");
        }
    }

    private static void processStringInput(Scanner scanner) {
        System.out.println("Enter a name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (THE_ONLY_NAME.equalsIgnoreCase(name)) {
            System.out.printf("Hello, %s \n", THE_ONLY_NAME);
        } else {
            System.out.println("There is no such name");
        }
    }

    private static void processIntegerArray(Scanner scanner) {
        System.out.println("Enter a numeric array separated by commas:");
        String arrayInput = scanner.nextLine();
        String[] arrayElements = arrayInput.split(",");
        for (String element : arrayElements) {
            try {
                printIfMultipleOfThree(element);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number in array: " + element);
            }
        }
    }

    private static void printIfMultipleOfThree(String element) {
        int num = Integer.parseInt(element.trim());
        if (multipleOfThree(num)) {
            System.out.println(num);
        }
    }

    private static boolean multipleOfThree(int num) {
        return num % 3 == 0;
    }

}