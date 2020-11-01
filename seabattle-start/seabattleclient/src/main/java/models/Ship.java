package models;

import seabattlegui.ShipType;

import java.util.ArrayList;

public class Ship {
    public int id;
    public int playerNr;
    public ShipType shipType;
    public int bowX;
    public int bowY;
    public boolean horizontal;
    public int length;
    public int health;
    public ArrayList<Coord> coords;

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
        this.health = length;
        coords = new ArrayList<>();
        setCoords(bowX, bowY, length, horizontal, shipType);
    }

    private void setCoords(int bowX, int bowY, int length, boolean horizontal, ShipType shipType) {
        for (int i = 0; i <length; i++){
            if (horizontal){
                coords.add(new Coord(bowX + i, bowY));
            } else {
                coords.add(new Coord(bowX, bowY + i));
            }
        }
    }


    public void giveDammage() {
        health--;
    }
    public int getHealth(){
        return health;
    }

    public ArrayList<Coord> getCoords() {
        return coords;
    }
}
