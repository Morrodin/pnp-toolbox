package com.gaems.pnptoolbox.views.activities;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Spinner;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.SpinnerController;
import com.gaems.pnptoolbox.views.fragments.CharacterSheetFragment;
import com.gaems.pnptoolbox.views.fragments.CombatFragment;
import com.gaems.pnptoolbox.views.fragments.NotesFragment;
import com.gaems.pnptoolbox.views.fragments.SpellsFragment;

/**
 * Management activity for the primary dual-facet layout
 *
 * @author: kwatson
 */
public class FacetActivity extends FragmentActivity implements SpinnerController.SpinnerCallback {

    SpinnerController mSpinnerController;

    private CombatFragment combatFragment;
    private CharacterSheetFragment characterSheetFragment;
    private SpellsFragment spellsFragment;
    private NotesFragment notesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(getResources().getBoolean(R.bool.portrait_only)){
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }
        setContentView(R.layout.dual_panel_activity);

        mSpinnerController = new SpinnerController(this, this);

        mSpinnerController.setUp();

        initializeFragments();


    }

    private void initializeFragments() {
        combatFragment = new CombatFragment();
        characterSheetFragment = new CharacterSheetFragment();
        spellsFragment = new SpellsFragment();
        notesFragment = new NotesFragment();
    }

    @Override
    public void spinner1Callback(int pos) {
        switch(pos) {
            //Character sheet
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_1, characterSheetFragment).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_1, combatFragment).commit();
        }
    }

    @Override
    public void spinner2Callback(int pos) {
        switch(pos) {

            //Spells
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_2, spellsFragment).commit();
                break;
            //Notes
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_2, notesFragment).commit();
                break;

        }
    }
}
