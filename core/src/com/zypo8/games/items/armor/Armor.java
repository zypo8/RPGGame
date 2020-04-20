package com.zypo8.games.items.armor;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.InventoryWindow;

public class Armor extends Item {
    private InventorySlot tempSlot = new InventorySlot();
    public Armor(String spriteFIle, int itemID, SlotType slotType) {
        super(spriteFIle, itemID);
        this.slotType = slotType;
        stackAmount = 1;
    }


    @Override
    public void setUpButtons(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactItemButtons.addUseButton(this));
        window.row();
        window.add(interactItemButtons.addDropButton(this));
        window.row();
        window.add(interactItemButtons.addEquipButton(this));
        window.row();
    }

    @Override
    public void setUpFirstOption() {
        if(location == Location.Equiped){
            unequip();
        }
        if(location == Location.Inventory){
            equip();
        }
    }

    @Override
    public void equip() {
        switch (this.slotType) {
            case Head:
                if (EquipmentWindow.headSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.headSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                    InventoryWindow.freeSpace++;

                } else {
                    tempSlot.setItem(EquipmentWindow.headSlot.getItem());
                    EquipmentWindow.headSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    HUDStage.lastClickedSlot.getItem().setLocation(Location.Inventory);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Boots:
                if (EquipmentWindow.bootsSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.bootsSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.bootsSlot.getItem());
                    EquipmentWindow.bootsSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Ring:
                if (EquipmentWindow.fingerSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.fingerSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.fingerSlot.getItem());
                    EquipmentWindow.fingerSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Shoulders:
                if (EquipmentWindow.shoulderSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.shoulderSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.shoulderSlot.getItem());
                    EquipmentWindow.shoulderSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Legs:
                if (EquipmentWindow.legsSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.legsSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.legsSlot.getItem());
                    EquipmentWindow.legsSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Gloves:
                if (EquipmentWindow.glovesSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.glovesSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.glovesSlot.getItem());
                    EquipmentWindow.glovesSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case MainHand:
                if (EquipmentWindow.mainHand.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.mainHand.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.mainHand.getItem());
                    EquipmentWindow.mainHand.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Offhand:
                if (EquipmentWindow.offHand.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.offHand.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.offHand.getItem());
                    EquipmentWindow.offHand.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Chest:
                if (EquipmentWindow.chestSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.chestSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.chestSlot.getItem());
                    EquipmentWindow.chestSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
            case Neck:
                if (EquipmentWindow.neckSlot.getItem() == null) {
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.neckSlot.setItem(this);
                    HUDStage.lastClickedSlot.removeItem();
                } else {
                    tempSlot.setItem(EquipmentWindow.neckSlot.getItem());
                    EquipmentWindow.neckSlot.setItem(this);
                    HUDStage.lastClickedSlot.setItem(tempSlot.getItem());
                    HUDStage.lastClickedSlot.setAmount(1);
                    //HUDStage.lastClickedSlot.getItem().equiped = false;
                }
                break;
        }
        location = Location.Equiped;
    }

}
