package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.items.Item;

public class InteractItemButtons {
    private TextButton consume, use, drop, equip, unequip, take, select, addTalent,
            removeTalent, addToActionBar, removeFromActionBar, buy;
    private Skin skin;

    public InteractItemButtons(Skin skin){
        this.skin = skin;
    }


    public TextButton addConsumeButton(final com.zypo8.games.items.Item item){
        consume = new TextButton("consume", skin);
        consume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("consume " + item.getName());
                item.consume();
            }
        });
        return consume;
    }

    public TextButton addUseButton(final com.zypo8.games.items.Item item){
        use = new TextButton("use", skin);
        use.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("used " + item.getName());
                item.use();
            }
        });
        return use;
    }

    public TextButton addDropButton(final com.zypo8.games.items.Item item){
        drop = new TextButton("drop", skin);
        drop.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("dropped " + item.getName());
                item.drop();
            }
        });
        return drop;
    }

    public TextButton addEquipButton(final com.zypo8.games.items.Item item){
        equip = new TextButton("equip", skin);
        equip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("equiped " + item.getName());
                item.equip();
            }
        });
        return equip;
    }

    public TextButton addTakeButton(final com.zypo8.games.items.Item item){
        take = new TextButton("take", skin);
        take.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("taked " + item.getName());
                item.take();
            }
        });
        return take;
    }

    public TextButton addSelectButton(final com.zypo8.games.items.Item item){
        select = new TextButton("select", skin);
        select.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("selected " + item.getName());
                item.select();
            }
        });
        return select;
    }

    public TextButton addUnequipItem(final com.zypo8.games.items.Item item){
        unequip = new TextButton("unequiped", skin);
        unequip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("unequiped " + item.getName());
                item.unequip();
            }
        });
        return unequip;
    }

    public TextButton addTalentButton(final com.zypo8.games.items.Item item){
        addTalent = new TextButton("add", skin);
        addTalent.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("added " + item.getName());
                item.addTalentPoint();
            }
        });
        return addTalent;
    }

    public TextButton addTalentRemoveButton(final com.zypo8.games.items.Item item){
        removeTalent = new TextButton("remove", skin);
        removeTalent.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Removed " + item.getName());
                item.removeTalentPoint();
            }
        });
        return removeTalent;
    }

    public TextButton addAddToActionBar(final com.zypo8.games.items.Item item){
        addToActionBar = new TextButton("add to bar", skin);
        addToActionBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("added to action bar " + item.getName());
                item.addToActionBar();
            }
        });
        return addToActionBar;
    }

    public TextButton addRemoveFromActionBar(final com.zypo8.games.items.Item item){
        removeFromActionBar = new TextButton("remove", skin);
        removeFromActionBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("removed from action bar " + item.getName());
                item.removeFromActionBar();
            }
        });
        return removeFromActionBar;
    }

    public TextButton addBuy(final Item item){
        buy = new TextButton("Buy", skin);
        buy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("bought " + item.getName());
                item.buy();
            }
        });
        return buy;
    }
}
