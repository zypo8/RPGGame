package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.ui.windows.WindowWithTopRightCornerCloseButton;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;

public class LootWindow extends WindowWithTopRightCornerCloseButton {
    private Table table;
    private Array<com.zypo8.games.items.InventorySlot> inventorySlots;
    public LootWindow(String title, Skin skin) {
        super(title, skin);
        inventorySlots = new Array<com.zypo8.games.items.InventorySlot>(true, 8);
        setMovable(true);
        setSize(125, 210);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        for (int i=0;i<8;i++)
            inventorySlots.add(new InventorySlot());
        if (table == null)
            setUpTable();
        addActor(table);
    }

    public void addItemToLoot(Item item, int amount){
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(item);
                inventorySlots.get(i).setAmount(amount);
                break;

            }
        }
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(inventorySlots.get(0)).expand().padTop(25);
        table.add(inventorySlots.get(1)).expand().padTop(25);
        table.row();
        table.add(inventorySlots.get(2)).expand();
        table.add(inventorySlots.get(3)).expand();
        table.row();
        table.add(inventorySlots.get(4)).expand();
        table.add(inventorySlots.get(5)).expand();
        table.row();
        table.add(inventorySlots.get(6)).expand();
        table.add(inventorySlots.get(7)).expand();


    }
}
