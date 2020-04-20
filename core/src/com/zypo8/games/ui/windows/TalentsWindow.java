package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;

public class TalentsWindow extends WindowWithTopRightCornerCloseButton {
    private com.zypo8.games.items.talents.talentSystem.TalentSystem talentSystem;


    public TalentsWindow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(600, 700);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

        talentSystem = new com.zypo8.games.items.talents.talentSystem.TalentSystem();

        addActor(talentSystem.getTable());
    }

    public com.zypo8.games.items.talents.talentSystem.TalentSystem getTalentSystem() {
        return talentSystem;
    }

    public void setTalentSystem(TalentSystem talentSystem) {
        this.talentSystem = talentSystem;
    }

}
