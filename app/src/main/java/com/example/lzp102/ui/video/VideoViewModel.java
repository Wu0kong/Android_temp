package com.example.lzp102.ui.video;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.lzp102.bean.VideoBean;
import com.example.lzp102.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class VideoViewModel extends ViewModel {



    public static LiveData<List<VideoBean>> getVideoList() {

        return Transformations.map(NetUtils.get().getVideoList(), Resource::getResource);
    }
}