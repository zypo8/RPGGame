package com.zypo8.games.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.InteractButtons;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;

public class Interactable extends Actor {
    protected HUDStage hudStage;
    protected Sprite sprite;
    protected com.zypo8.games.actors.InteractButtons interactButtons;

    public Interactable(String spriteFIle, int posX, int posY, HUDStage hudStage, String actorName) {
        sprite = new Sprite(new Texture(Gdx.files.internal(spriteFIle)));
        setPosition(posX, posY);
        this.hudStage = hudStage;
        this.setName(actorName);
        this.setTouchable(Touchable.enabled);
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        interactButtons = new InteractButtons(Tools.getSkin());
    }

    public void talk(){System.out.println("Talking");}

    public void firstOption(){System.out.println("NO FIRST OPTION SETUP!!!");}

    public void interactWindow(Window window, Skin skin){
        System.out.println("interacted");
    }

    public void showInventory(){
        System.out.println("inventory show");
    }

    public void showTalents(){
        System.out.println("talents show");
    }

    public void showEquipment(){
        System.out.println("equipment show");
    }

    public void showVendor(){
        System.out.println("vendor show");
    }

    public void showQuest(){
        System.out.println("quest show");
    }

    public void showGather(){
        System.out.println("gather show");
    }

    public void goUp(){
        System.out.println("up");
    }

    public void goDown(){
        System.out.println("down");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }
}