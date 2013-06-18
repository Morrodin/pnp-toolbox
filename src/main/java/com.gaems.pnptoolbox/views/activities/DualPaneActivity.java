package com.gaems.pnptoolbox.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Spinner;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.SpinnerController;
import com.gaems.pnptoolbox.views.fragments.CharacterSheetFragment;

/**
 * Management activity for the primary dual-panel layout
 *
 * @author: kwatson
 */
public class DualPaneActivity extends FragmentActivity implements SpinnerController.SpinnerCallback {

    SpinnerController mSpinnerController;
    CharacterSheetFragment characterSheetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_panel_activity);

        mSpinnerController = new SpinnerController(this, this);

        mSpinnerController.setUp();

        initializeFragments();


    }

    private void initializeFragments() {
        characterSheetFragment = new CharacterSheetFragment();
    }

    @Override
    public void spinner1Callback(int pos) {
        switch(pos) {
            //Character sheet
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_1, characterSheetFragment).commit();
        }
    }

    @Override
    public void spinner2Callback(int pos) {
        switch(pos) {
            //Character sheet
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_2, characterSheetFragment).commit();
        }
    }
}
