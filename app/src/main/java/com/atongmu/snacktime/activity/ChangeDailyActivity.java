package com.atongmu.snacktime.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.atongmu.snacktime.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeDailyActivity extends Activity {

    @BindView(R.id.number)
    EditText editText;
    @OnClick(R.id.button)void submit() {
        String s =editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("daily",s);
        setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
        finish();//此处一定要调用finish()方法
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_daily);
        ButterKnife.bind(this);
    }
}
