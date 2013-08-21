package com.gaems.pnptoolbox.model.character.implementation;

import com.gaems.pnptoolbox.model.character.CharacterSaveInterface;

/**
 * Model class for character saves
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterSave implements com.gaems.pnptoolbox.model.character.CharacterSaveInterface {

    private int baseMod;
    private int abilityMod;
    private int magicMod;
    private int miscMod;
    private int tempMod;

    /**
     * Calculates the fort save
     *
     * @return
     *      calculated fort save
     */
    @Override
    public int calculate() {
        return baseMod+abilityMod+magicMod+miscMod+tempMod;
    }

    public int getBaseMod() {
        return baseMod;
    }

    public void setBaseMod(int baseMod) {
        this.baseMod = baseMod;
    }

    public int getAbilityMod() {
        return abilityMod;
    }

    public void setAbilityMod(int abilityMod) {
        this.abilityMod = abilityMod;
    }

    public int getMagicMod() {
        return magicMod;
    }

    public void setMagicMod(int magicMod) {
        this.magicMod = magicMod;
    }

    public int getMiscMod() {
        return miscMod;
    }

    public void setMiscMod(int miscMod) {
        this.miscMod = miscMod;
    }

    public int getTempMod() {
        return tempMod;
    }

    public void setTempMod(int tempMod) {
        this.tempMod = tempMod;
    }
}
