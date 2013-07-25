package com.gaems.pnptoolbox.viewlocator.reference;

/**
 * Interface for view reference.
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public interface ReferenceInterface {

    /**
     * This method should return an android view ID referencing the specific view associated with this reference.
     *
     * @return
     *      Android view ID.
     */
    public int getId();
}
