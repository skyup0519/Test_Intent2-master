package com.example.andy.test_intent2.adapter;


import android.content.res.Resources;

import com.example.andy.test_intent2.R;
import com.example.andy.test_intent2.model.Question;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuestionFronXML implements QuestionAdapter {

    List<Question> list = new ArrayList<>();

    public QuestionFronXML(Resources res) throws IOException, XmlPullParserException {
        InputStream is = res.openRawResource(R.raw.question);
    }

    ;


    private List<Question> parse(InputStream is) throws IOException, XmlPullParserException {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();

        parser.setInput(is, "UTF-8");


        parser.require(XmlPullParser.START_TAG, null, "Exams");  //Exams樹根(頭)
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            parser.require(XmlPullParser.START_TAG, null, "Exam");
            parser.nextTag();

            parser.require(XmlPullParser.START_TAG, null, "Question");
            String question = parser.nextText();
            parser.require(XmlPullParser.END_TAG, null, "Question");


        }


        parser.require(XmlPullParser.END_TAG, null, "Exams");    //Exams樹根(尾)

return null;
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
