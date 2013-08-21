package com.gaems.pnptoolbox.model.character.implementation;

import com.gaems.pnptoolbox.model.character.CharacterSaveInterface;

/**
 * Model class for character saves
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterSave implements com.gaems.pnptoolbox.model.character.CharacterSaveInterface {

    private Integer baseMod;
    private Integer abilityMod;
    private Integer magicMod;
    private Integer miscMod;
    private Integer tempMod;

    /**
     * Full constructor
     *
     * @param baseMod
     * @param abilityMod
     * @param magicMod
     * @param miscMod
     * @param tempMod
     */
    public CharacterSave(int baseMod, int abilityMod, int magicMod, int miscMod, int tempMod) {
        this.baseMod = baseMod;
        this.abilityMod = abilityMod;
        this.magicMod = magicMod;
        this.miscMod = miscMod;
        this.tempMod = tempMod;
    }

    /**
     * Empty/default constructor
     */
    public CharacterSave() {
    }

    /**
     * Calculates the save
     *
     * @return
     *      calculated save
     */
    @Override
    public int calculate() {
        return baseMod+abilityMod+magicMod+miscMod+tempMod;
    }

    public int getBaseMod() {
        if (baseMod != null) {
            return baseMod;
        } else {
            return 0;
        }
    }

    public void setBaseMod(int baseMod) {
        this.baseMod = baseMod;
    }

    public int getAbilityMod() {
        if (abilityMod != null) {
            return abilityMod;
        } else {
            return 0;
        }
    }

    public void setAbilityMod(int abilityMod) {
        this.abilityMod = abilityMod;
    }

    public int getMagicMod() {
        if (magicMod != null) {
            return magicMod;
        } else {
            return 0;
        }
    }

    public void setMagicMod(int magicMod) {
        this.magicMod = magicMod;
    }

    public int getMiscMod() {
        if (miscMod != null) {
            return miscMod; }
        else {
            return 0;
        }
    }

    public void setMiscMod(int miscMod) {
        this.miscMod = miscMod;
    }

    public int getTempMod() {
        if (tempMod != null) {
            return tempMod;
        } else {
            return 0;
        }
    }

    public void setTempMod(int tempMod) {
        this.tempMod = tempMod;
    }
}
