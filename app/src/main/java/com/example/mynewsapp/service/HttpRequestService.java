package com.example.mynewsapp.service;

import android.util.Log;

import com.example.mynewsapp.model.Result;
import com.example.mynewsapp.service.MapperService;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class HttpRequestService{
    private static final String TAG = HttpRequestService.class.getSimpleName();
    private static final String URL = "https://newsapi.org/v2/everything?q=%1$s&from=%2$s&sortBy=%3$s&apiKey=%4$s";
    private static String topic = "bitcoin";
    private static String date = "2019-02-22";
    private static String sort = "publishedAt";
    private static final String KEY = "bdbba4e59a3b4cb59553673a8826453d";
    //private static final String KEY = String.format("%s", R.string.weather_key); --> Results in different Number!!!
    private static HttpURLConnection connection = null;

    public static Result getNews(String topic, String date, String sort) throws JSONException, IOException {
        HttpRequestService.topic = topic;
        HttpRequestService.date = date;
        HttpRequestService.sort = sort;
        return createResult();
    }

    public static Result getNews() throws JSONException, IOException {
        return createResult();
    }

    private static Result createResult() throws JSONException, IOException {
        String reqUrl = String.format(URL, topic, date, sort, KEY);
        System.out.println(reqUrl);

        final String jsonData = executeServerRequest(reqUrl);
        MapperService us = new MapperService();
        Result result = null;
        try {
            result = us.unmarshall(jsonData);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }
        return result;
    }

    private static String executeServerRequest(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpRequestService.connection = (HttpURLConnection) new URL(url).openConnection();
        HttpRequestService.connection.setRequestProperty("Content-Type", "application/json");

        if (HttpRequestService.connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStreamReader inputStreamReader = new InputStreamReader(HttpRequestService.connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();
        }

        HttpRequestService.connection.disconnect();
        String jsonResult = sb.toString();
        return jsonResult;
    }


    public static String addImage(Result result) throws IOException {
        /*
        boolean success = false;
        String icon = result.getWeather().get(0).getIcon();
        String url$ = String.format("http://openweathermap.org/img/w/%s.png", icon);
        Log.d(TAG, String.format("Request goes to: %s", url$));
        URL reqUrl = new URL(url$);
        WeatherServerReq.connection = (HttpURLConnection) reqUrl.openConnection();
        if (WeatherServerReq.connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            Bitmap bmp = BitmapFactory.decodeStream(WeatherServerReq.connection.getInputStream());
            if (bmp != null) {
                result.setBmp(bmp);
            }
            success = true;
        } else {
            Log.e(TAG, String.format("Fehler: ", WeatherServerReq.connection.getResponseCode()));
            throw new IOException(String.format("Beim Laden der Bilddatei: %s ist gewaltig was schief gelaufen!", url$));
        }
        WeatherServerReq.connection.disconnect();
         */
        return "Not yet implemented";
    }

}


