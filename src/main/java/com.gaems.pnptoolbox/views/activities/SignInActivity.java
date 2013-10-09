package com.gaems.pnptoolbox.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.controllers.SignInActivityController;
import com.gaems.pnptoolbox.service.sharedpreferences.DefaultSharedPreferenceService;
import com.gaems.pnptoolbox.service.sharedpreferences.SharedPreferenceService;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocator;
import com.gaems.pnptoolbox.viewlocator.reference.SignIn;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class SignInActivity extends Activity {

    private SignInActivityController mController;
    private ViewLocator mViewLocator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        View parentView = getWindow().getDecorView().findViewById(android.R.id.content);

        mViewLocator = new PrimaryViewLocator(parentView);

        mController = new SignInActivityController(this, parentView);


        setUp();

    }

    private void setUp() {
        Button signInBtn = (Button) mViewLocator.locateViewByReference(new SignIn());
        signInBtn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    mController.signIn();
                    return true;
                } else {
                    return false;
                }
            }
        });
        signInBtn.setOnClickListener(mController);
    }


}
