package com.tictactoe.back;

public class StatusGame {

    private char [][] board;
    private char winner;
    private int movementCounter;
    private int dimension;

    public StatusGame(char[][] board) {
        this.board = board;
        dimension = board.length;
        winner = '\0';
    }

    public boolean checkTicTacToe() {
        boolean check = false;
        if (movementCounter >= 0) {
            if (rowWinner() || columnWinner() || diagonalWinner()) {
                check = true;
            }
        }
        return check;
    }

    public char getWinner() {
        return winner;
    }

    public boolean draw() {
        boolean isDraw = false;
        if (finish() && winner == '\0'){
            isDraw = true;
        }
        return isDraw;
    }

    private boolean finish() {
        boolean finish = false;
        int limit = dimension * dimension;
        counterBoard();
        if (movementCounter == limit){
            finish = true;
        }
        return finish;
    }

    private void counterBoard() {
        movementCounter = 0;
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                if (board[i][j] != '\0'){
                    movementCounter++;
                }
            }
        }
    }

    private boolean rowWinner() {
        boolean earner = false;
        int countX;
        int countO;
        for (int i = 0; i < dimension; i++){
            countX = 0;
            countO = 0;
            for (int j = 0; j < dimension; j++){
                if (board[i][j] == 'X'){
                    countX++;
                }
                if (board[i][j] == 'O'){
                    countO++;
                }
                if (countX == dimension || countO == dimension){
                    getWinner(countX, countO);
                    earner = true;
                }
            }
        }

        return earner;
    }

    private boolean columnWinner() {
        boolean earner = false;
        int counterX;
        int counterO;
        for (int i = 0; i < dimension; i++) {
            counterX = 0;
            counterO = 0;
            for (int j = 0; j < dimension; j++) {
                if(board[j][i] == 'X'){
                    counterX++;
                }
                if(board[j][i] == 'O'){
                    counterO++;
                }
            }
            if(counterX == dimension || counterO == dimension){
                getWinner(counterX, counterO);
                earner = true;
            }
        }
        return earner;
    }

    private boolean diagonalWinner() {
        boolean earner = false;
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < 3; i++) {
            if(board[i][i] == 'X'){
                counterX++;
            }
            if(board[i][i] == 'O'){
                counterO++;
            }
        }
        if(counterX == 3 || counterO == 3){
            getWinner(counterX, counterO);
            earner = true;
        }
        counterX = 0;
        counterO = 0;
        for (int i = 2; i >= 0; i--) {
            if(board[i][2 - i] == 'X'){
                counterX++;
            }
            if(board[i][2 - i] == 'O'){
                counterO++;
            }
        }
        if(counterX == dimension || counterO == dimension){
            getWinner(counterX, counterO);
            earner = true;
        }
        return earner;
    }

    private void getWinner(int countX, int countO){
        if (countX == dimension){
            winner = 'X';
        }
        if (countO == dimension){
            winner = 'O';
        }
    }
}
