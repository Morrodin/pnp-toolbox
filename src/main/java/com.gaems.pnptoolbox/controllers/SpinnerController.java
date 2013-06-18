package com.gaems.pnptoolbox.controllers;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.gaems.pnptoolbox.R;

/**
 * Controller to manage the setup and functionality of the view changing spinners.
 *
 * @author kwatson
 */
public class SpinnerController {

    Activity mActivity;
    SpinnerCallback mCallback;
    Spinner container1Spinner;
    Spinner container2Spinner;

    ArrayAdapter<CharSequence> spinner1Adapter;
    ArrayAdapter<CharSequence> spinner2Adapter;

    public SpinnerController(Activity activity, SpinnerCallback callback) {
        mActivity = activity;
        mCallback = callback;
    }

    public void setUp() {
        container1Spinner = (Spinner) mActivity.findViewById(R.id.container_1_spinner);
        container2Spinner = (Spinner) mActivity.findViewById(R.id.container_2_spinner);
        initializeSpinner1();
        initializeSpinner2();
    }

    private void initializeSpinner1() {
        spinner1Adapter = ArrayAdapter.createFromResource(mActivity,
                R.array.fragments_array_left, android.R.layout.simple_spinner_item);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        container1Spinner.setAdapter(spinner1Adapter);
        container1Spinner.setOnItemSelectedListener(this.spinner1Listener());
    }

    private void initializeSpinner2() {
        spinner2Adapter = ArrayAdapter.createFromResource(mActivity,
                R.array.fragments_array_right, android.R.layout.simple_spinner_item);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        container2Spinner.setAdapter(spinner2Adapter);
        container2Spinner.setOnItemSelectedListener(this.spinner2Listener());
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
