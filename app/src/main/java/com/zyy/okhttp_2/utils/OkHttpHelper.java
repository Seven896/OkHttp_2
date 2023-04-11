package com.zyy.okhttp_2.utils;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    public static String getInputStream(String url) throws IOException {
//       OkHttpClient client = null;    出现连接超时错误
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseData = response.body().string();

        return responseData;
    }
}
