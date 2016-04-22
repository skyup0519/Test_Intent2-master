package com.example.andy.test_intent2.Actavity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.andy.test_intent2.MyAPP.MyApp;
import com.example.andy.test_intent2.R;
import com.example.andy.test_intent2.model.UserAnswer;

public class Activity4 extends AppCompatActivity {

//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        setM_tv_Button_back("FINAL");
//
//    }
//
//
//
//
//    @Override
//    protected Class getNextActavityClass() {
//        return null;
//    }
//
//    @Override
//    protected Class getBackActavityClass() {
//        return Activity3.class;
//    }
//
//    @Override
//    protected int getNxetButtonVisiliby() {
//        return View.VISIBLE;
//    }
//
//    @Override
//    protected int getBackButtonVisiliby() {
//        return 0;
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
//        initalColor();
    }

    private void initalColor(){
        Bundle bundle = getIntent().getExtras();
        int color = bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR,-1);
        if (color==-1){return;}

        TextView view =(TextView)findViewById(R.id.tv_merge_setcolor);
        view.setBackgroundColor(color);



    }


    public void MAIN(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        FatherAvtavity.Questionindext=0;

        intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
//        Activity1.ActivitySB_1.delete(10, Activity1.ActivitySB_1.length());

    }
private  StringBuilder message = new StringBuilder();
private  UserAnswer answer = MyApp.getUserAnswer();



    public void AnswerTotal(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("答案總攬")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      message.append(answer.getAnswer(1)).append(answer.getDescription(1));







                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();






   }
}
