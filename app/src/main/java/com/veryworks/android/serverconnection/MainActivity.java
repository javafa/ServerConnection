package com.veryworks.android.serverconnection;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    RecyclerView recycler;
    CustomAdapter adapter;

    // 리모트 관련 설정
    final String DOMAIN = "http://192.168.10.240:8080";
    final String SERVER_PATH = "/bbs/json/list";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        adapter = new CustomAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        load();
    }

    private void load(){
        run(DOMAIN + SERVER_PATH);
    }

    private void run(String url){
        // 서브 thread 에서 실행    // onDoingBa..리턴, onPostEx...파라미터
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String result = null;
                try{
                    result = getData(params[0]);
                }catch(Exception e){
                    Log.e("MainActivity", e.getMessage());
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                // 결과값인 json 스트링을 객체로 변환
                Log.e("Result",result);
                // listView 의 Adapter 에 세팅

                // listView notify
            }

        }.execute(url);
    }

    private String getData(String url) throws IOException {
        // 요청 정보를 담고 있는 객체
        Request request = new Request.Builder()
                .url(url)
                .build();
        // 응답 정보를 받을 객체
        Response response = null;
        // 서버로 요청해서 데이터 받음
        response = client.newCall(request).execute();
        // 응답객체에서 실제 데이터만 추출
        ResponseBody resBody = response.body();
        // 데이터를 스트링으로 변환해서 리턴
        return resBody.string();
    }


    // 화면 xml 위젯에 속성추가 -> android:onClick="btnPost"
    public void btnPost(View view){
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }
}
