package com.zypo8.games.abilities.buffs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUDStage;

public class Buff extends Item {
    public Buff(String spriteFIle, int itemID, boolean isDeBuff) {
        //super(spriteFIle, itemID);
        super("img/actors/items/talents/palladyn/2.png", 20);
        this.isDeBuff = isDeBuff;
        if(!isDeBuff)
            setName("Buff");
        else
            setName("DeBuff");
    }

    @Override
    public void firstOption() {
    }

    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        if(!isDeBuff)
            HUDStage.lastClickedSlot.removeItem();
    }

    public void itemHoverWindow(Window window, Skin skin){
        if(!isDeBuff)
            window.setPosition(window.getX()+window.getWidth(), window.getY()-35-window.getHeight());
    }

    public void effect(){}
}
