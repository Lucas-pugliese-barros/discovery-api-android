package com.barros.pugliese.discoveryapiandroid.views.apis;

import com.barros.pugliese.discoveryapiandroid.IBasePresenter;
import com.barros.pugliese.discoveryapiandroid.IBaseView;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import org.json.JSONObject;

import java.util.List;

public interface ApiListContract {

    interface View extends IBaseView<Presenter> {
        void updateApiList(List<ApiDTO> apis);
        void openFavoriteApisScreen();
    }

    interface Presenter extends IBasePresenter {
        void loadApisList();
        void likeApi(ApiDTO apiDTO, int position);
        void dislikeApi(ApiDTO apiDTO);
        void redirectUserToFavoriteApiScreen();
    }
}
