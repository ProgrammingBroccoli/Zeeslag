package seabattlegui;

import models.Ship;
import models.Shot;
import models.User;

import java.util.ArrayList;

public class GameData {

    private ArrayList<User> users;
    private ArrayList<Ship> ships;
    private ArrayList<Shot> shots;

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
    public void removeShip(int playerNr, int posX, int posY){
        Ship deletingShip = null;
        for (Ship ship : ships){
            if (ship.playerNr == playerNr && ship.bowX == posX && ship.bowY == posY){
                deletingShip = ship;
            }
        }
        ships.remove(deletingShip);
    }

    public void removeAllShips(int playerNr) {
        ships.removeIf(ship -> ship.playerNr == playerNr);
    }

    public ArrayList<Ship> getShips(int playerNr) {
        return ships;
    }

    public Shot fireShot(int opponent, int posX, int posY) {
        Shot shot = new Shot(opponent, posX, posY, ShotType.HIT);
        return  shot;
    }
}
