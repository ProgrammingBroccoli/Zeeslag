package seabattlegui;

import models.Ship;
import models.User;

import java.util.ArrayList;

public class GameData {

    private ArrayList<User> users;
    private ArrayList<Ship> ships;

    public GameData(){
        users = new ArrayList<User>();
        ships = new ArrayList<Ship>();
    }

    public User addUser(String username, String password, ISeaBattleGUI application, boolean singleplayer){
        User user = new User(username, password, application, singleplayer);
        user.id = users.size()+1;
        users.add(user);
        return user;
    }
    public User getUser(int id){
        User returningUser = null;
        for (User user: users) {
            if(user.id == id){
                returningUser = user;
            }
        }
        return returningUser;
    }
    public Ship addShip(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal){
        Ship ship = new Ship(playerNr, shipType, bowX, bowY, horizontal);
        ship.id = ships.size() + 1;
        ships.add(ship);
        return ship;
    }
    public void getShip(int id){
        Ship returningShip = null;
        for (Ship ship : ships){
            if (ship.id == id){
                returningShip = ship;
            }
        }
    }
    public Ship removeShip(int playerNr, int posX, int posY){
        Ship deletingShip = null;
        for (Ship ship : ships){
            if (ship.horizontal){
                //horizontal
                for (int i = 0; i < ship.length; i++){
                    if(posX == ship.bowX + i && posY == ship.bowY && ship.playerNr == playerNr){
                        deletingShip = ship;
                    }
                }
            }else{
                for (int i = 0; i< ship.length; i++){
                    if (posX == ship.bowX && posY == ship.bowY + i && ship.playerNr == playerNr){
                        deletingShip = ship;
                    }
                }
            }

        }
        ships.remove(deletingShip);
       return deletingShip;
    }

    public void removeAllShips(int playerNr) {
        ships.removeIf(ship -> ship.playerNr == playerNr);
    }

    public ArrayList<Ship> getShips(int playerNr) {
        ArrayList<Ship> tempList = new ArrayList<Ship>();
        for (Ship ship: ships) {
            if (ship.playerNr == playerNr){
                tempList.add(ship);
            }
        }
        return tempList;
    }

    public Ship getShipByCords(int playernr, int posX, int posY) {
        Ship tempShip = null;
        for (Ship ship : ships){
            if (ship.playerNr == playernr){
                if (ship.horizontal){
                    //horizontal
                    for (int i = 0; i < ship.length; i++){
                        if(posX == ship.bowX + i && posY == ship.bowY){
                            tempShip = ship;
                        }
                    }
                }else{
                    for (int i = 0; i< ship.length; i++){
                        if (posX == ship.bowX && posY == ship.bowY + i){
                            tempShip = ship;
                        }
                    }
                }
            }
        }
        return tempShip;
    }

    public int getNrOfShips(int playerNr) {
        User user = getUser(playerNr);
        return user.getNrOfShips();
    }
}
