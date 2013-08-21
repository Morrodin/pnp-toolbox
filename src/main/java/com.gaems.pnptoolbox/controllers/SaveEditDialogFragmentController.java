package com.gaems.pnptoolbox.controllers;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.mapper.CombatFragmentViewMapper;
import com.gaems.pnptoolbox.model.character.CharacterSaveInterface;
import com.gaems.pnptoolbox.model.character.implementation.CharacterSave;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocator;
import com.gaems.pnptoolbox.viewlocator.reference.*;
import com.gaems.pnptoolbox.views.fragments.dialogs.SaveEditDialogFragment;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SaveEditDialogFragmentController implements View.OnClickListener {

    private SaveEditDialogFragment.SaveDialogCallback mCallback;
    private Activity mActivity;
    private SaveEditDialogFragment mFragment;
    private ViewLocator mViewLocator;
    private SaveEditDialogFragment.DialogType mDialogType;
    private CombatFragmentViewMapper mViewMapper;

    public SaveEditDialogFragmentController(SaveEditDialogFragment.SaveDialogCallback callback,
                                            Activity activity, SaveEditDialogFragment fragment,
                                            SaveEditDialogFragment.DialogType dialogType) {
        this.mCallback = callback;
        this.mActivity = activity;
        this.mFragment = fragment;
        this.mDialogType = dialogType;
    }

    /**
     *
     *
     * @return
     */
    public TextView getCurrentView() {
        switch(mDialogType) {
            case FORT:
                return (TextView) mViewLocator.locateViewByReference(new FortSave());
            case REF:
                return (TextView) mViewLocator.locateViewByReference(new RefSave());
            case WILL:
                return (TextView) mViewLocator.locateViewByReference(new WillSave());
            default:
                return null;
        }
    }

    public void instantiateFields(CharacterSave characterSave) {
        instantiateViewMapper();
        mViewMapper.instantiateEditSaveFields(characterSave);
    }

    /**
     * Looks at the Dialog Type to determine what the title should be
     * of the dialog box.
     *
     * @return
     *          Correct title
     */
    public String getCurrentTitle() {
        switch (mDialogType) {
            case FORT:
                return mActivity.getResources().getString(R.string.fort_save_edit_dialog_title);
            case REF:
                return mActivity.getResources().getString(R.string.ref_save_edit_dialog_title);
            case WILL:
                return mActivity.getResources().getString(R.string.will_save_edit_dialog_title);
            default:
                return "";
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_edit_ok:
                switch (mDialogType) {
                    case FORT:
                        mFragment.getDialog().dismiss();
                        mCallback.submitFortSave(createNewSave());
                        break;
                    case REF:
                        mFragment.getDialog().dismiss();
                        mCallback.submitRefSave(createNewSave());
                        break;
                    case WILL:
                        mFragment.getDialog().dismiss();
                        mCallback.submitWillSave(createNewSave());
                        break;
                }
            case R.id.save_edit_cancel:
                mFragment.getDialog().dismiss();
                break;
        }
    }



    /**
     * Assembles a new CharacterSave from the dialog inputs.
     *
     * @return
     *      Assembled CharacterSave
     */
    private CharacterSave createNewSave() {
        instantiateViewLocator();
        return new CharacterSave(fetchSaveValue(new SaveBaseBonus()),
                fetchSaveValue(new SaveAbilityBonus()),
                fetchSaveValue(new SaveMagicBonus()),
                fetchSaveValue(new SaveMiscBonus()),
                fetchSaveValue(new SaveTempBonus()));
    }

    private int fetchSaveValue(Reference reference) {
        TextView view = (TextView) mViewLocator.locateViewByReference(reference);
        if (!view.getText().toString().equals("")) {
            return Integer.valueOf(view.getText().toString());
        } else {
            return 0;
        }
    }

    private void instantiateViewLocator() {
        mViewLocator = new PrimaryViewLocator(mFragment.getDialog().getWindow().getDecorView());
    }

    private void instantiateViewMapper() {
        mViewMapper = new CombatFragmentViewMapper(mFragment.getDialog().getWindow().getDecorView(), mActivity);
    }

}
