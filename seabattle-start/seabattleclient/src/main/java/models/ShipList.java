package models;

import java.util.ArrayList;

public class ShipList {
    public ShipList(String name, ArrayList<Ship> ships) {
        this.name = name;
        this.ships = ships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    private String name;
    private ArrayList<Ship> ships;
}
