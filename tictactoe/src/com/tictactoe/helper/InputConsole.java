package com.tictactoe.helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputConsole {
    private Scanner scanner;
    private ColorConsole colorConsole;

    public InputConsole() {
        scanner = null;
        colorConsole = new ColorConsole();
    }

    public int enterNumber(int max, String message) {
        scanner = null;
        int number = 0;
        do {
            try {
                scanner = new Scanner(System.in);
                number = scanner.nextInt();
                while (number < 1 || number > max) {
                    System.out.println(colorConsole.colorRed() + "*** " +
                            message + " not valid, enter another" +
                            colorConsole.resetColor());
                    System.out.print("- enter the " + message + ": ");
                    number = scanner.nextInt();
                }
            } catch (InputMismatchException ime){
                System.out.println(colorConsole.colorRed() + "***Watch out! You can only insert numbers" + colorConsole.resetColor());
                System.out.print("- enter the " + message + ": ");
                assert scanner != null;
                scanner.next();
            }finally {
                if (scanner == null) {
                    assert false;
                    scanner.close();
                }
            }
        }while (number < 1 || number > max);
        return number;
    }
}
