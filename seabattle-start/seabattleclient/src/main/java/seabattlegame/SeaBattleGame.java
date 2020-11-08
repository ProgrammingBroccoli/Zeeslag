/*
 * Sea Battle Start project.
 */
package seabattlegame;

import models.Ship;
import models.Square;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seabattlegui.GameData;
import seabattlegui.ISeaBattleGUI;
import seabattlegui.ShipType;
import seabattlegui.ShotType;

import java.util.ArrayList;

/**
 * The Sea Battle game. To be implemented.
 *
 * @author Nico Kuijpers
 */
public class SeaBattleGame implements ISeaBattleGame {
  GameData gameData;

  public SeaBattleGame() {

    gameData = new GameData();
  }

  private static final Logger log = LoggerFactory.getLogger(SeaBattleGame.class);

  @Override
  public User registerPlayer(String name, String password, ISeaBattleGUI application, boolean singlePlayerMode) {
    User user = gameData.addUser(name, password, application, singlePlayerMode);
    log.debug(user.toString());
    return user;
  }

  @Override
  public void placeShipsAutomatically(int playerNr) {

  }

  @Override
  public Ship placeShip(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal) {
    return gameData.addShip(playerNr, shipType, bowX, bowY, horizontal);
    //throw new UnsupportedOperationException("Method placeShip() VISUAL not implemented.");
  }

  @Override
  public Ship removeShip(int playerNr, int posX, int posY) {
    return gameData.removeShip(playerNr, posX, posY);
    //throw new UnsupportedOperationException("Method removeShip()VISUAL not implemented.");
  }

  @Override
  public void removeAllShips(int playerNr) {
    gameData.removeAllShips(playerNr);
  }

  @Override
  public void notifyWhenReady(int playerNr) {
    gameData.getUser(playerNr).setIsReady(true);



    System.out.println("Player and opponent ready to play");
  }

  @Override
  public ShotType fireShot(int playerNr, int posX, int posY, Square[][]map) {
    switch (map[posX][posY].getState()){
      case WATER:
        return ShotType.MISSED;

      case SHIP:
        gameData.getShipByCords(playerNr == 1 ? 999 : 1, posX, posY).giveDammage();
        return gameData.getShipByCords(playerNr == 1 ? 999 : 1, posX, posY).getHealth() == 0 ? ShotType.SUNK : ShotType.HIT;
    }
    throw new UnsupportedOperationException("Method fireShot() not implemented.");
  }

  @Override
  public void startNewGame(int playerNr) {
    throw new UnsupportedOperationException("Method startNewGame() not implemented.");
  }

  public ArrayList<Ship> getShips(int playerNr) {

    return gameData.getShips(playerNr);
  }

  public boolean shipPlaced(int playerNr, ShipType shipType) {
    for (Ship ship : gameData.getShips(playerNr)) {
      if (ship.shipType == shipType) return true;
    }
    return false;
  }

  @Override
  public Ship getShipByCords(int playerNr, int x, int y) {
   return gameData.getShipByCords(playerNr, x, y);
  }

  @Override
  public User getPlayer(int playerNr) {
    return gameData.getUser(playerNr);
  }

  @Override
  public int getNrOfShips(int playerNr) {
    return gameData.getNrOfShips(playerNr);
  }


}
