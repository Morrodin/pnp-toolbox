package com.gaems.pnptoolbox.views.fragments.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.SaveEditDialogFragmentController;
import com.gaems.pnptoolbox.model.character.implementation.CharacterSave;

/**
 * Dialog fragment to edit saves (Fort, Ref, Will)
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SaveEditDialogFragment extends DialogFragment {

    private Context mContext;
    private CharacterSave mCharacterSave;
    private SaveEditDialogFragmentController mController;
    private SaveDialogCallback mCallback;

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
    */
    public SaveEditDialogFragment(DialogType dialogType, SaveDialogCallback callback,
                                  Context context, CharacterSave characterSave) {
        this.mContext = context;
        this.mDialogType = dialogType;
        this.mCharacterSave = characterSave;
        this.mCallback = callback;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mController = new SaveEditDialogFragmentController(mCallback, getActivity(), this, mDialogType);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.save_edit_dialog);
        dialog.setTitle(mController.getCurrentTitle());


        if (mCharacterSave != null) {
            mController.instantiateFields(mCharacterSave);
        }

        //Wire buttons
        Button okBtn = (Button) dialog.findViewById(R.id.save_edit_ok);
        okBtn.setOnClickListener(mController);
        Button cancelBtn = (Button) dialog.findViewById(R.id.save_edit_cancel);
        cancelBtn.setOnClickListener(mController);

        return dialog;
    }

    public interface SaveDialogCallback {
        public void submitFortSave(CharacterSave newSave);

        public void submitRefSave(CharacterSave newSave);

        public void submitWillSave(CharacterSave newSave);
    }

    public Dialog getDialog() {
        return dialog;
    }

}
