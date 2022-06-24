package com.tictactoe.helper;

public class GameMessage {
    public String messageWinnerGame(String winner){
        return "The winner is " + winner + ", Congratulations!";
    }

    public String messageDrawGame(){
        return "It's a Draw :'v";
    }

    public String messageFinishGame(){
        return "Thanks for Play!!! :)";
    }
}