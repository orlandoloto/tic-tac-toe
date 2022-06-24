package com.tictactoe.back;

import com.tictactoe.front.Console;

public class TicTacToe {
    private final char[][] board;
    private final int dimension;
    private final Turn turn;
    private StatusGame statusGame;
    private final Console console;


    public TicTacToe() {
        dimension = 3;
        board = new char[dimension][dimension];
        turn = new Turn();
        console = new Console(this);
        create();
    }

    public void create() {
        turn.resetTurn();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = '\0';
            }
        }
        statusGame = new StatusGame(board);
        notifyListener("create");
    }

    public boolean markMove(int row, int column) {
        boolean mark = false;
        if (!checkTicTacToe()) {
            if (checkPosition(row, column)) {
                if (markBox(row, column)) {
                    mark = true;
                    changeTurn();
                    notifyListener("markMove");
                }
            }
        }
        return mark;
    }

    private void changeTurn() {
        turn.changeTurn();
    }

    private boolean markBox(int row, int column) {
        boolean mark = false;
        if (checkBox(row, column)) {
            board[row][column] = turn.getTurn();
            mark = true;
        }
        return mark;
    }

    private boolean checkBox(int row, int column) {
        boolean checkValid = false;
        if ('\0' == board[row][column]) {
            checkValid = true;
        }
        return checkValid;
    }

    private boolean checkPosition(int row, int column) {
        return isPosition(row) & isPosition(column);
    }

    private boolean isPosition(int i) {
        return i < dimension && i >= 0;
    }

    public boolean checkTicTacToe() {
        return statusGame.checkTicTacToe();
    }

    public boolean draw() {
        return statusGame.draw();
    }

    public char winner() {
        return statusGame.getWinner();
    }

    public char[][] getBoard() {
        return board;
    }

    private void notifyListener(String event) {
        console.update(event);

    }
}
