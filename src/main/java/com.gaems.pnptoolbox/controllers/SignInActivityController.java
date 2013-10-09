package com.gaems.pnptoolbox.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.mapper.SignInActivityViewMapper;
import com.gaems.pnptoolbox.mapper.ViewMapperInterface;
import com.gaems.pnptoolbox.service.sharedpreferences.DefaultSharedPreferenceService;
import com.gaems.pnptoolbox.service.sharedpreferences.SharedPreferenceService;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocatorInterface;
import com.gaems.pnptoolbox.viewlocator.reference.AccountName;
import com.gaems.pnptoolbox.views.activities.FacetActivity;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SignInActivityController implements View.OnClickListener {

    private SharedPreferenceService mSharedPreferencesService;
    private ViewMapperInterface mViewMapper;
    private ViewLocatorInterface mViewLocator;
    private RequestQueue mRequestQueue;
    private Activity mActivity;

    public SignInActivityController(Activity activity, View parentView) {
        mSharedPreferencesService = new DefaultSharedPreferenceService(activity);
        mViewMapper = new SignInActivityViewMapper(parentView, activity);
        mViewLocator = new PrimaryViewLocator(parentView);
        mRequestQueue = Volley.newRequestQueue(activity);
        mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.sign_in_activity_sign_in_button:
                signIn();
                break;
        }
    }

    public void signIn() {
        storeAccountName();
        Intent intent = new Intent(mActivity, FacetActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
        mActivity.overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    private void storeAccountName() {
        EditText accountNameInput = (EditText) mViewLocator.locateViewByReference(new AccountName());
        mSharedPreferencesService.saveString(SharedPreferenceService.ACCOUNT_NAME,
                accountNameInput.getText().toString());
    }

}
