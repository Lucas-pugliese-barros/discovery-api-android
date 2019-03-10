package com.barros.pugliese.discoveryapiandroid.utils;

import androidx.annotation.NonNull;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TimeTracker {

    private static final String DATE_FORMAT = "HH:mm:ss.SSS";
    private static HashMap<String, List<Date>> timeHistory = new HashMap<>();

    public static void recordTime(@NonNull String tag, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();

        Log.i(tag + "  " + message, dateFormat.format(date));

        timeHistory = updateHistory(timeHistory, tag, date);
        calculateProcessingTime(timeHistory, tag);
    }

    private static HashMap<String, List<Date>> updateHistory(HashMap<String, List<Date>> hashMap,
                                                             String tag,
                                                             Date date) {

        return (hashMap.containsKey(tag)) ?
                addTimeForTag(hashMap, tag, date) : newTagWithTime(hashMap, tag, date);
    }

    private static HashMap<String, List<Date>> addTimeForTag(HashMap<String, List<Date>> hashMap,
                                                             String tag,
                                                             Date date) {
        List<Date> dates = hashMap.get(tag);
        dates.add(date);
        hashMap.put(tag, dates);

        return hashMap;
    }

    private static HashMap<String, List<Date>> newTagWithTime(HashMap<String, List<Date>> hashMap,
                                                              String tag,
                                                              Date date) {
        List<Date> dates = new ArrayList<>();
        dates.add(date);
        hashMap.put(tag, dates);

        return hashMap;
    }

    private static void calculateProcessingTime(HashMap<String, List<Date>> hashMap, String tag) {
        if (hashMap.containsKey(tag) && hashMap.get(tag).size() % 2 == 0) {
            List<Date> dates = hashMap.get(tag);

            Date penultimateDate = dates.get(dates.size() - 2);
            Date lastDate =  dates.get(dates.size() - 1);
            Long processingTime = lastDate.getTime() - penultimateDate.getTime();

            Log.i(tag,"PROCESSING TIME: "  + String.valueOf(processingTime) + " milliseconds");
        }                        
    }
}
