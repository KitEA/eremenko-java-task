package org.kit;

import java.util.Scanner;

import static org.kit.ProcessNumberNameArray.solveProcessNumberNameArray;
import static org.kit.SequenceMirroring.solveSequenceMirroring;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what task you want to solve:");
        System.out.println("1. Process number, name, and numeric array.");
        System.out.println("2. Check if a sequence is perfectly mirrored.");

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                solveProcessNumberNameArray(scanner);
                break;
            case 2:
                solveSequenceMirroring(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}