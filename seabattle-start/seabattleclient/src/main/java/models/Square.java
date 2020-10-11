package models;

import seabattlegui.SquareState;

public class Square {
    public SquareState getState() {
        return state;
    }

    public void setState(SquareState state) {
        this.state = state;
    }

    private SquareState state;

    public Square(){
        this.state = SquareState.WATER;
    }

}
