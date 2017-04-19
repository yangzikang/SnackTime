package com.atongmu.snacktime.model;

import com.atongmu.snacktime.engine.NetWork;

import java.util.List;

/**
 * Created by yangzikang on 17-4-9.
 */

public class KnowModelList implements IknowModelList{

    public static String daliy=""; //外部做更新，更新的类为ChangeDailyActivity

    @Override
    public List<KnowModel> getList() {
        return NetWork.getInstance().doNetWork(daliy);
    }
}
