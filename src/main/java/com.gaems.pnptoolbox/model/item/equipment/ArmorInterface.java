package com.gaems.pnptoolbox.model.item.equipment;

import com.gaems.pnptoolbox.model.item.ItemInterface;

/**
 * Interface for objects representing armor.
 */
public interface ArmorInterface extends ItemInterface {
    public String getWeightClass();
    public void setWeightClass(String weightClass);

    public Integer getBonus();
    public void setBonus(Integer bonus);

    public Integer getMaximumDexterity();
    public void setMaximumDexterity(Integer maximumDexterity);

    public Integer getCheckPenalty();
    public void setCheckPenalty(Integer checkPenalty);

    public Float getSpellFailure();
    public void setSpellFailure(Float spellFailure);

    public ArmorSpeed getSpeed();
    public void setSpeed(ArmorSpeed armorSpeed);
}
