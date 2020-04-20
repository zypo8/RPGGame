package com.zypo8.games.actors.player;

public class PlayerStats {
    public static int HEALTH, maxHEALTH, EXP = 0, LEVEL = 1;

    //professions
    public static int GatheringLevel = 1, CraftingLevel = 1, ArmorCraftingLevel = 1;
    public static int GatheringEXP, CraftingEXP, ArmorCraftingEXP;

    //base stats
    public static int Dexterity, Intellect, Strenght, Vitality;
    public static int armor, armorPiercing, crit, attackPower, focus;

    //armor stats
    public static int Dexterityeq, Intellecteq, Strenghteq, Vitalityeq;
    public static int armoreq, armorPiercingeq, criteq, attackPowereq, focuseq;
    public static int GatheringLeveleq = 1, CraftingLeveleq = 1, ArmorCraftingLeveleq = 1;


    ///////////Getters and Setters//////////////////////////////
    public static int getDexterityeq() {
        return Dexterityeq;
    }

    public static void setDexterityeq(int dexterityeq) {
        Dexterityeq = dexterityeq;
    }

    public static int getIntellecteq() {
        return Intellecteq;
    }

    public static void setIntellecteq(int intellecteq) {
        Intellecteq = intellecteq;
    }

    public static int getStrenghteq() {
        return Strenghteq;
    }

    public static void setStrenghteq(int strenghteq) {
        Strenghteq = strenghteq;
    }

    public static int getVitalityeq() {
        return Vitalityeq;
    }

    public static void setVitalityeq(int vitalityeq) {
        Vitalityeq = vitalityeq;
        //EquipmentWindow.
    }

    public static int getArmoreq() {
        return armoreq;
    }

    public static void setArmoreq(int armoreq) {
        PlayerStats.armoreq = armoreq;
    }

    public static int getArmorPiercingeq() {
        return armorPiercingeq;
    }

    public static void setArmorPiercingeq(int armorPiercingeq) {
        PlayerStats.armorPiercingeq = armorPiercingeq;
    }

    public static int getCriteq() {
        return criteq;
    }

    public static void setCriteq(int criteq) {
        PlayerStats.criteq = criteq;
    }

    public static int getAttackPowereq() {
        return attackPowereq;
    }

    public static void setAttackPowereq(int attackPowereq) {
        PlayerStats.attackPowereq = attackPowereq;
    }

    public static int getFocuseq() {
        return focuseq;
    }

    public static void setFocuseq(int focuseq) {
        PlayerStats.focuseq = focuseq;
    }

    public static int getGatheringLeveleq() {
        return GatheringLeveleq;
    }

    public static void setGatheringLeveleq(int gatheringLeveleq) {
        GatheringLeveleq = gatheringLeveleq;
    }

    public static int getCraftingLeveleq() {
        return CraftingLeveleq;
    }

    public static void setCraftingLeveleq(int craftingLeveleq) {
        CraftingLeveleq = craftingLeveleq;
    }

    public static int getArmorCraftingLeveleq() {
        return ArmorCraftingLeveleq;
    }

    public static void setArmorCraftingLeveleq(int armorCraftingLeveleq) {
        ArmorCraftingLeveleq = armorCraftingLeveleq;
    }
    public static int getHEALTH() {
        return HEALTH;
    }

    public static void setHEALTH(int HEALTH) {
        PlayerStats.HEALTH = HEALTH;
    }

    public static int getMaxHEALTH() {
        return maxHEALTH;
    }

    public static void setMaxHEALTH(int maxHEALTH) {
        PlayerStats.maxHEALTH = maxHEALTH;
    }

    public static int getEXP() {
        return EXP;
    }

    public static void setEXP(int EXP) {
        PlayerStats.EXP = EXP;
    }

    public static int getLEVEL() {
        return LEVEL;
    }

    public static void setLEVEL(int LEVEL) {
        PlayerStats.LEVEL = LEVEL;
    }

    public static int getDexterity() {
        return Dexterity;
    }

    public static void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public static int getIntellect() {
        return Intellect;
    }

    public static void setIntellect(int intellect) {
        Intellect = intellect;
    }

    public static int getStrenght() {
        return Strenght;
    }

    public static void setStrenght(int strenght) {
        Strenght = strenght;
    }

    public static int getVitality() {
        return Vitality;
    }

    public static void setVitality(int vitality) {
        Vitality = vitality;
    }

    public static int getArmor() {
        return armor;
    }

    public static void setArmor(int armor) {
        PlayerStats.armor = armor;
    }

    public static int getArmorPiercing() {
        return armorPiercing;
    }

    public static void setArmorPiercing(int armorPiercing) {
        PlayerStats.armorPiercing = armorPiercing;
    }

    public static int getCrit() {
        return crit;
    }

    public static void setCrit(int crit) {
        PlayerStats.crit = crit;
    }

    public static int getAttackPower() {
        return attackPower;
    }

    public static void setAttackPower(int attackPower) {
        PlayerStats.attackPower = attackPower;
    }

    public static int getFocus() {
        return focus;
    }

    public static void setFocus(int focus) {
        PlayerStats.focus = focus;
    }

    public static int getGatheringLevel() {
        return GatheringLevel;
    }

    public static void setGatheringLevel(int gatheringLevel) {
        GatheringLevel = gatheringLevel;
    }

    public static int getCraftingLevel() {
        return CraftingLevel;
    }

    public static void setCraftingLevel(int craftingLevel) {
        CraftingLevel = craftingLevel;
    }

    public static int getArmorCraftingLevel() {
        return ArmorCraftingLevel;
    }

    public static void setArmorCraftingLevel(int armorCraftingLevel) {
        ArmorCraftingLevel = armorCraftingLevel;
    }

    public static int getGatheringEXP() {
        return GatheringEXP;
    }

    public static void setGatheringEXP(int gatheringEXP) {
        GatheringEXP = gatheringEXP;
    }

    public static int getCraftingEXP() {
        return CraftingEXP;
    }

    public static void setCraftingEXP(int craftingEXP) {
        CraftingEXP = craftingEXP;
    }

    public static int getArmorCraftingEXP() {
        return ArmorCraftingEXP;
    }

    public static void setArmorCraftingEXP(int armorCraftingEXP) {
        ArmorCraftingEXP = armorCraftingEXP;
    }
}
