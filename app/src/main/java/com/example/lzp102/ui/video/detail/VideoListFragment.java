package com.example.lzp102.ui.video.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lzp102.R;
import com.example.lzp102.adapter.VideoListAdapter;

import java.util.Arrays;
import java.util.List;


public class VideoListFragment extends Fragment {

    private final VideoDetailFragment videoDetailFragment;
    private List<String> list;
    private String url0="https://vdept3.bdstatic.com/mda-qdqxj7s4d6njpv18/360p/h264/1714083422378574586/mda-qdqxj7s4d6njpv18.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1717758630-0-0-12d39e3051f49f03b5e9768b18b4d091&bcevod_channel=searchbox_feed&pd=1&cr=0&cd=0&pt=3&logid=0630294594&vid=12292776055750791018&klogid=0630294594&abtest=";
    private String url1="https://vdept3.bdstatic.com/mda-qdviemex7rkb2veb/360p/h264/1714482072484084454/mda-qdviemex7rkb2veb.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1717758726-0-0-b8968551f6578f5f74074836372ea932&bcevod_channel=searchbox_feed&cr=0&cd=0&pd=1&pt=3&logid=0726573344&vid=8341713078698862233&klogid=0726573344&abtest=";

    public VideoListFragment(String[] list, VideoDetailFragment videoDetailFragment) {
        this.list= Arrays.asList(list);
        this.videoDetailFragment=videoDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_video_list, container, false);
        RecyclerView recyclerView=root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(root.getContext()
                ,DividerItemDecoration.VERTICAL));
        VideoListAdapter videoListAdapter=new VideoListAdapter(list);
        recyclerView.setAdapter(videoListAdapter);
        videoListAdapter.setOnItemClickListener((adapter, view, position) -> {
            if(position%2==0){
                videoDetailFragment.playNewUrl(url0);
            }else{
                videoDetailFragment.playNewUrl(url1);

            }
        });
        return root;
    }
}