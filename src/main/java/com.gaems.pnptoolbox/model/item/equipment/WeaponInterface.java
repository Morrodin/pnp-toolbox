package com.gaems.pnptoolbox.model.item.equipment;

import com.gaems.pnptoolbox.model.item.ItemInterface;

/**
 * Interface for weapon model classes.
 */
public interface WeaponInterface extends ItemInterface {
    public String getDamageMedium();
    public void setDamageMedium(String damageMedium);

    public String getDamageSmall();
    public void setDamageSmall(String damageSmall);

    public Integer getCriticalMinimum();
    public void setCriticalMinimum(Integer criticalMinimum);

    public Integer getCriticalMultiplier();
    public void setCriticalMultiplier(Integer criticalMultiplier);

    public Integer getEffectiveRange();
    public void setEffectiveRange(Integer effectiveRange);

    public String getDamageType();
    public void setDamageType(String damageType);

    public String getWeaponType();
    public void setWeaponType(String weaponType);

    public Integer getHands();
    public void setHands(Integer hands);
}
