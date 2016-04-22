package com.example.andy.test_intent2.Service;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

//先創作一個service



public interface QuestionListService {


    @GET("/uc?export=dowload&id=0BwIdzAjvQ8FwWG5HZUxIZHJOd0k")
    public abstract Call<QuestionList> getQuestionList();


    public static final Retrofit retrofit = new Retrofit.Builder()   //打造一個 retrofit(改造) 物件
            .baseUrl("https://drive.google.com/")                    //網址
            .addConverterFactory(SimpleXmlConverterFactory.create()) //將讀取到的資料給Simple解析
            .build();


}
