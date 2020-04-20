package com.zypo8.games.levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.StageGameScreen;
import com.zypo8.games.levels.gatherableLocations.Floor0Gatherable;
import com.zypo8.games.levels.gatherableLocations.Floor1Gatherable;

public class Level {
    private com.zypo8.games.Screens.StageGameScreen gameScreenStage;
    private HUDStage hudStage;
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;


    public Level(String mapName, StageGameScreen gameScreenStage, HUDStage hudStage){
        this.gameScreenStage = gameScreenStage;
        this.hudStage = hudStage;
        if(com.zypo8.games.Screens.GameScreen.floor == 0) {
            map = new TmxMapLoader().load(mapName+ com.zypo8.games.Screens.GameScreen.floor+".tmx");
            renderer = new OrthogonalTiledMapRenderer(map);
            Floor0Gatherable.setUp(gameScreenStage, hudStage);
        }
        if(com.zypo8.games.Screens.GameScreen.floor == 1) {
            map = new TmxMapLoader().load(mapName+ GameScreen.floor+".tmx");
            renderer = new OrthogonalTiledMapRenderer(map);
            Floor1Gatherable.setUp(gameScreenStage, hudStage);
        }
        //InteractableLocations.setup(gameScreenStage);
    }
}
