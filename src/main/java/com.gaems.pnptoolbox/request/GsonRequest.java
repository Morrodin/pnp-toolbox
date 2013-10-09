package com.gaems.pnptoolbox.request;

import com.android.volley.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Kenton Watson
 */
public class GsonRequest<T> extends Request<T> {

    private final Gson mGson;
    private final Class<T> mClazz;
    private final Response.Listener<T> mListener;
    private String mJsonBody;
    private String mContentType;

    /**
     * Creates a new GsonRequest object
     *
     * @param method        http method to use @see com.android.volley.Request.Method
     * @param url           url to post to
     * @param clazz         class gson should serialize data into
     * @param listener      callback listener on success
     * @param errorListener listener for error
     * @param gson          gson object for serialization
     */
    public GsonRequest(
            int method,
            String url,
            Class<T> clazz,
            Response.Listener<T> listener,
            Response.ErrorListener errorListener,
            Gson gson
    ) {
        super(method, url, errorListener);

        mClazz = checkNotNull(clazz);
        mListener = checkNotNull(listener);
        mGson = checkNotNull(gson);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(
                            response.headers
                    )
            );
            return Response.success(
                    mGson.fromJson(
                            json, mClazz
                    ),
                    HttpHeaderParser.parseCacheHeaders(
                            response
                    )
            );
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }


    @Override
    public byte[] getBody() throws AuthFailureError {
        if (getMethod() == Method.PUT && mJsonBody != null || getMethod() == Method.POST && mJsonBody != null) {
            return mJsonBody.getBytes();
        } else {
            return super.getBody();
        }
    }

    @Override
    public String getBodyContentType() {
        if (getMethod() == Method.PUT && mContentType != null || getMethod() == Method.POST && mContentType != null) {
            return mContentType;
        } else {
            return super.getBodyContentType();
        }
    }

    public void setContentType(String contentType) {
        mContentType = contentType;
    }

    public void setJsonBody(String jsonBody) {
        mJsonBody = jsonBody;
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
