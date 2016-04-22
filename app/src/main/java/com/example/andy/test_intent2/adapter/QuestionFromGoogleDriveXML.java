package com.example.andy.test_intent2.adapter;

import com.example.andy.test_intent2.model.Question;

import java.util.List;

/**
 * Created by student on 2016/4/22.
 */
public class QuestionFromGoogleDriveXML implements QuestionAdapter {
    private List<Question> list;

    public QuestionFromGoogleDriveXML(List<Question> list) {
        this.list = list;
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getdescription(int indext) {
        return list.get(indext).getQuestion();
    }

    @Override
    public CharSequence getQuestionOptionsA(int indext) {
        return list.get(indext).getOptionA();
    }

    @Override
    public CharSequence getQuestionOptionsB(int indext) {
        return list.get(indext).getOptionB();
    }

    @Override
    public CharSequence getQuestionOptionsC(int indext) {
        return list.get(indext).getOptionC();
    }
}
