package com.example.andy.test_intent2.Actavity;

import android.view.View;

public class Activity1 extends FatherAvtavity {
    @Override
    protected Class getNextActavityClass() {
        return Activity2.class;
    }

    @Override
    protected Class getBackActavityClass() {
        return null;
    }

    @Override
    protected int getNxetButtonVisiliby() {
        return View.VISIBLE;
    }

    @Override
    protected int getBackButtonVisiliby() {
        return View.GONE ;
    }


//    private TextView  m_tv_merge_NO ;
//    private TextView  m_tv_merge_question;
//    private RadioButton  m_tv_merge_radio_A;
//    private RadioButton  m_tv_merge_radio_B;
//    private RadioButton  m_tv_merge_radio_C;
//    protected static CharSequence m_answers_1;
//    public static final String BUNDLE_KEY_ANSWERS_1="com.andy.Android.answer_1";
//    protected static StringBuilder ActivitySB_1= new StringBuilder("第一題 回答的是→");
//    private CharSequence answer;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_1);
//        initalSetColor();
//        initalQuestion();
//    }
//
//    private void initalSetColor() {
//        TextView view = (TextView) findViewById(R.id.tv_merge_setcolor);
//        int color = getIntent().getIntExtra(Rest_color.BUNDLE_KEY_SETCOLOR, -1);
//        if (color == -1) {
//            return;
//        }
//        view.setBackgroundColor(color);
//    }
//
//    private void initalQuestion() {
//        findID();
//        setMessage();
//    }
//
//    private void findID() {
//        m_tv_merge_NO = (TextView) findViewById(R.id.tv_merge_no);
//        m_tv_merge_question = (TextView) findViewById(R.id.tv_merge_question);
//        m_tv_merge_radio_A = (RadioButton) findViewById(R.id.tv_merge_radio_A);
//        m_tv_merge_radio_B= (RadioButton) findViewById(R.id.tv_merge_radio_B);
//        m_tv_merge_radio_C= (RadioButton) findViewById(R.id.tv_merge_radio_C);
//
//
//
//
//
//
//
//    }
//
//
//
//
//
//    private void setMessage(){
////        m_tv_merge_NO.setText("1");
////        m_tv_merge_question.setText(Html.fromHtml(getString(R.string.question_1)));
////        m_tv_merge_radio_A.setText(Html.fromHtml(getString(R.string.question_1_radio_a)));
////        m_tv_merge_radio_B.setText(Html.fromHtml(getString(R.string.question_1_radio_b)));
////        m_tv_merge_radio_C.setText(Html.fromHtml(getString(R.string.question_1_radio_c)));
//
//        int index=0;
//        String NO = String.valueOf(index);
//        m_tv_merge_NO.setText(NO);
//
//        QuestionAdapter adapter = QuestionAdapterFactor.getQuestionAdapter();
//        m_tv_merge_radio_A.setText(adapter.getQuestionOptionsA(index));
//        m_tv_merge_radio_B.setText(adapter.getQuestionOptionsB(index));
//        m_tv_merge_radio_C.setText(adapter.getQuestionOptionsC(index));}
//
//
//    public void NEXT(View view) {
//        Intent intent = new Intent(this, Activity2.class);
//        intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, MainActivity.setColor);
//        intent.putExtra(BUNDLE_KEY_ANSWERS_1, m_answers_1);
//        ActivitySB_1.append(answer + "\n");
//
//        startActivity(intent);
//    }
//
//    public void click(View view) {
//        m_answers_1=view.getTag().toString();
//        RadioButton radio = (RadioButton)view;
//        answer =radio.getText();
//
//    }
//





}

