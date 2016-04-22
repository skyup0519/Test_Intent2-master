package com.example.andy.test_intent2.MyAPP;

import android.app.Application;
import android.content.Context;

import com.example.andy.test_intent2.model.UserAnswer;

public class MyApp extends Application { //Application 就是actavity的群組


    private static Context context;      // context 參考到 類別：Context'
    private  static UserAnswer userAnswer;


    public static Context getContext() { //方法 getContext 回傳一個 context

        return context;
    }


    public  static  UserAnswer getUserAnswer(){

        if (userAnswer==null){
            userAnswer = new UserAnswer(3);

        }


        return userAnswer;

    }
    public MyApp() {                     //context(有資源的)  =  MyApp這個類別
        context = this;                   //所以MyApp = 類別：Context 這樣就可以使用getResour這個方法

    }


}
