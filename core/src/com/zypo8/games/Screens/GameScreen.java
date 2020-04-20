package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.BattleScreen;
import com.zypo8.games.actors.npc.Vendor;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.levels.Level;
import com.zypo8.games.ui.HUD;


public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private static StageGameScreen stage;
    private MyRPGGame game;
    private Player player;
    private Viewport viewport;
    private static HUD hud;
    private int playerPosX, playerPosY;
    private TiledMapTileLayer collisionLayer;
    private boolean colision;
    private float tileWidth, tileHeight;
    private InputMultiplexer multiplexer = new InputMultiplexer();

    public static Level world;
    public static int floor = 0;

    public GameScreen(MyRPGGame game) {
        this.game = game;


        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        stage = new StageGameScreen(viewport, game.batch, game);
        hud = new HUD(game.batch);
        world = new Level("maps/map", stage, hud.hudStage);
        camera.setToOrtho(false, 1280, 720);
        camera.update();
        playerPosY = playerPosX = 32 * 10;
        player = new Player("img/actors/player.gif", playerPosX, playerPosY, hud.hudStage, stage, (TiledMapTileLayer) world.map.getLayers().get(0));


        collisionLayer = (TiledMapTileLayer) world.map.getLayers().get(0);
        tileWidth = collisionLayer.getTileWidth();
        tileHeight = collisionLayer.getTileHeight();
        stage.addActor(player);
        multiplexer.addProcessor(hud.hudStage);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);


    }

    @Override
    public void show() {
        stage.addActor(new Vendor(10*32, 9*32,  hud.hudStage));
    }

    @Override
    public void render(float delta) {
        update(delta);
        cameraUpdate();
        stage.act(Gdx.graphics.getDeltaTime());
        game.batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.renderer.setView(camera);
        world.renderer.render();
        stage.draw();

        game.batch.setProjectionMatrix(hud.hudStage.getCamera().combined);
        hud.hudStage.draw();
    }

    private void update(float delta) {
        stage.act(delta);
        hud.hudStage.act(delta);
        if (player.playerBattleStart) {
            player.playerBattleStart = false;
            playerPosX = (int) player.getX();
            playerPosY = (int) player.getY();
            game.setScreen(new BattleScreen(game, this));
        }
    }

    private void cameraUpdate() {
        camera.position.x = camera.position.x + (player.getX() - camera.position.x) * .05f;
        camera.position.y = camera.position.y + (player.getY() - camera.position.y) * .05f;
        camera.update();

    }

    public static void worldUpdate(){
        world = new Level("maps/map", stage, hud.hudStage);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        hud.hudStage.getViewport().update(width, height);
        hud.setToOrthooo(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.map.dispose();
        world.renderer.dispose();
        stage.dispose();
    }
}