package com.barros.pugliese.discoveryapiandroid.utils;

import androidx.annotation.NonNull;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTracker {

    private static final String DATE_FORMAT = "HH:mm:ss.SSS";
    private static HashMap<String, List<Date>> timeHistory = new HashMap<>();
    private static HashMap<String, Long> processingTimes = new HashMap<>();

    public static void recordTime(@NonNull String tag, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();

        Log.i(tag + "  " + message, dateFormat.format(date));

        timeHistory = updateHistory(timeHistory, tag, date);
        calculateProcessingTime(timeHistory, tag);
    }

    public static void printResult() {
        String titlesTag = "TITLES";
        String valuesTag = "VALUES";

        StringBuilder titles = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Map.Entry<String, Long> value : processingTimes.entrySet()) {
            titles.append(value.getKey() + ",");
            values.append(value.getValue() + ",");
        }

        Log.i(titlesTag, titles.toString());
        Log.i(valuesTag, values.toString());
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

            processingTimes.put(tag, processingTime);
            Log.i(tag,"PROCESSING TIME: "  + String.valueOf(processingTime) + " milliseconds");
        }                        
    }
}
