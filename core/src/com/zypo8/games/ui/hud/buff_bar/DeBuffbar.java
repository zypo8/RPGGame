package com.zypo8.games.ui.hud.buff_bar;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.items.InventorySlot;

public class DeBuffbar extends Group {
    public static int freeSpace = 18;
    public static Array<com.zypo8.games.items.InventorySlot> inventorySlots;
    private Table table;

    public DeBuffbar(){
        inventorySlots = new Array<>(true, 18);
        for(int i=0;i<18;i++)
            inventorySlots.add(new com.zypo8.games.items.InventorySlot(false));
        table= new Table();
        table.setFillParent(true);
        for(int i=0;i<18;i++) {
            table.add(inventorySlots.get(i)).padTop(15).padRight(7).padLeft(7);
            if((i+1)%6 == 0){
                table.row();
            }
        }
        addActor(table);
        com.zypo8.games.items.InventorySlot inventorySlot = new com.zypo8.games.items.InventorySlot();
        inventorySlot.setItem(new Buff("asd", 22, true));
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
    }
}
