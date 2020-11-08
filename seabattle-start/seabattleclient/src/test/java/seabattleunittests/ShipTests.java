package seabattleunittests;

import models.Ship;
import org.junit.jupiter.api.Test;
import seabattlegui.ShipType;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipTests {
    Ship shipTests;
    int testPlayerNr;

    public ShipTests() {
        testPlayerNr = 1;
        shipTests = new Ship(testPlayerNr, ShipType.CRUISER,1,1,false);
    }

    @Test
    public void damage() {
        var hp =shipTests.health;
        shipTests.giveDammage();
        var actual = hp-1;
        var expected = 2;
        assertSame(actual,expected);
    }

    @Test
    public void sunk() {
        var hp =shipTests.health;
        for(int i=0;i<hp;i++){
            shipTests.giveDammage();
        }
        var expected =0;
        var actual =shipTests.health;
        assertSame(actual,expected);
    }
}
