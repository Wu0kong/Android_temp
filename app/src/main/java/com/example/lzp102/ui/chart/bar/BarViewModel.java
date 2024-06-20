package com.example.lzp102.ui.chart.bar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lzp102.bean.BarBean;
import com.example.lzp102.bean.LineBean;

import java.util.ArrayList;
import java.util.List;

public class BarViewModel extends ViewModel {
    private MutableLiveData<List<BarBean>> barList;
    public BarViewModel(){
        barList=new MutableLiveData<>();
        String[] years = new String[]{"应届生","1-2年","2-3年",
                "3-5年","5-8年","8-10年","10年"};
        int[] salaries1 = {6000,13000,20000,26000,35000,50000,100000};
        int[] salaries2 = {4000,10000,15000,19000,20000,40000,70000};
        List<BarBean> value = new ArrayList<>();
        for (int i = 0; i < years.length; i++) {
            LineBean lineBean1 =new LineBean(years[i],salaries1[i]);
            LineBean lineBean2 =new LineBean(years[i],salaries2[i]);
            value.add(new BarBean(lineBean1,lineBean2));
        }
        barList.setValue(value);
    }
    public LiveData<List<BarBean>> getBarList(){
        return barList;
    }
}