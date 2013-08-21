package com.gaems.pnptoolbox.controllers;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.gaems.pnptoolbox.R;
import com.gaems.pnptoolbox.viewlocator.PrimaryViewLocator;
import com.gaems.pnptoolbox.viewlocator.ViewLocator;
import com.gaems.pnptoolbox.viewlocator.reference.Spinner1;
import com.gaems.pnptoolbox.viewlocator.reference.Spinner2;

/**
 * Controller to manage the setup and functionality of the view changing spinners.
 *
 * @author kwatson
 */
public class SpinnerController {

    Activity mActivity;
    SpinnerCallback mCallback;
    Spinner facet1Spinner;
    Spinner facet2Spinner;
    private ViewLocator mViewLocator;

    ArrayAdapter<CharSequence> spinner1Adapter;
    ArrayAdapter<CharSequence> spinner2Adapter;

    public SpinnerController(Activity activity, SpinnerCallback callback) {
        mActivity = activity;
        mCallback = callback;
        mViewLocator = new PrimaryViewLocator(mActivity.getWindow().getDecorView());
    }

    public void setUp() {
        facet1Spinner = (Spinner) mViewLocator.locateViewByReference(new Spinner1());
        facet2Spinner = (Spinner) mViewLocator.locateViewByReference(new Spinner2());
        initializeSpinner1();
        //Second facet/spinner is only shown in landscape.
        if (mActivity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initializeSpinner2();
        }
    }

    private void initializeSpinner1() {
        spinner1Adapter = ArrayAdapter.createFromResource(mActivity,
                R.array.fragments_array_left, android.R.layout.simple_spinner_item);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facet1Spinner.setAdapter(spinner1Adapter);
        facet1Spinner.setOnItemSelectedListener(this.spinner1Listener());
    }

    private void initializeSpinner2() {
        spinner2Adapter = ArrayAdapter.createFromResource(mActivity,
                R.array.fragments_array_right, android.R.layout.simple_spinner_item);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facet2Spinner.setAdapter(spinner2Adapter);
        facet2Spinner.setOnItemSelectedListener(this.spinner2Listener());
    }

    protected AdapterView.OnItemSelectedListener spinner1Listener() {
        return new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mCallback.spinner1Callback(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    protected AdapterView.OnItemSelectedListener spinner2Listener() {
        return new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mCallback.spinner2Callback(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    public interface SpinnerCallback {

        public void spinner1Callback(int pos);

        public void spinner2Callback(int pos);

    }

}
