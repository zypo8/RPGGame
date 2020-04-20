package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.consumable.Consumable;

public class Apple extends Consumable {

    public Apple(Location location) {
        super("img/actors/items/item_apple.png", 1, ItemRarity.Legendary, location);
        this.setName("Apple");
    }

    @Override
    public void setUpButtons(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactItemButtons.addConsumeButton(this));
        window.row();
        window.add(interactItemButtons.addDropButton(this));
        window.row();

    }

    @Override
    public void itemHoverWindow(Window window, Skin skin) {
    }

    @Override
    public void consume() {
        System.out.println("heal for 27");
        super.consume();
    }
}
