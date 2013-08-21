package com.gaems.pnptoolbox.controllers;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.mapper.CombatFragmentViewMapper;
import com.gaems.pnptoolbox.model.character.implementation.CharacterAC;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocator;
import com.gaems.pnptoolbox.viewlocator.reference.*;
import com.gaems.pnptoolbox.views.fragments.dialogs.AcEditDialogFragment;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class AcEditDialogFragmentController implements View.OnClickListener {

    private AcEditDialogFragment.AcEditCallback mCallback;
    private FragmentActivity mActivity;
    private AcEditDialogFragment mFragment;
    private ViewLocator mViewLocator;
    private CombatFragmentViewMapper mViewMapper;


    public AcEditDialogFragmentController(FragmentActivity activity, AcEditDialogFragment fragment, AcEditDialogFragment.AcEditCallback callback) {
        mActivity = activity;
        mFragment = fragment;
        mCallback = callback;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ac_edit_ok:
                mCallback.acEditOk(constructNewCharacterAc());
                mFragment.getDialog().dismiss();
                break;
            case R.id.ac_edit_cancel:
                mFragment.getDialog().dismiss();
                break;
        }
    }

    /**
     * Fills in the dialog edit texts with any already existing information
     */
    public void instantiateFields(CharacterAC currentAc) {
        instantiateViewMapper();
        mViewMapper.instantiateEditAcFields(currentAc);

    }

    /**
     * Gathers inputted information from dialog fields.
     *
     * @return
     *      new CharacterAC
     */
    private CharacterAC constructNewCharacterAc() {
        CharacterAC ac = new CharacterAC();
        instantiateViewLocator();
        ac.setArmorBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcArmorBonus())).getText().toString()));
        ac.setShieldBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcShieldBonus())).getText().toString()));
        ac.setDexBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcDexBonus())).getText().toString()));
        ac.setSizeBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcSizeBonus())).getText().toString()));
        ac.setNatArmorBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcNaturalArmorBonus())).getText().toString()));
        ac.setDeflectBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcDeflectBonus())).getText().toString()));
        ac.setMiscBonus(Integer.valueOf(((EditText) mViewLocator.locateViewByReference(
                new AcMiscBonus())).getText().toString()));

        ac.calculate();
        return ac;
    }

    /**
     * Used to setup the ViewLocator. Should be called in any method which makes use of it, since we can't
     * instantiate it in the constructor (dialog may not exist yet).
     */
    private void instantiateViewLocator() {
        if (mViewLocator == null) {
            mViewLocator = new PrimaryViewLocator(mFragment.getDialog().getWindow().getDecorView());
        }
    }

    /**
     * Used to setup the ViewMapper. Should be called in any method which makes use of it, since we can't
     * instantiate it in the constructor (dialog may not exist yet).
     */
    private void instantiateViewMapper() {
        if (mViewMapper == null) {
            mViewMapper = new CombatFragmentViewMapper(mFragment.getDialog().getWindow().getDecorView(),
                    mActivity);
        }
    }

}
