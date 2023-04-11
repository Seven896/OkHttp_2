package com.zyy.okhttp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.zyy.okhttp_2.utils.OkHttpHelper;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    public String url = "https://www.baidu.com/home";
    private TextView tv_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_textview = (TextView) findViewById(R.id.tv_textview);

    }
    public void click(View view){
        sendResquestWithOkHttp(url);
    }

    private void sendResquestWithOkHttp(String url){
        new Thread(){
            @Override
            public void run() {
                OkHttpHelper helper = new OkHttpHelper();
                try {
                    String response = helper.getInputStream(url);
                    showResponse(response);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }

    private void showResponse(String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_textview.setText(response);
            }
        });
    }
}