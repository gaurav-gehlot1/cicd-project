package com.example.java.basics;

import java.util.Scanner;

public class ControlFlowDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // if-else demonstration
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        // switch demonstration
        System.out.print("Enter a day number (1-7): ");
        int day = scanner.nextInt();
        String dayName;
        switch (day) {
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
            case 7: dayName = "Sunday"; break;
            default: dayName = "Invalid day";
        }
        System.out.println("Day: " + dayName);

        // for loop demonstration
        System.out.print("Enter a number to print its multiplication table: ");
        int num = scanner.nextInt();
        System.out.println("Multiplication table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        // while loop demonstration
        System.out.print("Enter a number to find its factorial: ");
        int factNum = scanner.nextInt();
        long factorial = 1;
        int i = 1;
        while (i <= factNum) {
            factorial *= i;
            i++;
        }
        System.out.println("Factorial of " + factNum + " is " + factorial);

        // do-while demonstration
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Check Even/Odd");
            System.out.println("2. Check Positive/Negative");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter a number: ");
                int n = scanner.nextInt();
                System.out.println(n + " is " + (n % 2 == 0 ? "Even" : "Odd"));
            } else if (choice == 2) {
                System.out.print("Enter a number: ");
                int n = scanner.nextInt();
                System.out.println(n + " is " + (n >= 0 ? "Positive" : "Negative"));
            }
        } while (choice != 3);

        System.out.println("Program ended.");
        scanner.close();
    }
}

