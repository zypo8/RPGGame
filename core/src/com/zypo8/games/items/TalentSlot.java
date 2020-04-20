package com.zypo8.games.items;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.zypo8.games.MyRPGGame;

public class TalentSlot extends InventorySlot {
    @Override
    public void draw(Batch batch, float parentAlpha) {
        backgroundImage.draw(batch);
        if(talent != null){
            //item.sprite.draw(batch);
            if(talent.isActive)
                batch.draw(talent.sprite, getX(), getY());
            else
                batch.draw(talent.inActiveSprite, getX(), getY());
            if(amount > -1) {
                MyRPGGame.font.setColor(Color.RED);
                MyRPGGame.font.draw(batch, (amount)+"/"+(talent.talentCount), getX(), getY() + 14);
            }
        }
    }
}
