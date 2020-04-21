package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.windows.InteractWindow;
import com.zypo8.games.ui.windows.ItemDescriptionWIndow;

public class HUDStage extends Stage implements InputProcessor {
    private com.zypo8.games.ui.windows.InteractWindow window;
    private com.zypo8.games.ui.windows.ItemDescriptionWIndow itemDescriptionWIndow;
    private com.zypo8.games.items.InventorySlot hitActor;
    private Vector2 coord;


    public static com.zypo8.games.items.InventorySlot lastClickedSlot;

    public HUDStage(Viewport viewport, Batch batch) {
        super(viewport, batch);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        try {
            hitActor = (com.zypo8.games.items.InventorySlot) hit(coord.x, coord.y, true);
        }
        catch (ClassCastException e){
            if (window != null) {
                window.remove();
                lastClickedSlot.getItem().selected = false;
            }
            return false;
        }
        if(hitActor != null){
            System.out.println(hitActor.getClass().getName());
            if (hitActor.getClass().getName().substring(0, 21).equals("com.zypo8.games.items")) {
                if (window != null) {
                    window.remove();
                    lastClickedSlot.getItem().selected = false;
                }
                Gdx.app.log("HIT", hitActor.getName());
                lastClickedSlot = hitActor;
                if(hitActor.getItem() != null) {
                    if(button == 0){hitActor.getItem().firstOption();}
                    else if(button == 1) {
                        if(hitActor.getItem().getClass().getName().length() == 36 &&
                                hitActor.getItem().getClass().getName().substring(0, 36).equals("com.zypo8.games.abilities.buffs.Buff")) {
                            if(hitActor.getItem() != null) {
                                hitActor.getItem().itemInteractWindow(window, com.zypo8.games.ui.Tools.getSkin());

                            }
                            return true;
                        }
                        hitActor.getItem().selected = true;
                        window = new InteractWindow(hitActor.getItem().getName() + " " + hitActor.getAmount(), com.zypo8.games.ui.Tools.getSkin());
                        window.setPosition(coord.x + 32, coord.y);
                        hitActor.getItem().itemInteractWindow(window, com.zypo8.games.ui.Tools.getSkin());
                        if(hitActor.getItem() != null)
                            addActor(window);
                        return true;
                    }
                }
                if(hitActor.getTalent() != null) {
                    if(button == 0){hitActor.getTalent().firstOption();}
                    else if(button == 1) {
                        hitActor.getTalent().removeTalentPoint();
                        return true;
//                        window = new InteractWindow(hitActor.getTalent().getName() + " " + hitActor.getAmount(), Tools.getSkin());
//                        window.setPosition(coord.x + 32, coord.y);
//                        hitActor.getTalent().itemInteractWindow(window, Tools.getSkin());
//                        addActor(window);
                    }
                }
                else {
                    return false;
                }
            }
        }
        else {
            if (window != null) {
                window.remove();
                lastClickedSlot.getItem().selected = false;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        try {
            hitActor = (InventorySlot) hit(coord.x, coord.y, true);
        }
        catch (ClassCastException e){
            if (itemDescriptionWIndow != null)
                itemDescriptionWIndow.remove();
            return false;
        }
        if(hitActor != null){
            if (itemDescriptionWIndow != null)
                itemDescriptionWIndow.remove();
            if (hitActor.getClass().getName().substring(0, 21).equals("com.zypo8.games.items")) {
                //Gdx.app.log("Hover ", hitActor.getName());
                if(hitActor.getItem() != null) {
                    itemDescriptionWIndow = new com.zypo8.games.ui.windows.ItemDescriptionWIndow(hitActor.getItem().getName(), com.zypo8.games.ui.Tools.getSkin(), hitActor.getItem().getItemRarity().getColor());
                    itemDescriptionWIndow.setPosition(coord.x-itemDescriptionWIndow.getWidth()-16, coord.y+16);
                    hitActor.getItem().itemHoverWindow(itemDescriptionWIndow, com.zypo8.games.ui.Tools.getSkin());
                    addActor(itemDescriptionWIndow);
                }
                if(hitActor.getTalent() != null) {
                    itemDescriptionWIndow = new ItemDescriptionWIndow(hitActor.getTalent().getName(), com.zypo8.games.ui.Tools.getSkin());
                    itemDescriptionWIndow.setPosition(coord.x-itemDescriptionWIndow.getWidth()-16, coord.y+16);
                    hitActor.getTalent().itemHoverWindow(itemDescriptionWIndow, Tools.getSkin());
                    addActor(itemDescriptionWIndow);
                }
            }
        }
        else {
            if (itemDescriptionWIndow != null)
                itemDescriptionWIndow.remove();
            return false;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        switch (character){
            case '1':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(0);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(0).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(0).getItem().firstOption();
                return true;
            case '2':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(1);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(1).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(1).getItem().firstOption();
                return true;
            case '3':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(2);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(2).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(2).getItem().firstOption();
                return true;
            case '4':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(3);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(3).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(3).getItem().firstOption();
                return true;
            case '5':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(4);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(4).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(4).getItem().firstOption();
                return true;
            case '6':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(5);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(5).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(5).getItem().firstOption();
                return true;
            case '7':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(6);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(6).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(6).getItem().firstOption();
                return true;
            case '8':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(7);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(7).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(7).getItem().firstOption();
                return true;
            case '9':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(8);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(8).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(8).getItem().firstOption();
                return true;
            case '0':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(9);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(9).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(9).getItem().firstOption();
                return true;
            case '-':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(10);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(10).getItem() != null)
                    com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(10).getItem().firstOption();
                return true;
            case '=':
                HUDStage.lastClickedSlot = com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(11);
                if( com.zypo8.games.ui.hud.actionBar.Actionbar.inventorySlots.get(11).getItem() != null)
                    Actionbar.inventorySlots.get(11).getItem().firstOption();
                return true;
            default:
                return false;
        }
    }
}
