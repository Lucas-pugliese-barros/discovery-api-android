package com.barros.pugliese.discoveryapiandroid.data.remote.apis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Response;

import org.json.JSONObject;

public interface IApiRemoteRepository {
    void getAll(@NonNull Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener);
}
