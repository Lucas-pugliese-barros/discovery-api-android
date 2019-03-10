package com.barros.pugliese.discoveryapiandroid.views.apis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.barros.pugliese.discoveryapiandroid.R;
import com.barros.pugliese.discoveryapiandroid.data.local.LocalServicesManager;
import com.barros.pugliese.discoveryapiandroid.data.remote.RemoteServicesManager;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;
import com.barros.pugliese.discoveryapiandroid.views.apis.list.ApisAdapter;
import com.barros.pugliese.discoveryapiandroid.views.favoriteApis.FavoriteApisActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ApiListActivity extends AppCompatActivity implements ApiListContract.View {

    private ApiListContract.Presenter presenter;

    private RelativeLayout rootLayout;
    private Toolbar mTopToolbar;
    private RecyclerView recyclerView;
    private ApisAdapter apisAdapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_list);

        context = this;

        presenter = new ApiListPresenter(RemoteServicesManager.getApiRemoteRepository(context),
                LocalServicesManager.getApiLocalRepository(context),
                this);

        rootLayout = findViewById(R.id.root_layout);
        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle(R.string.api_list);

        recyclerView = findViewById(R.id.list);

        setupList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    public void openFavoriteApisScreen() {
        Intent intent = new Intent(context, FavoriteApisActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            presenter.redirectUserToFavoriteApiScreen();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showAlertMessage(String message) {
        Snackbar.make(rootLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void setupList() {
        apisAdapter = new ApisAdapter();
        apisAdapter.setLikedListener(presenter::likeApi);
        apisAdapter.setDislikeListener(presenter::dislikeApi);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(apisAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }
}
