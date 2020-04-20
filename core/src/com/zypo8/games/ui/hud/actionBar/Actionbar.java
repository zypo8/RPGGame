package com.zypo8.games.ui.hud.actionBar;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.abilities.skills.palladyn_skills.HandCannon;
import com.zypo8.games.items.InventorySlot;

public class Actionbar extends Group {
    public static int freeSpace = 12;
    public static Array<InventorySlot> inventorySlots;
    private Table table;

    public Actionbar(){
        inventorySlots = new Array<>(true, 12);
        for(int i=0;i<12;i++)
            inventorySlots.add(new InventorySlot());
        table= new Table();
        table.setFillParent(true);
        for(int i=0;i<12;i++)
            table.add(inventorySlots.get(i));
        addActor(table);
        InventorySlot inventorySlot = new InventorySlot();
        inventorySlot.setItem(new HandCannon());
        inventorySlot.setAmount(1);

        addItem(inventorySlot);
    }

    public static void addItem(InventorySlot lastClickedSlot) {
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(lastClickedSlot.getItem());
                inventorySlots.get(i).setAmount(lastClickedSlot.getAmount());
                freeSpace--;
                return;
            }
        }
        if(freeSpace <= 0){
            System.out.println("NOT ENOUGH SPACE IN ACTION BAR");
        }
    }
}
