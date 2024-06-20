package com.example.lzp102.ui.home.python;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


import com.example.lzp102.bean.PythonBean;
import com.example.lzp102.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class PythonViewModel extends ViewModel {
    public static LiveData<List<PythonBean>> getPythonList() {

        return Transformations.map(NetUtils.get().getPythonList(), Resource::getResource);
    }
}