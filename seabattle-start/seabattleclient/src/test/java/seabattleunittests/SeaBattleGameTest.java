/*
 * Sea Battle Start project.
 */
package seabattleunittests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seabattlegame.ISeaBattleGame;
import seabattlegame.SeaBattleGame;
import seabattlegui.GameData;
import seabattlegui.ShipType;
import seabattlegui.SquareState;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for Sea Battle game.
 * @author Nico Kuijpers
 */
class SeaBattleGameTest {
    
    private ISeaBattleGame game;
    private MockSeaBattleApplication applicationPlayer;
    private MockSeaBattleApplication applicationOpponent;
    
    SeaBattleGameTest() {
    }

    @BeforeEach
    void setUp() {
        
        // Create the Sea Battle game
        game = new SeaBattleGame();
        
        // Create mock Sea Battle GUI for player
        applicationPlayer = new MockSeaBattleApplication();
        
        // Create mock Sea Battle GUI for opponent
        applicationOpponent = new MockSeaBattleApplication();
    }
    
    @AfterEach
    void tearDown() {
    }

    /**
     * Example test for method registerPlayerName(). 
     * Test whether an IllegalArgumentException is thrown when parameter 
     * name is null.
     * @author Nico Kuijpers
     */
    @Test() // expected=IllegalArgumentException.class
    void testRegisterPlayerNameNull() {

        // Register player with parameter name null in single-player mode
        String name = null;
        String password = "password";
        boolean singlePlayerMode = true;
        game.registerPlayer(name, password, applicationPlayer, singlePlayerMode);
    }
    
    /**
     * Example test for method placeShipsAutomatically().
     * Test whether the correct number of squares contain a ship in the
     * ocean area of the player's application.
     */
    @Test
    void testPlaceShipsAutomatically() {
        
        // Register player in single-player mode
        game.registerPlayer("Some Name", "Some Password", applicationPlayer, true);
        
        // Place ships automatically
        int playerNr = applicationPlayer.getPlayerNumber();
        game.placeShipsAutomatically(playerNr);
        
        // Count number of squares where ships are placed in player's application
        int expectedResult = 5 + 4 + 3 + 3 + 2;
        int actualResult = applicationPlayer.numberSquaresPlayerWithSquareState(SquareState.SHIP);
        assertEquals(expectedResult,actualResult, "Wrong number of squares where ships are placed");
    }

    @Test
    void removeShip()
    {
        // Register player in single-player mode
        game.registerPlayer("Some Name", "Some Password", applicationPlayer, true);
        int playerNr = applicationPlayer.getPlayerNumber();

        // Place and remove ship
        game.placeShip(playerNr,ShipType.BATTLESHIP,0,0,true);
        game.removeShip(playerNr,0,0);

        // Count number of squares where ships are placed in player's application
        int expectedResult = 0;
        int actualresult = applicationPlayer.numberSquaresOpponentWithSquareState(SquareState.SHIP);
        assertEquals(expectedResult,actualresult);
    }

    @Test
    void firedShotHits()
    {
        // Register player in single-player mode
        game.registerPlayer("Some Name", "Some Password", applicationPlayer, true);
        int playerNr = applicationPlayer.getPlayerNumber();

        game.placeShip(playerNr,ShipType.BATTLESHIP,0,0,true);
        game.fireShot(playerNr,0,0);

        int expectedResult = applicationOpponent.numberSquaresOpponentWithSquareState(SquareState.SHOTHIT);
        int actualresult = applicationPlayer.numberSquaresOpponentWithSquareState(SquareState.SHOTHIT);
        assertEquals(expectedResult,actualresult);
    }

    @Test
    void firedShotMiss()
    {
        // Register player in single-player mode
        game.registerPlayer("Some Name", "Some Password", applicationPlayer, true);
        int playerNr = applicationPlayer.getPlayerNumber();

        game.placeShip(playerNr,ShipType.BATTLESHIP,0,0,true);
        game.fireShot(playerNr,0,0);

        int expectedResult = applicationOpponent.numberSquaresOpponentWithSquareState(SquareState.SHOTMISSED);
        int actualresult = applicationPlayer.numberSquaresOpponentWithSquareState(SquareState.SHOTMISSED);
        assertEquals(expectedResult,actualresult);
    }

}

