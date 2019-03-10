package com.barros.pugliese.discoveryapiandroid.views.apis.list;

import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

@FunctionalInterface
public interface OnApiLikeListener {
    void OnApiLike(ApiDTO apiDTO);
}
