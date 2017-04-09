package com.atongmu.snacktime.model;

import com.atongmu.snacktime.engine.NetWork;

import java.util.List;

/**
 * Created by yangzikang on 17-4-9.
 */

public class KnowModelList implements IknowModelList{
    @Override
    public List<KnowModel> getList() {
        return NetWork.getInstance().doNetWork("");
    }
}
