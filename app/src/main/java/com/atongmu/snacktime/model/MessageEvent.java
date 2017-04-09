package com.atongmu.snacktime.model;

import com.atongmu.snacktime.model.KnowModel;

import java.util.List;

/**
 * Created by yangzikang on 17-4-9.
 */

public class MessageEvent {
    private List<KnowModel> knowModelList;

    public List<KnowModel> getKnowModelList() {
        return knowModelList;
    }

    public void setKnowModelList(List<KnowModel> knowModelList) {
        this.knowModelList = knowModelList;
    }
}
