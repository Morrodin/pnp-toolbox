package com.gaems.pnptoolbox.views.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import com.gaems.pnptoolbox.R;

/**
 * Dialog fragment to edit saves (Fort, Ref, Will)
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SaveEditDialogFragment extends DialogFragment {

    private int mBaseMod;
    private int mAbilityMod;
    private int mMagicMod;
    private int mMiscMod;
    private int mTempMod;
    private int

    private DialogType mDialogType;
    private Dialog dialog;

    public enum DialogType {
        FORT,
        REF,
        WILL
    }


    /**
     * Empty/default constructor
     */
    public SaveEditDialogFragment() {
    }

    /**
     * Full constructor
     *
     * @param base
     *          base class modifier
     * @param abilityMod
     *          ability modifier
     * @param magicMod
     *          magic modifier
     * @param miscMod
     *          misc modifier
     * @param tempMod
     *          temporary modifier
     */
    public SaveEditDialogFragment(DialogType dialogType, int base, int abilityMod, int magicMod, int miscMod, int tempMod) {
        this.mBaseMod = base;
        this.mAbilityMod = abilityMod;
        this.mMagicMod = magicMod;
        this.mMiscMod = miscMod;
        this.mTempMod = tempMod;
        this.mDialogType = dialogType;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.combat_ac_edit_dialog);
        dialog.setTitle(getString(R.string.ac_edit_dialog_title));

        if (mCurrentAC != null) {
            mController.instantiateFields(mCurrentAC);
        }

        //Wire buttons
        Button okBtn = (Button) dialog.findViewById(R.id.ac_edit_ok);
        okBtn.setOnClickListener(mController);
        Button cancelBtn = (Button) dialog.findViewById(R.id.ac_edit_cancel);
        cancelBtn.setOnClickListener(mController);

        return dialog;
    }

    public interface saveDialogCallback {
        public void submitFortSave();

        public void submitRefSave();

        public void submitWillSave();
    }

    public int getBase() {
        return mBaseMod;
    }

    public void setBase(int base) {
        this.mBaseMod = base;
    }

    public int getAbilityMod() {
        return mAbilityMod;
    }

    public void setAbilityMod(int mAbilityMod) {
        this.mAbilityMod = mAbilityMod;
    }

    public int getMagicMod() {
        return mMagicMod;
    }

    public void setMagicMod(int mMagicMod) {
        this.mMagicMod = mMagicMod;
    }

    public int getMiscMod() {
        return mMiscMod;
    }

    public void setMiscMod(int mMiscMod) {
        this.mMiscMod = mMiscMod;
    }

    public int getTempMod() {
        return mTempMod;
    }

    public void setTempMod(int mTempMod) {
        this.mTempMod = mTempMod;
    }
}
