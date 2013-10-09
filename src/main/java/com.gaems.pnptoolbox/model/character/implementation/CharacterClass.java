package com.gaems.pnptoolbox.model.character.implementation;

/**
 * Model object for character class (i.e. Fighter, Wizard, etc.)
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterClass {

    private int id;
    private String name;

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }
}
