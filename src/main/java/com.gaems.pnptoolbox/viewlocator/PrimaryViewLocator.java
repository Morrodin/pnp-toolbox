package com.gaems.pnptoolbox.viewlocator;

import android.view.View;
import com.gaems.pnptoolbox.viewlocator.reference.Reference;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class PrimaryViewLocator extends ViewLocator {

    private View mParentView;

    public PrimaryViewLocator(View parentView) {
        mParentView = parentView;
    }

    @Override
    public Object locateViewByReference(Reference reference) {
        return mParentView.findViewById(reference.getId());
    }
}
