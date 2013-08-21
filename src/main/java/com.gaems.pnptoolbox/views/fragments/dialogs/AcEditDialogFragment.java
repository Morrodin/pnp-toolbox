package com.gaems.pnptoolbox.views.fragments.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.AcEditDialogFragmentController;
import com.gaems.pnptoolbox.model.character.implementation.CharacterAC;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class AcEditDialogFragment extends DialogFragment {

    private Dialog dialog;
    private Context mContext;
    private AcEditDialogFragmentController mController;
    private CharacterAC mCurrentAC;

    public AcEditDialogFragment(Context context, AcEditCallback callback, CharacterAC currentAc) {
        mContext = context;
        mCurrentAC = currentAc;
        mController = new AcEditDialogFragmentController(getActivity(), this, callback);
    }

    public AcEditDialogFragment(Context context, AcEditCallback callback) {
        mContext = context;
        mController = new AcEditDialogFragmentController(getActivity(), this, callback);
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

    public interface AcEditCallback {

        public void acEditOk(CharacterAC newAc);

    }


    public Dialog getDialog() {
        return dialog;
    }
}
