package com.tictactoe.helper;

public class ColorConsole {

    public String colorRed(){ return "\033[31m"; }

    public String colorGreen(){ return "\033[32m"; }

    public String colorYellow(){ return "\033[33m"; }

    public String colorBlue(){ return "\033[34m"; }

    public String colorPurple(){ return "\033[35m"; }

    public String colorCyan(){ return "\033[36m"; }

    public String resetColor(){ return "\u001B[0m"; }
}
