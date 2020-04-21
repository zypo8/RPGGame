package com.zypo8.games.actors.player;


import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.TalentsWindow;
import com.zypo8.games.Screens.StageGameScreen;

public class Player extends Character{
    private StageGameScreen gameScreenStage;
    public PlayerStats playerStats;
    //move
    private float speed = 128f;
    private String move;
    public static int destX, destY;
    public static boolean Player_moving;
    //collision
    private TiledMapTileLayer collisionLayer;
    private boolean colision;
    private float tileWidth, tileHeight;

    //battle system
    public boolean playerBattle, playerBattleStart;

    //player UI
    public static InventoryWindow inventoryWindow;
    public static TalentsWindow talentsWindow;
    public static EquipmentWindow equipmentWindow;


    public Player(String spriteFIle, int posX, int posY, HUDStage hudStage, StageGameScreen gameScreenStage, TiledMapTileLayer collisionLayer) {
        super(spriteFIle, posX, posY, hudStage, "Player");
        playerStats = new PlayerStats();
        this.gameScreenStage = gameScreenStage;
        this.collisionLayer = collisionLayer;
        tileWidth = collisionLayer.getTileWidth();
        tileHeight = collisionLayer.getTileHeight();
        destY = posY;
        destX =  posX;

        inventoryWindow = new InventoryWindow("Inventory", Tools.getSkin());
        talentsWindow = new TalentsWindow("Talents", Tools.getSkin());
        equipmentWindow = new EquipmentWindow("Equipment", Tools.getSkin());
        hudStage.addActor(inventoryWindow);
        inventoryWindow.setVisible(false);

        hudStage.addActor(talentsWindow);
        talentsWindow.setVisible(false);

        hudStage.addActor(equipmentWindow);
        equipmentWindow.setVisible(false);


    }

    @Override
    public void firstOption() {
        showInventory();
    }

    @Override
    public void act(float delta) {
        Player_moving = moving;
        move(delta);
    }

    private void move(float delta) {
        if(getY() == destY && getX() == destX){
            moving = false;
            if(playerBattle){
                playerBattle = false;
                playerBattleStart = true;
            }

        }
        if(gameScreenStage.wsad.size-1 >= 0){
            move = gameScreenStage.wsad.get(gameScreenStage.wsad.size-1);
            switch (move) {
                case "W":
                    if (!moving) {
                        if (!(collision("collision", 0, +32))) {
                            characterAnimatoin = walkUp;
                            moving = true;
                            destY += 32;
                            if (collision("grass", 0, +32))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "A":
                    if (!moving) {
                        if (!(collision("collision", -32, 0))) {
                            characterAnimatoin = walkLeft;
                            moving = true;
                            destX -= 32;
                            if (collision("grass", -32, 0))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "S":
                    if (!moving) {
                        if (!(collision("collision", 0, -32))) {
                            characterAnimatoin = walkDown;
                            moving = true;
                            destY -= 32;
                            if (collision("grass", 0, -32))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "D":
                    if (!moving) {
                        if (!(collision("collision", 32, 0))) {
                            characterAnimatoin = walkRight;
                            moving = true;
                            destX += 32;
                            if (collision("grass", 32, 0))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
            }
        }


        if(moving){
            if(destY > getY())
                setY(getY()+speed/64);
            if(destY < getY())
                setY(getY()-speed/64);
            if(destX > getX())
                setX(getX()+speed/64);
            if(destX < getX())
                setX(getX()-speed/64);
        }
    }

    protected boolean collision(String KeyWord, int x, int y) {
        colision = collisionLayer.getCell((int) ((getX()+x)/ tileWidth), (int) ((getY()+y)/tileHeight)).getTile().getProperties().containsKey(KeyWord);
        //System.out.println((int)((getX())/ tileWidth) + ":"+(int)((getY())/tileHeight)+ colision+ "|"+ (int) ((getX()+x)/ tileWidth)+ ":"+ (int) ((getY()+y)/tileHeight));
        return colision;
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactButtons.addInventoryButton(this));
        window.row();
        window.add(interactButtons.addTalentsButton(this));
        window.row();
        window.add(interactButtons.addEquipmentButton(this));
    }

    @Override
    public void showInventory() {
        System.out.println("player inventory");
        inventoryWindow.setVisible(true);
    }

    @Override
    public void showTalents() {
        System.out.println("player talents");
        talentsWindow.setVisible(true);
    }

    @Override
    public void showEquipment() {
        System.out.println("player eq");
        equipmentWindow.setVisible(true);
    }

}