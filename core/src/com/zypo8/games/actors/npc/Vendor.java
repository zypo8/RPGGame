package com.zypo8.games.actors.npc;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.VendorWindow;
import com.zypo8.games.actors.player.Character;

public class Vendor extends Character {
    private VendorWindow vendorWindow;

    public Vendor(int posX, int posY, HUDStage hudStage) {
        super("img/actors/player.gif", posX, posY, hudStage, "Vendor");
        vendorWindowSetUp();
    }

    private void vendorWindowSetUp() {
        vendorWindow = new VendorWindow(getName(), Tools.getSkin());
        vendorWindow.addItem(new InventorySlot(new Apple(Location.Vendor), 10));


        hudStage.addActor(vendorWindow);
        vendorWindow.setVisible(false);
    }

    @Override
    public void firstOption() {
        showVendor();
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactButtons.addVendorButton(this));
        window.row();
        window.add(interactButtons.addTalkButton(this));
    }

    @Override
    public void showVendor() {
        super.showVendor();
        vendorWindow.setVisible(true);
    }

    @Override
    public void talk() {
        super.talk();
    }

    //getters and setters
    public VendorWindow getVendorWindow() {
        return vendorWindow;
    }

    public void setVendorWindow(VendorWindow vendorWindow) {
        this.vendorWindow = vendorWindow;
    }
}

