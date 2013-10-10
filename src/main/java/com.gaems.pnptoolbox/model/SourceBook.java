package com.gaems.pnptoolbox.model;

/**
 * Represents a game book.
 */
public class SourceBook {
    private Integer mId;
    private String mName;
    private String mDescription;

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
}
