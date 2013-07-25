package com.gaems.pnptoolbox.viewlocator;

import android.view.ViewGroup;
import com.gaems.pnptoolbox.viewlocator.Reference;

/**
 * ViewLocatorInterface Interface.
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public interface ViewLocatorInterface {

    public ViewGroup locateViewByReference(Reference reference);

}
