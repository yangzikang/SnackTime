package com.atongmu.snacktime.presenter;

import android.util.Log;

import com.atongmu.snacktime.model.IknowModelList;
import com.atongmu.snacktime.model.KnowModel;
import com.atongmu.snacktime.model.KnowModelList;
import com.atongmu.snacktime.model.MessageEvent;
import com.atongmu.snacktime.view.ATINewsView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


/**
 * Created by yangzikang on 2017/4/1.
 */

public class ATNewsPresenter {
    private ATINewsView mNewsView;
    private IknowModelList mknowModelList;
    public ATNewsPresenter(ATINewsView view) {
        mNewsView = view;
        mknowModelList = new KnowModelList();
    }

    public void loadNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List l =mknowModelList.getList();
                MessageEvent event = new MessageEvent();
                event.setKnowModelList(l);
                EventBus.getDefault().post(event);//eventBus做事件总线
            }
        }).start();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        mNewsView.setList(event.getKnowModelList());
    };
}
