package seabattleunittests;

import models.User;
import org.junit.jupiter.api.Test;
import seabattlegui.ISeaBattleGUI;
import seabattlegui.ShipType;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {
    User userTests;
    public ISeaBattleGUI application;

    public UserTests() {
        userTests = new User("test","testp",application,true);
    }

    @Test
    public void getNrOfShips() {
        userTests.getNrOfShips();
        assertTrue(userTests.nrOfShips==5);
    }

    @Test
    public void sinkShip() {
        userTests.sinkship();
        assertTrue(userTests.nrOfShips==4);
    }

    @Test
    public void userLost() {
        var lost = false;
        for(int i=0;i<5;i++){
            userTests.sinkship();
            if (userTests.nrOfShips==0){
                lost =true;
            }
        }
        assertTrue(lost);
    }
}
