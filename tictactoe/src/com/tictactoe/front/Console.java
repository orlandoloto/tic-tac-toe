package com.tictactoe.front;

import com.tictactoe.back.Computer;
import com.tictactoe.back.TicTacToe;
import com.tictactoe.helper.ColorConsole;
import com.tictactoe.helper.ConvertCoordinates;
import com.tictactoe.helper.GameMessage;
import com.tictactoe.helper.InputConsole;

public class Console {

    private final TicTacToe ticTacToe;
    private final InputConsole inputConsole;
    private final GameMessage gameMessage;
    private final ColorConsole colorConsole;
    private final ConvertCoordinates convert;
    private final Computer computer;

    private final PrintBoard printBoard;
    private String piece;
    private int count;
    private boolean turnComputer = false;
    private boolean playComputer = false;

    public Console(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;

        inputConsole = new InputConsole();
        gameMessage  = new GameMessage();
        colorConsole = new ColorConsole();
        convert      = new ConvertCoordinates(3);
        computer     = new Computer(ticTacToe);
        printBoard   = new PrintBoard();

        piece = "X";
        count = 0;
    }

    public void run(){
        setLabelsGameInit();
        play();
    }

    private void play() {
        setLabelsMessagesOptionsInit();
        while (true) {
            movePlayer();
        }
    }


    private void movePlayer(){
        int number = isTurnComputer();

        if (number == 10){
            ticTacToe.create();
            turnComputer = false;
        }else{
            if (number == 11){
                System.out.println(gameMessage.messageFinishGame());
                System.exit(0);
            }else {
                if (!ticTacToe.markMove(convert.convertRow(number), convert.convertColumn(number))){
                    System.out.println(colorConsole.colorRed() +
                            "***play not valid, box already checked" +
                            colorConsole.resetColor());
                    System.out.print("- re-enter the play number: ");
                    turnComputer = !turnComputer;
                    movePlayer();
                }
            }
        }
    }

    private int isTurnComputer(){
        int number = 10;
        if (!ticTacToe.checkTicTacToe()){
            if (!turnComputer){
                number = inputConsole.enterNumber(11, "play number");
                turnComputer = !turnComputer;
            } else {
                number = computer.enterNumberComputer();
                turnComputer = false;
            }
        }
        return number;
    }

    public void update(String event) {
        if(event.equals("markMove")){
            changeLabelTurn();
            printBoard();
            checkStatusGame();
        }
        if(event.equals("create")){
            setLabelsMessagesOptionsInit();
        }

    }

    private void checkStatusGame(){
        if(ticTacToe.checkTicTacToe()){
            String winner = String.valueOf(ticTacToe.winner());
            System.out.println(gameMessage.messageWinnerGame(winner) + "\n");
            turnComputer = false;
        }else{
            if (ticTacToe.draw()){
                System.out.println(gameMessage.messageDrawGame() + "\n");
                starSubMenu();
                turnComputer = false;
            }else{
                System.out.print("- enter the play number " + piece + " : ");
            }
        }
    }

    private void starSubMenu() {
        System.out.println(colorConsole.colorGreen() + "> Press 10 new game \n> Press 11 to the exit game" + colorConsole.resetColor() + "\n");
        System.out.print("- enter the option: ");
    }

    private void setLabelsGameInit(){
        System.out.println();
        System.out.println(colorConsole.colorYellow() + "\n ----- WELCOME TIC TAC TOE ----- \n" + colorConsole.resetColor());
    }

    private void setLabelsMessagesOptionsInit(){
        piece = "X";
        System.out.println(colorConsole.colorBlue() + "\n\nChoose a number from 1 to 9 for play" + colorConsole.resetColor());
        System.out.println(colorConsole.colorGreen() + "> Press 10 new game \n> Press 11 to the exit game" + colorConsole.resetColor());
        printBoard();
        System.out.print("- enter the play number " + piece + " : ");
    }

    private void printBoard(){
        char[][] boardPlay = ticTacToe.getBoard();
        printBoard.printBoardGame(boardPlay);
    }

    private void changeLabelTurn(){
        if(piece.equals("X")){
            piece = "O";
        }else{
            piece = "X";
        }
    }
}
