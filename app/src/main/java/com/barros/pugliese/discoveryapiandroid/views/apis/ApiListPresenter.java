package com.barros.pugliese.discoveryapiandroid.views.apis;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.barros.pugliese.discoveryapiandroid.data.local.apis.IApiLocalRepository;
import com.barros.pugliese.discoveryapiandroid.data.remote.apis.IApiRemoteRepository;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;
import com.barros.pugliese.discoveryapiandroid.dto.DiscoveryApisDTO;

import org.json.JSONObject;

import static com.barros.pugliese.discoveryapiandroid.utils.TimeTracker.recordTime;

public class ApiListPresenter implements ApiListContract.Presenter, Response.ErrorListener {

    private static String TAG_REMOTE = ApiListPresenter.class.getSimpleName() + " REMOTE ";
    private static String TAG_LIKE_API = ApiListPresenter.class.getSimpleName() + " LIKE_API ";

    private final IApiRemoteRepository apiRemoteRespository;
    private IApiLocalRepository apiLocalRepository;
    private final ApiListContract.View view;

    public ApiListPresenter(IApiRemoteRepository apiRemoteRespository, IApiLocalRepository apiLocalRepository, ApiListContract.View view) {;
        this.apiRemoteRespository = apiRemoteRespository;
        this.apiLocalRepository = apiLocalRepository;
        this.view = view;
    }

    @Override
    public void start() {
        loadApisList();
    }

   @Override
    public void loadApisList() {
       recordTime(TAG_REMOTE, "loadApisList");

       apiRemoteRespository.getAll(this::updateApiList, this::onErrorResponse);
    }

    @Override
    public void likeApi(ApiDTO apiDTO) {
        recordTime(TAG_LIKE_API, "likeApi");
        apiLocalRepository.likeApi(apiDTO);
        recordTime(TAG_LIKE_API, "apiLiked");
    }

    @Override
    public void dislikeApi(ApiDTO apiDTO) {
        apiLocalRepository.dislikeApi(apiDTO);
    }

    @Override
    public void redirectUserToFavoriteApiScreen() {
        view.openFavoriteApisScreen();
    }

    private void updateApiList(JSONObject jsonObject) {
        DiscoveryApisDTO discoveryApisDTO = DiscoveryApisDTO.fromJson(jsonObject.toString());

        recordTime(TAG_REMOTE, "updateApiList");

        view.updateApiList(discoveryApisDTO.getApiDTOS());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        view.showAlertMessage(error.getMessage());
    }
}
