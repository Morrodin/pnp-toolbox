package com.gaems.pnptoolbox.api;

import com.gaems.pnptoolbox.model.item.equipment.Armor;

import java.util.List;

/**
 * Interface to be informed when armors are retrieved.
 */
public interface OnArmorRequestListener {
    /**
     * A callback for when armors are successfully retrieved.
     *
     * @param armorList The retrieved armor items.
     */
    public void onArmorRequestFinished(List<Armor> armorList);

    /**
     * A callback for when retrieving armors fails.
     */
    public void onArmorRequestFailed();
}
