package com.gaems.pnptoolbox.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.CombatFragmentController;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CombatFragment extends Fragment {

    private View view;
    private CombatFragmentController mController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.combat_fragment, container, false);

        mController = new CombatFragmentController(getActivity(), view);

        LinearLayout currentHpLayout = (LinearLayout) view.findViewById(R.id.combat_current_hp_container);
        currentHpLayout.setOnClickListener(mController);
        initializeHpModButtons();
        initializeLongclicksForEdit();

        return view;
    }

    /**
     * Sets OnClickListeners for the buttons that adjust current HP.
     */
    private void initializeHpModButtons() {
        TextView plus10 = (TextView) view.findViewById(R.id.combat_hp_plus_10);
        plus10.setOnClickListener(mController);
        TextView plus5 = (TextView) view.findViewById(R.id.combat_hp_plus_5);
        plus5.setOnClickListener(mController);
        TextView plus1 = (TextView) view.findViewById(R.id.combat_hp_plus_1);
        plus1.setOnClickListener(mController);
        TextView minus10 = (TextView) view.findViewById(R.id.combat_hp_minus_10);
        minus10.setOnClickListener(mController);
        TextView minus5 = (TextView) view.findViewById(R.id.combat_hp_minus_5);
        minus5.setOnClickListener(mController);
        TextView minus1 = (TextView) view.findViewById(R.id.combat_hp_minus_1);
        minus1.setOnClickListener(mController);
    }

    /**
     * Sets up Longclick listeners for all the longpress edit dialogs.
     */
    private void initializeLongclicksForEdit() {
        LinearLayout acContainer = (LinearLayout) view.findViewById(R.id.combat_ac_container);
        acContainer.setOnLongClickListener(mController);

        TextView fortSave = (TextView) view.findViewById(R.id.combat_save_fort_value);
        fortSave.setOnLongClickListener(mController);
        TextView refSave = (TextView) view.findViewById(R.id.combat_save_ref_value);
        refSave.setOnLongClickListener(mController);
        TextView willSave = (TextView) view.findViewById(R.id.combat_save_will_value);
        willSave.setOnLongClickListener(mController);
    }
}
