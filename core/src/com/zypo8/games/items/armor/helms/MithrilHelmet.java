package com.zypo8.games.items.armor.helms;

import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.actors.player.PlayerStats;

public class MithrilHelmet extends Armor {
    public MithrilHelmet() {
        super("img/placeHolders/mithrilHelm.png", 3, SlotType.Head);
        this.setName("Mithril Helmet");
    }

    @Override
    public void equip() {
        super.equip();
        com.zypo8.games.actors.player.PlayerStats.setVitalityeq(PlayerStats.getVitality()+3);
    }
}
