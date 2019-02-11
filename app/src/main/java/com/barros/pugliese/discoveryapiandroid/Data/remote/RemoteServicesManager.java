package com.barros.pugliese.discoveryapiandroid.Data.remote;

import android.content.Context;

import com.barros.pugliese.discoveryapiandroid.Data.remote.apis.ApiRemoteRespository;
import com.barros.pugliese.discoveryapiandroid.Data.remote.apis.IApiRemoteRepository;

public class RemoteServicesManager {

    public static IApiRemoteRepository getApiRemoteRepository(Context context) {
            return new ApiRemoteRespository(context);
    }
}
