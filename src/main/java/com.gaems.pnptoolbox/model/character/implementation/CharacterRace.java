package com.gaems.pnptoolbox.model.character.implementation;

/**
 * Model object to hold character race (i.e. Human, Elf, etc.)
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterRace {

    private int id;
    private String name;


    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }
}
