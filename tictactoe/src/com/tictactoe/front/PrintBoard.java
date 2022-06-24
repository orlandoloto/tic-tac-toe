package com.tictactoe.front;

import com.tictactoe.helper.ColorConsole;

public class PrintBoard {
    private ColorConsole colorConsole;

    public PrintBoard() {
        colorConsole = new ColorConsole();
    }

    public void printBoardGame(char[][] game) {
        char[][] boardPlay = game;
        System.out.println();
        for (int i = 0; i < boardPlay.length; i++) {
            char[] chars = boardPlay[i];
            for (int j = 0; j < boardPlay.length; j++) {
                char box = chars[j];
                if (box == 'X') {
                    System.out.print("[ " + colorConsole.colorPurple() + box + colorConsole.resetColor() + " ]");
                } else if (box == 'O') {
                    System.out.print("[ " + colorConsole.colorCyan() + box + colorConsole.resetColor() + " ]");
                } else {
                    System.out.print("[   ]");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
