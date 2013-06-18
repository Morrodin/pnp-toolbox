package com.gaems.pnptoolbox.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gaems.pnptoolbox.R;

/**
 * Fragment for spells
 *
 * @author kwatson
 */
public class SpellsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spells_fragment, container, false);

        return view;
    }
}
