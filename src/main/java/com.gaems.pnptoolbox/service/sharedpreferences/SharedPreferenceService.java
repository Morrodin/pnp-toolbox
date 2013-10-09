package com.gaems.pnptoolbox.service.sharedpreferences;

/**
 * @author Andrew
 */
public interface SharedPreferenceService {

    //Place Preference Keys Here
    public static final String ACCOUNT_NAME = "AccountName";

    void saveBoolean(String key, boolean value);

    boolean getBoolean(String key, boolean defaultVal);

    void saveInt(String key, int value);

    int getInt(String key, int defaultVal);

    void saveFloat(String key, float value);

    float getFloat(String key, float defaultVal);

    void saveString(String key, String value);

    String getString(String key, String defaultVal);
}
