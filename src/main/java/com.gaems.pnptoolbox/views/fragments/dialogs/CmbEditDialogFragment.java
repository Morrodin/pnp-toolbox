package com.gaems.pnptoolbox.views.fragments.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import com.gaems.pnptoolbox.controllers.CmbEditDialogFragmentController;
import com.gaems.pnptoolbox.model.character.implementation.CharacterAC;
import com.gaems.pnptoolbox.model.character.implementation.CharacterCMB;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CmbEditDialogFragment extends DialogFragment {

    private Dialog dialog;
    private Context mContext;
    private CmbEditDialogFragmentController mController;
    private CharacterCMB mCurrentCmb;


}
