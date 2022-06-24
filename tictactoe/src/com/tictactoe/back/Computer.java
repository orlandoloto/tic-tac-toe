package com.tictactoe.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private final TicTacToe ticTacToe;
    private final int min = 1;
    private final int max = 9;

    public Computer(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public int enterNumberComputer() {
        Random random = new Random();
        int value = 0;
        try {
            Thread.sleep(1000);
            value = random.nextInt(max - min + 1) + min;
        } catch (Exception e){
            System.out.println(e);
        }
        return value;
    }

    private void numberValid() {
        List<Integer> busyBoxes = new ArrayList();
        char[][] board = ticTacToe.getBoard();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == '\0'){
                    busyBoxes.add(i);
                }
            }
        }
    }
}
