package com.zypo8.games.items.consumable;

import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;

public class Consumable extends Item {

    public Consumable(String spriteFIle, int itemID, ItemRarity itemRarity, Location location) {
        super(spriteFIle, itemID, itemRarity, location);
        stackAmount = 5;
    }

    @Override
    public void setUpFirstOption() {
        consume();
    }
}
