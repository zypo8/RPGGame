package com.zypo8.games.actors.stairs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.Screens.GameScreen;

public class Stairs extends Interactable {
    protected int maxFloor, minFloor;
    public Stairs(String spriteFIle, int posX, int posY, HUDStage hudStage, String actorName, int minFloor, int maxFloor) {
        super(spriteFIle, posX, posY, hudStage, actorName);
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        if(com.zypo8.games.Screens.GameScreen.floor < maxFloor)
            window.add(interactButtons.goUp(this));
        window.row();
        if (com.zypo8.games.Screens.GameScreen.floor > minFloor )
            window.add(interactButtons.goDown(this));
    }

    @Override
    public void goUp() {
        com.zypo8.games.Screens.GameScreen.floor++;
        com.zypo8.games.Screens.GameScreen.worldUpdate();
    }

    @Override
    public void goDown() {
        com.zypo8.games.Screens.GameScreen.floor--;
        GameScreen.worldUpdate();
    }
}
