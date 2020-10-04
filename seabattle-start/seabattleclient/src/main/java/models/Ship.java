package models;

import seabattlegui.ShipType;

public class Ship {
    public int id;
    public int playerNr;
    public ShipType shipType;
    public int bowX;
    public int bowY;
    boolean horizontal;

    public Ship(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal) {
        this.playerNr = playerNr;
        this.shipType = shipType;
        this.bowX = bowX;
        this.bowY = bowY;
        this.horizontal = horizontal;
    }


}
