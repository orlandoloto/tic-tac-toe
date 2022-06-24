package com.tictactoe;

import com.tictactoe.back.TicTacToe;
import com.tictactoe.front.Console;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Console console = new Console(ticTacToe);

        console.run();
    }
}
