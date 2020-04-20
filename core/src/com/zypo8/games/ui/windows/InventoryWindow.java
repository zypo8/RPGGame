package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.windows.WindowWithTopRightCornerCloseButton;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.armor.helms.MithrilHelmet;
import com.zypo8.games.items.armor.necks.EmeraldNeck;

public class InventoryWindow extends WindowWithTopRightCornerCloseButton {
    private static Array<com.zypo8.games.items.InventorySlot> inventorySlots;
    private Table table;
    public static int freeSpace = 28;
    public static int coins;
    public static Label coinsLabel = new Label(String.valueOf(coins), Tools.getSkin());

    public InventoryWindow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setName("Player Inventory WIndow");
        setUpCoinsLabel();


        inventorySlots = new Array<>(true, 28);
        for (int i=0;i<28;i++)
            inventorySlots.add(new com.zypo8.games.items.InventorySlot());
        if (table == null)
            setUpTable();
        addActor(table);
        inventorySlots.get(0).setItem(new MithrilHelmet());
        inventorySlots.get(0).setAmount(1);

        inventorySlots.get(1).setItem(new EmeraldNeck());
        inventorySlots.get(1).setAmount(1);
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(new Label("Coins: ", Tools.getSkin())).center().expand().padTop(20);
        table.add(coinsLabel).center().expand().padTop(20);
        table.row();
        table.add(inventorySlots.get(0)).expand().padTop(20);
        table.add(inventorySlots.get(1)).expand().padTop(20);
        table.add(inventorySlots.get(2)).expand().padTop(20);
        table.add(inventorySlots.get(3)).expand().padTop(20);
        table.row();
        table.add(inventorySlots.get(4)).expand();
        table.add(inventorySlots.get(5)).expand();
        table.add(inventorySlots.get(6)).expand();
        table.add(inventorySlots.get(7)).expand();
        table.row();
        table.add(inventorySlots.get(8)).expand();
        table.add(inventorySlots.get(9)).expand();
        table.add(inventorySlots.get(10)).expand();
        table.add(inventorySlots.get(11)).expand();
        table.row();
        table.add(inventorySlots.get(12)).expand();
        table.add(inventorySlots.get(13)).expand();
        table.add(inventorySlots.get(14)).expand();
        table.add(inventorySlots.get(15)).expand();
        table.row();
        table.add(inventorySlots.get(16)).expand();
        table.add(inventorySlots.get(17)).expand();
        table.add(inventorySlots.get(18)).expand();
        table.add(inventorySlots.get(19)).expand();
        table.row();
        table.add(inventorySlots.get(20)).expand();
        table.add(inventorySlots.get(21)).expand();
        table.add(inventorySlots.get(22)).expand();
        table.add(inventorySlots.get(23)).expand();
        table.row();
        table.add(inventorySlots.get(24)).expand();
        table.add(inventorySlots.get(25)).expand();
        table.add(inventorySlots.get(26)).expand();
        table.add(inventorySlots.get(27)).expand();
        table.row();

    }

    public static void addItem(InventorySlot newInventorySlot){
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return;
                }
            }
        }
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(newInventorySlot.getItem());
                inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                freeSpace--;
                return;
            }
        }
        for (int i = 0;i < Actionbar.inventorySlots.size;i++){
            if(Actionbar.inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == Actionbar.inventorySlots.get(i).getItem().getItemID()){
                if(Actionbar.inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= Actionbar.inventorySlots.get(i).getItem().getStackAmount()) {
                    Actionbar.inventorySlots.get(i).setAmount(Actionbar.inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return;
                }
            }
        }
        for (int i = 0;i < Actionbar.inventorySlots.size;i++){
            if (Actionbar.inventorySlots.get(i).getItem() == null){
                Actionbar.inventorySlots.get(i).setItem(newInventorySlot.getItem());
                Actionbar.inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                Actionbar.freeSpace--;
                return;
            }
        }
    }

//    public static void consume(int inventorySlot){
//        if(inventorySlots.get(inventorySlot).getAmount() > 1)
//            inventorySlots.get(inventorySlot).setAmount(inventorySlots.get(inventorySlot).getAmount()-1);
//        else {
//            inventorySlots.get(inventorySlot).setItem(null);
//        }
//    }

    public static void addCoins(int newCoins){
        coins += newCoins;
        setUpCoinsLabel();
    }

    private static void setUpCoinsLabel() {

        coinsLabel.setText(coins);
        if(coins >= 10000 && coins < 1000000)
            coinsLabel.setText(coins/1000+"K");
        if(coins >=1000000)
            coinsLabel.setText(coins/1000000+"M");
    }

    public static void removeCoins(int vendorPrice) {
        coins -= vendorPrice;setUpCoinsLabel();
    }

}
