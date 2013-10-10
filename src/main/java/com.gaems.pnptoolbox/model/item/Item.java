package com.gaems.pnptoolbox.model.item;

import com.gaems.pnptoolbox.model.SourceBook;

/**
 * Represents an item.
 */
public class Item implements ItemInterface {
    private int mId;
    private String mValue;
    private String mName;
    private String mDescription;
    private Float mWeight;
    private String mType;

    private ItemEffects mItemEffects;

    private SourceBook mSourceBook;

    @Override
    public Integer getId() {
        return mId;
    }

    @Override
    public void setId(Integer id) {
        mId = id;
    }

    @Override
    public String getValue() {
        return mValue;
    }

    @Override
    public void setValue(String value) {
        mValue = value;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }

    @Override
    public String getDescription() {
        return mDescription;
    }

    @Override
    public void setDescription(String description) {
        mDescription = description;
    }

    @Override
    public Float getWeight() {
        return mWeight;
    }

    @Override
    public void setWeight(Float weight) {
        mWeight = weight;
    }

    @Override
    public String getType() {
        return mType;
    }

    @Override
    public void setType(String type) {
        mType = type;
    }

    @Override
    public ItemEffects getItemEffects() {
        return mItemEffects;
    }

    @Override
    public void setItemEffects(ItemEffects itemEffects) {
        mItemEffects = itemEffects;
    }

    @Override
    public SourceBook getSourceBook() {
        return mSourceBook;
    }

    @Override
    public void setSourceBook(SourceBook book) {
        mSourceBook = book;
    }
}
