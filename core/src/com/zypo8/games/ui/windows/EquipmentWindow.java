package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.professions.ProfessionBar;
import com.zypo8.games.ui.hud.tools.ExpBarr;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.equipmentSystem.BootsSlot;
import com.zypo8.games.items.equipmentSystem.ChestSlot;
import com.zypo8.games.items.equipmentSystem.CostamSlot;
import com.zypo8.games.items.equipmentSystem.FingerSlot;
import com.zypo8.games.items.equipmentSystem.GlovesSlot;
import com.zypo8.games.items.equipmentSystem.HeadSlot;
import com.zypo8.games.items.equipmentSystem.LegsSlot;
import com.zypo8.games.items.equipmentSystem.MainSlot;
import com.zypo8.games.items.equipmentSystem.NeckSlot;
import com.zypo8.games.items.equipmentSystem.OffSlot;
import com.zypo8.games.items.equipmentSystem.ShoulderSlot;


public class EquipmentWindow extends WindowWithTopRightCornerCloseButton {
    private static Array<com.zypo8.games.items.InventorySlot> inventorySlots;
    public static com.zypo8.games.items.equipmentSystem.HeadSlot headSlot;
    public static com.zypo8.games.items.equipmentSystem.NeckSlot neckSlot;
    public static com.zypo8.games.items.equipmentSystem.ShoulderSlot shoulderSlot;
    public static com.zypo8.games.items.equipmentSystem.CostamSlot costamSlot;
    public static com.zypo8.games.items.equipmentSystem.ChestSlot chestSlot;
    public static com.zypo8.games.items.equipmentSystem.LegsSlot legsSlot;
    public static com.zypo8.games.items.equipmentSystem.BootsSlot bootsSlot;
    public static com.zypo8.games.items.equipmentSystem.GlovesSlot glovesSlot;
    public static com.zypo8.games.items.equipmentSystem.FingerSlot fingerSlot;
    public static com.zypo8.games.items.equipmentSystem.MainSlot mainHand;
    public static com.zypo8.games.items.equipmentSystem.OffSlot offHand;
    private TextButton buttonSummary, buttonBack;

    private Table eqtable, statTable;

    private ExpBarr expBarr;

    public EquipmentWindow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        slotInit();
        inventorySlots = new Array<>(true, 28);
        for (int i=0;i<28;i++)
            inventorySlots.add(new InventorySlot());
        buttonSummary = new TextButton("Stats", Tools.getSkin());
        buttonBack = new TextButton("back", Tools.getSkin());
        buttonSummary.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonSummaryClick();
            }
        });
        buttonBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonBackClick();
            }
        });
        expBarr = new ExpBarr();
        expBarr.setValue(30);
        setUpTable();
        addActor(eqtable);
    }

    private void buttonSummaryClick(){
        removeActor(eqtable);
        addActor(statTable);
    }

    private void buttonBackClick(){
        removeActor(statTable);
        addActor(eqtable);
    }



    private void setUpTable() {
        eqtable = new Table();
        eqtable.setFillParent(true);
        eqtable.setDebug(false);
        eqtable.add().expand().padTop(20);
        eqtable.add(headSlot).expand().padTop(20);
        eqtable.add().height(20).width(20);
        eqtable.row();
        eqtable.add(shoulderSlot).expand();
        eqtable.add(neckSlot).expand();
        eqtable.add(costamSlot).expand();
        eqtable.row();
        eqtable.add(glovesSlot).expand();
        eqtable.add(chestSlot).expand();
        eqtable.add(fingerSlot).expand();
        eqtable.row();
        eqtable.add(mainHand).expand();
        eqtable.add(legsSlot).expand();
        eqtable.add(offHand).expand();
        eqtable.row();
        eqtable.add(buttonSummary).width(40);
        eqtable.add(bootsSlot).expand();
        eqtable.add().expand();


        setUpLabels();
        statTable = new Table();
        statTable.setFillParent(true);
        statTable.setDebug(false);
        statTable.add(new Label("Character Level: ", Tools.getSkin())).expand().padTop(25);
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getLEVEL()),Tools.getSkin())).expand().center().padTop(25);
        statTable.row();
        statTable.add(new Label("Health: ", Tools.getSkin())).expand();
        statTable.add(new Label(com.zypo8.games.actors.player.PlayerStats.getVitalityeq()+"/"+ com.zypo8.games.actors.player.PlayerStats.getVitality(), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Intellect: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getIntellect()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Dexterity: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getDexterity()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Strenght: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getStrenght()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("armor: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getArmor()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("armor piercing: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getArmorPiercing()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Crit: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getCrit()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("attack power: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getAttackPower()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Gathering: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(com.zypo8.games.actors.player.PlayerStats.getGatheringLevel()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Crafting: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(PlayerStats.getCraftingLevel()), Tools.getSkin())).expand();
        statTable.row();
//        statTable.add(new Label("Armor crafting: ", Tools.getSkin())).expand();
//        statTable.add(new Label(String.valueOf(PlayerStats.getArmorCraftingLevel()), Tools.getSkin())).expand();
        statTable.add(new ProfessionBar());
        statTable.row();
        statTable.add(buttonBack).expand();
        statTable.add(expBarr);

    }

    private void setUpLabels() {
    }

    private void slotInit() {
        headSlot = new HeadSlot();
        neckSlot = new NeckSlot();
        shoulderSlot = new ShoulderSlot();
        costamSlot = new CostamSlot();
        chestSlot = new ChestSlot();
        legsSlot = new LegsSlot();
        glovesSlot = new GlovesSlot();
        fingerSlot = new FingerSlot();
        mainHand = new MainSlot();
        offHand = new OffSlot();
        bootsSlot = new BootsSlot();
    }
}
