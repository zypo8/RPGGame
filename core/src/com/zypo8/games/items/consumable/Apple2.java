package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.consumable.Consumable;

public class Apple2 extends Consumable {
    public Apple2(String spriteFIle, int itemID) {
        super(spriteFIle, itemID, ItemRarity.Common, Location.Inventory);
        this.setName("Apple2");
    }

    @Override
    public void setUpButtons(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactItemButtons.addConsumeButton(this));
        window.row();
        window.add(interactItemButtons.addUseButton(this));
        window.row();
        window.add(interactItemButtons.addDropButton(this));
    }

    @Override
    public void consume() {
        System.out.println("heal for 1");
    }

}
