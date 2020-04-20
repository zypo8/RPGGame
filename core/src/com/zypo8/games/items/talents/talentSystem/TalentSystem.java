package com.zypo8.games.items.talents.talentSystem;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree1;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree10;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree11;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree12;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree13;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree14;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree15;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree16;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree2;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree3;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree4;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree5;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree6;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree7;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree8;
import com.zypo8.games.items.talents.talentSystem.talent_trees.PalTree9;

public class TalentSystem {
    public static Array<TalentTree> talentTrees;
    public Table table;
    public static int talentSpend;
    public int totalTalentPoints = 60;

    public TalentSystem(){
        talentTrees = new Array<>(true, 16);

        setUpTalents();

        setUpTable();
    }

    private void setUpTalents() {
        talentTrees.add(new PalTree1());
        talentTrees.add(new PalTree2());
        talentTrees.add(new PalTree3());
        talentTrees.add(new PalTree4());

        talentTrees.add(new PalTree5());
        talentTrees.add(new PalTree6());
        talentTrees.add(new PalTree7());
        talentTrees.add(new PalTree8());

        talentTrees.add(new PalTree9());
        talentTrees.add(new PalTree10());
        talentTrees.add(new PalTree11());
        talentTrees.add(new PalTree12());

        talentTrees.add(new PalTree13());
        talentTrees.add(new PalTree14());
        talentTrees.add(new PalTree15());
        talentTrees.add(new PalTree16());
    }


    private void setUpTable(){
        table = new Table();
        table.setDebug(false);
        table.setFillParent(true);
        table.add(talentTrees.get(0)).expand();
        table.add(talentTrees.get(1)).expand();
        table.add(talentTrees.get(2)).expand();
        table.add(talentTrees.get(3)).expand();
        table.row();
        table.add(talentTrees.get(4)).expand();
        table.add(talentTrees.get(5)).expand();
        table.add(talentTrees.get(6)).expand();
        table.add(talentTrees.get(7)).expand();
        table.row();
        table.add(talentTrees.get(8)).expand();
        table.add(talentTrees.get(9)).expand();
        table.add(talentTrees.get(10)).expand();
        table.add(talentTrees.get(11)).expand();
        table.row();
        table.add(talentTrees.get(12)).expand();
        table.add(talentTrees.get(13)).expand();
        table.add(talentTrees.get(14)).expand();
        table.add(talentTrees.get(15)).expand();
        table.row();

    }

    public static void talentActive(int i){
        if(i < 5){
            lockRow(0);
        }
        else if(i < 9){
            lockRow(4);
        }
        else if(i < 13){
            lockRow(8);
        }
        else if(i < 17){
            lockRow(12);
        }
    }
    public static void lockRow(int wichrow){
        for (int j = wichrow; j<wichrow+4;j++){
            talentTrees.get(j).setActive(true);
            System.out.println(talentTrees.get(j).isTaken);
            if(!talentTrees.get(j).isTaken){
                talentTrees.get(j).lockTree();
            }
        }
    }

    public Table getTable() {
        return table;
    }
}
