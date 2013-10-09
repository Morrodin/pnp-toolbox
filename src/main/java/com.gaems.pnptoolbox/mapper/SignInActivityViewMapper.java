package com.gaems.pnptoolbox.mapper;

import android.content.Context;
import android.view.View;
import com.gaems.pnptoolbox.controllers.AnimationService;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocatorInterface;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SignInActivityViewMapper implements ViewMapperInterface {

    private View mParentView;
    private Context mContext;
    private ViewLocatorInterface mViewLocator;



    public SignInActivityViewMapper(View parentView, Context ctx) {
        mParentView = parentView;
        mContext = ctx;
        mViewLocator = new PrimaryViewLocator(mParentView);
    }





}
