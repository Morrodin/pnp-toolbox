package com.gaems.pnptoolbox.model.character.implementation;

import com.gaems.pnptoolbox.model.character.CharacterACInterface;

/**
 * Model object to manage and hold character AC values
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterAC implements com.gaems.pnptoolbox.model.character.CharacterACInterface {

    private int acTotal;
    private int acTouch;
    private int acFlat;

    private int armorBonus;
    private int shieldBonus;
    private int dexBonus;
    private int sizeBonus;
    private int natArmorBonus;
    private int deflectBonus;
    private int miscBonus;

    private static final int AC_BASE = 10;


    /**
     * Calculates totals for all 3 AC categories: Main total, touch, and flatfooted.
     */
    public void calculate() {
        calculateAcTotal();
        calculateAcTouch();
        calculateAcFlat();
    }

    /**
     * Calculates the main AC total
     */
    private void calculateAcTotal() {
        acTotal = AC_BASE
                + armorBonus
                + shieldBonus
                + dexBonus
                + sizeBonus
                + natArmorBonus
                + deflectBonus
                + miscBonus;
    }

    /**
     * Calculates the total for touch AC
     */
    private void calculateAcTouch() {
        acTouch = AC_BASE
                + dexBonus
                + sizeBonus
                + natArmorBonus
                + deflectBonus
                + miscBonus;
    }

    /**
     * Calculates the total for flatfooted AC
     */
    private void calculateAcFlat() {
        acFlat = AC_BASE
                + armorBonus
                + shieldBonus
                + sizeBonus
                + natArmorBonus
                + deflectBonus
                + miscBonus;
    }


    /**
     * Gets acTotal
     *
     * @return
     *        Total for main AC
     */
    public int getAcTotal() {
        return acTotal;
    }

    /**
     * Sets acTotal
     *
     * @param acTotal
     *          acTotal to set
     */
    public void setAcTotal(int acTotal) {
        this.acTotal = acTotal;
    }

    /**
     * Gets AcTouch
     *
     * @return
     *      Total for touch AC
     */
    public int getAcTouch() {
        return acTouch;
    }

    /**
     * Sets acTouch
     *
     * @param acTouch
     *          acTouch to set
     */
    public void setAcTouch(int acTouch) {
        this.acTouch = acTouch;
    }

    /**
     * Gets acFlat
     *
     * @return
     *      Total for flatfooted AC
     */
    public int getAcFlat() {
        return acFlat;
    }

    /**
     * Sets acFlat
     *
     * @param acFlat
     *          acFlat to set
     */
    public void setAcFlat(int acFlat) {
        this.acFlat = acFlat;
    }

    /**
     * Gets armorBonus
     *
     * @return
     *        Gets the armor bonus for AC
     */
    public int getArmorBonus() {
        return armorBonus;
    }

    /**
     * Sets armorBonus
     *
     * @param armorBonus
     *          armorBonus to set
     */
    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    /**
     * Gets shieldBonus
     *
     * @return
     *          Gets the shield bonus for AC
     */
    public int getShieldBonus() {
        return shieldBonus;
    }

    /**
     * Sets shieldBonus
     *
     * @param shieldBonus
     *          shieldBonus to set
     */
    public void setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;
    }

    /**
     * Gets dexBonus
     *
     * @return
     *          Gets the dex bonus for AC
     */
    public int getDexBonus() {
        return dexBonus;
    }

    /**
     * Sets the dexBonus
     *
     * @param dexBonus
     *          dexBonus to set
     */
    public void setDexBonus(int dexBonus) {
        this.dexBonus = dexBonus;
    }

    /**
     * Gets sizeBonus
     *
     * @return
     *          Gets the size bonus for AC
     */
    public int getSizeBonus() {
        return sizeBonus;
    }

    /**
     * Sets sizeBonus
     *
     * @param sizeBonus
     *          sizeBonus to set
     */
    public void setSizeBonus(int sizeBonus) {
        this.sizeBonus = sizeBonus;
    }

    /**
     * Gets natArmorBonus
     *
     * @return
     *          Gets the natural armor bonus for AC
     */
    public int getNatArmorBonus() {
        return natArmorBonus;
    }

    /**
     * Sets natArmorBonus
     *
     * @param natArmorBonus
     *          natArmorBonus to set
     */
    public void setNatArmorBonus(int natArmorBonus) {
        this.natArmorBonus = natArmorBonus;
    }

    /**
     * Gets deflectBonus
     *
     * @return
     *          Gets the deflect bonus for AC
     */
    public int getDeflectBonus() {
        return deflectBonus;
    }

    /**
     * Sets deflectBonus
     *
     * @param deflectBonus
     *          deflectBonus to set
     */
    public void setDeflectBonus(int deflectBonus) {
        this.deflectBonus = deflectBonus;
    }

    /**
     * Gets miscBonus
     *
     * @return
     *          Gets any misc bonuses to AC
     */
    public int getMiscBonus() {
        return miscBonus;
    }

    /**
     * Sets miscBonus
     *
     * @param miscBonus
     *          miscBonus to set
     */
    public void setMiscBonus(int miscBonus) {
        this.miscBonus = miscBonus;
    }
}
