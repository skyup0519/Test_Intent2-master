package com.example.andy.test_intent2.Actavity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andy.test_intent2.MyAPP.MyApp;
import com.example.andy.test_intent2.R;
import com.example.andy.test_intent2.adapter.QuestionAdapter;
import com.example.andy.test_intent2.adapter.QuestionAdpaterFactory;
import com.example.andy.test_intent2.model.UserAnswer;

public  abstract class FatherAvtavity extends AppCompatActivity
        implements QuestionAdpaterFactory.Receiver{
    private TextView m_tv_merge_setcolor;
    private TextView m_tv_merge_NO ;
    private TextView  m_tv_merge_question;
    private RadioButton m_tv_merge_radio_A;
    private RadioButton  m_tv_merge_radio_B;
    private RadioButton  m_tv_merge_radio_C;
    private Button m_tv_Button_next;
    private Button m_tv_Button_back;

    protected static int Questionindext=0;
    private static  int sLasrQuestionindext;
    private static QuestionAdapter sadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_father_avtavity);
        initalQuestion();
        Log.d(this.toString(), " onCreate indext=" + Questionindext);
    }
    protected abstract Class getNextActavityClass();
    protected abstract Class getBackActavityClass();
    protected abstract int getNxetButtonVisiliby();
    protected abstract int getBackButtonVisiliby();

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.toString(),"onStart indext="+Questionindext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.toString(), "onResume indext=" + Questionindext);


        if(Questionindext<sLasrQuestionindext ){
            Toast.makeText(this,"左進右出",Toast.LENGTH_LONG).show();
            overridePendingTransition(R.anim.push_lift_in, R.anim.push_right_out);}
        else if (Questionindext>sLasrQuestionindext|| sLasrQuestionindext==Questionindext ){
            Toast.makeText(this,"右進左出",Toast.LENGTH_LONG).show();
            overridePendingTransition(R.anim.push_right_in,R.anim.push_lift_out);}

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.toString(), "onPause indext=" + Questionindext);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.toString(), "onStop indext=" + Questionindext);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.toString(), "onDestroy indext=" + Questionindext);
    }


    private void initalQuestion() {
        findID();
        setMessage();
        setNextBackButton();
    }

    public void setM_tv_Button_back(CharSequence c) {
        m_tv_Button_back.setText(c);
    }

    public void setM_tv_Button_next(CharSequence c) {
        m_tv_Button_next.setText(c);
    }

    private void findID() {
//        TextView m_tv_merge_setcolor = (TextView) findViewById(R.id.tv_merge_setcolor);

        m_tv_merge_NO = (TextView) findViewById(R.id.tv_merge_no);
        m_tv_merge_question = (TextView) findViewById(R.id.tv_merge_question);
        m_tv_merge_radio_A = (RadioButton) findViewById(R.id.tv_merge_radio_A);
        m_tv_merge_radio_B= (RadioButton) findViewById(R.id.tv_merge_radio_B);
        m_tv_merge_radio_C= (RadioButton) findViewById(R.id.tv_merge_radio_C);
        m_tv_Button_next = (Button)findViewById(R.id.tv_button_next);
        m_tv_Button_back = (Button)findViewById(R.id.tv_button_back);




    }



    private void setMessage(){

        String NO = String.valueOf(Questionindext);
        m_tv_merge_NO.setText(NO);


        if (sadapter==null) {
//            sadapter = QuestionAdpaterFactory.getAdapter();


           }
        m_tv_merge_question.setText(sadapter.getdescription(Questionindext));
        m_tv_merge_radio_A.setText(sadapter.getQuestionOptionsA(Questionindext));
        m_tv_merge_radio_B.setText(sadapter.getQuestionOptionsB(Questionindext));
        m_tv_merge_radio_C.setText(sadapter.getQuestionOptionsC(Questionindext));}

    private void setNextBackButton(){

        m_tv_Button_next.setVisibility(getNxetButtonVisiliby());
        m_tv_Button_back.setVisibility(getBackButtonVisiliby());


    }


    public void NEXT(View view) {
        sLasrQuestionindext=Questionindext;
        Questionindext++;
        Intent intent = new Intent(this,getNextActavityClass());

        intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent); }


    public void back(View view) {
        sLasrQuestionindext=Questionindext;
        Questionindext--;
        Intent intent = new Intent(this, getBackActavityClass());

        intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent); }

    UserAnswer answer = MyApp.getUserAnswer();


    public void click(View view) {

       switch (view.getId()){
           case R.id.tv_merge_radio_A:
               answer.setAnswer(Questionindext,m_tv_merge_radio_A.getText(),"題目A");
               Log.d(this.toString(),"indext 選擇了A= "+Questionindext);
               break;

           case R.id.tv_merge_radio_B:
               answer.setAnswer(Questionindext,m_tv_merge_radio_B.getText(),"題目A");
               Log.d(this.toString(), "indext 選擇了B= " + Questionindext);
               break;

           case R.id.tv_merge_radio_C:
               answer.setAnswer(Questionindext,m_tv_merge_radio_C.getText(),"題目A");
               Log.d(this.toString(), "indext 選擇了C= " + Questionindext);
               break;



       }
    }


}
