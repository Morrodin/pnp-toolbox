package com.gaems.pnptoolbox.controllers;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.mapper.CombatFragmentViewMapper;
import com.gaems.pnptoolbox.model.character.CharacterSaveInterface;
import com.gaems.pnptoolbox.model.character.implementation.Character;
import com.gaems.pnptoolbox.model.character.implementation.CharacterAC;
import com.gaems.pnptoolbox.model.character.implementation.CharacterSave;
import com.gaems.pnptoolbox.viewlocator.reference.HpModShowHide;
import com.gaems.pnptoolbox.views.fragments.dialogs.AcEditDialogFragment;
import com.gaems.pnptoolbox.views.fragments.dialogs.SaveEditDialogFragment;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CombatFragmentController implements View.OnClickListener, View.OnLongClickListener
        , AcEditDialogFragment.AcEditCallback, SaveEditDialogFragment.SaveDialogCallback{

    private Character mCurrentCharacter;
    private FragmentActivity mActivity;
    private boolean isHpButtonsVisible;
    private CombatFragmentViewMapper viewMapper;

    private AcEditDialogFragment acEditDialog;
    private SaveEditDialogFragment saveEditDialog;

    public CombatFragmentController(FragmentActivity activity, View parentView) {
        mCurrentCharacter = new Character();
        mActivity = activity;
        viewMapper = new CombatFragmentViewMapper(parentView, mActivity);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.combat_current_hp_container:
                currentHpClick();
                break;
            case R.id.combat_hp_plus_10:
                hpPlus10Click();
                break;
            case R.id.combat_hp_plus_5:
                hpPlus5Click();
                break;
            case R.id.combat_hp_plus_1:
                hpPlus1Click();
                break;
            case R.id.combat_hp_minus_10:
                hpMinus10Click();
                break;
            case R.id.combat_hp_minus_5:
                hpMinus5Click();
                break;
            case R.id.combat_hp_minus_1:
                hpMinus1Click();
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch(view.getId()) {
            case R.id.combat_ac_container:
                showEditAcDialog();
                return true;
            case R.id.combat_save_fort_value:
                showEditFortSaveDialog();
                return true;
            case R.id.combat_save_ref_value:
                showEditRefSaveDialog();
                return true;
            case R.id.combat_save_will_value:
                showEditWillSaveDialog();
                return true;
            default:
                return false;
        }
    }

    /**
     * Action to take when Current HP area is tapped
     */
    private void currentHpClick() {
        HpModShowHide reference = new HpModShowHide();
        if (!isHpButtonsVisible) {
            isHpButtonsVisible = true;
            viewMapper.doSlideDownOnButtonPress(reference);
        } else {
            isHpButtonsVisible = false;
            viewMapper.doSlideUpOnButtonPress(reference);
        }
    }


    /**
     * Action to take when HP +10 button is tapped
     */
    private void hpPlus10Click() {
        viewMapper.hpPlus10Click();
    }

    /**
     * Action to take when HP +5 button is tapped
     */
    private void hpPlus5Click() {
        viewMapper.hpPlus5Click();
    }

    /**
     * Action to take when HP +1 button is tapped
     */
    private void hpPlus1Click() {
        viewMapper.hpPlus1Click();
    }

    /**
     * Action to take when HP -10 button is tapped
     */
    private void hpMinus10Click() {
        viewMapper.hpMinus10Click();
    }

    /**
     * Action to take when HP -5 button is tapped
     */
    private void hpMinus5Click() {
        viewMapper.hpMinus5Click();
    }

    /**
     * Action to take when HP -1 button is tapped
     */
    private void hpMinus1Click() {
        viewMapper.hpMinus1Click();
    }

    /**
     * Displays the dialog to edit AC information
     */
    private void showEditAcDialog() {
        if (mCurrentCharacter.getAC() != null) {
            acEditDialog = new AcEditDialogFragment(mActivity, this, mCurrentCharacter.getAC());
        } else {
            acEditDialog = new AcEditDialogFragment(mActivity, this);
        }
        acEditDialog.show(mActivity.getSupportFragmentManager(), "acEdit");
    }

    /**
     * Displays the dialog to edit fort save information
     */
    private void showEditFortSaveDialog() {
        if (mCurrentCharacter.getFortSave() != null) {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.FORT, this, mActivity,
                    mCurrentCharacter.getFortSave());
        } else {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.FORT, this, mActivity,
                    null);
        }
        saveEditDialog.show(mActivity.getSupportFragmentManager(), "fortSaveEdit");
    }

    /**
     * Displays the dialog to edit ref save information
     */
    private void showEditRefSaveDialog() {
        if (mCurrentCharacter.getRefSave() != null) {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.REF, this, mActivity,
                    mCurrentCharacter.getFortSave());
        } else {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.REF, this, mActivity,
                    null);
        }
        saveEditDialog.show(mActivity.getSupportFragmentManager(), "refSaveEdit");
    }

    /**
     * Displays the dialog to edit ref save information
     */
    private void showEditWillSaveDialog() {
        if (mCurrentCharacter.getWillSave() != null) {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.WILL, this, mActivity,
                    mCurrentCharacter.getFortSave());
        } else {
            saveEditDialog = new SaveEditDialogFragment(SaveEditDialogFragment.DialogType.WILL, this, mActivity,
                    null);
        }
        saveEditDialog.show(mActivity.getSupportFragmentManager(), "willSaveEdit");
    }


    @Override
    public void acEditOk(CharacterAC newAc) {
        mCurrentCharacter.setAC(newAc);
        viewMapper.updateAc(newAc);
    }

    @Override
    public void submitFortSave(CharacterSave newSave) {
        mCurrentCharacter.setFortSave(newSave);
        viewMapper.updateFortSave(newSave);
    }

    @Override
    public void submitRefSave(CharacterSave newSave) {
        mCurrentCharacter.setRefSave(newSave);
        viewMapper.updateRefSave(newSave);
    }

    @Override
    public void submitWillSave(CharacterSave newSave) {
        mCurrentCharacter.setWillSave(newSave);
        viewMapper.updateWillSave(newSave);
    }
}
