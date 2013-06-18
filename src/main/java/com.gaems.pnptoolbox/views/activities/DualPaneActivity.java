package com.gaems.pnptoolbox.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import com.gaems.pnptoolbox.R;

/**
 * Management activity for the primary dual-panel layout
 *
 * @author: kwatson
 */
public class DualPaneActivity extends Activity {

    Spinner container1Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_panel_activity);

        container1Spinner = (Spinner) findViewById(R.id.container_1_spinner);
    }

    private void setUpSpinner1
}
