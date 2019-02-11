package com.barros.pugliese.discoveryapiandroid.ApiList;

import com.barros.pugliese.discoveryapiandroid.Model.Api;

@FunctionalInterface
public interface OnApiFavoritedListener {
    void OnApiFavorited(Api api);
}
