package com.barros.pugliese.discoveryapiandroid.ApiList;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.barros.pugliese.discoveryapiandroid.Data.remote.apis.IApiRemoteRepository;

public class ApiListPresenter implements ApiListContract.Presenter, Response.ErrorListener {

    private IApiRemoteRepository apiRemoteRespository;
    private ApiListContract.View view;

    public ApiListPresenter(IApiRemoteRepository apiRemoteRespository, ApiListContract.View view) {;
        this.apiRemoteRespository = apiRemoteRespository;
        this.view = view;
    }

    @Override
    public void start() {
        loadApisList();
    }

   @Override
    public void loadApisList() {
       apiRemoteRespository.getAll(view::updateApiList, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        view.showAlertMessage(error.getMessage());
    }
}
