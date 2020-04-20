package com.zypo8.games.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.items.talents.talentSystem.Talent;


public class InventorySlot extends Group {
    private static int slotsNumber = 0;
    protected int slotID, amount;
    protected Sprite backgroundImage;
    protected com.zypo8.games.items.Item item;
    protected com.zypo8.games.items.talents.talentSystem.Talent talent;
    protected com.zypo8.games.items.armor.SlotType slotType;
    private boolean drawBackground = true;
    private Texture debuffBackground = new Texture(Gdx.files.internal("img/actors/abilities/buffs/debuffBackground.png"));
    private Texture useBackground = new Texture(Gdx.files.internal("img/items/Use.png"));

    public InventorySlot(com.zypo8.games.items.Item item, int amount){
        this();
        this.item = item;
        this.amount = amount;
    }

    public InventorySlot(boolean drawBackground){
        this();
        this.drawBackground = drawBackground;
    }

    public  InventorySlot(SlotType slotType){
        this();
        this.slotType = slotType;
    }
    public InventorySlot(){
        slotID = slotsNumber;
        backgroundImage = new Sprite(new Texture(Gdx.files.internal("img/ui/inventorySlotBGimg.png")));
        setBounds(backgroundImage.getX(), backgroundImage.getY(), backgroundImage.getWidth(), backgroundImage.getHeight());
        setTouchable(Touchable.enabled);
        setName("InventorySlot"+slotID);
        slotsNumber++;
        MyRPGGame.font.setColor(Color.WHITE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(drawBackground)
            backgroundImage.draw(batch);
        if(item != null){
            if(item.isDeBuff){
                batch.draw(debuffBackground, getX()-1, getY()-1);
            }

            batch.draw(item.sprite, getX(), getY());
            if(amount > 1 && amount < 10) {
                MyRPGGame.font.setColor(Color.WHITE);
                MyRPGGame.font.draw(batch, String.valueOf(amount), getX() + 22, getY() + 14);
            }
            if (amount >= 10) {
                MyRPGGame.font.setColor(Color.WHITE);
                MyRPGGame.font.draw(batch, String.valueOf(amount), getX() + 14, getY() + 14);
            }

        if(item.selected){
            batch.draw(useBackground, getX()-3, getY()-3);
        }

        }
    }

    public com.zypo8.games.items.Item getItem() {
        return item;
    }

    public void setItem(com.zypo8.games.items.Item item) {
        this.item = item;
    }

    public void removeItem(){
        InventoryWindow.freeSpace++;
        item = null;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    @Override
    protected void positionChanged() {
        backgroundImage.setPosition(getX(), getY());
        super.positionChanged();
    }

}
