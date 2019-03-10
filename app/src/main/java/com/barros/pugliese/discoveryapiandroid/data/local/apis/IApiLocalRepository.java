package com.barros.pugliese.discoveryapiandroid.data.local.apis;

import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import java.util.List;

public interface IApiLocalRepository {

    void likeApi(ApiDTO apiDTO);
    void dislikeApi(ApiDTO apiDTO);
    List<ApiDTO> getAllFavoriteApis();

}
