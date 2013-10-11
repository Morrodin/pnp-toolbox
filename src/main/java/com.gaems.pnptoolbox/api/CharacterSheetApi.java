package com.gaems.pnptoolbox.api;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gaems.pnptoolbox.model.item.equipment.Armor;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * API client.
 */
public class CharacterSheetApi {

    private static final String CHARACTER_SHEET_BASE_ENDPOINT_URL = "http://www.example.com/api/";

    private RequestQueue mRequestQueue;

    public CharacterSheetApi(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Retrieve the full list of armors.
     *
     * @param listener A listener to send the armors, or error, to on completion.
     */
    public void getAllArmors(OnArmorRequestListener listener) {
        String relativeUrl = "armor";

        this.makeArmorRequest(relativeUrl, listener);
    }

    /**
     * Retrieve an armor by ID.
     *
     * @param id The ID of the armor to retrieve.
     * @param listener A listener to send the armor, or error, to on completion.
     */
    public void getArmor(Integer id, OnArmorRequestListener listener) {
        String relativeUrl = String.format("armor/%d", id);

        this.makeArmorRequest(relativeUrl, listener);
    }

    /**
     * Helper method to make requests to retrieve armor item(s)
     * @param relativeUrl The request URL relative to the base endpoint URL.
     * @param listener A listener to send the armor(s), or error, to on completion.
     */
    private void makeArmorRequest(String relativeUrl, OnArmorRequestListener listener) {
        String endpoint = CHARACTER_SHEET_BASE_ENDPOINT_URL + relativeUrl;
        ArmorRequestListener requestListener = new ArmorRequestListener(listener);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, endpoint, null, requestListener, requestListener);
        mRequestQueue.add(request);
    }

    /**
     * Helper class to handle responses when retrieving armor.
     */
    private class ArmorRequestListener implements
            Response.Listener<JSONObject>,
            Response.ErrorListener {
        private final OnArmorRequestListener mListener;

        private ArmorRequestListener(OnArmorRequestListener listener) {
            this.mListener = listener;
        }

        @Override
        public void onResponse(JSONObject jsonObjectNotGson) {
            ArrayList<Armor> armors = new ArrayList<Armor>();

            try {
                String jsonString = jsonObjectNotGson.toString();
                JsonParser parser = new JsonParser();
                Gson gson = new Gson();

                if (jsonObjectNotGson.getClass().equals(JSONArray.class)) {
                    JsonArray array = (JsonArray)parser.parse(jsonString);

                    Type armorListType = new TypeToken<ArrayList<Armor>>() {}.getClass();
                    ArrayList<Armor> parsedArmors = gson.fromJson(array, armorListType);

                    armors.addAll(parsedArmors);
                } else {
                    JsonObject object = (JsonObject)parser.parse(jsonString);

                    Type armorType = Armor.class;
                    Armor armor = gson.fromJson(object, armorType);

                    armors.add(armor);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mListener.onArmorRequestFinished(armors);
        }

        @Override
        public void onErrorResponse(VolleyError volleyError) {
            mListener.onArmorRequestFailed();
        }
    }
}
