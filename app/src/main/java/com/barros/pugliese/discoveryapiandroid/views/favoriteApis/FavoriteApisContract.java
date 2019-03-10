package com.barros.pugliese.discoveryapiandroid.views.favoriteApis;

import com.barros.pugliese.discoveryapiandroid.IBasePresenter;
import com.barros.pugliese.discoveryapiandroid.IBaseView;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import java.util.List;

public interface FavoriteApisContract {

    interface View extends IBaseView<FavoriteApisContract.Presenter> {
        void updateApiList(List<ApiDTO> apis);
        void onApiDisliked(ApiDTO apiDTO);
    }

    interface Presenter extends IBasePresenter {
        void loadApisList();
        void dislikeApi(ApiDTO apiDTO);
    }

}
