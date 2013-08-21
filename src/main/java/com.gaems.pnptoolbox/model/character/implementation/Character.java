package com.gaems.pnptoolbox.model.character.implementation;

/**
 * Primary character model to hold all information (stats, items, etc) associated with a given character.
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class Character {

    private String name;

    private CharacterAC AC;
    private CharacterAbilities abilities;
    private CharacterSave fortSave;
    private CharacterSave refSave;
    private CharacterSave willSave;

    public CharacterAC getAC() {
        return AC;
    }

    public void setAC(CharacterAC AC) {
        this.AC = AC;
    }

    public CharacterSave getFortSave() {
        return fortSave;
    }

    public void setFortSave(CharacterSave fortSave) {
        this.fortSave = fortSave;
    }

    public CharacterSave getRefSave() {
        return refSave;
    }

    public void setRefSave(CharacterSave refSave) {
        this.refSave = refSave;
    }

    public CharacterSave getWillSave() {
        return willSave;
    }

    public void setWillSave(CharacterSave willSave) {
        this.willSave = willSave;
    }
}
