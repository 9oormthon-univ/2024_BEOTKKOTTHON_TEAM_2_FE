package com.mukatlist.mukatlist.utils;


import android.util.Log;

import com.mukatlist.mukatlist.data.AllUniData;
import com.mukatlist.mukatlist.data.UniData;
import com.mukatlist.mukatlist.server.ApiServices;
import com.mukatlist.mukatlist.server.RetrofitManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class remoteDB {
    RetrofitManager retrofitManager = new RetrofitManager();

//    private Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.202.65.80:3000")
//            .addConverterFactory(GsonConverterFactory.create()).build();
//
//    private ApiService retrofitAPI = retrofit.create(ApiService.scr);

    public void postRegister(
            String id,
            String name,
            String university,
            String fcm_Token
    ) {
        JSONObject jobj = new JSONObject();

        Log.e("registerRequest","in");

        try {
            jobj.put("kakao_Id", id);
            jobj.put("user_Id", name);
            jobj.put("university_Name", university);
            jobj.put("fcm_Token", fcm_Token);

        } catch (JSONException e1) {
            Log.e("JSONObject","jobj: "+ e1.toString());
        }

        String jsonString = jobj.toString();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonString);
        Log.e("JSONObject","jobj: "+ jsonString);

        retrofitManager.getApiService().post_register(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("onResponse","onResponse");

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        Log.d("checkResponse","response: "+response.code());

                    } else {
                        Log.d("checkResponse","response: "+response.code());
                    }
                }
                else{
                    Log.d("checkResponse","response: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("LoginError", t.getMessage());

                Log.d("responseBody",call.request().body().toString());
            }
        });
    }

    public void postLogin(
            String id
    ) {
        JSONObject jobj = new JSONObject();

        try {
            jobj.put("kakao_Id", id);

        } catch (JSONException e1) {
            Log.e("JSONObject","jobj: "+ e1.toString());
        }

        String jsonString = jobj.toString();
        Log.e("registerRequest","in"+jsonString);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonString);
        retrofitManager.getApiService().post_login(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        Log.e("checkResponse","response: "+response.code());

                    } else{
                        Log.e("checkResponse","response: "+response.code());
                    }
                }
                else{
                    Log.e("checkResponse","response: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("LoginError", t.getMessage());

                Log.d("responseBody",call.request().body().toString());
            }
        });
    }

    public void getUniversity(){
        ArrayList<UniData> ud = new ArrayList<UniData> ();
        AllUniData a = new AllUniData();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://43.203.208.221:8079")
                .addConverterFactory(ScalarsConverterFactory.create()) // 문자열로 변환하기 위한 Converter 추가
                .build();

        ApiServices apiService = retrofit.create(ApiServices.class);

        Call<String> call = apiService.get_university();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    try {
                        JSONArray JSONArray = new JSONArray(response.body());
                        for (int i = 0; i < JSONArray.length(); i++) {
                            try {
                                JSONObject jsonObject = JSONArray.getJSONObject(i);
                                String name = jsonObject.getString("universityName");
                                UniData u = new UniData(name);
                                ud.add(u);
                                Log.e("onResponse",ud.toString());
                                if(i == JSONArray.length()-1){
                                    List<UniData> l = new ArrayList<>(ud);
                                    a.create(l);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    // 응답 실패 처리
                    Log.e("error","Response failed with code: "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("error","onFailure: "+ t.toString());
            }
        });
        Log.e("onResponse",ud.toString());
    }

}