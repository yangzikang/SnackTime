package com.atongmu.snacktime;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.atongmu.snacktime.adapter.ATNewsAdapter;
import com.atongmu.snacktime.model.KnowModel;
import com.atongmu.snacktime.presenter.ATNewsPresenter;
import com.atongmu.snacktime.view.ATINewsView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ATMainActivity extends AppCompatActivity implements ATINewsView {
    @BindView(R.id.news_list)
    RecyclerView mRecyclerView;
    ATNewsPresenter presenter = new ATNewsPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Snackbar.make(mRecyclerView,"右上角可以看以前的", Snackbar.LENGTH_INDEFINITE).setAction("我知道了", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ATMainActivity.this,"知道了",Toast.LENGTH_SHORT).show();
            }
        }).show();
        EventBus.getDefault().register(presenter);
        presenter.loadNews();


    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(presenter);
    }
    @Override
    public void setList(List l) {
        Log.d("sss","www.baidu.com");
        Log.d("lllh",String.valueOf(l.size()));
        for(int i =0;i<l.size();i++){
            Log.d("lllh",((KnowModel)l.get(i)).getTitle());
        }
        LinearLayoutManager a = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(a);
        mRecyclerView.setAdapter(new ATNewsAdapter(l, this));
    }
}
