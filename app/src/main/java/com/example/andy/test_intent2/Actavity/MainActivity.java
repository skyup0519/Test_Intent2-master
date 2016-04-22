package com.example.andy.test_intent2.Actavity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andy.test_intent2.R;

public class MainActivity extends AppCompatActivity {
    private int INTENT_KEY_SETCOLOR=0;//傳令兵名子
    private int INTENT_KEY_SETMESSAGE=1;//傳令兵名子
    protected static int setColor; //從bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR);

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

    }

    @Override
    protected void onStart() {

        super.onStart();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_lift_out);
        Toast.makeText(this,"onstart",Toast.LENGTH_LONG).show();
    }

    public void NEXT(View view) {
    Intent intent = new Intent(this,Activity1.class);
    intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, setColor);


        intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    public void SetColor(View view) {
       Intent intent = new Intent(this,Rest_color.class);

       intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
       startActivityForResult(intent, INTENT_KEY_SETCOLOR);
//      overridePendingTransition(R.anim.push_right_in,R.anim.push_lift_out);

    }

    public void SetMessage(View view) {
        Intent intent = new Intent(this , Rest_Message.class);
        startActivityForResult(intent, INTENT_KEY_SETMESSAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if (requestCode==INTENT_KEY_SETCOLOR){
        if(resultCode==RESULT_OK){

            Bundle bundle =data.getExtras();
            setColor =bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR);
            TextView textView =(TextView)findViewById(R.id.tv_所要更改的項目);
            textView.setBackgroundColor(setColor);
            Toast.makeText(this, "恭喜您 顏色成功值入 MainActivity ", Toast.LENGTH_LONG).show();

        }}
        if (requestCode==INTENT_KEY_SETMESSAGE){
            if(resultCode==RESULT_OK){

                Bundle bundle =data.getExtras();
                CharSequence setMessage =bundle.getCharSequence(Rest_Message.BUNDLE_KEY_SETMESSAGE);
                TextView textView =(TextView)findViewById(R.id.tv_所要更改的項目);
                textView.setText(setMessage);

    }}}

}





