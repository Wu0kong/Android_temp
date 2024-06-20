package com.example.lzp102.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.lzp102.bean.NewsBean;
import com.example.lzp102.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class HomeViewModel extends ViewModel {



    public static LiveData<List<NewsBean>> getNewsList() {

        return Transformations.map(NetUtils.get().getNewsList(), Resource::getResource);
    }
    public static LiveData<List<NewsBean>> getAdList() {

        return Transformations.map(NetUtils.get().getAdList(), Resource::getResource);
    }
}