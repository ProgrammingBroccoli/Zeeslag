package models;

import seabattlegui.ShipType;

public class Ship {
    public int id;
    public int playerNr;
    public ShipType shipType;
    public int bowX;
    public int bowY;
    public boolean horizontal;
    public int length;

    public Ship(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal) {
        this.playerNr = playerNr;
        this.shipType = shipType;
        this.bowX = bowX;
        this.bowY = bowY;
        this.horizontal = horizontal;

        switch (shipType){
            case MINESWEEPER:
                length = 2;
                break;
            case SUBMARINE:
                length = 3;
                break;
            case CRUISER:
                length = 3;
                break;
            case BATTLESHIP:
                length = 4;
                break;
            case AIRCRAFTCARRIER:
                length = 5;
                break;
        }
    }


}
