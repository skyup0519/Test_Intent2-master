package com.example.andy.test_intent2.adapter;

import android.content.res.Resources;
import android.text.Html;

import com.example.andy.test_intent2.R;
import com.example.andy.test_intent2.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionFromstringResource implements QuestionAdapter {

    private List <Question> list = new ArrayList();


public QuestionFromstringResource(Resources res)
{
    list.add(new Question(res.getString(R.string.question_1),
            res.getString(R.string.question_1_radio_a),
            res.getString(R.string.question_1_radio_b),
            res.getString(R.string.question_1_radio_c)
            ));


    list.add(new Question(res.getString(R.string.question_2),
            res.getString(R.string.question_2_radio_a),
            res.getString(R.string.question_2_radio_b),
            res.getString(R.string.question_2_radio_c)
    ));

    list.add(new Question(res.getString(R.string.question_3),
            res.getString(R.string.question_3_radio_a),
            res.getString(R.string.question_3_radio_b),
            res.getString(R.string.question_3_radio_c)
    ));


}


    @Override
    public int getQuestionCount() {
        return list.size(); //一共有幾題?
    }

    @Override
    public CharSequence getdescription(int indext) {
        return Html.fromHtml(list.get(indext).getQuestion());
    }

    @Override
    public CharSequence getQuestionOptionsA(int indext) {
        return Html.fromHtml(list.get(indext).getOptionA());
    }

    @Override
    public CharSequence getQuestionOptionsB(int indext) {
        return Html.fromHtml(list.get(indext).getOptionB());
    }

    @Override
    public CharSequence getQuestionOptionsC(int indext) {
        return Html.fromHtml(list.get(indext).getOptionC());
    }
}
