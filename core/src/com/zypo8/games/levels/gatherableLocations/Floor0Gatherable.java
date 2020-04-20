package com.zypo8.games.levels.gatherableLocations;

import com.zypo8.games.actors.gatherable.MithrillOre;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.Screens.StageGameScreen;

public class Floor0Gatherable {
    public static void setUp(StageGameScreen gameScreenStage, HUDStage hudStage){
        gameScreenStage.addActor(new MithrillOre(8*32, 8*32, hudStage));
    }
}
