package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;

public class ExpBar extends ProgressBar {

    /**
     * @param width of the health bar
     * @param height of the health bar
     */
    public ExpBar(int width, int height) {
        super(0f, 100f, 0.01f, false, new ProgressBar.ProgressBarStyle());
        getStyle().background = Utils.getColoredDrawable(width, height, Color.GRAY);
        getStyle().knob = Utils.getColoredDrawable(0, height, Color.YELLOW);
        getStyle().knobBefore = Utils.getColoredDrawable(width, height, Color.YELLOW);

        setWidth(width);
        setHeight(height);

        setAnimateDuration(0.0f);
        setValue(1f);

        setAnimateDuration(0.25f);
    }
}