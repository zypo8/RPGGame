package com.zypo8.games.abilities.skills.palladyn_skills;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.abilities.skills.Skill;

public class HandCannon extends Skill {
    public HandCannon() {
        super("img/actors/items/talents/palladyn/Slash.png", "img/actors/items/talents/palladyn/Slash_inactive.png", 44);
        setName("Hand Cannon");
    }
    @Override
    public void use() {
        System.out.println("Hand Cannon Used");
    }


}
