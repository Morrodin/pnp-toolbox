package com.gaems.pnptoolbox.viewlocator;

import android.view.View;
import com.gaems.pnptoolbox.R;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CombatFragmentViewLocator {

    private View mParentView;

    public CombatFragmentViewLocator(View parentView) {
        mParentView = parentView;
    }

    public Object locateViewByReference(ViewLocatorRequestInterface request) {
        ViewLocatorRequestInterface.ReferenceName button = request.getButtonName();
        switch(button) {
            case HP_MOD_SHOW_HIDE:
                return mParentView.findViewById(R.id.combat_mod_hp_buttons);
            case HP_PLUS_10:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case HP_PLUS_5:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case HP_PLUS_1:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case HP_MINUS_10:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case HP_MINUS_5:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case HP_MINUS_1:
                return mParentView.findViewById(R.id.combat_current_hp_value);
            case ARMOR_BONUS:
                return mParentView.findViewById(R.id.ac_edit_armor_input);
            case UPDATE_AC_TOTAL:
                return mParentView.findViewById(R.id.combat_ac_value);
            case UPDATE_AC_TOUCH:
                return mParentView.findViewById(R.id.combat_ac_touch_value);
            case UPDATE_AC_FLAT:
                return mParentView.findViewById(R.id.combat_ac_flat_value);
            default:
                return null;
        }
    }

}
