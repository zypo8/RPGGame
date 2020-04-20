package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.CastBar;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;
import com.zypo8.games.ui.hud.minimap.Minimap;
import com.zypo8.games.ui.hud.playerFrame.ExpBar;
import com.zypo8.games.ui.hud.playerFrame.HealthBar;
import com.zypo8.games.ui.hud.status.StatusButtons;

public class HUD {
    public com.zypo8.games.ui.HUDStage hudStage;
    public Viewport viewport;
    //private ProgressBar health, exp;
    private float playerHealth;
    private OrthographicCamera camera;

    ImageButton image;
    com.zypo8.games.ui.hud.playerFrame.HealthBar hp;
    com.zypo8.games.ui.hud.playerFrame.ExpBar exp;
    //Label minimap;
    Label chat;
    //Label actionbar;
    //Label status;

    public com.zypo8.games.ui.hud.actionBar.Actionbar actionbar;
    public com.zypo8.games.ui.hud.buff_bar.Buffbar buffbar;
    public com.zypo8.games.ui.hud.buff_bar.DeBuffbar deBuffbar;
    public com.zypo8.games.ui.hud.status.StatusButtons statusButtons;
    public com.zypo8.games.ui.hud.minimap.Minimap minimap;
    public static com.zypo8.games.ui.hud.CastBar castBar;


    public HUD(SpriteBatch batch){
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        hudStage = new HUDStage(viewport, batch);
        camera.setToOrtho(false, 1280, 720);

        Drawable drawable = new TextureRegionDrawable(new Texture(Gdx.files.internal("img/actors/player.png")));
        image = new ImageButton(drawable);
        hp = new HealthBar(100, 10);
        hp.setHealth(100f);
        exp = new ExpBar(100, 10);

        Table playerFrame = new Table();
        //playerFrame.setDebug(true);

        actionbar = new Actionbar();
        buffbar = new Buffbar();
        deBuffbar = new DeBuffbar();
        statusButtons = new StatusButtons();
        castBar = new CastBar();


        VerticalGroup hp_exp = new VerticalGroup();
        hp_exp.addActor(hp);
        hp_exp.addActor(exp);


        playerFrame.add(image);
        playerFrame.add(hp_exp);

        minimap = new Minimap();
        //buffbar = new Label("buffbar", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        chat = new Label("chat", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //actionbar = new Label("actionbar", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //status = new Label("status", new Label.LabelStyle(new BitmapFont(), Color.WHITE));



        Table table = new Table();
        table.setDebug(false);
        table.setFillParent(true);

        table.add(playerFrame).expand().left().top().height(Gdx.graphics.getHeight()/100f*10).width((Gdx.graphics.getWidth()/100f)*18);
        table.add(buffbar).center().top().width((Gdx.graphics.getWidth()/100f)*50).height(Gdx.graphics.getHeight()/100f*10);
        table.add(minimap).expand().right().top().height(Gdx.graphics.getHeight()/100f*30).width((Gdx.graphics.getWidth()/100f)*18);
        table.row();
        table.add();
        table.add();
        table.add(deBuffbar).expand().padTop(-90).top();
        table.row();
        table.add(castBar).colspan(3).center().height(Gdx.graphics.getHeight()/100f*8);
        table.row();
        table.row();
        table.add(actionbar).colspan(3).center().height(Gdx.graphics.getHeight()/100f*8);
        table.row();
        table.add(chat).height(Gdx.graphics.getHeight()/100f*18);
        table.add().height(Gdx.graphics.getHeight()/100f*18);
        table.add(statusButtons).height(Gdx.graphics.getHeight()/100f*18);
        table.row();

        hudStage.addActor(table);
    }


    public void setToOrthooo(int width, int height){
        camera.setToOrtho(false, width, height);
    }
}
