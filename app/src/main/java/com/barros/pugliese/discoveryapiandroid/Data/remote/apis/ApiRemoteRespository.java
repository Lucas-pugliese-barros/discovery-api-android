package com.barros.pugliese.discoveryapiandroid.Data.remote.apis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ApiRemoteRespository implements IApiRemoteRepository {

    private final String BASE_URL = "https://www.googleapis.com/discovery/v1/";
    private final String APIS_ENDPOINT = "apis";

    private RequestQueue requestQueue;

    public ApiRemoteRespository(@NonNull Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void getAll(@NonNull Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, BASE_URL + APIS_ENDPOINT, null, listener, errorListener);

        requestQueue.add(jsonObjectRequest);
    }
}
