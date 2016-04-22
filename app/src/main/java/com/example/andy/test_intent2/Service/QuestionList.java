package com.example.andy.test_intent2.Service;

import com.example.andy.test_intent2.model.Question;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

  // 2.
  // 取得資料後 要取得這個陣列 所以先做一個  QuestionList的類別
  // 且做一個方法getList這個方法。



    @Root
    public class QuestionList {


    @ElementList
    private List<Question> list;

    public List<Question> getList(){

        return list;

    }




}
