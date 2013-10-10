package com.gaems.pnptoolbox.model.item.equipment;

/**
 * Model object representing movement speed for a piece of armor.
 */
public class ArmorSpeed {
    private Integer m30Speed;
    private Integer m20Speed;

    public Integer get30() {
        return m30Speed;
    }

    public void set30(Integer movementSpeed) {
        m30Speed = movementSpeed;
    }

    public Integer get20Speed() {
        return m20Speed;
    }

    public void set20Speed(Integer movementSpeed) {
        m20Speed = movementSpeed;
    }
}
