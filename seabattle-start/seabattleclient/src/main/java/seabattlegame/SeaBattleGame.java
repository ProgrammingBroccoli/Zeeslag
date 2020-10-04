/*
 * Sea Battle Start project.
 */
package seabattlegame;

import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seabattlegui.GameData;
import seabattlegui.ISeaBattleGUI;
import seabattlegui.ShipType;

import java.io.Console;

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
  public void registerPlayer(String name, String password, ISeaBattleGUI application, boolean singlePlayerMode) {
    gameData.addUser(name, password, application, singlePlayerMode);
    User user = gameData.getUser(1);
    log.debug(user.toString());
    //throw new UnsupportedOperationException("Method registerPlayer() not implemented.");
  }

  @Override
  public void placeShipsAutomatically(int playerNr) {
    //throw new UnsupportedOperationException("Method placeShipsAutomatically() not implemented.");
  }

  @Override
  public void placeShip(int playerNr, ShipType shipType, int bowX, int bowY, boolean horizontal) {
    throw new UnsupportedOperationException("Method placeShip() not implemented.");
  }

  @Override
  public void removeShip(int playerNr, int posX, int posY) {
    throw new UnsupportedOperationException("Method removeShip() not implemented.");
  }

  @Override
  public void removeAllShips(int playerNr) {
    throw new UnsupportedOperationException("Method removeAllShips() not implemented.");
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
}
