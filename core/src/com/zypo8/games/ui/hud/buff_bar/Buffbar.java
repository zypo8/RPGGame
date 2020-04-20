package com.zypo8.games.ui.hud.buff_bar;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.items.InventorySlot;

public class Buffbar extends Group {
    public static int freeSpace = 18;
    public static Array<InventorySlot> inventorySlots;
    private Table table;

    public Buffbar(){
        inventorySlots = new Array<>(true, 18);
        for(int i=0;i<18;i++) {
            inventorySlots.add(new InventorySlot(false));
        }
        table= new Table();
        table.setFillParent(true);
        for(int i=0;i<18;i++) {
            table.add(inventorySlots.get(i)).padTop(15).padRight(7).padLeft(7);
            if((i+1)%9==0)
                table.row();
        }
        addActor(table);
        InventorySlot inventorySlot = new InventorySlot();
        inventorySlot.setItem(new Buff("asd", 20, false));
        inventorySlot.setAmount(2);

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
