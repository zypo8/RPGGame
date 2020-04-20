package com.zypo8.games.abilities.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;

public class Skill extends Item {
    protected int amount;
    public boolean isActive;
    public Sprite inActiveSprite;

    public Skill(String spriteFIle, String inActiveSpriteFile, int itemID) {
        super(spriteFIle, itemID);
        this.inActiveSprite = new Sprite(new Texture(Gdx.files.internal(inActiveSpriteFile)));
        setName("ability");
    }

    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        window.setHeight(80);
        window.add(interactItemButtons.addUseButton(this));
    }

    @Override
    public void itemHoverWindow(Window window, Skin skin){

        if(!isLocked)
            window.add(description);
        else {
            window.add(new Label("need at least 12 points \n in primary tree", Tools.getSkin()));
            window.row();
            window.add(description);
        }
    }
    @Override
    public void removeFromActionBar() {
        HUDStage.lastClickedSlot.removeItem();
    }

    @Override
    public void firstOption() {
        use();
    }

    @Override
    public void use() {
        System.out.println("Skill Used "+this.getName());
    }
    //getters and setters

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
