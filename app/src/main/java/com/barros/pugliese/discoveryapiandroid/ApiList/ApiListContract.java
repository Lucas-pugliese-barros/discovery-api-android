package com.barros.pugliese.discoveryapiandroid.ApiList;

import com.barros.pugliese.discoveryapiandroid.IBasePresenter;
import com.barros.pugliese.discoveryapiandroid.IBaseView;

import org.json.JSONObject;

public interface ApiListContract {

    interface View extends IBaseView<Presenter> {
        void updateApiList(JSONObject jsonObject);
    }

    interface Presenter extends IBasePresenter {
        void loadApisList();
    }
}
