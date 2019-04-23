package com.barros.pugliese.discoveryapiandroid.views.favoriteApis;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.barros.pugliese.discoveryapiandroid.data.local.apis.IApiLocalRepository;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import java.util.List;

import static com.barros.pugliese.discoveryapiandroid.utils.TimeTracker.recordTime;

public class FavoriteApisPresenter implements FavoriteApisContract.Presenter, Response.ErrorListener {

    private static String TAG_LOCAL = " LOCAL ";

    private final IApiLocalRepository apiLocalRepository;
    private final FavoriteApisContract.View view;

    public FavoriteApisPresenter(IApiLocalRepository apiLocalRepository, FavoriteApisContract.View view) {
        this.apiLocalRepository = apiLocalRepository;
        this.view = view;
    }

    @Override
    public void loadApisList() {
        recordTime(TAG_LOCAL, "loadApisList");
        List<ApiDTO> apis = apiLocalRepository.getAllFavoriteApis();
        recordTime(TAG_LOCAL, "updateApiList");
        view.updateApiList(apis);
    }

    @Override
    public void dislikeApi(ApiDTO apiDTO) {
        apiLocalRepository.dislikeApi(apiDTO);
        view.onApiDisliked(apiDTO);
    }

    @Override
    public void deleteAll() {
        apiLocalRepository.deleteAll();
    }

    @Override
    public void start() {
        this.loadApisList();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        view.showAlertMessage(error.getMessage());
    }
}
