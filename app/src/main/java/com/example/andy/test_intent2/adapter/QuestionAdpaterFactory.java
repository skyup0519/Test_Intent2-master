package com.example.andy.test_intent2.adapter;

import android.content.res.Resources;
import android.util.Log;

import com.example.andy.test_intent2.MyAPP.MyApp;
import com.example.andy.test_intent2.Service.QuestionList;
import com.example.andy.test_intent2.Service.QuestionListService;
import com.example.andy.test_intent2.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by student on 2016/4/22.
 */
public class QuestionAdpaterFactory {
    private static Resources res = MyApp.getContext().getResources();
    private static QuestionAdapter adapter;

    private QuestionAdpaterFactory() {
    } //私有的建構子　防止別人　NEW一個新的物件出來

    //當資源在"本機端"的時候所用的方法 (直接做一個Adapter的物件)
    public static QuestionAdapter getAdapter() {
        if (adapter == null) {
            adapter = new QuestionFromstringResource(res);
        }
        return adapter;
    }
    // 當資源在"雲端"的時候所用的方法
    // 封裝的概念=給人使用這個公開的方法 內部的方法是方公開的
    public static void getQuestionAdapter(Receiver receiver) {
        loadFromGoogleDrive(receiver);
    }

    private static void loadFromGoogleDrive(final Receiver receiver) { //<可放入 Receiver 的>

        // 步驟1：打造出一個Service
        //  內容：先從 QuestionListService類別 拿到打造一半的 retrofit 然後繼續加工
        QuestionListService service = QuestionListService.retrofit.create(QuestionListService.class);

        // 步驟2：取得資料
        //  內容：有了service後 就可以使用 QuestionListService類別 內的getQuestionList()這個方法
        Call<QuestionList> call =service.getQuestionList(); //類別Call要注意 有java的 有Android的 有Retrofit的

        // 步驟3：建立一個執行緒
        //  內容：call 透過service取得資料後，可以使用類別Call中 enqueue()方法
        call.enqueue(new Callback<QuestionList>() {
            @Override //取得資料後
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {

                if (response.isSuccessful()) {
                    Log.d("Retrofit"," onResponse 成功");

                    QuestionList Q1 = response.body();
                    List<Question> list = Q1.getList();
                    adapter = new QuestionFromGoogleDriveXML(list);
                    receiver.reciveQuestionAdapter(adapter);

                } else {
                    Log.d("Retrofit"," onResponse 失敗");

                }
            }

            @Override //未取得資料
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Log.d("Retrofit"," onFailure 尚未連線");
            }
        });
    }



    ;

    // public static void getQuestionAdapter(Receiver receiver)
    // 為了要放入一個 可 Receiver 的東西
    // 所以 我們要打造一個 Receiver介面 來溝通 不認識的類別
    //而裡面的方法可以放入一個 adapter 至於做什麼還不知道
    public interface Receiver {
        void reciveQuestionAdapter(QuestionAdapter adapter);
    }


}