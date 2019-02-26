package com.example.mynewsapp.service;

import com.example.mynewsapp.model.Result;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpRequestService_org {
    public static final String TAG = HttpRequestService_org.class.getSimpleName();
    // Request - String -> nach ? kommen die Parameter
    public static final String URL = "https://newsapi.org/v2/everything?q=%1$s&from=2$s&sortBy=3$s&apiKey=4$s";
    private static String topic = "bitcoin";
    private static String date = "2019-02-22";
    private static String sort = "publishedAt";
    private static final String KEY = "bdbba4e59a3b4cb59553673a8826453d";

    private static HttpURLConnection connection = null;

    public static Result getNews(String topic, String date, String sort) throws JSONException, IOException{
        HttpRequestService_org.topic = topic;
        HttpRequestService_org.date = date;
        HttpRequestService_org.sort = sort;
        return createResult();
    }

    public static Result getNews() throws JSONException, IOException {
        return createResult();
    }

    private static Result createResult() {
        return null;
    }
}
