package com.gaems.pnptoolbox.model.item.equipment;

import com.gaems.pnptoolbox.model.Book;
import com.gaems.pnptoolbox.model.item.Item;
import com.gaems.pnptoolbox.model.item.ItemEffects;
import com.gaems.pnptoolbox.model.item.ItemInterface;

/**
 * Model class representing a weapon.
 */
public class Weapon implements ItemInterface, WeaponInterface {
    /**
     * Delegate ItemInterface methods to a private internal object.
     */
    private ItemInterface mItem;

    private String mDamageMedium;
    private String mDamageSmall;
    private Integer mCriticalMinimum;
    private Integer mCriticalMultiplier;
    private Integer mEffectiveRange;
    private String mDamageType;
    private String mWeaponType;
    private Integer mHands;

    public Weapon() {
        mItem = new Item();
    }

    public String getDamageMedium() {
        return mDamageMedium;
    }

    @Override
    public void setDamageMedium(String damageMedium) {
        mDamageMedium = damageMedium;
    }

    @Override
    public String getDamageSmall() {
        return mDamageSmall;
    }

    @Override
    public void setDamageSmall(String damageSmall) {
        mDamageSmall = damageSmall;
    }

    @Override
    public Integer getCriticalMinimum() {
        return mCriticalMinimum;
    }

    @Override
    public void setCriticalMinimum(Integer criticalMinimum) {
        mCriticalMinimum = criticalMinimum;
    }

    @Override
    public Integer getCriticalMultiplier() {
        return mCriticalMultiplier;
    }

    @Override
    public void setCriticalMultiplier(Integer criticalMultiplier) {
        mCriticalMultiplier = criticalMultiplier;
    }

    @Override
    public Integer getEffectiveRange() {
        return mEffectiveRange;
    }

    @Override
    public void setEffectiveRange(Integer effectiveRange) {
        mEffectiveRange = effectiveRange;
    }

    @Override
    public String getDamageType() {
        return mDamageType;
    }

    @Override
    public void setDamageType(String damageType) {
        mDamageType = damageType;
    }

    @Override
    public String getWeaponType() {
        return mWeaponType;
    }

    @Override
    public void setWeaponType(String weaponType) {
        mWeaponType = weaponType;
    }

    @Override
    public Integer getHands() {
        return mHands;
    }

    @Override
    public void setHands(Integer hands) {
        mHands = hands;
    }

    @Override
    public Integer getId() {
        return mItem.getId();
    }

    @Override
    public void setId(Integer id) {
        mItem.setId(id);
    }

    @Override
    public String getValue() {
        return mItem.getValue();
    }

    @Override
    public void setValue(String value) {
        mItem.setValue(value);
    }

    @Override
    public String getName() {
        return mItem.getName();
    }

    @Override
    public void setName(String name) {
        mItem.setName(name);
    }

    @Override
    public String getDescription() {
        return mItem.getDescription();
    }

    @Override
    public void setDescription(String description) {
        mItem.setDescription(description);
    }

    @Override
    public Float getWeight() {
        return mItem.getWeight();
    }

    @Override
    public void setWeight(Float weight) {
        mItem.setWeight(weight);
    }

    @Override
    public String getType() {
        return mItem.getType();
    }

    @Override
    public void setType(String type) {
        mItem.setType(type);
    }

    @Override
    public ItemEffects getItemEffects() {
        return mItem.getItemEffects();
    }

    @Override
    public void setItemEffects(ItemEffects itemEffects) {
        mItem.setItemEffects(itemEffects);
    }

    @Override
    public Book getSourceBook() {
        return mItem.getSourceBook();
    }

    @Override
    public void setSourceBook(Book book) {
        mItem.setSourceBook(book);
    }
}
