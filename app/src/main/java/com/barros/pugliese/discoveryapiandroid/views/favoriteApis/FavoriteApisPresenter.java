package com.barros.pugliese.discoveryapiandroid.views.favoriteApis;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.barros.pugliese.discoveryapiandroid.data.local.apis.IApiLocalRepository;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import static com.barros.pugliese.discoveryapiandroid.utils.TimeTracker.recordTime;

public class FavoriteApisPresenter implements FavoriteApisContract.Presenter, Response.ErrorListener {

    private static String TAG = FavoriteApisPresenter.class.getSimpleName();

    private final IApiLocalRepository apiLocalRepository;
    private final FavoriteApisContract.View view;

    public FavoriteApisPresenter(IApiLocalRepository apiLocalRepository, FavoriteApisContract.View view) {
        this.apiLocalRepository = apiLocalRepository;
        this.view = view;
    }

    @Override
    public void loadApisList() {
        recordTime(TAG, "loadApisList");
        view.updateApiList(apiLocalRepository.getAllFavoriteApis());
        recordTime(TAG, "updateApiList");
    }

    @Override
    public void dislikeApi(ApiDTO apiDTO) {
        apiLocalRepository.dislikeApi(apiDTO);
        view.onApiDisliked(apiDTO);
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
