package com.gaems.pnptoolbox.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.gaems.pnptoolbox.Constants;
import com.gaems.pnptoolbox.model.character.implementation.ApiCharacter;
import com.gaems.pnptoolbox.request.GsonRequest;
import com.google.gson.Gson;

/**
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class CharacterService {

    private RequestQueue mRequestQueue;
    private Gson mGson;

    public CharacterService(RequestQueue requestQueue) {
        mRequestQueue = requestQueue;
        mGson = new Gson();
    }

    public void getCharactersByAccountName(String accountName,
                                           Response.Listener<ApiCharacter> successListener,
                                           Response.ErrorListener errorListener) {
        GsonRequest<ApiCharacter> req = new GsonRequest<ApiCharacter>(
                Request.Method.GET,
                createUrl(),
                ApiCharacter.class,
                successListener,
                errorListener,
                mGson
        );
        mRequestQueue.add(req);
    }

    private String createUrl() {
        return Constants.API_BASE_URL+Constants.API_CHARACTER_URL;
    }

}
