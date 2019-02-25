package com.example.mynewsapp;

public class LogMeToo {
    public static void debug(String msg, Object value){
        System.out.println(String.format(msg, value));
    }
    public static void debug(String msg){
        System.out.println(msg);
    }
}
