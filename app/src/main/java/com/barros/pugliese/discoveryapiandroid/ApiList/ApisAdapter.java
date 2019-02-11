package com.barros.pugliese.discoveryapiandroid.ApiList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.barros.pugliese.discoveryapiandroid.Model.Api;
import com.barros.pugliese.discoveryapiandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ApisAdapter extends RecyclerView.Adapter<ApisAdapter.ViewHolder> {

    private List<Api> apis;
    private OnApiFavoritedListener favoritedListener;

    public ApisAdapter(List<Api> apis) {
        this.apis = apis != null ? apis : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.api_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Api api = apis.get(position);

        viewHolder.title.setText(api.getTitle());
        viewHolder.description.setText(api.getDescription());
        viewHolder.version.setText(api.getVersion());

        viewHolder.favorite.setOnCheckedChangeListener(null);
        viewHolder.favorite.setChecked(api.isFavorited());
        viewHolder.favorite.setOnCheckedChangeListener((buttonView, isFavorited) ->
                {
                    if(favoritedListener != null)
                        favoritedListener.OnApiFavorited(api);
                    api.setFavorited(isFavorited);
                }

        );
    }

    @Override
    public int getItemCount() {
        return apis.size();
    }

    public void addItems(List<Api> newApis) {
        int positionStart = apis.isEmpty() ? apis.size() : apis.size() - 1 ;
        apis.addAll(newApis);
        notifyItemRangeInserted(positionStart, newApis.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView description;
        private TextView version;
        private CheckBox favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            version = itemView.findViewById(R.id.version);
            favorite = itemView.findViewById(R.id.is_favorite);
        }
    }

    public OnApiFavoritedListener getFavoritedListener() {
        return favoritedListener;
    }

    public void setFavoritedListener(OnApiFavoritedListener favoritedListener) {
        this.favoritedListener = favoritedListener;
    }
}
