package com.example.TicTacToe;

public class Game {
    private String GameName;
    private String HostName;


    public Game(String gameName, String hostName) {
        GameName = gameName;
        HostName = hostName;
    }

    public String getGameName() {
        return GameName;
    }

    public String getHostName() {
        return HostName;
    }

}
