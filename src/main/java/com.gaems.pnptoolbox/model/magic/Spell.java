package com.gaems.pnptoolbox.model.magic;

import com.gaems.pnptoolbox.model.Book;

import java.util.List;

/**
 * Model class representing a spell.
 */
public class Spell {
    private Integer mId;
    private String mName;
    private String mDescription;
    private String mSchool;
    private Integer mLevel;
    private String mClasses;
    private String mCastingTime;
    private List<String> mComponents;
    private String mEffectRange;
    private String mArea;
    private String mDuration;
    private String mSavingThrow;
    private String mSpellResistance;

    private Book mSourceBook;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getSchool() {
        return mSchool;
    }

    public void setSchool(String school) {
        mSchool = school;
    }

    public Integer getLevel() {
        return mLevel;
    }

    public void setLevel(Integer level) {
        mLevel = level;
    }

    public String getClasses() {
        return mClasses;
    }

    public void setClasses(String classes) {
        mClasses = classes;
    }

    public String getCastingTime() {
        return mCastingTime;
    }

    public void setCastingTime(String castingTime) {
        mCastingTime = castingTime;
    }

    public List<String> getComponents() {
        return mComponents;
    }

    public void setComponents(List<String> components) {
        mComponents = components;
    }

    public String getEffectRange() {
        return mEffectRange;
    }

    public void setEffectRange(String effectRange) {
        mEffectRange = effectRange;
    }

    public String getArea() {
        return mArea;
    }

    public void setArea(String area) {
        mArea = area;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public String getSavingThrow() {
        return mSavingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        mSavingThrow = savingThrow;
    }

    public String getSpellResistance() {
        return mSpellResistance;
    }

    public void setSpellResistance(String spellResistance) {
        mSpellResistance = spellResistance;
    }

    public Book getSourceBook() {
        return mSourceBook;
    }

    public void setSourceBook(Book sourceBook) {
        mSourceBook = sourceBook;
    }
}
