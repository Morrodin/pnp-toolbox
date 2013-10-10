package com.gaems.pnptoolbox.model.item.equipment;

import com.gaems.pnptoolbox.model.Book;
import com.gaems.pnptoolbox.model.item.Item;
import com.gaems.pnptoolbox.model.item.ItemEffects;
import com.gaems.pnptoolbox.model.item.ItemInterface;

/**
 * Model class representing a piece of armor.
 */
public class Armor implements ItemInterface, ArmorInterface {
    /**
     * Delegate ItemInterface methods to a private internal object.
     */
    private Item mItem;

    private String mWeightClass;
    private Integer mBonus;
    private Integer mMaximumDexterity;
    private Integer mCheckPenalty;
    private Float mSpellFailure;
    private ArmorSpeed mSpeed;

    public Armor() {
        mItem = new Item();
    }

    @Override
    public String getWeightClass() {
        return mWeightClass;
    }

    @Override
    public void setWeightClass(String weightClass) {
        mWeightClass = weightClass;
    }

    @Override
    public Integer getBonus() {
        return mBonus;
    }

    @Override
    public void setBonus(Integer bonus) {
        mBonus = bonus;
    }

    @Override
    public Integer getMaximumDexterity() {
        return mMaximumDexterity;
    }

    @Override
    public void setMaximumDexterity(Integer maximumDexterity) {
        mMaximumDexterity = maximumDexterity;
    }

    @Override
    public Integer getCheckPenalty() {
        return mCheckPenalty;
    }

    @Override
    public void setCheckPenalty(Integer checkPenalty) {
        mCheckPenalty = checkPenalty;
    }

    @Override
    public Float getSpellFailure() {
        return mSpellFailure;
    }

    @Override
    public void setSpellFailure(Float spellFailure) {
        mSpellFailure = spellFailure;
    }

    @Override
    public ArmorSpeed getSpeed() {
        return mSpeed;
    }

    @Override
    public void setSpeed(ArmorSpeed armorSpeed) {
        mSpeed = armorSpeed;
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
    public void setItemEffects(ItemEffects itemEffects) {
        mItem.setItemEffects(itemEffects);
    }

    @Override
    public ItemEffects getItemEffects() {
        return mItem.getItemEffects();
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
