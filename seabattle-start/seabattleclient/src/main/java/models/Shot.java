package models;

import seabattlegui.ShipType;
import seabattlegui.ShotType;

public class Shot {
    public int playerTarget;
    public int bowX;
    public int bowY;
    public ShotType shotType;

    public Shot(int player, int bowX, int bowY, ShotType shotType) {
        this.playerTarget = player;
        this.bowX = bowX;
        this.bowY = bowY;
        this.shotType = shotType;

        switch (shotType){
            case MISSED:
                break;
            case HIT:
                break;
            case SUNK:
                break;
            case ALLSUNK:
                break;
        }
    }
}
