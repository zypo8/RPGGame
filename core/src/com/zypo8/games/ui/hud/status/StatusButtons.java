package com.zypo8.games.ui.hud.status;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.actors.player.Player;

import static com.zypo8.games.actors.player.Player.equipmentWindow;
import static com.zypo8.games.actors.player.Player.inventoryWindow;
import static com.zypo8.games.actors.player.Player.talentsWindow;

public class StatusButtons extends Group {
    private ImageButton inventoryIB, talentsIB, questLogIB, equipmentIB, optionsIB;
    private Table table;
    public StatusButtons(){


        setUpButtons();
        setUpTable();
        addActor(table);
    }

    private void setUpButtons() {
        inventoryIB = new ImageButton(Tools.getSkin());
        talentsIB = new ImageButton(Tools.getSkin());
        questLogIB = new ImageButton(Tools.getSkin());
        equipmentIB = new ImageButton(Tools.getSkin());
        optionsIB = new ImageButton(Tools.getSkin());


        inventoryIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.inventoryWindow.setVisible(true);
            }
        });
        talentsIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.talentsWindow.setVisible(true);
            }
        });
        questLogIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("questLogIB ");
            }
        });
        equipmentIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.equipmentWindow.setVisible(true);
            }
        });
        optionsIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("optionsIB ");
            }
        });
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        table.add(inventoryIB).width(28).height(28);
        table.add(talentsIB).width(28).height(28);
        table.add(questLogIB).width(28).height(28);
        table.add(equipmentIB).width(28).height(28);
        table.add(optionsIB).width(28).height(28);
    }
}
