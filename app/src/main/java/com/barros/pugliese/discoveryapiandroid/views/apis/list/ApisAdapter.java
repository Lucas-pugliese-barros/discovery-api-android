package com.barros.pugliese.discoveryapiandroid.views.apis.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.barros.pugliese.discoveryapiandroid.R;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ApisAdapter extends RecyclerView.Adapter<ApisAdapter.ViewHolder> {

    private List<ApiDTO> apiDTOS;

    private OnApiLikeListener likedListener;
    private OnApiDislikeListener dislikeListener;

    public ApisAdapter() {
        this.apiDTOS = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.api_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ApiDTO apiDTO = apiDTOS.get(position);

        viewHolder.position.setText(String.valueOf(position));
        viewHolder.title.setText(apiDTO.getTitle());
        viewHolder.description.setText(apiDTO.getDescription());
        viewHolder.version.setText(apiDTO.getVersion());

        viewHolder.favorite.setOnCheckedChangeListener(null);
        viewHolder.favorite.setChecked(apiDTO.isFavorited());
        viewHolder.favorite.setOnCheckedChangeListener((buttonView, isFavorited) ->
                {
                    if(likedListener != null && isFavorited)
                        likedListener.OnApiLike(apiDTO);
                    else if(dislikeListener != null && !isFavorited)
                        dislikeListener.OnApiDislike(apiDTO);

                    apiDTO.setFavorited(isFavorited);
                }
        );
    }

    @Override
    public int getItemCount() {
        return apiDTOS.size();
    }

    public void addItems(List<ApiDTO> newApiDTOS) {
        int positionStart = apiDTOS.isEmpty() ? apiDTOS.size() : apiDTOS.size() - 1 ;
        apiDTOS.addAll(newApiDTOS);
        notifyItemRangeInserted(positionStart, newApiDTOS.size());
    }

    public void removeItem(ApiDTO apiDTO) {
        for (int i = 0; i < apiDTOS.size(); i++) {

            if(apiDTOS.get(i).equals(apiDTO)) {
                apiDTOS.remove(apiDTO);
                notifyItemRemoved(i);
                return;
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView position;
        private TextView title;
        private TextView description;
        private TextView version;
        private CheckBox favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.position);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            version = itemView.findViewById(R.id.version);
            favorite = itemView.findViewById(R.id.is_favorite);
        }
    }

    public void setLikedListener(OnApiLikeListener likedListener) {
        this.likedListener = likedListener;
    }

    public void setDislikeListener(OnApiDislikeListener dislikeListener) {
        this.dislikeListener = dislikeListener;
    }
}
