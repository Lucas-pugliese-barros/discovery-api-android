package com.barros.pugliese.discoveryapiandroid.data.local;

import android.content.Context;

import com.barros.pugliese.discoveryapiandroid.data.local.apis.ApiLocalRepository;
import com.barros.pugliese.discoveryapiandroid.data.local.apis.IApiLocalRepository;

public class LocalServicesManager {

    public static IApiLocalRepository getApiLocalRepository(Context context) {
        return new ApiLocalRepository(context);
    }
}
