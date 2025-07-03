package org.kit;

import java.util.Scanner;

public class SequenceMirroring {
    public static void solveSequenceMirroring(Scanner scanner) {
        System.out.println("Enter a sequence:");
        String sequence = scanner.nextLine();

        if (checkIfEven(sequence)) {
            System.out.println("Odd-length sequence is incorrect by default.");
            return;
        }

        if (checkIfSequenceIsCorrect(sequence)) {
            System.out.println("The sequence is correct.");
        }
        else {
            System.out.println("The sequence is incorrect.");
            System.out.println("Corrected sequence is: " + correctSequence(sequence));
        }
    }

    private static boolean checkIfEven(String sequence) {
        return sequence.length() % 2 != 0;
    }

    private static boolean checkIfSequenceIsCorrect(String sequence) {
        int mid = sequence.length() / 2;
        String leftHalf = sequence.substring(0, mid);
        String rightHalf = sequence.substring(mid);

        boolean isCorrect = true;
        for (int i = 0; i < leftHalf.length(); i++) {
            char leftChar = leftHalf.charAt(i);
            char rightChar = rightHalf.charAt(rightHalf.length() - 1);

            if (!isMatchingPair(leftChar, rightChar)) {
                isCorrect = false;
                break;
            }
        }

        return isCorrect;
    }

    private static boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}') ||
                (left == ')' && right == '(') ||
                (left == ']' && right == '[') ||
                (left == '}' && right == '{');
    }

    private static String correctSequence(String sequence) {
        int mid = sequence.length() / 2;
        String leftHalf = sequence.substring(0, mid);

        StringBuilder correctedRightHalf = new StringBuilder();
        for (int i = leftHalf.length() - 1; i >= 0; i--) {
            char leftChar = leftHalf.charAt(i);
            correctedRightHalf.append(getMatchingBracket(leftChar));
        }

        return leftHalf + correctedRightHalf;
    }

    private static char getMatchingBracket(char left) {
        return switch (left) {
            case '(' -> ')';
            case ')' -> '(';
            case '[' -> ']';
            case ']' -> '[';
            case '{' -> '}';
            case '}' -> '{';
            default -> left;
        };
    }
}
