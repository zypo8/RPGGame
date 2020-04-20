package com.zypo8.games.items.talents.talentSystem;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.talents.palladyn.Pal1;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;
import com.zypo8.games.ui.Tools;


public class TalentTree extends Group {
    public static int talentTreeCount = 0;
    protected int talentTreeID;
    protected boolean isTaken, active;
    protected TextButton take;
    protected Array<TalentSlot> talentSlots;
    public int talentSpendTree;
    public boolean treeLocked;

    private Table talentTable, summaryTable;

    public TalentTree(){
        talentTreeCount++;
        talentTreeID = talentTreeCount;
        take = new TextButton("Take", Tools.getSkin());
        take.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isTaken = true;
                TalentSystem.talentActive(talentTreeID);
                removeActor(summaryTable);
                addActor(talentTable);
            }
        });
        talentSlots = new Array<>(true, 16);
        for (int i=0;i<16;i++)
            talentSlots.add(new TalentSlot());
        setUpTalents();
        setUpTable();
        setUpSummary();
        addActor(summaryTable);

    }
    public void lockTree(){
        for (int i =0;i<16;i++){
            if(talentSlots.get(i).getTalent() != null)
                talentSlots.get(i).getTalent().isLocked = true;
        }
    }

    public void unlockTree(){
        for (int i =0;i<16;i++){
            if(talentSlots.get(i).getTalent() != null)
                talentSlots.get(i).getTalent().isLocked = false;
        }
    }

    protected void setUpSummary() {
        summaryTable = new Table();
        summaryTable.setDebug(false);
        summaryTable.setFillParent(true);
        summaryTable.add();
        summaryTable.add();
        summaryTable.row();
        summaryTable.add(take);
    }

    protected void setUpTalents() {
        talentSlots.get(0).setItem(new Pal1());
        talentSlots.get(1).setItem(new Pal1());
        talentSlots.get(2).setItem(new Pal1());
        talentSlots.get(3).setItem(new Pal1());
        talentSlots.get(4).setItem(new Pal1());
        talentSlots.get(5).setItem(new Pal1());
        talentSlots.get(6).setItem(new Pal1());
        talentSlots.get(7).setItem(new Pal1());
        talentSlots.get(8).setItem(new Pal1());
        talentSlots.get(9).setItem(new Pal1());
        talentSlots.get(10).setItem(new Pal1());
        talentSlots.get(11).setItem(new Pal1());
        talentSlots.get(12).setItem(new Pal1());
        talentSlots.get(13).setItem(new Pal1());
        talentSlots.get(14).setItem(new Pal1());
        talentSlots.get(15).setItem(new Pal1());
    }

    protected void setUpTable(){
        talentTable = new Table();
        talentTable.setDebug(false);
        talentTable.setFillParent(true);
        talentTable.add(talentSlots.get(0)).expand().padTop(20);
        talentTable.add(talentSlots.get(1)).expand().padTop(20);
        talentTable.add(talentSlots.get(2)).expand().padTop(20);
        talentTable.add(talentSlots.get(3)).expand().padTop(20);
        talentTable.row();
        talentTable.add(talentSlots.get(4)).expand();
        talentTable.add(talentSlots.get(5)).expand();
        talentTable.add(talentSlots.get(6)).expand();
        talentTable.add(talentSlots.get(7)).expand();
        talentTable.row();
        talentTable.add(talentSlots.get(8)).expand();
        talentTable.add(talentSlots.get(9)).expand();
        talentTable.add(talentSlots.get(10)).expand();
        talentTable.add(talentSlots.get(11)).expand();
        talentTable.row();
        talentTable.add(talentSlots.get(12)).expand();
        talentTable.add(talentSlots.get(13)).expand();
        talentTable.add(talentSlots.get(14)).expand();
        talentTable.add(talentSlots.get(15)).expand();

    }

    protected void setActive(boolean active){
        this.active = active;
        if(active){
            removeActor(summaryTable);
            addActor(talentTable);
        }
    }

    public boolean isTaken() {
        return isTaken;
    }

}
