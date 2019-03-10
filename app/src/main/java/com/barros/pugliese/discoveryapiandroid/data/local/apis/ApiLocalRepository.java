package com.barros.pugliese.discoveryapiandroid.data.local.apis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.barros.pugliese.discoveryapiandroid.data.local.DatabaseManager;
import com.barros.pugliese.discoveryapiandroid.dto.ApiDTO;

import java.util.ArrayList;
import java.util.List;

import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_DESCRIPTION;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_DISCOVERY_RESULT_URL;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_DOCUMENTATION_LINK;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_IS_FAVORITED;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_KIND;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_PREFERRED;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_SEQUENCE;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_TITLE;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.COLUMN_NAME_VERSION;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.TABLE_NAME;
import static com.barros.pugliese.discoveryapiandroid.data.local.entities.ApiEntity.WHERE_CLAUSE;

public class ApiLocalRepository implements IApiLocalRepository {

    private DatabaseManager databaseManager;

    public ApiLocalRepository(Context context) {
        this.databaseManager = new DatabaseManager(context);
    }

    @Override
    public void likeApi(ApiDTO apiDTO) {
        SQLiteDatabase db = databaseManager.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME_SEQUENCE, apiDTO.getId());
        values.put(COLUMN_NAME_KIND, apiDTO.getKind());
        values.put(COLUMN_NAME, apiDTO.getName());
        values.put(COLUMN_NAME_VERSION, apiDTO.getVersion());
        values.put(COLUMN_NAME_TITLE, apiDTO.getTitle());
        values.put(COLUMN_NAME_DESCRIPTION, apiDTO.getDescription());
        values.put(COLUMN_NAME_DISCOVERY_RESULT_URL, apiDTO.getDiscoveryRestUrl());
        values.put(COLUMN_NAME_DOCUMENTATION_LINK, apiDTO.getDocumentationLink());
        values.put(COLUMN_NAME_PREFERRED, apiDTO.getPreferred());
        values.put(COLUMN_NAME_IS_FAVORITED, apiDTO.isFavorited());

        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void dislikeApi(ApiDTO apiDTO) {
        SQLiteDatabase db = databaseManager.getWritableDatabase();

        String[] args = {apiDTO.getId()};

        db.delete(TABLE_NAME, COLUMN_NAME_SEQUENCE + WHERE_CLAUSE, args);
    }

    @Override
    public List<ApiDTO> getAllFavoriteApis() {
        List<ApiDTO> apis = new ArrayList<>();

        SQLiteDatabase db = databaseManager.getReadableDatabase();

        String[] projection = {
                COLUMN_NAME_SEQUENCE,
                COLUMN_NAME_KIND,
                COLUMN_NAME,
                COLUMN_NAME_VERSION,
                COLUMN_NAME_TITLE,
                COLUMN_NAME_DESCRIPTION,
                COLUMN_NAME_DISCOVERY_RESULT_URL,
                COLUMN_NAME_DOCUMENTATION_LINK,
                COLUMN_NAME_IS_FAVORITED
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_SEQUENCE));
            String kind = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_KIND));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String version = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_VERSION));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_DESCRIPTION));
            String discoveryResultUrl = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_DISCOVERY_RESULT_URL));
            String documentationLink = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_DOCUMENTATION_LINK));

            ApiDTO api = new ApiDTO(id, kind, name, version, title, description,
                    discoveryResultUrl, documentationLink, Boolean.TRUE);

            apis.add(api);
        }

        cursor.close();

        return apis;
    }
}
