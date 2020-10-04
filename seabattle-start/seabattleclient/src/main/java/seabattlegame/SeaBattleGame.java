/*
 * Sea Battle Start project.
 */
package seabattlegame;

import models.Ship;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seabattlegui.GameData;
import seabattlegui.ISeaBattleGUI;
import seabattlegui.ShipType;

import java.util.ArrayList;

/**
 * The Sea Battle game. To be implemented.
 *
 * @author Nico Kuijpers
 */
public class SeaBattleGame implements ISeaBattleGame {
  GameData gameData;
  public SeaBattleGame(){
    gameData = new GameData();
  }

  private static final Logger log = LoggerFactory.getLogger(SeaBattleGame.class);

  @Override
  public User registerPlayer(String name, String password, ISeaBattleGUI application, boolean singlePlayerMode) {
    User user =  gameData.addUser(name, password, application, singlePlayerMode);
    log.debug(user.toString());
    return user;
  }

  @Override
  public void placeShipsAutomatically(int playerNr) {
    //throw new UnsupportedOperationException("Method placeShipsAutomatically() not implemented.");
  }

  @Override
  public Ship placeShip(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal) {
    return gameData.addShip(playerNr, shipType, bowX, bowY, horizontal);
    //throw new UnsupportedOperationException("Method placeShip() VISUAL not implemented.");
  }

  @Override
  public void removeShip(int playerNr, int posX, int posY) {
    removeShip(playerNr, posX, posY);
    throw new UnsupportedOperationException("Method removeShip()VISUAL not implemented.");
  }

  @Override
  public void removeAllShips(int playerNr) {
    gameData.removeAllShips(playerNr);
    throw new UnsupportedOperationException("Method removeAllShips()VISUAL not implemented.");
  }

  @Override
  public void notifyWhenReady(int playerNr) {
    throw new UnsupportedOperationException("Method notifyWhenReady() not implemented.");
  }

  @Override
  public void fireShot(int playerNr, int posX, int posY) {
    throw new UnsupportedOperationException("Method fireShot() not implemented.");
  }

  @Override
  public void startNewGame(int playerNr) {
    throw new UnsupportedOperationException("Method startNewGame() not implemented.");
  }

  @Override
  public ArrayList<Ship> getShips(int playerNr) {
    return gameData.getShips(playerNr);
  }
}
