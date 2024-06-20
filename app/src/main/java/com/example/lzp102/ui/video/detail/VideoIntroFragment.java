package com.example.lzp102.ui.video.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lzp102.R;


public class VideoIntroFragment extends Fragment {

    private final String intro;

    public VideoIntroFragment(String intro) {
        this.intro=intro;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_video_intro, container, false);
        TextView textView = root.findViewById(R.id.textview20);
        textView.setText(intro);
        return root;
    }
}