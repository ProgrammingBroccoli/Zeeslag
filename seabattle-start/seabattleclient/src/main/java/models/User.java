package models;

import seabattlegui.ISeaBattleGUI;

public class User {
    public int id;
    public String username;
    public String password;
    public ISeaBattleGUI application;
    public boolean singleplayer;
    public boolean isReady = false;
    public int nrOfShips = 5;

    public User(String username, String password, ISeaBattleGUI application, boolean singleplayer) {
        this.id = 1;
        this.username = username;
        this.password = password;
        this.application = application;
        this.singleplayer = singleplayer;
    }
    @Override
    public String toString(){
        return "ID = " +id+ " Username = " +username;
    }

    public void setIsReady(boolean state) {
        this.isReady = state;
    }

    public void sinkship() {
        this.nrOfShips--;
    }

    public int getNrOfShips() {
        return nrOfShips;
    }
}
