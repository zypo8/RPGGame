package com.zypo8.games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.zypo8.games.Screens.MenuScreen;

public class MyRPGGame extends Game {
	public static int Secounds = 0;
	public SpriteBatch batch;
	public static BitmapFont font;
	public Skin skin;
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		skin = new Skin(Gdx.files.internal("skin/metal-ui.json"));
		//skin = new Skin(Gdx.files.internal("vis/skin/x1/uiskin.json"));
		setScreen(new MenuScreen(this));
	}
}
