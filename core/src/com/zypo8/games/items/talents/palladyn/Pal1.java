package com.zypo8.games.items.talents.palladyn;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.talents.talentSystem.Talent;

public class Pal1 extends Talent {
    public Pal1() {
        super("img/actors/items/talents/palladyn/Slash.png", "img/actors/items/talents/palladyn/Slash_inactive.png", 0, 3);
        this.setName("Dupczkoks Vengance");
    }

    @Override
    public void itemHoverWindow(Window window, Skin skin) {
        window.setHeight(100);
        super.itemHoverWindow(window, skin);
    }


}
