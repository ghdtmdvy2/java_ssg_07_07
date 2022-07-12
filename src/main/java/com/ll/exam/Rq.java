package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    String path;
    Map<String, String> queryParams;

    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        queryParams = new HashMap<>();

        if (urlBits.length == 2){
            String []paramBits = urlBits[1].split("&");
            for (String paramBit : paramBits){
                String param[] = paramBit.split("=");
                if(param.length == 1){
                    continue;
                }
            }
        }
    }

    public int getIntParam(String paramName, int defaultValue) {
       if(queryParams.containsKey(paramName) == false){
           return defaultValue;
       }
       String paramValue = queryParams.get(paramName);
       if(paramValue.length() == 0){
           return defaultValue;
       }
       return Integer.parseInt(paramValue);
    }

    public String getPath() {
        return path;
    }
}