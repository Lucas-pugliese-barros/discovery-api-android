package com.barros.pugliese.discoveryapiandroid.Data.remote.apis;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.Response;

import org.json.JSONObject;

public interface IApiRemoteRepository {
    void getAll(@NonNull Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener);
}
