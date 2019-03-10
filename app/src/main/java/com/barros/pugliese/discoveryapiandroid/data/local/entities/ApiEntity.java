package com.barros.pugliese.discoveryapiandroid.data.local.entities;

import android.provider.BaseColumns;

public class ApiEntity implements BaseColumns {

    public static final String TABLE_NAME = "api";
    public static final String COLUMN_NAME_SEQUENCE = "sequence";
    public static final String COLUMN_NAME_KIND = "kind";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NAME_VERSION = "version";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_DISCOVERY_RESULT_URL = "discoveryRestUrl";
    public static final String COLUMN_NAME_DOCUMENTATION_LINK = "documentationLink";
    public static final String COLUMN_NAME_PREFERRED = "preferred";
    public static final String COLUMN_NAME_IS_FAVORITED = "favorited";

    public static final String WHERE_CLAUSE = "=?";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_NAME_SEQUENCE + " TEXT, " +
            COLUMN_NAME_KIND + " TEXT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_NAME_VERSION + " TEXT, " +
            COLUMN_NAME_TITLE + " TEXT, " +
            COLUMN_NAME_DESCRIPTION + " TEXT, " +
            COLUMN_NAME_DISCOVERY_RESULT_URL + " TEXT, " +
            COLUMN_NAME_DOCUMENTATION_LINK + " TEXT, " +
            COLUMN_NAME_PREFERRED + " TEXT, " +
            COLUMN_NAME_IS_FAVORITED + " INTEGER " +
            ")";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
