package com.zypo8.games.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.windows.InteractItemButtons;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.items.armor.SlotType;

public class Item extends Actor {

    //normal things
    protected InteractItemButtons interactItemButtons;
    protected ItemRarity itemRarity = ItemRarity.Common;
    protected Location location = Location.Inventory;
    protected int vendorPrice = 100;
    protected com.zypo8.games.items.armor.SlotType slotType;
    protected int stackAmount = 20;
    protected int itemID;
    public Sprite sprite;
    protected TextArea description;
    protected int CD;
    public boolean selected;

    //talent and buff extension
    public boolean isLocked;
    protected boolean isDeBuff;


    public Item(String spriteFIle, int itemID, ItemRarity itemRarity, Location location){
        this(spriteFIle, itemID, itemRarity);
        this.location = location;

    }

    public Item(String spriteFIle, int itemID, ItemRarity itemRarity){
        this(spriteFIle, itemID);
        this.itemRarity = itemRarity;

    }

    public Item(String spriteFIle, int itemID) {
        sprite = new Sprite(new Texture(Gdx.files.internal(spriteFIle)));
        this.itemID = itemID;
        this.setTouchable(Touchable.enabled);
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        interactItemButtons = new InteractItemButtons(Tools.getSkin());

    }
    public void firstOption(){
        if(location == Location.Vendor){
            buy();
        }
        if (location == Location.Loot) {
            take();
        }

        if (location == Location.Equiped) {
            unequip();
        }
        if(location == Location.Inventory || location == Location.ActionBar){
            setUpFirstOption();
        }
    }

    // This one you override for left click use effect setup
    public void setUpFirstOption() {
        if(location == Location.ActionBar){
            removeFromActionBar();
        }
        if(location == Location.Inventory){
            addToActionBar();
        }
    }

    //This one YOU DO NOT TOUCH !!!!
    public void itemInteractWindow(Window window, Skin skin){
        if(location == Location.Vendor){
            window.setHeight(70);
            window.add(interactItemButtons.addBuy(this));
        }
        if (location == Location.Loot) {
            window.setHeight(70);
            window.add(interactItemButtons.addTakeButton(this));
        }

        if (location == Location.Equiped) {
            window.setHeight(70);
            window.add(interactItemButtons.addUnequipItem(this));
        }
        if(location == Location.ActionBar){
            setUpButtons(window, skin);
            window.setHeight(window.getHeight()+35);
            window.add(interactItemButtons.addRemoveFromActionBar(this));
        }
        if(location == Location.Inventory){
            setUpButtons(window, skin);
            window.setHeight(window.getHeight()+35);
            window.add(interactItemButtons.addAddToActionBar(this));
        }
    }

    // THis method is the one you override to create interact window
    public void setUpButtons(Window window, Skin skin) {
    }


    public void itemHoverWindow(Window window, Skin skin){
        System.out.println("Hovered over "+ this.getName());
    }

    public void consume(){
        System.out.println("consumed "+HUDStage.lastClickedSlot.getItem());
        HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount()-1);
        if(HUDStage.lastClickedSlot.getAmount() == 0) {
            if(HUDStage.lastClickedSlot.getItem().getLocation() == Location.Inventory)
                InventoryWindow.freeSpace++;
            if(HUDStage.lastClickedSlot.getItem().getLocation() == Location.ActionBar)
                Actionbar.freeSpace++;
            HUDStage.lastClickedSlot.removeItem();
        }
    }

    public void use(){
        System.out.println("Nothing interesting happens.");
    }

    public void addToActionBar(){
        if(Actionbar.freeSpace > 0) {
            Actionbar.addItem(HUDStage.lastClickedSlot);
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            location = Location.ActionBar;
            Actionbar.freeSpace--;
            InventoryWindow.freeSpace++;
        }
        else
            System.out.println("ActionBAR IS FULL!!!");

    }

    public void removeFromActionBar(){
        if(InventoryWindow.freeSpace > 0){
            InventoryWindow.addItem(HUDStage.lastClickedSlot);
            HUDStage.lastClickedSlot.removeItem();
            location = Location.Inventory;
            Actionbar.freeSpace++;
            InventoryWindow.freeSpace--;
        }
        else
            System.out.println("INVENTORY IS FULLL");

    }

    public void drop(){
        HUDStage.lastClickedSlot.removeItem();
        InventoryWindow.freeSpace++;
    }

    public void equip(){
        location = Location.Equiped;
        InventoryWindow.freeSpace++;
    }

    public void take(){
        if(InventoryWindow.freeSpace > 0) {
            InventoryWindow.addItem(HUDStage.lastClickedSlot);
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            location = Location.Inventory;
            InventoryWindow.freeSpace--;
        }
        else
            System.out.println("INVENTORY IS FULL!!!");

    }

    public void buy(){
        if(InventoryWindow.coins >= vendorPrice) {
            InventoryWindow.removeCoins(vendorPrice);
            InventoryWindow.addItem(HUDStage.lastClickedSlot);
            location = Location.Inventory;
            InventoryWindow.freeSpace--;
        }
        else
            System.out.println("NOT ENOUGH GOLD");
    }

    public void select(){
        selected = true;
        System.out.println("selected");
    }


    public void unequip() {
        if(InventoryWindow.freeSpace > 0){
            InventoryWindow.addItem(HUDStage.lastClickedSlot);
            HUDStage.lastClickedSlot.removeItem();
            location = Location.Inventory;
            InventoryWindow.freeSpace--;
        }
        else {
            System.out.println("Inventory is full");
        }
    }

    public void addTalentPoint(){
        System.out.println("Talent Point Added");
    }

    public void removeTalentPoint(){
        System.out.println("Talent Point Added");
    }


    //Getters and Setters
    public int getItemID() {
        return itemID;
    }


    public com.zypo8.games.items.armor.SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public int getStackAmount() {
        return stackAmount;
    }

    public void setStackAmount(int stackAmount) {
        this.stackAmount = stackAmount;
    }

    public int getCD() {
        return CD;
    }

    public void setCD(int CD) {
        this.CD = CD;
    }

    public ItemRarity getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(ItemRarity itemRarity) {
        this.itemRarity = itemRarity;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }
}
