package seabattleunittests;

import models.Square;
import org.junit.jupiter.api.Test;
import seabattlegame.SeaBattleGame;
import seabattlegui.ShipType;

import static org.junit.jupiter.api.Assertions.*;

public class SeaBattleTests {
    SeaBattleGame testFunctions;
    int testPlayerNr;

    public SeaBattleTests() {
        testFunctions = new SeaBattleGame();
        testPlayerNr = 1;
    }

    @Test
    public void placeShip() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        assertTrue(testFunctions.shipPlaced(1, ShipType.CRUISER));
    }

    @Test
    public void removeShip() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        testFunctions.removeShip(testPlayerNr, 1, 1);
        assertFalse(testFunctions.shipPlaced(1, ShipType.CRUISER));
    }

    @Test
    public void removeAllShips() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        testFunctions.placeShip(testPlayerNr, ShipType.AIRCRAFTCARRIER, 5, 5, false);
        testFunctions.removeAllShips(testPlayerNr);
        assertFalse(testFunctions.shipPlaced(1, ShipType.CRUISER));
        assertFalse(testFunctions.shipPlaced(1, ShipType.AIRCRAFTCARRIER));
    }

    @Test
    public void getShips() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        var actual = testFunctions.getShips(testPlayerNr).size();
        var expected = 1;
        assertSame(expected, actual);
    }

    @Test
    public void shipPlaced() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        var actual = testFunctions.shipPlaced(1, ShipType.CRUISER);
        assertTrue(actual);
    }

    @Test
    public void getShipByCords() {
        var expected =testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        var actual =testFunctions.getShipByCords(testPlayerNr,1,1);
        assertSame(expected, actual);
    }

    @Test
    public void getNrOfShips() {
        testFunctions.placeShip(testPlayerNr, ShipType.CRUISER, 1, 1, false);
        testFunctions.placeShip(testPlayerNr, ShipType.AIRCRAFTCARRIER, 5, 5, false);
        var expected = 2;
        var actual =testFunctions.getNrOfShips(testPlayerNr);
        assertSame(expected, actual);
    }

}