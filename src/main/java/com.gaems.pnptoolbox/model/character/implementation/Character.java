package com.gaems.pnptoolbox.model.character.implementation;

import com.gaems.pnptoolbox.model.character.CharacterSaveInterface;

/**
 * Primary character model to hold all information (stats, items, etc) associated with a given character.
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class Character {

    private String name;

    private CharacterAC AC;
    private CharacterSave fortSave;
    private CharacterSave refSave;
    private CharacterSave willSave;

    private int BAB;

    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

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

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }
}
