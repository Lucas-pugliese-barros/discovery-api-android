package com.barros.pugliese.discoveryapiandroid.views.apis.list;

import android.util.Log;
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

import static com.barros.pugliese.discoveryapiandroid.utils.TimeTracker.printResult;
import static com.barros.pugliese.discoveryapiandroid.utils.TimeTracker.recordTime;

public class ApisAdapter extends RecyclerView.Adapter<ApisAdapter.ViewHolder> {

    static String TAG = "";

    private List<ApiDTO> apiDTOS;

    private OnApiLikeListener likedListener;
    private OnApiDislikeListener dislikeListener;
    private OnItemLoadedListener itemLoadedListener;

    public ApisAdapter(String TAG) {
        this.apiDTOS = new ArrayList<>();
        this.TAG = TAG;
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
        viewHolder.name.setText(apiDTO.getName());
        viewHolder.description.setText(apiDTO.getDescription());

        viewHolder.favorite.setOnCheckedChangeListener(null);
        viewHolder.favorite.setChecked(apiDTO.isFavorited());
        viewHolder.favorite.setOnCheckedChangeListener((buttonView, isFavorited) ->
                {
                    if(likedListener != null && isFavorited)
                        likedListener.OnApiLike(apiDTO, position);
                    else if(dislikeListener != null && !isFavorited)
                        dislikeListener.OnApiDislike(apiDTO);

                    apiDTO.setFavorited(isFavorited);
                }
        );

        if (position == 3)
            recordTime(TAG, "apisListLoaded");

        if (itemLoadedListener != null)
            itemLoadedListener.OnItemLoaded(position);
    }

    @Override
    public int getItemCount() {
        return apiDTOS.size();
    }

    public void addItems(List<ApiDTO> newApiDTOS) {
        recordTime(TAG, "addingApisToList");

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
        private TextView name;
        private TextView description;
        private CheckBox favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.position);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            favorite = itemView.findViewById(R.id.is_favorite);
        }
    }

    public void setLikedListener(OnApiLikeListener likedListener) {
        this.likedListener = likedListener;
    }

    public void setDislikeListener(OnApiDislikeListener dislikeListener) {
        this.dislikeListener = dislikeListener;
    }

    public void setItemLoadedListener(OnItemLoadedListener itemLoadedListener) {
        this.itemLoadedListener = itemLoadedListener;
    }
}
