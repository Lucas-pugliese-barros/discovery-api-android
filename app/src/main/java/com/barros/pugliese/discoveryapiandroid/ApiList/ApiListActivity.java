package com.barros.pugliese.discoveryapiandroid.ApiList;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.barros.pugliese.discoveryapiandroid.Data.remote.RemoteServicesManager;
import com.barros.pugliese.discoveryapiandroid.Model.DiscoveryApis;
import com.barros.pugliese.discoveryapiandroid.R;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class ApiListActivity extends AppCompatActivity implements ApiListContract.View {

    private static final String TAG = "MainActivity";

    private Context context;

    private DiscoveryApis discoveryApis;

    private RelativeLayout rootLayout;
    private Toolbar mTopToolbar;
    private RecyclerView recyclerView;
    private ApisAdapter apisAdapter;

    private ApiListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_list);

        context = this;

        presenter = new ApiListPresenter(RemoteServicesManager.getApiRemoteRepository(context), this);

        rootLayout = findViewById(R.id.root_layout);
        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle(R.string.api_list);

        recyclerView = findViewById(R.id.list);

        setupList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void updateApiList(JSONObject jsonObject) {
        discoveryApis = DiscoveryApis.fromJson(jsonObject.toString());
        apisAdapter.addItems(discoveryApis.getApis());
    }

    @Override
    public void showAlertMessage(String message) {
        Snackbar.make(rootLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void setupList() {
        discoveryApis = new DiscoveryApis();
        apisAdapter = new ApisAdapter(discoveryApis.getApis());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(apisAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }
}
