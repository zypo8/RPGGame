package com.zypo8.games.items.talents.talentSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;

public class Talent extends Item {
    protected int amount;
    public boolean isActive;
    public int talentCount;
    public Sprite inActiveSprite;
    public Talent(String spriteFIle, String inActiveSpriteFile, int itemID, int talentCount) {
        super(spriteFIle, itemID);
        this.inActiveSprite = new Sprite(new Texture(Gdx.files.internal(inActiveSpriteFile)));
        this.talentCount = talentCount;
    }


    @Override
    public void itemHoverWindow(Window window, Skin skin){

        if(!isLocked)
            window.add(description);
        else {
            window.add(new Label("need at least 12 points \n in primary tree", Tools.getSkin()));
            window.row();
            window.add(description);
        }
    }

    @Override
    public void firstOption() {
        if(!isLocked)
            addTalentPoint();
    }

    @Override
    public void addTalentPoint() {
        if(amount < talentCount) {
            isActive = true;
            amount++;
            HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount() + 1);
            com.zypo8.games.items.talents.talentSystem.TalentSystem.talentSpend++;
        }
    }

    @Override
    public void removeTalentPoint() {
        if(amount > 0) {
            if(amount == 1)
                isActive = false;
            amount--;
            HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount() - 1);
            TalentSystem.talentSpend--;
        }
    }

    //getters and setters
    public int getTalentCount() {
        return talentCount;
    }

    public void setTalentCount(int talentCount) {
        talentCount = talentCount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
