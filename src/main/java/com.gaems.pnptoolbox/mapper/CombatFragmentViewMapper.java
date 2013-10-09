package com.gaems.pnptoolbox.mapper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.AnimationService;
import com.gaems.pnptoolbox.model.character.implementation.CharacterAC;
import com.gaems.pnptoolbox.model.character.implementation.CharacterSave;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocator;
import com.gaems.pnptoolbox.viewlocator.reference.*;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CombatFragmentViewMapper extends ViewMapper {

    private Context mContext;
    private View mParentView;
    private AnimationService mAnimService;
    private ViewLocator mViewLocator;

    /**
     * Constructor
     * @param parentView
     *          root view of layout which this view mapper belongs to
     * @param ctx
     *          context
     */
    public CombatFragmentViewMapper(View parentView, Context ctx) {
        mParentView = parentView;
        mContext = ctx;
        mAnimService = new AnimationService();
        mViewLocator = new PrimaryViewLocator(mParentView);
    }

    /**
     * Plays an animation to slide up a layout. Corresponding animations
     *  are played depending on which button is pressed. ButtonName values are
     *  constants stored in {@link com.gaems.pnptoolbox.viewlocator.ViewLocatorInterface}.
     *
     * @param reference
     *      {@link Reference} corresponding to the view which is being manipulated.
     */
    public void doSlideUpOnButtonPress(Reference reference) {
        final ViewGroup view = (ViewGroup) mViewLocator.locateViewByReference(reference);
        view.postInvalidate();
        mAnimService.setLayoutAnim_slideup(view);
        view.startLayoutAnimation();
    }

    /**
     * Plays an animation to slide down a layout. Corresponding animations
     *  are played depending on which button is pressed. ButtonName values are
     *  constants stored in {@link com.gaems.pnptoolbox.viewlocator.ViewLocatorInterface}.
     *
     * @param reference
     *      {@link Reference} corresponding to the view which is being manipulated.
     */
    public void doSlideDownOnButtonPress(Reference reference) {
        final ViewGroup view = (ViewGroup) mViewLocator.locateViewByReference(reference);
        mAnimService.setLayoutAnim_slidedown(view);
        view.startLayoutAnimation();
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Updates the current HP view by adding 10.
     */
    public void hpPlus10Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpPlus10());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())+10));
    }

    /**
     * Updates the current HP view by adding 5.
     */
    public void hpPlus5Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpPlus5());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())+5));
    }

    /**
     * Updates the current HP view by adding 1.
     */
    public void hpPlus1Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpPlus1());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())+1));
    }

    /**
     * Updates the current HP view by subtracting 10.
     */
    public void hpMinus10Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpMinus10());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())-10));
    }

    /**
     * Updates the current HP view by subtracting 5.
     */

    public void hpMinus5Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpMinus5());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())-5));
    }

    /**
     * Updates the current HP view by subtracting 1.
     */
    public void hpMinus1Click() {
        TextView view = (TextView) mViewLocator.locateViewByReference(new HpMinus1());
        view.setText(String.valueOf(Integer.parseInt(view.getText().toString())-1));
    }

    /**
     * Updates AC, Touch, and Flatfooted values after submitting an edited AC.
     *
     * @param ac
     *          AC entity to pull new values from
     */
    public void updateAc(CharacterAC ac) {
        TextView acTotal = (TextView) mViewLocator.locateViewByReference(new UpdateAcTotal());
        acTotal.setText(String.valueOf(ac.getAcTotal()));
        TextView acTouch = (TextView) mViewLocator.locateViewByReference(new UpdateAcTouch());
        acTouch.setText(String.valueOf(ac.getAcTouch()));
        TextView acFlat = (TextView) mViewLocator.locateViewByReference(new UpdateAcFlat());
        acFlat.setText(String.valueOf(ac.getAcFlat()));
    }

    /**
     * Updates Fort save value after submitting an edited save
     *
     * @param characterSave
     *          Save entity to pull new values from
     */
    public void updateFortSave(CharacterSave characterSave) {
        TextView fortSave = (TextView) mViewLocator.locateViewByReference(new FortSave());

        //If the player has a temp mod, we want to indicate that by changing the color
        if (characterSave.getTempMod() != 0) {
            if (characterSave.getTempMod() > 0) {
                fortSave.setTextColor(mContext.getResources().getColor(R.color.green));
            } else {
                fortSave.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } else {
            fortSave.setTextColor(mContext.getResources().getColor(R.color.black));
        }

        int test = characterSave.calculate();
        fortSave.setText(String.valueOf(characterSave.calculate()));
    }

    /**
     * Updates Ref save value after submitting an edited save
     *
     * @param characterSave
     *          Save entity to pull new values from
     */
    public void updateRefSave(CharacterSave characterSave) {
        TextView refSave = (TextView) mViewLocator.locateViewByReference(new RefSave());

        //If the player has a temp mod, we want to indicate that by changing the color
        if (characterSave.getTempMod() != 0) {
            if (characterSave.getTempMod() > 0) {
                refSave.setTextColor(mContext.getResources().getColor(R.color.green));
            } else {
                refSave.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } else {
            refSave.setTextColor(mContext.getResources().getColor(R.color.black));
        }

        refSave.setText(String.valueOf(characterSave.calculate()));
    }

    /**
     * Updates Will save value after submitting an edited save
     *
     * @param characterSave
     *          Save entity to pull new values from
     */
    public void updateWillSave(CharacterSave characterSave) {
        TextView willSave = (TextView) mViewLocator.locateViewByReference(new WillSave());

        //If the player has a temp mod, we want to indicate that by changing the color
        if (characterSave.getTempMod() != 0) {
            if (characterSave.getTempMod() > 0) {
                willSave.setTextColor(mContext.getResources().getColor(R.color.green));
            } else {
                willSave.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } else {
            willSave.setTextColor(mContext.getResources().getColor(R.color.black));
        }

        willSave.setText(String.valueOf(characterSave.calculate()));
    }


    /**
     * Directly fills in values on the Edit AC dialog for any pre-existing AC information.
     *
     * @param currentAc
     *      {@link com.gaems.pnptoolbox.model.character.implementation.CharacterAC} holding existing values
     */
    public void instantiateEditAcFields(CharacterAC currentAc) {
        EditText armorBonus = (EditText) mViewLocator.locateViewByReference(new AcArmorBonus());
        armorBonus.setText(String.valueOf(currentAc.getArmorBonus()));
        EditText shieldBonus = (EditText) mViewLocator.locateViewByReference(new AcShieldBonus());
        shieldBonus.setText(String.valueOf(currentAc.getShieldBonus()));
        EditText dexBonus = (EditText) mViewLocator.locateViewByReference(new AcDexBonus());
        dexBonus.setText(String.valueOf(currentAc.getDexBonus()));
        EditText sizeBonus = (EditText) mViewLocator.locateViewByReference(new AcSizeBonus());
        sizeBonus.setText(String.valueOf(currentAc.getSizeBonus()));
        EditText natArmorBonus = (EditText) mViewLocator.locateViewByReference(new AcNaturalArmorBonus());
        natArmorBonus.setText(String.valueOf(currentAc.getNatArmorBonus()));
        EditText deflectBonus = (EditText) mViewLocator.locateViewByReference(new AcDeflectBonus());
        deflectBonus.setText(String.valueOf(currentAc.getDeflectBonus()));
        EditText miscBonus = (EditText) mViewLocator.locateViewByReference(new AcMiscBonus());
        miscBonus.setText(String.valueOf(currentAc.getMiscBonus()));
    }

    /**
     * Directly fills in values on the Edit Save dialog for any pre-existing save information.
     *
     * @param currentSave
     *          {@link CharacterSave} holding existing values
     */
    public void instantiateEditSaveFields(CharacterSave currentSave) {
        EditText baseBonus = (EditText) mViewLocator.locateViewByReference(new SaveBaseBonus());
        baseBonus.setText(String.valueOf(currentSave.getBaseMod()));
        EditText abilityBonus = (EditText) mViewLocator.locateViewByReference(new SaveAbilityBonus());
        abilityBonus.setText(String.valueOf(currentSave.getAbilityMod()));
        EditText magicBonus = (EditText) mViewLocator.locateViewByReference(new SaveMagicBonus());
        magicBonus.setText(String.valueOf(currentSave.getMagicMod()));
        EditText miscBonus = (EditText) mViewLocator.locateViewByReference(new SaveMiscBonus());
        miscBonus.setText(String.valueOf(currentSave.getMiscMod()));
        EditText tempBonus = (EditText) mViewLocator.locateViewByReference(new SaveTempBonus());
        tempBonus.setText(String.valueOf(currentSave.getTempMod()));
    }
}
