package com.barros.pugliese.discoveryapiandroid.views.favoriteApis;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.barros.pugliese.discoveryapiandroid.R;
import com.barros.pugliese.discoveryapiandroid.data.local.LocalServicesManager;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;
import com.barros.pugliese.discoveryapiandroid.views.apis.list.ApisAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteApisActivity extends AppCompatActivity implements FavoriteApisContract.View {

    private FavoriteApisContract.Presenter presenter;

    private RelativeLayout rootLayout;
    private Toolbar mTopToolbar;
    private RecyclerView recyclerView;
    private ApisAdapter apisAdapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_apis);

        context = this;

        presenter = new FavoriteApisPresenter(LocalServicesManager.getApiLocalRepository(context), this);

        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle(R.string.title_activity_favorite_apis_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.favorite_apis_list);

        setupList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void updateApiList(List<ApiDTO> apis) {
        apisAdapter.addItems(apis);
    }

    @Override
    public void onApiDisliked(ApiDTO apiDTO) {
        apisAdapter.removeItem(apiDTO);
    }

    @Override
    public void showAlertMessage(String message) {
        Snackbar.make(rootLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void setupList() {
        apisAdapter = new ApisAdapter();
        apisAdapter.setDislikeListener(presenter::dislikeApi);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(apisAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

}
