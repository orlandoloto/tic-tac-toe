package com.tictactoe.back;

public class Turn {
    private char turn;
    private final char symbolX = 'X';
    private final char symbolO = 'O';

    public Turn() {
        this.turn = symbolX;
    }

    public char getTurn() {
        return turn;
    }

    public void changeTurn(){
        if (turn == symbolX) turn = symbolO;
        else turn = symbolX;
    }

    public void resetTurn(){
        turn = symbolX;
    }
}
