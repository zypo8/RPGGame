package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.ui.Tools;

public class MenuScreen implements Screen {
    private MyRPGGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private TextButton playButton, settingsButton, costamButton;

    public MenuScreen(MyRPGGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new Stage(viewport, game.batch);
        //sprite = new Sprite(new Texture(Gdx.files.internal("img/mapka.jpg")));
        Gdx.input.setInputProcessor(stage);
        setUpButtons();
        setUpTable();
        stage.addActor(table);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();
    }

    private void setUpButtons() {
        playButton = new TextButton("Play", Tools.getSkin());
        settingsButton = new TextButton("Settings", Tools.getSkin());
        costamButton = new TextButton("costam", Tools.getSkin());

        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        settingsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("SETTINGS DONT WORK");
            }
        });
        costamButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("COSTAM DONT WORK");
            }
        });
    }


    private void setUpTable() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.add(playButton).padTop(-80);
        table.row();
        table.add(settingsButton);
        table.row();
        table.add(costamButton).padTop(40);
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.setToOrtho(false, width, height);
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
        stage.dispose();
    }
}