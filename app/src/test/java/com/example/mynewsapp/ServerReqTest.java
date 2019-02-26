package com.example.mynewsapp;


import com.example.mynewsapp.model.Result;
import com.example.mynewsapp.service.HttpRequestService;

import org.junit.Test;


public class ServerReqTest {
    private static final String TAG = ServerReqTest.class.getSimpleName();
    @Test
    /**
     * Den Server nach Daten abfragen ...
     */
    public void test() throws Exception {
        HttpRequestService service = new HttpRequestService();
        final Result newsResult = service.getNews();
        System.out.println(newsResult.toString());
    }
}
