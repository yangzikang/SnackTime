package com.atongmu.snacktime.engine;

import android.util.Log;

import com.atongmu.snacktime.model.KnowModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yangzikang on 17-4-9.
 */

public class NetWork {
    private static NetWork netWork = new NetWork();

    private NetWork(){}

    public static NetWork getInstance(){
        return netWork;
    }

    public List<KnowModel>  doNetWork(String daily){
        List<KnowModel> l=null;
                String url = "https://zhidao.baidu.com/daily/"+daily;
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    Response response = mOkHttpClient.newCall(request).execute();
                    byte[] originResponseData = response.body().bytes();
                    String responseData = new String(originResponseData, "gbk");
                    l = regex(responseData);

                    String reg = "data-num=\"[0-9]+";
                    Pattern p = Pattern.compile(reg);
                    Matcher m = p.matcher(responseData);

                } catch (IOException e) {
                    e.printStackTrace();
                }
        return l;


    }

    private List<KnowModel> regex(String responseData) {


        List<KnowModel> models = new ArrayList<>();

        String findBegin[] = responseData.split("class=\"daily-list");
        String findEnd[] = findBegin[1].split("class=\"aside-wp grid-r");
        Log.d("Main", findEnd[0]);

        responseData = findEnd[0];

        List<String> titles = new ArrayList<>();
        String reg = "title=\"[^\\x00-\\xff]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(responseData);
        while (m.find()) {
            String s = m.group().substring(7);
            System.out.println(s);
            titles.add(s);
        }

        List<String> images = new ArrayList<>();
        reg = "[a-zA-z]+://[^\\s]*";
        p = Pattern.compile(reg);
        m = p.matcher(responseData);
        while (m.find()) {

            String s = m.group().substring(0, m.group().length()-1);
            System.out.println(s);
            images.add(s);
        }

        List<String> articURL = new ArrayList<>();
        reg = "wp\" href=\"/daily/view\\?id=[0-9]+";
        p = Pattern.compile(reg);
        m = p.matcher(responseData);
        while (m.find()) {
            String s = "https://zhidao.baidu.com"+m.group().substring(10);

            System.out.println(s);

            articURL.add(s);
        }

        for(int i=0;i<titles.size();i++){
            KnowModel model = new KnowModel();
            model.setArtic(articURL.get(i));
            model.setImage(images.get(i));
            model.setTitle(titles.get(i));
            models.add(model);
        }
        Log.d("sss",String.valueOf(models.size()));
        return models;
    }
}
